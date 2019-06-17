package kr.or.ddit.article.controller;

import java.io.File;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.service.IArticleService;
import kr.or.ddit.attach.dao.IFileUploadDao;
import kr.or.ddit.attach.model.AttachVo;
import kr.or.ddit.attach.service.FileUploadService;
import kr.or.ddit.attach.service.IFileUploadService;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.PartUtil;

/**
 * 
* ArticleWrite.java
*
* @author PC20
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC20 최초 생성
*
* </pre>
 */
@WebServlet("/articleWrite")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class ArticleWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleWrite.class);
	
	private IArticleService articleService;
	
	private IFileUploadService fileUploadService;
	
	@Override
	public void init() throws ServletException {
		articleService = new ArticleService();
		fileUploadService = new FileUploadService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String board_id = request.getParameter("board_id");
		request.setAttribute("board_id", board_id);
		logger.debug("board_id 1123 : {}", board_id);
		request.getRequestDispatcher("/board/article/articleWrite.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		logger.debug("article_id: {}",request.getParameter("board_id"));
		int article_board = Integer.parseInt(request.getParameter("board_id"));
		
		UserVo userVo = (UserVo) request.getSession().getAttribute("USER_INFO");
		
		
		String article_userid = userVo.getUserId();
		
		logger.debug("userid : {}", article_userid);
		
		String article_title = request.getParameter("article_title");
		logger.debug("article_title : {}", article_title);
		
		String article_content = request.getParameter("article_content");
		logger.debug("article_content : {}", article_content);
		
		Date dt = new Date();
		
		ArticleVo articleVo = new ArticleVo(article_board, article_userid, article_title, article_content, dt);
		
		if(articleVo != null){
			int insertCnt = articleService.insertArticle(articleVo);
			if(insertCnt ==1){
				
				Collection<Part> parts = request.getParts();
				for(Part part : parts) {
					if(part.getName().equals("myfile") && part.getSize() > 0){
						String contentDisposition = part.getHeader("content-disposition");
						String fileName = PartUtil.getFileName(contentDisposition);
						String ext = PartUtil.getExt(fileName);

						// 업로드 폴더가 존재하는지 확인 후 생성
						String uploadPath = PartUtil.getUploadPath();
						String path = uploadPath + "\\" + UUID.randomUUID().toString() + ext;
						part.write(path);
						
						part.delete(); // 디스크 임시 공간에 저장된 파일이 있다면 삭제한다.
						String attach_route = path;
						int attach_article = articleService.searchInsert();
						AttachVo attachVo = new AttachVo(attach_article, attach_route, fileName);
						fileUploadService.insertFile(attachVo);
						
						
					}
				}
				
				int article_id = articleService.searchInsert();
				request.setAttribute("article_id", article_id);
				response.sendRedirect(request.getContextPath() + "/articleController?article_id=" + article_id);
			}
		}

	}
}