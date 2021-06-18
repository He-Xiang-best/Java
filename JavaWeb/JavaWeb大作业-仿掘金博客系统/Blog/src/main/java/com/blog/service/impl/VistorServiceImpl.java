package com.blog.service.impl;

import com.blog.dao.VistorDao;
import com.blog.entity.Vistor;
import com.blog.service.VistorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service("vistorService")
public class VistorServiceImpl implements VistorService {
	@Resource
	private VistorDao vistorDao;

	public List<Vistor> listVistor() {
		// TODO Auto-generated method stub
		return vistorDao.listVistor();
	}

	@Override
	public List<Vistor> listVistorByMap(Map<String, Object> map) {
		return vistorDao.listVistorByMap(map);
	}

	public Integer insertVistor(Vistor vistor) {
		// TODO Auto-generated method stub
		return vistorDao.insertVistor(vistor);
	}

	public Integer countVistor() {
		// TODO Auto-generated method stub
		return vistorDao.countVistor();
	}

	public Integer deleteVistor(Integer id) {
		// TODO Auto-generated method stub
		return vistorDao.deleteVistor(id);
	}


}
