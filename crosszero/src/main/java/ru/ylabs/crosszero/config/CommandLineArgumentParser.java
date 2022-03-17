package ru.ylabs.crosszero.config;

import ru.ylabs.crosszero.component.Move;
import ru.ylabs.crosszero.model.GameTable;
import ru.ylabs.crosszero.model.Player;
import ru.ylabs.crosszero.model.Sign;

public class CommandLineArgumentParser {

    private final String[] args;

    public CommandLineArgumentParser(final String[] args) {
        this.args = args;
    }

    public CommandLineArguments parse() {
        Player player1 = null;
        Player player2 = null;

        for (final String  param: args){
            if (player1 == null) {
                player1 = new Player(param, Sign.X, new Move() {
                    public void make(final GameTable gameTable, final Sign sign) {

                    }
                });
            } else if (player2 == null) {
                player2 = new Player(param, Sign.X, new Move() {
                    public void make(final GameTable gameTable, final Sign sign) {

                    }
                });
            }
            ;
        }
        return new CommandLineArguments(player1, player2);
    }

    public static class CommandLineArguments {

        private final Player player1Type;

        private final Player player2Type;

        private CommandLineArguments(final Player player1Type,
                                     final Player player2Type) {
            this.player1Type = player1Type;
            this.player2Type = player2Type;
        }

        public Player getPlayer1() {
            return player1Type;
        }

        public Player getPlayer2() {
            return player2Type;
        }
    }
}
