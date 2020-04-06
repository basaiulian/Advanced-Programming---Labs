package com.company.lab7.compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private List<Token> selectedTokenList;
    private Game game;

    public Player() {
        this.game = new Game();
        this.selectedTokenList = new ArrayList<>();
    }


    public Player(String name) {
        this.name = name;
        this.selectedTokenList = new ArrayList<>();
    }

    public List<Token> getSelectedTokenList() {
        return selectedTokenList;
    }

    public void setSelectedTokenList(List<Token> selectedTokenList) {
        this.selectedTokenList = selectedTokenList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Token> getSelectedToken() {
        return selectedTokenList;
    }

    public void setSelectedToken(List<Token> selectedToken) {
        this.selectedTokenList = selectedToken;
    }

    public void addToken(Token... token) {
        Collections.addAll(selectedTokenList, token);
    }

    public void selectToken(int index) {
        Token token;
        Board board = game.getBoard();
        token = board.selectToken(index);
        this.selectedTokenList.add(token);
    }

    public boolean play() throws InterruptedException {
        Board board = game.getBoard();
        if (board.emptyBoard()) {
            return false;
        } else {
            selectToken(board.getTokenList().size() - 1);
        }
        return true;
    }

    @Override
    public void run() {
        try {
            while (play()) {
                System.out.println("Token selected by " + this.getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "\nPlayer{" +
                "name='" + name + '\'' +
                ", selectedTokenList=" + selectedTokenList +
                "}\n";
    }
}
