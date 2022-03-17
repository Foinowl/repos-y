package ru.ylabs.crosszero.console;

import ru.ylabs.crosszero.model.GameTable;

public interface DataPrinter {
    void printInstructions();

    void printInfoMessage(String message);

    void printErrorMessage(String message);

    void printGameTable(GameTable gameTable);
}
