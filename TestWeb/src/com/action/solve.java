package com.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.webpage.*;

public class solve {
	File[] html = null;
	
	public File[] getHtml() {
		return html;
	}
	public void setHtml(File[] html) {
		this.html = html;
	}
	public String execute() throws Exception{
		String index=ServletActionContext.getRequest().getSession().getAttribute("index").toString();
		if(index==null)
			return "failure";
		if(index.equals("1"))
			new gradeGet().get(html);
		else if(index.equals("2"))
			new taobaoGet().get(html);
		else if(index.equals("3"))
			new zfbGet().get(html);
		else if(index.equals("4"))
			new phoneGet().get(html);
		else if(index.equals("5"))
			new doubanGet().get(html);
		else if(index.equals("6"))
			new metalGet().get(html);
		else if(index.equals("7"))
			new singGet().get(html);
		else if(index.equals("8"))
			new gaokaoGet().get(html);
		else if(index.equals("9"))
			new movieGet().get(html);
		else if(index.equals("10"))
			new btGet().get(html);
		return index;
	}
}
