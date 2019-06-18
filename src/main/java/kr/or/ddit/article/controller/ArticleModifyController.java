package kr.or.ddit.article.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.service.IArticleService;
import kr.or.ddit.attach.model.AttachVo;
import kr.or.ddit.attach.service.FileUploadService;
import kr.or.ddit.attach.service.IFileUploadService;
import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ArticleModifyController.java
 *
 * @author newed
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정자 수정내용
 * ------ ------------------------
 * newed 최초 생성
 *
 * </pre>
 */
@WebServlet("/articleModify")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class ArticleModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleModifyController.class);
	
	private IArticleService articleService;
	private IFileUploadService fileUploadService;
	
	@Override
	public void init() throws ServletException {
		articleService = new ArticleService();
		fileUploadService = new FileUploadService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int article_id = Integer.parseInt(request.getParameter("article_id"));
		
		ArticleVo articleVo = articleService.getArticle(article_id);
		
		request.setAttribute("vo", articleVo);
		
		List<AttachVo> fileList = fileUploadService.fileList(article_id);
		
		
		request.setAttribute("fileList", fileList);
		
		
		
		request.getRequestDispatcher("/board/article/articleModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		
		String article_title = request.getParameter("article_title");
		logger.debug("article_title : {}", article_title);
		
		String article_content = request.getParameter("article_content");
		logger.debug("article_content : {}", article_content);
		
		int article_id = Integer.parseInt(request.getParameter("article_id"));
		logger.debug("article_id : {}", article_id);
		ArticleVo articleVo = new ArticleVo(article_title, article_content, article_id);
		
		if(articleVo !=null){
			int modifyCnt = articleService.modifyArticle(articleVo);
			
			if(modifyCnt == 1){
				logger.debug("modifyCnt : {}",modifyCnt );
				String[] fileIds = request.getParameterValues("file_id");
				if(fileIds != null){
					for(String fileId : fileIds){
						if(fileId.equals("")) continue;
						int attach_id = Integer.parseInt(fileId);
						fileUploadService.deleteFile(attach_id);
					}
						
				}
				
				Collection<Part> parts = request.getParts();
				for(Part part : parts) {
					if(part.getName().equals("myfile") && part.getSize() > 0){
						logger.debug("ddfd");
						
						String contentDisposition = part.getHeader("content-disposition");
						String fileName = PartUtil.getFileName(contentDisposition);
						String ext = PartUtil.getExt(fileName);
						
						// 업로드 폴더가 존재하는지 확인 후 생성
						String uploadPath = PartUtil.getUploadPath();
						
						part.write(uploadPath + "\\" + UUID.randomUUID().toString()
								+ ext);
						
						part.delete(); // 디스크 임시 공간에 저장된 파일이 있다면 삭제한다.
						String attach_route = uploadPath + "\\" + UUID.randomUUID().toString() + ext;
						int attach_article = articleService.searchInsert();
						AttachVo attachVo = new AttachVo(attach_article, attach_route, fileName);
						fileUploadService.insertFile(attachVo);
					}
				}
			}
		}
		response.sendRedirect(request.getContextPath() + "/articleController?article_id=" + article_id);
	}//doPost
}
		

