package kr.or.ddit.article.controller;

import java.io.IOException;
import java.util.HashMap;
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
import kr.or.ddit.article.model.PagingVo;
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
			logger.debug("board_id : {}", board_id);
			
			String pageString = request.getParameter("page");
			String pageSizeString = request.getParameter("pageSize");
			
			
			int page = pageString == null ? 1 : Integer.parseInt(pageString);
			int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
			logger.debug("pageString : {}",page);
			logger.debug("pageSizeString : {}",pageSize);
			
			PagingVo pagingVo = new PagingVo(page, pageSize, board_id);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("board_id", board_id);
			map.put("pageSize", pageSize);
			map.put("page", page);
			Map<String, Object> resultMap = articleService.articlePagingList(map);
			
			List<ArticleVo> articleList = (List<ArticleVo>) resultMap.get("articleList");
			int paginationSize = (Integer) resultMap.get("paginationSize");
			
			request.setAttribute("articleList", articleList);
			request.setAttribute("paginationSize", paginationSize);
			request.setAttribute("pagingVo", pagingVo);
			request.getParameter("board_name");
			logger.debug("board_id : {}",request.getParameter("board_id") );
			request.getSession().getAttribute("USER_INFO");
			request.getServletContext().getAttribute("boardList");
			request.getSession().setAttribute("board_list", boardService.getBaord(board_id));
			
			request.setAttribute("board_id", board_id);
			request.getRequestDispatcher("/board/article/article.jsp").forward(request, response);
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("board_id");
		
	}

}
