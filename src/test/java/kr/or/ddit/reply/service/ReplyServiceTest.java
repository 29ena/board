package kr.or.ddit.reply.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReplyServiceTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ReplyServiceTest.class);
	
	private IReplyService replyService;
	
	@Before
	public void setup(){
		replyService = new ReplyService();
	}
	
	@Test
	public void replyListTest() {
		/***Given***/
		int reply_article = 1;
		/***When***/
		List<ReplyVo> replyList = replyService.replyList(reply_article);
		logger.debug("replyList_userid : {}",replyList.get(0).getReply_userid() );
		/***Then***/
		assertEquals("brown", replyList.get(0).getReply_userid());
	}
	
	@Test
	public void insertReplyTest(){
		/***Given***/
		Date dt = new Date();
		
		ReplyVo replyVo = new ReplyVo(1, "brown", "ㄲㄲㄲㄲㄲㄲㄱ", dt);
		/***When***/
		int insertCnt = replyService.insertReply(replyVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteReply(){
		/***Given***/
		int num = 4;
		/***When***/
		int deleteCnt = replyService.deleteReply(4);
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
}
