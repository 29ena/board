package kr.or.ddit.attach.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.article.dao.ArticleDao;
import kr.or.ddit.article.dao.IArticleDao;
import kr.or.ddit.attach.model.AttachVo;
import kr.or.ddit.board.dao.BoardDaoTest;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttachDaoTest {

	private static final Logger logger = LoggerFactory
			.getLogger(BoardDaoTest.class);
	private IFileUploadDao fileUploadDao;
	
	@Before
	public void setup(){
		fileUploadDao = new FileUploadDao();
	}
	
	
	@Test
	public void insertAttachTest() {
		/***Given***/
		int attach_article = 1;
		
		String attach_route = "C:\\upload\\"; 
		
		String attach_name = "jordan4";
		
		AttachVo attachVo = new AttachVo(attach_article, attach_route, attach_name);
		
		
		/***When***/
		int insertCnt = fileUploadDao.insertFile(attachVo);
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteAttachTest(){
		/***Given***/
		int attach_id = 5;
		
		/***When***/
		int deleteCnt = fileUploadDao.deleteFile(attach_id);
		/***Then***/
		assertEquals(1, deleteCnt);
		
	}
	
	@Test
	public void fileList(){
		/***Given***/
		int attach_article = 1;
		
		/***When***/
		List<AttachVo> fileList = fileUploadDao.fileList(attach_article);
		/***Then***/
		assertEquals("jordan2", fileList.get(0).getAttach_name());
		
	}

}
