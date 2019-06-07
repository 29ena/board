package kr.or.ddit.article.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class ArticleDao implements IArticleDao {

	/**
	 * 
	* Method : articleList
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 전체 조회
	 */
	@Override
	public List<ArticleVo> articleList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<ArticleVo> articleList = sqlSession.selectList("article.articleList");
		sqlSession.close();
		return articleList;
	}

	/**
	 * 
	* Method : getArticle
	* 작성자 : PC20
	* 변경이력 :
	* @param ArticleId
	* @return
	* Method 설명 : 게시글 조회
	 */
	@Override
	public ArticleVo getArticle(int article_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		ArticleVo articleVo =  sqlSession.selectOne("article.getArticle",article_id);
		sqlSession.close();
		return articleVo;
	}

	/**
	 * 
	* Method : insertArticle
	* 작성자 : PC20
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 등록
	 */
	@Override
	public int insertArticle(ArticleVo articleVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertCnt = sqlSession.insert("article.insertArticle", articleVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	/**
	 * 
	* Method : updateArticle
	* 작성자 : PC20
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 수정
	 */
	@Override
	public int updateArticle(ArticleVo articleVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("article.updateArticle", articleVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

	/**
	 * 
	* Method : deleteArticle
	* 작성자 : PC20
	* 변경이력 :
	* @param articleId
	* @return
	* Method 설명 : 게시글 삭제
	 */
	@Override
	public int deleteArticle(ArticleVo articleVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int deleteCnt = sqlSession.update("article.deleteArticle",articleVo);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}
	
	/**
	 * 
	* Method : articlePagingList
	* 작성자 : PC20
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 게시글 페이징 리스트 조회
	 */
	@Override
	public List<ArticleVo> articlePagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<ArticleVo> articleList = sqlSession.selectList("article.articlePagingList",
				pageVo);
		sqlSession.close();
		return articleList;
	}

	/**
	 * 
	* Method : articlesCnt
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 전체수 조회
	 */
	@Override
	public int articlesCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int articlesCnt = (Integer) sqlSession.selectOne("article.articlesCnt");
		sqlSession.close();
		return articlesCnt;
	}
	

}
