package com.example.GuessTheWord.Entity;

import java.util.List;

public class Word {
    private int id;
    private String word;
    private List<String> hint;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getHint() {
        return hint;
    }

    public void setHint(List<String> hint) {
        this.hint = hint;
    }
}
