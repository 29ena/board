package kr.or.ddit.article.model;

import java.util.Date;

public class ArticleVo {
	private int article_id;
	private int article_board;
	private int article_pid;
	private String article_userid;
	private String article_title;
	private String article_content;
	private Date article_dt;
	private String article_delete;
	private int lv;
	private int group_seq;
	
	
	
	

	public ArticleVo(int article_board, String article_userid, String article_title,
			String article_content, Date article_dt) {
		this.article_board = article_board;
		this.article_userid = article_userid;
		this.article_title = article_title;
		this.article_content = article_content;
		this.article_dt = article_dt;
	}
	
	
	
	

	public ArticleVo(int article_board, int article_pid, String article_userid,
			String article_title, String article_content, Date article_dt) {
		this.article_board = article_board;
		this.article_pid = article_pid;
		this.article_userid = article_userid;
		this.article_title = article_title;
		this.article_content = article_content;
		this.article_dt = article_dt;
	}





	public ArticleVo(int article_board, int article_pid, String article_userid,
			String article_title, String article_content, Date article_dt,
			int group_seq) {
		super();
		this.article_board = article_board;
		this.article_pid = article_pid;
		this.article_userid = article_userid;
		this.article_title = article_title;
		this.article_content = article_content;
		this.article_dt = article_dt;
		this.group_seq = group_seq;
	}





	public ArticleVo(int article_id, int article_board, int article_pid,
			String article_userid, String article_title,
			String article_content, Date article_dt) {
		this.article_id = article_id;
		this.article_board = article_board;
		this.article_pid = article_pid;
		this.article_userid = article_userid;
		this.article_title = article_title;
		this.article_content = article_content;
		this.article_dt = article_dt;
	}

	

	public ArticleVo(String article_title, String article_content,
			int article_id) {
		this.article_title = article_title;
		this.article_content = article_content;
		this.article_id = article_id;
	}



	public ArticleVo() {
		
	}
	



	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public int getArticle_board() {
		return article_board;
	}
	public void setArticle_board(int article_board) {
		this.article_board = article_board;
	}
	public int getArticle_pid() {
		return article_pid;
	}
	public void setArticle_pid(int article_pid) {
		this.article_pid = article_pid;
	}
	public String getArticle_userid() {
		return article_userid;
	}
	public void setArticle_userid(String article_userid) {
		this.article_userid = article_userid;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public Date getArticle_dt() {
		return article_dt;
	}
	public void setArticle_dt(Date article_dt) {
		this.article_dt = article_dt;
	}

	public String getArticle_delete() {
		return article_delete;
	}

	public void setArticle_delete(String article_delete) {
		this.article_delete = article_delete;
	}

	public int getGroup_seq() {
		return group_seq;
	}

	public void setGroup_seq(int group_seq) {
		this.group_seq = group_seq;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}
	
	
	
	
}
