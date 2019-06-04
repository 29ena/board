package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {
	private int board_id;
	private String board_userid;
	private String board_name;
	private String board_yn;
	private Date board_dt;

	public BoardVo(int board_id, String board_name, String board_yn) {
		this.board_id = board_id;
		this.board_name = board_name;
		this.board_yn = board_yn;
	}

	public BoardVo(String board_userid, String board_name, String board_yn,
			Date board_dt) {
		this.board_userid = board_userid;
		this.board_name = board_name;
		this.board_yn = board_yn;
		this.board_dt = board_dt;
	}
	
	

	public BoardVo() {
		
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getBoard_userid() {
		return board_userid;
	}

	public void setBoard_userid(String board_userid) {
		this.board_userid = board_userid;
	}

	public String getBoard_name() {
		return board_name;
	}

	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}

	public String getBoard_yn() {
		return board_yn;
	}

	public void setBoard_yn(String board_yn) {
		this.board_yn = board_yn;
	}

	public Date getBoard_dt() {
		return board_dt;
	}

	public void setBoard_dt(Date board_dt) {
		this.board_dt = board_dt;
	}

}
