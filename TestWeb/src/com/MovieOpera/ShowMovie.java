package com.MovieOpera;

import java.util.List;

import org.apache.struts2.ServletActionContext;


import com.bean.movieTbl;


public class ShowMovie {
	public String execute()throws Exception{
		
		OperaMovie db = new OperaMovie();
		List<movieTbl> movie_list = db.showTbl();
			ServletActionContext.getRequest().getSession().setAttribute("movie_list", movie_list);
			ServletActionContext.getRequest().setAttribute("movie_list", movie_list);
			return "success";
		
	}

}
