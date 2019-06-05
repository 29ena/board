package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

/**
 * 
* UpdateBoard.java
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
@WebServlet("/updateBoard")
public class UpdateBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory
			.getLogger(UpdateBoard.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 설정하지 않으면 한글깨짐
		
		String uBoard_name = request.getParameter("uboard_name");
		logger.debug("uBoard_name : {}",uBoard_name);
		String uBoard_yn = request.getParameter("uboard_yn");
		logger.debug("uBoard_yn : {}", uBoard_yn);
		String board_id = request.getParameter("board_id");
		logger.debug("board_id : {}", board_id);
		int uBoard_id = Integer.parseInt(board_id);
		
		BoardVo updateBoard = null;
		updateBoard = new BoardVo(uBoard_id, uBoard_name, uBoard_yn);
		
		int updateCnt = boardService.updateBoard(updateBoard);
		
		if(updateCnt ==1){
			response.sendRedirect(request.getContextPath() + "/insertBoard");
		}
	}

}
