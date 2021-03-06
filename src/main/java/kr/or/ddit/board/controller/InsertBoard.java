package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.model.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class InsertBoard
 */
@WebServlet("/insertBoard")
public class InsertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(InsertBoard.class);

	private IBoardService boardService;

	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().setAttribute("board_List", boardService.boardList());
		request.getRequestDispatcher("/board/insertBoard/insertBoard.jsp")
				.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 설정하지 않으면 한글깨짐
		
		Date dt = new Date();

		// 파라미터를 사용해서 boardVo 인스턴스를 만든다.
		String board_name = request.getParameter("board_name");
		logger.debug("board_name: {}", board_name);
		String board_yn = request.getParameter("board_yn");	
		logger.debug("board_yn : {}", board_yn);
		UserVo userVo = (UserVo) request.getSession().getAttribute("USER_INFO");
		String user_id = userVo.getUserId();
		logger.debug("user_id : {}", user_id);
		
		
		
		BoardVo boardVo = null;
		boardVo = new BoardVo(user_id, board_name, board_yn, dt);
		
		
		if (boardVo != null) {
			int insertCnt = boardService.insertBoard(boardVo);
			if (insertCnt == 1) {
				List<BoardVo> boardList = boardService.boardList();
				request.getServletContext().setAttribute("board_List", boardList);
				response.sendRedirect(request.getContextPath() + "/insertBoard");
			}
		}

	}

}
