package com.company.lab7.compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> playerList;

    public Game() {
        this.playerList = new ArrayList<Player>();
    }

    public Game(Board board, List<Player> playerList) {
        this.board = board;
        this.playerList = playerList;
    }

    public void addPlayer(Player... player) {
        Collections.addAll(playerList, player);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void start() {

        Thread[] threadArray = new Thread[playerList.size()];

        for (int i = 0; i < playerList.size(); i++) {
            threadArray[i] = new Thread(playerList.get(i));
            threadArray[i].start();
        }

        for (Thread thread : threadArray) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return "Game{" +
                "board=" + board +
                ", playerList=" + playerList +
                '}' + "\n";
    }
}


