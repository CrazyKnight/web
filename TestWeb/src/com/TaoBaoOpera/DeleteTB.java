package com.TaoBaoOpera;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.bean.taobaoTbl;


public class DeleteTB {
	private String taobao_index;
	public String execute()throws Exception{
		@SuppressWarnings("unchecked")
		List<taobaoTbl> list = (List<taobaoTbl>) ServletActionContext.getRequest().getSession().getAttribute("taobao_list");
		int number = Integer.parseInt(taobao_index);
		taobaoTbl tb = list.get(number);
		OperaTaoBao db = new OperaTaoBao();
		db.DeleteTB(tb);
		list.remove(number);
		ServletActionContext.getRequest().getSession().setAttribute("taobao_list",list);
		ServletActionContext.getRequest().setAttribute("taobao_list",list);
		return "success";
	}
	public String getTaobao_index() {
		return taobao_index;
	}
	public void setTaobao_index(String taobao_index) {
		this.taobao_index = taobao_index;
	}
	
	

}
