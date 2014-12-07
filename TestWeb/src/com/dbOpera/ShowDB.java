package com.dbOpera;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import com.bean.doubanTbl;


public class ShowDB {
	public String execute()throws Exception{
		
		OperaDB db = new OperaDB();
		List<doubanTbl> douban_list = db.showTbl();
			ServletActionContext.getRequest().getSession().setAttribute("douban_list",douban_list);
			ServletActionContext.getRequest().setAttribute("douban_list",douban_list);
			return "success";
		
	}
	

}
