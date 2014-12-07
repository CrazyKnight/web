package com.zfbOpera;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.bean.zfbTbl;

public class ShowZfb {
	

		public String execute()throws Exception{
		
			OperaZfb db = new OperaZfb();
			List<zfbTbl> zfb_list = db.showTbl();
				ServletActionContext.getRequest().getSession().setAttribute("zfb_list",zfb_list);
				ServletActionContext.getRequest().setAttribute("zfb_list",zfb_list);
				return "success";
			
		
		

	}


}
