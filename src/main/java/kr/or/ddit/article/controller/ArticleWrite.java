package kr.or.ddit.article.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.service.IArticleService;

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
public class ArticleWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IArticleService articleService;
	
	@Override
	public void init() throws ServletException {
		articleService = new ArticleService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/board/article/articleWrite.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
