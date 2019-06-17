package kr.or.ddit.attach.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.attach.model.AttachVo;
import kr.or.ddit.mybatis.MyBatisUtil;

public class FileUploadDao implements IFileUploadDao {

	@Override
	public int insertFile(AttachVo attachVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertCnt = sqlSession.insert("attach.insertFile", attachVo);
		sqlSession.commit();
		sqlSession.close();
		
		return insertCnt;
	}

	@Override
	public int deleteFile(int attach_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int deleteCnt = sqlSession.delete("attach.deleteFile", attach_id);
		sqlSession.commit();
		sqlSession.close();
		
		return deleteCnt;
	}

	@Override
	public List<AttachVo> fileList(int attach_article) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<AttachVo> fileList = sqlSession.selectList("attach.fileList",attach_article);
		sqlSession.commit();
		sqlSession.close();
		
		return fileList;
	}

	@Override
	public AttachVo getFile(int attach_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AttachVo getFile = sqlSession.selectOne("attach.getFile", attach_id);
		sqlSession.close();
		
		return getFile;
	}



}
