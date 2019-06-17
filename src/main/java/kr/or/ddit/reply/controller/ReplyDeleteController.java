package kr.or.ddit.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;

import org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ReplyDeleteController.java
 *
 * @author newed
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정자 수정내용
 * ------ ------------------------
 * newed 최초 생성
 *
 * </pre>
 */
@WebServlet("/replyDelete")
public class ReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(ReplyDeleteController.class);
	
	private IReplyService replyService;
	
	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int reply_id = Integer.parseInt(request.getParameter("reply_id"));
		logger.debug("reply_id : {}",String.valueOf(reply_id));
		
		int article_id = Integer.parseInt(request.getParameter("article_id"));
		logger.debug("article_id : {}",String.valueOf(article_id));
		
		int deleteCnt = replyService.deleteReply(reply_id);
		if(deleteCnt == 1){
			response.sendRedirect(request.getContextPath() + "/articleController?article_id=" + article_id);
		}
		
	}


}
