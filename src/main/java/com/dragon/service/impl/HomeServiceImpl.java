package com.dragon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dragon.dao.HomeDao;
import com.dragon.model.Category;
import com.dragon.service.HomeService;

public class HomeServiceImpl implements HomeService {
	@Autowired
	private HomeDao homeDao;

	@Override
	public List<Category> getAllCategory() {
		return homeDao.getAllCategory();
	}

	
}
