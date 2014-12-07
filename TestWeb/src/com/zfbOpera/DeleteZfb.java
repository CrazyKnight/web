package com.zfbOpera;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.bean.zfbTbl;

public class DeleteZfb {
	private String zfb_index;
	public String execute()throws Exception{
		@SuppressWarnings("unchecked")
		List<zfbTbl> list = (List<zfbTbl>) ServletActionContext.getRequest().getSession().getAttribute("zfb_list");
		int number = Integer.parseInt(zfb_index);
		zfbTbl zfb = list.get(number);
		OperaZfb db = new OperaZfb();
		db.DeleteZfb(zfb);
		list.remove(number);
		ServletActionContext.getRequest().getSession().setAttribute("zfb_list",list);
		ServletActionContext.getRequest().setAttribute("zfb_list",list);
		return "success";
	}
	public String getZfb_index() {
		return zfb_index;
	}
	public void setZfb_index(String zfb_index) {
		this.zfb_index = zfb_index;
	}
	

}
