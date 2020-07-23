package com.example.quizapp;

public class Question {
    private int answerResID;
    private boolean answerTrue;

    public Question(int answerResID, boolean answerTrue) {
        this.answerResID = answerResID;
        this.answerTrue = answerTrue;
    }

    public int getAnswerResID() {
        return answerResID;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerResID(int answerResID) {
        this.answerResID = answerResID;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
