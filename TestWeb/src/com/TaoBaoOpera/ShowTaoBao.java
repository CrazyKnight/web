package com.TaoBaoOpera;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.bean.taobaoTbl;


public class ShowTaoBao {
	public String execute()throws Exception{
		
		OperaTaoBao db = new OperaTaoBao();
		List<taobaoTbl> taobao_list = db.showTbl();
			ServletActionContext.getRequest().getSession().setAttribute("taobao_list",taobao_list);
			ServletActionContext.getRequest().setAttribute("taobao_list",taobao_list);
			return "success";
		
	}
	

}
