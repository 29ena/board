package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public interface IBoardService {
	
	/**
	 * 
	* Method : userList
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	 */
	List<BoardVo> boardList();
	
	/**
	 * 
	* Method : getBaord
	* 작성자 : PC20
	* 변경이력 :
	* @param board_id
	* @return
	* Method 설명 : 게시판 조회
	 */
	BoardVo getBaord(int board_id);
	
	/**
	 * 
	* Method : insertBoard
	* 작성자 : PC20
	* 변경이력 :
	* @param boarVo
	* @return
	* Method 설명 : 게시판 등록
	 */
	int insertBoard(BoardVo boardVo);
	
	/**
	 * 
	* Method : updateBoard
	* 작성자 : PC20
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 수정
	 */
	int updateBoard(BoardVo boardVo);
}
