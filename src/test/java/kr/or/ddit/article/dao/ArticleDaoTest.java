package kr.or.ddit.article.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.article.model.PagingVo;
import kr.or.ddit.board.dao.BoardDaoTest;
import kr.or.ddit.paging.model.PageVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArticleDaoTest {

	private static final Logger logger = LoggerFactory
			.getLogger(BoardDaoTest.class);
	private IArticleDao articleDao;
	
	@Before
	public void setup(){
		articleDao = new ArticleDao();
	}
	
	@Test
	public void articleListTest() {
		/***Given***/
		

		/***When***/
		List<ArticleVo> articleList = articleDao.articleList();
		logger.debug("userid : {}", articleList.get(0).getArticle_userid());
		/***Then***/
		assertEquals("brown", articleList.get(0).getArticle_userid());
	}
	
	
	/**
	 * 
	* Method : getArticleTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 게시글 상세 보기 테스트
	 */
	@Test
	public void getArticle(){
		/***Given***/
		int article_id = 1;
		
		/***When***/
		ArticleVo articleVo = articleDao.getArticle(article_id);
		/***Then***/
		assertNotNull(articleVo);
		assertEquals(1, article_id);
	}
	
	/**
	 * 
	* Method : insertArticleTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 게시글 등록
	 */
	@Test
	public void insertArticleTest(){
		/***Given***/
		Date dt = new Date();
		ArticleVo articleVo1 = new ArticleVo(2, "brown", "터지지마라11", "1부터 10까지 세어봅시다.", dt);
		/***When***/
		int insertCnt = articleDao.insertArticle(articleVo1);
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	/**
	 * 
	* Method : modifyArticleTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 게시글 수정
	 */
	@Test
	public void modifyArticleTest(){
		/***Given***/
		String article_title = "수정하겠습니다.";
		String article_content = "수정하였습니다.";
		int article_id = 29;
		ArticleVo articleVo = new ArticleVo(article_title, article_content, article_id);
		
		/***When***/
		int updateCnt = articleDao.modifyArticle(articleVo);
		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	/**
	 * 
	* Method : deleteArticleTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 게시글 삭제
	 */
	@Test
	public void deleteArticleTest(){
		/***Given***/
		int article_id = 29;
		/***When***/
		int deleteCnt = articleDao.deleteArticle(article_id);
		/***Then***/
		assertEquals(1, deleteCnt);
	}

}
