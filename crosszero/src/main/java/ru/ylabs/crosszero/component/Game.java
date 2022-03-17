package ru.ylabs.crosszero.component;

import ru.ylabs.crosszero.model.GameTable;
import ru.ylabs.crosszero.model.Player;

public class Game {

    private final Player player1;

    private final Player player2;

    final DataPrinter dataPrinter;

    public Game(final Player player1, final Player player2, final DataPrinter dataPrinter) {
        this.player1 = player1;
        this.player2 = player2;
        this.dataPrinter = dataPrinter;
    }

    public void play() {
        dataPrinter.printInstructions();
        final GameTable gameTable = new GameTable();
        final Player[] players = {player1, player2};
        while (true) {
            for (final Player player : players) {
                player.makeMove(gameTable);
                dataPrinter.printGameTable(gameTable);
//                TODO: Check winner or all fields was filled
            }
        }
    }
}
