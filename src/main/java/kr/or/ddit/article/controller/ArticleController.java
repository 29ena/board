package kr.or.ddit.article.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.service.IArticleService;
import kr.or.ddit.attach.model.AttachVo;
import kr.or.ddit.attach.service.FileUploadService;
import kr.or.ddit.attach.service.IFileUploadService;
import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
* ArticleController.java
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
@WebServlet("/articleController")
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleController.class);
    
	private IArticleService articleService;
	
	private IReplyService replyService;
	
	private IFileUploadService fileUploadService;
	
	@Override
	public void init() throws ServletException {
		articleService = new ArticleService();
		replyService = new ReplyService();
		fileUploadService = new FileUploadService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo userVo = (UserVo) request.getSession().getAttribute("USER_INFO");
		String userId = userVo.getUserId();
		logger.debug("userId : {}", userId);
		request.setAttribute("userId", userId);
		
		ReplyVo replyVo = new ReplyVo();
		replyVo.setReply_userid(userId);
		int article_id = Integer.parseInt(request.getParameter("article_id"));
		logger.debug("article_id222 : {}",article_id);
		
		ArticleVo articleVo = articleService.getArticle(article_id);
		
		int board_id = articleVo.getArticle_board();
		request.setAttribute("board_id", board_id);
		logger.debug("article_id : {}", articleVo.getArticle_id());
		replyVo.setReply_article(article_id);
		request.setAttribute("replyVo", replyVo);
		
		request.setAttribute("articleVo", articleVo);
		
		List<AttachVo> fileList = fileUploadService.fileList(article_id);
		request.setAttribute("fileList", fileList);
		
		int reply_article = Integer.parseInt(request.getParameter("article_id"));
		logger.debug("reply_article : {}", reply_article);
		List<ReplyVo> replyList = replyService.replyList(reply_article);
		request.setAttribute("replyList", replyList);
		
		request.getServletContext().getAttribute("boardList");
		
		request.getRequestDispatcher("/board/article/articleView.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
