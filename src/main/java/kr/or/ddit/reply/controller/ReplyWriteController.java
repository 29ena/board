package kr.or.ddit.reply.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * ReplyWriteController.java
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
@WebServlet("/replyWrite")
public class ReplyWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(ReplyWriteController.class);
	
	private IReplyService replyService;
	
	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		logger.debug("doPost");
		
		int reply_article = Integer.parseInt(request.getParameter("reply_article"));
		logger.debug("reply_article_id : {}", reply_article);
		String reply_userid = request.getParameter("reply_userid");
		String reply_content = request.getParameter("reply_content");
		Date dt = new Date();
		
		ReplyVo replyVo = new ReplyVo(reply_article, reply_userid, reply_content, dt);
		logger.debug("replyVo : {}", replyVo);
		
		int article_id = Integer.parseInt(request.getParameter("article_id"));
		logger.debug("article_id : {}", article_id);
		if(replyVo != null){
			int insertCnt = replyService.insertReply(replyVo); 
			logger.debug("insertCnt : {}", insertCnt);
			if(insertCnt ==1){
				response.sendRedirect(request.getContextPath() + "/articleController?article_id=" +article_id);
			}
		}
	}

}
