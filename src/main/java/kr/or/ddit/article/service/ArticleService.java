package kr.or.ddit.article.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.article.dao.ArticleDao;
import kr.or.ddit.article.dao.IArticleDao;
import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.paging.model.PageVo;

public class ArticleService implements IArticleService {
	
	private IArticleDao articleDao;
	
	
	
	public ArticleService() {
		articleDao = new ArticleDao();
	}

	@Override
	public List<ArticleVo> articleList() {
		return articleDao.articleList();
	}

	@Override
	public ArticleVo getArticle(int article_id) {
		return articleDao.getArticle(article_id);
	}

	@Override
	public int insertArticle(ArticleVo articleVo) {
		return articleDao.insertArticle(articleVo);
	}

	@Override
	public int updateArticle(ArticleVo articleVo) {
		return articleDao.updateArticle(articleVo);
	}

	@Override
	public int deleteArticle(ArticleVo articleVo) {
		return articleDao.deleteArticle(articleVo);
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
	public Map<String, Object> articlePagingList(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("articleList", articleDao.articlePagingList(pageVo));
		
		int articlesCnt = articleDao.articlesCnt();
		int paginationSize = (int)Math.ceil((double)articlesCnt / pageVo.getPageSize());
		
		resultMap.put("paginationSize", paginationSize);
		return resultMap;
	}

	
}
