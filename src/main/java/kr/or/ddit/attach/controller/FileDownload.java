package kr.or.ddit.attach.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.attach.model.AttachVo;
import kr.or.ddit.attach.service.FileUploadService;
import kr.or.ddit.attach.service.IFileUploadService;



@WebServlet("/fileDownload")
public class FileDownload extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	   
	   private static final Logger logger = LoggerFactory
			.getLogger(FileDownload.class);
	   
	    private IFileUploadService fileUploadService;
	    
	    @Override
	    public void init() throws ServletException {
	    	fileUploadService = new FileUploadService();
	    }
	   
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      logger.debug("FileDownloadController doGet");
	      int attach_id = Integer.parseInt(request.getParameter("attach_id"));
	      logger.debug("아이디값 : {}", attach_id);
	      AttachVo attachVo = fileUploadService.getFile(attach_id);
	      logger.debug("attachvo : {}", attachVo);
	      String temp = attachVo.getAttach_route();
	      int index = temp.lastIndexOf("\\");
	      String path = temp.substring(0, index+1);
	      String fileName = temp.substring(index+1);
	      String viewFileName = attachVo.getAttach_name();
	      logger.debug("path : {}", path);
	      logger.debug("fileName : {}", fileName);
	      
	      request.setAttribute("path", path);
	      request.setAttribute("fileName", fileName);
	      request.setAttribute("viewFileName", viewFileName);
	      
	      request.getRequestDispatcher("/board/article/filedown.jsp").forward(request, response);
	   }

	}