package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.model.BoardVo;

public class BoardService implements IBoardService {
	
	private IBoardDao boardDao;
	
	
	
	public BoardService() {
		boardDao = new BoardDao();
	}

	@Override
	public List<BoardVo> boardList() {
		return boardDao.boardList();
	}
	
	@Override
	public int insertBoard(BoardVo boardVo) {
		return boardDao.insertBoard(boardVo);
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		return boardDao.updateBoard(boardVo);
	}

	@Override
	public BoardVo getBaord(int board_id) {
		return boardDao.getBaord(board_id);
	}


}
