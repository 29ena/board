package kr.or.ddit.article.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.article.model.ArticleVo;
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
	* Method : articlePagingListTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 게시글 페이징 리스트 조회 테스트
	 */
	@Test
	public void articlePagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);

		/***When***/
		List<ArticleVo> articleList = articleDao.articlePagingList(pageVo);
		/***Then***/
		assertNotNull(articleList);
		assertEquals(10, articleList.size() );
		logger.debug("articleList : {}", articleList.size());
	}
	
	/**
	 * 
	* Method : getArticle
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

}
