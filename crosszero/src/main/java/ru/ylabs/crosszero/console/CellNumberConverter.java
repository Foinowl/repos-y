package ru.ylabs.crosszero.console;

import ru.ylabs.crosszero.model.Cell;

public interface CellNumberConverter {
    Cell toCell(char number);

    char toNumber(Cell cell);
}
