package kr.or.ddit.article.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.paging.model.PageVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArticleServiceTest {

	private static final Logger logger = LoggerFactory
			.getLogger(ArticleServiceTest.class);
	
	private IArticleService articleService;
	
	@Before
	public void setup(){
		articleService = new ArticleService();
	}
	
	@Test
	public void articleListTest() {
		/***Given***/

		/***When***/
		List<ArticleVo> articleList = articleService.articleList();
		logger.debug("userid : {}", articleList.get(0).getArticle_content());
		/***Then***/
		assertEquals("brown", articleList.get(0).getArticle_userid());
	}
	
	/**
	 * 
	* Method : articlePagingListTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 게시길 페이징 리스트 조회 테스트
	 */
	@Test
	public void articlePagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);

		/***When***/
		Map<String, Object> resultMap = articleService.articlePagingList(pageVo);
		List<ArticleVo> articleList = (List<ArticleVo>) resultMap.get("articleList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		/***Then***/
		assertEquals(10, articleList.size());
		
		assertEquals(2, paginationSize);
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
		ArticleVo articleVo = articleService.getArticle(article_id);
		/***Then***/
		assertNotNull(articleVo);
		assertEquals(1, article_id);
	}

}
