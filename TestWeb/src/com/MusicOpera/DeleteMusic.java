package com.MusicOpera;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import com.bean.singTbl;


public class DeleteMusic {
	private String music_index;
	public String execute()throws Exception{
		@SuppressWarnings("unchecked")
		List<singTbl> list = (List<singTbl>) ServletActionContext.getRequest().getSession().getAttribute("Music_list");
		int number = Integer.parseInt(music_index);
		singTbl tb = list.get(number);
		OperaMusic db = new OperaMusic();
		db.DeleteMusic(tb);
		list.remove(number);
		ServletActionContext.getRequest().getSession().setAttribute("Music_list",list);
		ServletActionContext.getRequest().setAttribute("Music_list",list);
		return "success";
	}
	public String getMusic_index() {
		return music_index;
	}
	public void setMusic_index(String music_index) {
		this.music_index = music_index;
	}
	
	

}
