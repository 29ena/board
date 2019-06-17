package kr.or.ddit.article.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.service.IArticleService;

/**
 * Servlet implementation class ArticleDelete
 */
@WebServlet("/articleDelete")
public class ArticleDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleDeleteController.class);
	
	private IArticleService articleService;
	
	@Override
	public void init() throws ServletException {
		articleService = new ArticleService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int article_id = Integer.parseInt(request.getParameter("article_id"));
		logger.debug("Delete article_id : {}",String.valueOf(article_id));
		
		
		int deleteCnt = articleService.deleteArticle(article_id);
		logger.debug("Delete deleteCnt : {}",String.valueOf(deleteCnt));
		
		ArticleVo vo = articleService.getArticle(article_id);
		
		int board_id = vo.getArticle_board();
		logger.debug("board_id : {}",String.valueOf(board_id));
		
		
		if(deleteCnt == 1){
			response.sendRedirect(request.getContextPath() + "/articlePagingList?board_id=" + board_id);
		}
		
		
	}

}
