package ru.ylabs.crosszero.component;

import java.util.Scanner;
import ru.ylabs.crosszero.console.DataPrinter;
import ru.ylabs.crosszero.model.GameTable;
import ru.ylabs.crosszero.model.Player;

public class Game {

    private final Player player1;

    private final Player player2;

    private final DataPrinter dataPrinter;

    private final ValidatorService validatorService;

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public void setWinnerPlayer(final Player winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }

    private Player winnerPlayer;

    public void setGameTable(final GameTable gameTable) {
        this.gameTable = gameTable;
    }

    private GameTable gameTable;

    public Game(final Player player1, final Player player2, final DataPrinter dataPrinter,
                final ValidatorService validatorService, GameTable gameTable) {
        this.player1 = player1;
        this.player2 = player2;
        this.dataPrinter = dataPrinter;
        this.validatorService = validatorService;
        this.gameTable = gameTable;
    }

    public void play() {
        dataPrinter.printInstructions();
        dataPrinter.printGameTable(gameTable);
        final Player[] players = {player1, player2};
        while (true) {
            for (final Player player : players) {
                dataPrinter.printInfoMessage("Ходит игрок: " + player.getUsername());
                player.makeMove(gameTable);
                dataPrinter.printGameTable(gameTable);

                if (validatorService.isWinner(gameTable, player)) {
                    dataPrinter.printInfoMessage(player + " WIN!");
                    gameOver();
                    return;
                }
                if (validatorService.isFilled(gameTable)) {
                    dataPrinter.printInfoMessage("Sorry, DRAW!");
                    gameOver();
                    return;
                }
            }
        }
    }

//    TODO: Вынести окончания игры в отдельный слой.
    private void gameOver() {
        dataPrinter.printInfoMessage("GAME OVER!");
        dataPrinter.printInfoMessage("Продолжить играть или ввести рейтинг ? ");
        dataPrinter.printInfoMessage("Продолжить играть - нажми 1");
        dataPrinter.printInfoMessage("Продолжить играть - нажми 2");


        int command = Integer.parseInt(new Scanner(System.in).nextLine());
        if (command == 1) {
            setGameTable(new GameTable());
        } else if (command == 2) {
//            TODO: добавить сервисы для записи очков
            return;
        }
    }
}
