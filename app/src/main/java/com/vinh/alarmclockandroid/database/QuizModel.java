package com.vinh.alarmclockandroid.database;

import java.io.Serializable;

/**
 * Created by Admin on 9/5/2017.
 */

public class QuizModel implements Serializable {
    private int id;
    private String question;
    private String answera;
    private String answerb;
    private String answerc;
    private String answerd;
    private int realalswer;
    private int level;
    private int job;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswera() {
        return answera;
    }

    public void setAnswera(String answera) {
        this.answera = answera;
    }

    public String getAnswerb() {
        return answerb;
    }

    public void setAnswerb(String answerb) {
        this.answerb = answerb;
    }

    public String getAnswerc() {
        return answerc;
    }

    public void setAnswerc(String answerc) {
        this.answerc = answerc;
    }

    public String getAnswerd() {
        return answerd;
    }

    public void setAnswerd(String answerd) {
        this.answerd = answerd;
    }

    public int getRealalswer() {
        return realalswer;
    }

    public void setRealalswer(int realalswer) {
        this.realalswer = realalswer;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public QuizModel(int id, String question, String answera, String answerb, String answerc, String answerd, int realalswer, int level, int job) {
        this.id = id;
        this.question = question;
        this.answera = answera;
        this.answerb = answerb;
        this.answerc = answerc;
        this.answerd = answerd;
        this.realalswer = realalswer;
        this.level = level;
        this.job = job;
    }
}
