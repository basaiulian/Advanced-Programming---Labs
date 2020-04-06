package com.company.lab7.compulsory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        board.setN(6);

        Game game = new Game();
        game.setBoard(board);

        List<Token> tokenList ;
        List<Player> playerList;

        Player playerArray[];
        playerArray = IntStream.rangeClosed(1, 2)
                .mapToObj(i -> new Player("Player" + i))
                .toArray(Player[]::new);

        playerList = Arrays.asList(playerArray);
        for (Player player : playerList) {
            player.setGame(game);
        }

        game.setPlayerList(playerList);

        Token tokenArray[];
        tokenArray = IntStream.rangeClosed(1, 6)
                .mapToObj(i -> new Token(i))
                .toArray(Token[]::new);

        tokenList = Arrays.asList(tokenArray);
        board.getTokenList().addAll(tokenList);

        game.start();

        for (Player player : playerList) {
            System.out.println(player.getName() + " === " + player.getSelectedTokenList());
        }

    }
}
