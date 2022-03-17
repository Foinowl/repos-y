package ru.ylabs.crosszero.component;

import ru.ylabs.crosszero.model.GameTable;
import ru.ylabs.crosszero.model.Sign;

public interface Move {
    void make(GameTable gameTable, Sign sign);
}
