package kr.or.ddit.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyDao implements IReplyDao {
	
	
	/**
	 * 
	 * Method : insertReply
	 * 작성자 : newed
	 * 변경이력 :
	 * @param replyVo
	 * @return
	 * Method 설명 : 댓글 등록
	 */
	
	@Override
	public int insertReply(ReplyVo replyVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertCnt = sqlSession.insert("reply.insertReply",replyVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}
	/**
	 * 
	 * Method : updateReply
	 * 작성자 : newed
	 * 변경이력 :
	 * @param replyVo
	 * @return
	 * Method 설명 : 댓글 수정
	 */
	@Override
	public int updateReply(ReplyVo replyVo) {
		return 0;
	}
	
	/**
	 * 
	 * Method : deleteReply
	 * 작성자 : newed
	 * 변경이력 :
	 * @param replyVo
	 * @return
	 * Method 설명 : 댓글 삭제
	 */
	@Override
	public int deleteReply(int reply_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int deleteCnt = sqlSession.update("reply.deleteReply", reply_id);
		sqlSession.commit();
		sqlSession.close();
		
		return deleteCnt;
	}
	@Override
	public List<ReplyVo> replyList(int reply_article) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<ReplyVo> replyList = sqlSession.selectList("reply.replyList",reply_article);
		sqlSession.close();
		return replyList;
	}


}
