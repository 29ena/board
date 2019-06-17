package kr.or.ddit.article.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.article.dao.ArticleDao;
import kr.or.ddit.article.dao.IArticleDao;
import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.article.model.PagingVo;
import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.model.BoardVo;
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
	public int modifyArticle(ArticleVo articleVo) {
		return articleDao.modifyArticle(articleVo);
	}

	@Override
	public int deleteArticle(int article_id) {
		return articleDao.deleteArticle(article_id);
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
	public Map<String, Object> articlePagingList(Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int board_id = (int) map.get("board_id");
		int pageSize = (int) map.get("pageSize");
		int articleCnt = articleDao.articlesCnt(board_id);
		int paginationSize = (int) Math.ceil((double)articleCnt/pageSize);
		
		resultMap.put("articleList", articleDao.articlePagingList(map));
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

	@Override
	public int searchInsert() {
		return articleDao.searchInsert();
	}

	@Override
	public int commentArticle(ArticleVo articleVo) {
		return articleDao.commentArticle(articleVo);
	}

	@Override
	public int searchGroup(int article_id) {
		return articleDao.searchGroup(article_id);
	}

	
}
