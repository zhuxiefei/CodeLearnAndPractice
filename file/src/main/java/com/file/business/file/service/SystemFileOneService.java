package com.file.business.file.service;

import basic.common.core.dto.PageDto;
import com.file.business.file.model.SystemFile;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *  SystemFileService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-18 
 */
public interface SystemFileOneService {
	
	int insertSystemFile(SystemFile systemFile);
	
	int insertSystemFileBatch(List<SystemFile> list);
	
	int updateSystemFileById(SystemFile systemFile);
	
	boolean deleteSystemFileById(String fileId);
	
 	SystemFile getSystemFileById(String fileId);
 
 	List<SystemFile> getSystemFiles(SystemFile systemFile);

 	PageDto<SystemFile> getSystemFilesForPage(SystemFile systemFile, Pageable pageable);


}
