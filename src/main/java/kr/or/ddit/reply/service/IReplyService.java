package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

public interface IReplyService {

	/**
	 * 
	* Method : replyList
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 댓글조회
	 */
	List<ReplyVo> replyList (int reply_article);
	
	/**
	 * 
	* Method : insertReply
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 댓글 등록
	 */
	int insertReply(ReplyVo replyVo);
	
	/**
	 * 
	* Method : updateReply
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 댓글 수정
	 */
	int updateReply(ReplyVo replyVo);
	
	/**
	 * 
	* Method : deleteReply
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 댓글 삭제
	 */
	int deleteReply(int reply_id);

}
