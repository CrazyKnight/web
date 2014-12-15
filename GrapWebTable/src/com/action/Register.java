package com.action;

import com.jdbc.MyOperation;

public class Register {
	String set_username;
	String set_password;
	String test_password;
	String Tip1;
	
	public String execute()throws Exception{
		MyOperation op = new MyOperation();
		if(set_username.equals("") || set_password.equals("")){
			this.setTip1("用户名或密码不能为空，请重新输入！");
			return "fail";
		}else if(!set_password.equals(test_password)){
			this.setTip1("两次密码不一致，请重新输入！");
			return "fail";
		}else if(op.exit_username(set_username)){
			this.setTip1("存在该用户，请重新输入！");
			return "fail";
		}else{
		    op.addUser(set_username, set_password);
			return "success";
		}
		
	}

	public String getSet_username() {
		return set_username;
	}

	public void setSet_username(String set_username) {
		this.set_username = set_username;
	}

	public String getSet_password() {
		return set_password;
	}

	public void setSet_password(String set_password) {
		this.set_password = set_password;
	}

	public String getTest_password() {
		return test_password;
	}

	public void setTest_password(String test_password) {
		this.test_password = test_password;
	}

	public String getTip1() {
		return Tip1;
	}

	public void setTip1(String tip1) {
		Tip1 = tip1;
	}
	
	

}
