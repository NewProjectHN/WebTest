package com.dragon.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.dragon.bean.HomeBean;
import com.dragon.service.HomeService;

public class HomeAction extends AbstractBaseAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	private HomeService homeService;

	private HomeBean homeBean;
	
	public HomeBean getHomeBean() {
		return homeBean;
	}


	public void setHomeBean(HomeBean homeBean) {
		this.homeBean = homeBean;
	}


	public String execute() {
		homeBean = new HomeBean();
		homeBean.setCategoryLst(homeService.getAllCategory());
		return SUCCESS;
	}

}
