package kr.or.ddit.article.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IArticleDao {
	
	/**
	 * 
	* Method : articleList
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 전체 조회
	 */
	List<ArticleVo> articleList();
	
	/**
	 * 
	* Method : getArticle
	* 작성자 : PC20
	* 변경이력 :
	* @param ArticleId
	* @return
	* Method 설명 : 게시글 조회
	 */
	ArticleVo getArticle(int article_id);
	
	/**
	 * 
	* Method : insertArticle
	* 작성자 : PC20
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 등록
	 */
	
	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC20
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 게시글 페이징 리스트 조회
	 */
	List<ArticleVo> articlePagingList(PageVo pageVo);
	
	/**
	 * 
	* Method : articlesCnt
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 전체수 조회
	 */
	int articlesCnt();
	
	/**
	 * 
	* Method : insertArticle
	* 작성자 : PC20
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 등록
	 */
	int insertArticle(ArticleVo articleVo);
	
	/**
	 * 
	* Method : updateArticle
	* 작성자 : PC20
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 수정
	 */
	int updateArticle(ArticleVo articleVo);
	
	/**
	 * 
	* Method : deleteArticle
	* 작성자 : PC20
	* 변경이력 :
	* @param articleId
	* @return
	* Method 설명 : 게시글 삭제
	 */
	int deleteArticle(ArticleVo articleVo);
	
	
}
