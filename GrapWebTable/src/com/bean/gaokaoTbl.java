package com.bean;

public class gaokaoTbl {
	private String grade;
	private String stuNum;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	
	public void set(String s,String v) {
        if (s.equals("grade")) {
            this.setGrade(v);
        } else if (s.equals("stuNum")) {
            this.setStuNum(v);
        }
        return;
    }
}
