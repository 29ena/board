package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import kr.or.ddit.board.model.BoardVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardServiceTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(BoardServiceTest.class);
	
	IBoardService boardService;
	
	@Before
	public void setup(){
		boardService = new BoardService();
	}
	
	
	/**
	 * 
	* Method : boardListTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 게시판 전체 조회
	 */
	@Test
	public void boardListTest(){
		/***Given***/
		

		/***When***/
		List<BoardVo> boardList = boardService.boardList();
		logger.debug("name : {}",boardList.get(0).getBoard_name());
		/***Then***/
		assertEquals("FAQ게시판",boardList.get(0).getBoard_name());
	}
	
	/**
	 * 
	* Method : insertBoardTest
	* 작성자 : PC20
	* 변경이력 :
	* @throws ParseException
	* Method 설명 : 게시판 등록 테스트
	 */
	@Test
	public void insertBoardTest() throws ParseException {
		/***Given***/
		
		Date dt = new Date();
		
		BoardVo boardVo = new BoardVo("brown", "FAQ게시판", "Y", dt);
		/***When***/
		int insertCnt = boardService.insertBoard(boardVo);
		/***Then***/
		assertEquals(1, insertCnt);
		
		
	}
	
	@Test
	public void updateBaordTest(){
		/***Given***/
		BoardVo boardVo = new BoardVo(3, "FAQ게시판", "N");
		
		/***When***/
		int updateCnt = boardService.updateBoard(boardVo);
		/***Then***/
		assertEquals(1, updateCnt);
	}

}
