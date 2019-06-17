package kr.or.ddit.reply.model;

import java.util.Date;

public class ReplyVo {
	private int reply_id;
	private int reply_article;
	private String reply_userid;
	private String reply_content;
	private Date reply_dt;
	private String reply_delete;
	
	
	
	
	public ReplyVo(int reply_article, String reply_userid,
			String reply_content, Date reply_dt) {
		this.reply_article = reply_article;
		this.reply_userid = reply_userid;
		this.reply_content = reply_content;
		this.reply_dt = reply_dt;
	}
	
	



	public ReplyVo() {
		
	}



	public int getReply_id() {
		return reply_id;
	}



	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}



	public int getReply_article() {
		return reply_article;
	}



	public void setReply_article(int reply_article) {
		this.reply_article = reply_article;
	}



	public String getReply_userid() {
		return reply_userid;
	}



	public void setReply_userid(String reply_userid) {
		this.reply_userid = reply_userid;
	}



	public String getReply_content() {
		return reply_content;
	}



	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}



	public Date getReply_dt() {
		return reply_dt;
	}



	public void setReply_dt(Date reply_dt) {
		this.reply_dt = reply_dt;
	}



	public String getReply_delete() {
		return reply_delete;
	}



	public void setReply_delete(String reply_delete) {
		this.reply_delete = reply_delete;
	}
	
	
}
