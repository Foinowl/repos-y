package ru.ylabs.crosszero.console;

import ru.ylabs.crosszero.model.Cell;
import ru.ylabs.crosszero.model.GameTable;

public class DataPrinterImpl implements DataPrinter {

    private final CellNumberConverter cellNumberConverter;

    public DataPrinterImpl(final CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    @Override
    public void printInstructions() {
        printInfoMessage("Следуйте номерам ячеек для заполнения полей");
        print((i, j) -> String.valueOf(cellNumberConverter.toNumber(new Cell(i, j))));
    }

    @Override
    public void printInfoMessage(final String message) {
        System.out.println(message);
    }

    @Override
    public void printErrorMessage(final String message) {
        System.err.println(message);
    }

    @Override
    public void printGameTable(final GameTable gameTable) {
        print((i, j) -> String.valueOf(gameTable.getSign(new Cell(i, j))));
    }

    private void print(final Lambda lambda) {
        for (int i = 0; i < 3; i++) {
            System.out.println(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + lambda.getValue(i, j) + " ");
            }
            System.out.println("|");
        }
    }

    @FunctionalInterface
    private interface Lambda {

        String getValue(int i, int j);
    }
}
