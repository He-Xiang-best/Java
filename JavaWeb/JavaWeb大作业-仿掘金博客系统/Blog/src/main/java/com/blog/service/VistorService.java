package com.blog.service;

import com.blog.entity.Vistor;

import java.util.List;
import java.util.Map;

public interface VistorService {
	List<Vistor> listVistor();
	List<Vistor> listVistorByMap(Map<String, Object> map);
	Integer insertVistor(Vistor vistor);
	Integer countVistor();
	Integer deleteVistor(Integer id);

}
