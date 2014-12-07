package com.dbOpera;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import com.bean.doubanTbl;


public class DeleteDB {
	private String db_index;
	public String execute()throws Exception{
		@SuppressWarnings("unchecked")
		List<doubanTbl> list = (List<doubanTbl>) ServletActionContext.getRequest().getSession().getAttribute("douban_list");
		int number = Integer.parseInt(db_index);
		doubanTbl tb = list.get(number);
		OperaDB db = new OperaDB();
		db.DeleteDB(tb);
		list.remove(number);
		ServletActionContext.getRequest().getSession().setAttribute("douban_list",list);
		ServletActionContext.getRequest().setAttribute("douban_list",list);
		return "success";
	}
	public String getDb_index() {
		return db_index;
	}
	public void setDb_index(String db_index) {
		this.db_index = db_index;
	}
	
}
