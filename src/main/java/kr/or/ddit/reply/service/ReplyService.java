package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.dao.IReplyDao;
import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyService implements IReplyService {

	private IReplyDao replyDao;
	
	
	
	public ReplyService() {
		replyDao = new ReplyDao();
	}
	
	/**
	 * 
	 * Method : replyList
	 * 작성자 : newed
	 * 변경이력 :
	 * @param reply_article
	 * @return
	 * Method 설명 : 댓글 조회
	 */
	@Override
	public List<ReplyVo> replyList(int reply_article) {
		return replyDao.replyList(reply_article);
	}

	@Override
	public int insertReply(ReplyVo replyVo) {
		return replyDao.insertReply(replyVo);
	}

	@Override
	public int updateReply(ReplyVo replyVo) {
		return 0;
	}

	@Override
	public int deleteReply(int reply_id) {
		return replyDao.deleteReply(reply_id);
	}

}
