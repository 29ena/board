package kr.or.ddit.article.model;

public class PagingVo {
	private int page;		// 페이지번호
	private int pageSize;	// 페이지당 건수
	private int board_id;	// 게시판 아이디
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public PagingVo() {
	}
	public PagingVo(int page, int pageSize, int board_id) {
		this.page = page;
		this.pageSize = pageSize;
		this.board_id = board_id;
	}
	
	
	
}
