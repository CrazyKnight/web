package com.bean;

public class gradeTbl {

    private String term;
    private String lessonNum;
    private String lessonName;
    private String techerName;
    private String kind;
    private String grade;
    private String time;
    private String myPoint;
    private String gradeKind;
    private String remark;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(String lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getTecherName() {
        return techerName;
    }

    public void setTecherName(String techerName) {
        this.techerName = techerName;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMyPoint() {
        return myPoint;
    }

    public void setMyPoint(String myPoint) {
        this.myPoint = myPoint;
    }

    public String getGradeKind() {
        return gradeKind;
    }

    public void setGradeKind(String gradeKind) {
        this.gradeKind = gradeKind;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void set(String s,String v) {
        if (s.equals("term")) {
            this.setTerm(v);
        } else if (s.equals("lessonNum")) {
            this.setLessonNum(v);
        } else if (s.equals("lessonName")) {
            this.setLessonName(v);
        } else if (s.equals("techerName")) {
            this.setTecherName(v);
        } else if (s.equals("kind")) {
            this.setKind(v);
        } else if (s.equals("grade")) {
            this.setGrade(v);
        } else if (s.equals("time")) {
            this.setTime(v);
        } else if (s.equals("myPoint")) {
            this.setMyPoint(v);
        } else if (s.equals("gradeKind")) {
            this.setGradeKind(v);
        } else if (s.equals("remark")) {
            this.setRemark(v);
        }
        return;
    }

}
