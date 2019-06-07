package kr.or.ddit.article.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.service.IArticleService;

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
	
	
	
	
	@Override
	public void init() throws ServletException {
		articleService = new ArticleService();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int article_id = Integer.parseInt(request.getParameter("article_id"));
		logger.debug("article_id : {}",String.valueOf(article_id));
		
		ArticleVo articleVo = articleService.getArticle(article_id);
		request.setAttribute("articleVo", articleVo);
		
		
		
		request.getSession().getAttribute("USER_INFO");
		request.getServletContext().getAttribute("boardList");
		
		request.getRequestDispatcher("/board/article/articleView.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
