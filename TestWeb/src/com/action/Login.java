package com.action;

import com.jdbc.MyOperation;

public class Login {
	String username;
	String password;
	String Tip;
	
	public String execute()throws Exception{
		MyOperation op = new MyOperation();
		if(!op.exit_user(username, password)){
			this.setTip("用户名或密码错误，请重新输入！");
			return "fail";
		}else{
			return "success";
		}
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTip() {
		return Tip;
	}

	public void setTip(String tip) {
		Tip = tip;
	}
	
	

}
