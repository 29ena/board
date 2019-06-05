package kr.or.ddit.board.dao;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.user.dao.IuserDao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardDaoTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(BoardDaoTest.class);
	
	private IBoardDao boardDao;
	@Before
	public void setup(){
		boardDao = new BoardDao();
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
		List<BoardVo> boardList = boardDao.boardList();
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
		
		BoardVo boardVo = new BoardVo("brown", "자유게시판", "Y", dt);
		/***When***/
		int insertCnt = boardDao.insertBoard(boardVo);
		/***Then***/
		assertEquals(1, insertCnt);
		
		
	}
	
	@Test
	public void updateBaordTest(){
		/***Given***/
		BoardVo boardVo = new BoardVo(1, "공지게시판", "N");
		
		/***When***/
		int updateCnt = boardDao.updateBoard(boardVo);
		/***Then***/
		assertEquals(1, updateCnt);
	}

}
