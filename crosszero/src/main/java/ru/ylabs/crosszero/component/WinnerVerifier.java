package ru.ylabs.crosszero.component;

import ru.ylabs.crosszero.model.GameTable;
import ru.ylabs.crosszero.model.Player;

public interface WinnerVerifier {
    boolean isWinner(GameTable gameTable, Player player);
}
