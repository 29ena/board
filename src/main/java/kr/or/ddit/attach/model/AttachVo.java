package kr.or.ddit.attach.model;

public class AttachVo {
	private int attach_id;
	private int attach_article;
	private String attach_route;
	private String attach_name;
	
	

	public AttachVo(int attach_article, String attach_route,
			String attach_name) {
		super();
		this.attach_article = attach_article;
		this.attach_route = attach_route;
		this.attach_name = attach_name;
	}
	
	



	public AttachVo() {
		
	}

	public int getAttach_id() {
		return attach_id;
	}

	public void setAttach_id(int attach_id) {
		this.attach_id = attach_id;
	}

	public int getAttach_article() {
		return attach_article;
	}

	public void setAttach_article(int attach_article) {
		this.attach_article = attach_article;
	}

	public String getAttach_route() {
		return attach_route;
	}

	public void setAttach_route(String attach_route) {
		this.attach_route = attach_route;
	}

	public String getAttach_name() {
		return attach_name;
	}

	public void setAttach_name(String attach_name) {
		this.attach_name = attach_name;
	}
	
	
}
