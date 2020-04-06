package com.company.lab7.compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class Board {
    private int n;
    private List<Token> tokenList;

    public Board() {
        this.tokenList = new ArrayList<Token>();
    }

    public Board(int n, List<Token> tokenList) {
        this.n = n;
        this.tokenList = tokenList;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public List<Token> getTokenList() {
        return this.tokenList;
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public void addToken(Token... token) {
        Collections.addAll(tokenList, token);
    }

    public boolean emptyBoard() {
        if (tokenList.isEmpty()) {
            return true;
        }
        return false;
    }

    public synchronized Token selectToken(int index) {
        if (!this.emptyBoard() && index < getTokenList().size()) {
            Token token = getTokenList().get(index);
            getTokenList().remove(getTokenList().get(index));
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return token;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Board{" +
                "n=" + n +
                ", tokenList=" + tokenList +
                '}';
    }
}
