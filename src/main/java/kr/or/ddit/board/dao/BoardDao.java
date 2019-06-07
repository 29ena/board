package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.mybatis.MyBatisUtil;

public class BoardDao implements IBoardDao {
	
	/**
	 * 
	 * Method : boardList
	 * 작성자 : PC20
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 전체 조회
	 */
	@Override
	public List<BoardVo> boardList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.boardList");
		sqlSession.close();
		return boardList;
	}

	/**
	 * 
	* Method : insertBoard
	* 작성자 : PC20
	* 변경이력 :
	* @param boarVo
	* @return
	* Method 설명 : 게시판 등록
	 */
	@Override
	public int insertBoard(BoardVo boardVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertCnt = sqlSession.insert("board.insertBoard",boardVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}
	
	/**
	 * 
	* Method : updateBoard
	* 작성자 : PC20
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 수정
	 */
	@Override
	public int updateBoard(BoardVo boardVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("board.updateBoard", boardVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}
	
	/**
	 * 
	* Method : getBaord
	* 작성자 : PC20
	* 변경이력 :
	* @param board_id
	* @return
	* Method 설명 : 게시판 조회
	 */
	@Override
	public BoardVo getBaord(int board_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BoardVo boardVo = sqlSession.selectOne("board.getBoard", board_id);
		sqlSession.close();
		return boardVo;
	}
	
	

}
