package com.bean;

public class doubanTbl {
	private String topic;
	private String author;
	private String response;
	private String last_re;
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getLast_re() {
		return last_re;
	}
	public void setLast_re(String last_re) {
		this.last_re = last_re;
	}
	
	public void set(String s,String v) {
        if (s.equals("topic")) {
            this.setTopic(v);
        } else if (s.equals("author")) {
            this.setAuthor(v);
        } else if (s.equals("response")) {
            this.setResponse(v);
        } else if (s.equals("last_re")) {
            this.setLast_re(v);
        }
        return;
    }
}
