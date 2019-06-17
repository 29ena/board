package kr.or.ddit.article.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
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
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class ArticleCommentController
 */
@WebServlet("/articleComment")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class ArticleCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleCommentController.class);
	
	private IArticleService articleService;
	private IFileUploadService fileUploadService;
	
	
	@Override
	public void init() throws ServletException {
		articleService = new ArticleService();
		fileUploadService = new FileUploadService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int article_id = Integer.parseInt(request.getParameter("article_id"));
		
		int article_pid = Integer.parseInt(request.getParameter("article_pid"));

		ArticleVo articleVo = articleService.getArticle(article_id);
		articleVo.setArticle_pid(article_pid);
		request.setAttribute("articleVo", articleVo);
		logger.debug("article_pid : {}",String.valueOf(articleVo.getArticle_pid()));
		request.getRequestDispatcher("/board/article/articleComment.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int article_id = Integer.parseInt(request.getParameter("article_id"));
		
		
		int article_pid = Integer.parseInt(request.getParameter("article_pid"));
		logger.debug(String.valueOf(article_pid));
		int article_board = Integer.parseInt(request.getParameter("article_board"));;
		
		UserVo userVo = (UserVo) request.getSession().getAttribute("USER_INFO");
		
		String article_userid = userVo.getUserId();
		
		String article_title = request.getParameter("article_title");
		
		String article_content = request.getParameter("article_content");
		
		
		int group_seq = articleService.searchGroup(article_id);
		
		Date dt = new Date();
		
		
		ArticleVo articleVo = new ArticleVo(article_board, article_pid, article_userid, article_title, article_content, dt, group_seq);
		
		if(articleVo != null){
			int insertCnt = articleService.commentArticle(articleVo);
			if(insertCnt ==1){
				
				Collection<Part> parts = request.getParts();
				for(Part part : parts) {
				if(part.getName().equals("myfile") && part.getSize() > 0){
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
				
				int max_id = articleService.searchInsert();
				response.sendRedirect(request.getContextPath() + "/articleController?article_id=" + max_id);
			}
		}
	}
}
