package com.bean;

public class movieTbl {
	private String name;
	private String actor;
	private String place;
	private String type;
	private String grade;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public void set(String s,String v) {
        if (s.equals("name")) {
            this.setName(v);
        } else if (s.equals("actor")) {
            this.setActor(v);
        } else if (s.equals("place")) {
            this.setPlace(v);
        } else if (s.equals("type")) {
            this.setType(v);
        } else if (s.equals("grade")) {
            this.setGrade(v);
        } 
        return;
    }
}
