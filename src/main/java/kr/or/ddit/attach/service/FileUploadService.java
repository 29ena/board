package kr.or.ddit.attach.service;

import java.util.List;

import kr.or.ddit.attach.dao.FileUploadDao;
import kr.or.ddit.attach.dao.IFileUploadDao;
import kr.or.ddit.attach.model.AttachVo;

public class FileUploadService implements IFileUploadService {

	private IFileUploadDao fileUploadDao;
	
	
	
	public FileUploadService() {
		fileUploadDao = new FileUploadDao();
	}

	@Override
	public int insertFile(AttachVo attachVo) {
		return fileUploadDao.insertFile(attachVo);
	}

	@Override
	public int deleteFile(int attach_id) {
		return fileUploadDao.deleteFile(attach_id);
	}

	@Override
	public List<AttachVo> fileList(int attach_article) {
		return fileUploadDao.fileList(attach_article);
	}

	@Override
	public AttachVo getFile(int attach_id) {
		return fileUploadDao.getFile(attach_id);
	}

}
