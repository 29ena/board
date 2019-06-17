package kr.or.ddit.attach.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.attach.model.AttachVo;

import org.junit.Before;
import org.junit.Test;

public class AttachServiceTest {

	private IFileUploadService fileUploadService;
	
	@Before
	public void setup(){
		fileUploadService = new FileUploadService();
		
	}
	
	@Test
	public void insertAttachTest() {
		/***Given***/
		int attach_article = 1;
		
		String attach_route = "C:\\upload\\"; 
		
		String attach_name = "jordan2";
		
		AttachVo attachVo = new AttachVo(attach_article, attach_route, attach_name);
		
		
		/***When***/
		int insertCnt = fileUploadService.insertFile(attachVo);
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteAttachTest(){
		/***Given***/
		int attach_id = 2;
		
		/***When***/
		int deleteCnt = fileUploadService.deleteFile(attach_id);
		/***Then***/
		assertEquals(1, deleteCnt);
		
	}
	
	@Test
	public void fileList(){
		/***Given***/
		int attach_article = 1;
		
		/***When***/
		List<AttachVo> fileList = fileUploadService.fileList(attach_article);
		/***Then***/
		assertEquals("jordan2", fileList.get(0).getAttach_name());
		
	}

}
