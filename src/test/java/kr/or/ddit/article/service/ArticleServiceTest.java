package kr.or.ddit.article.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.Map;

import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.article.model.PagingVo;

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
	
	/*
	@Test
	public void articlePagingListTest(){
		*//***Given***//*
		PagingVo pagingVo = new PagingVo(1, 10, 1);

		*//***When***//*
		Map<String, Object> resultMap = articleService.articlePagingList(pagingVo);
		List<ArticleVo> articleList = (List<ArticleVo>) resultMap.get("articleList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		*//***Then***//*
		assertEquals(10, articleList.size());
		
		assertEquals(2, paginationSize);
	}
	*/
	
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
	/**
	 * 
	* Method : insertArticle
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 게시글 등록
	 */
	@Test
	public void insertArticleTest(){
		/***Given***/
		Date dt = new Date();
		ArticleVo articleVo1 = new ArticleVo(2, "brown", "터지지마라", "1부터 10까지 세어봅시다.", dt);
		/***When***/
		int insertCnt = articleService.insertArticle(articleVo1);
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void searchInsertTest(){
		/***Given***/
		
		/***When***/
		int searchId = articleService.searchInsert();
		/***Then***/
		assertNotNull(searchId);
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
		int updateCnt = articleService.modifyArticle(articleVo);
		/***Then***/
		assertEquals(1, updateCnt);
	}
	
}
