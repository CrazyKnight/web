package com.MovieOpera;

import java.util.List;

import org.apache.struts2.ServletActionContext;


import com.bean.movieTbl;


public class DeleteMovie {
	private String movie_index;
	public String execute()throws Exception{
		@SuppressWarnings("unchecked")
		List<movieTbl> list = (List<movieTbl>) ServletActionContext.getRequest().getSession().getAttribute("movie_list");
		int number = Integer.parseInt(movie_index);
		movieTbl tb = list.get(number);
		OperaMovie db = new OperaMovie();
		db.DeleteTB(tb);
		list.remove(number);
		ServletActionContext.getRequest().getSession().setAttribute("movie_list",list);
		ServletActionContext.getRequest().setAttribute("movie_list",list);
		return "success";
	}
	public String getMovie_index() {
		return movie_index;
	}
	public void setMovie_index(String movie_index) {
		this.movie_index = movie_index;
	}
	

}
