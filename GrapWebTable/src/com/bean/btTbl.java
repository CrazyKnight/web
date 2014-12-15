package com.bean;

public class btTbl {
	private String title;
	private String day;
	private String actor;
	private String type;
	private String scan_num;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getScan_num() {
		return scan_num;
	}

	public void setScan_num(String scan_num) {
		this.scan_num = scan_num;
	}
	
	public void set(String s,String v) {
        if (s.equals("title")) {
            this.setTitle(v);
        } else if (s.equals("day")) {
            this.setDay(v);
        } else if (s.equals("actor")) {
            this.setActor(v);
        } else if (s.equals("type")) {
            this.setType(v);
        } else if (s.equals("scan_num")) {
            this.setScan_num(v);
        }
        return;
    }
}
