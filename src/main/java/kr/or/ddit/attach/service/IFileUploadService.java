package kr.or.ddit.attach.service;

import java.util.List;

import kr.or.ddit.attach.model.AttachVo;

public interface IFileUploadService {

	int insertFile(AttachVo attachVo);
	
	int deleteFile(int attach_id);
	
	List<AttachVo> fileList (int attach_article);
	
	AttachVo getFile(int attach_id);
}
