package com.blog.service.impl;

import javax.annotation.Resource;

import com.blog.service.UploadService;
import org.springframework.stereotype.Service;

import com.blog.dao.UploadDao;
import com.blog.entity.Upload;
@Service("uploadService")
public class UploadServiceImpl implements UploadService {
	@Resource
	private UploadDao uploadDao;

	public Integer insertPath(Upload upload) {
		// TODO Auto-generated method stub
		return uploadDao.insertPath(upload);
	}




}
