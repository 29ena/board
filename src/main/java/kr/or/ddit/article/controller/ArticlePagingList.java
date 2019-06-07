package kr.or.ddit.article.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.article.dao.IArticleDao;
import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.service.IArticleService;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.paging.model.PageVo;

/**
 * 
* ArticlePagingList.java
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
@WebServlet("/articlePagingList")
public class ArticlePagingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ArticlePagingList.class);
	
	private IArticleService articleService;
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		articleService = new ArticleService();
		boardService = new BoardService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int board_id = Integer.parseInt(request.getParameter("board_id"));
			
			
			String pageString = request.getParameter("page");
			String pageSizeString = request.getParameter("pageSize");
			logger.debug("pageString : {}",pageString);
			logger.debug("pageSizeString : {}",pageSizeString);
			
			
			int page = pageString == null ? 1 : Integer.parseInt(pageString);
			int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
			
			PageVo pageVo = new PageVo(page, pageSize);
			
			Map<String, Object> resultMap = articleService.articlePagingList(pageVo);
			
			List<ArticleVo> articleList = (List<ArticleVo>) resultMap.get("articleList");
			int paginationSize = (Integer) resultMap.get("paginationSize");
			
			logger.debug("paginationSize : {}", paginationSize);
			
			request.setAttribute("articleList", articleList);
			request.setAttribute("paginationSize", paginationSize);
			request.setAttribute("pageVo", pageVo);
			request.getParameter("board_name");
			request.getParameter("board_id");
			
			request.getSession().getAttribute("USER_INFO");
			request.getServletContext().getAttribute("boardList");
			request.getSession().setAttribute("board_list", boardService.getBaord(board_id));
			
			request.getRequestDispatcher("/board/article/article.jsp").forward(request, response);
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
