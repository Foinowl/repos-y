package ru.ylabs.crosszero.model;

import ru.ylabs.crosszero.component.Move;

public class Player {

    private final String username;

    private final Sign sign;

    private final Move move;

    public Player(final String username, final Sign sign, final Move move) {
        this.username = username;
        this.sign = sign;
        this.move = move;
    }

    public String getUsername() {
        return username;
    }

    public Sign getSign() {
        return sign;
    }

    public void makeMove(final GameTable gameTable) {
        move.make(gameTable, sign);
    }

    @Override
    public String toString() {
        return "Player{" +
            "username='" + username + '\'' +
            ", sign=" + sign +
            '}';
    }
}
