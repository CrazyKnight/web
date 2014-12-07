package com.MusicOpera;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import com.bean.singTbl;


public class ShowMusic {
public String execute()throws Exception{
		
		OperaMusic db = new OperaMusic();
		List<singTbl> Music_list = db.showTbl();
			ServletActionContext.getRequest().getSession().setAttribute("Music_list",Music_list);
			ServletActionContext.getRequest().setAttribute("Music_list",Music_list);
			return "success";
		
	}
	

}
