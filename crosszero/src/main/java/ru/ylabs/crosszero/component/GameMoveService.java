package ru.ylabs.crosszero.component;

import ru.ylabs.crosszero.console.DataPrinter;
import ru.ylabs.crosszero.console.UserInputReader;
import ru.ylabs.crosszero.model.Cell;
import ru.ylabs.crosszero.model.GameTable;
import ru.ylabs.crosszero.model.Sign;

public class GameMoveService implements Move{

    private final UserInputReader userInputReader;

    private final DataPrinter dataPrinter;

    public GameMoveService(final UserInputReader userInputReader,
                           final DataPrinter dataPrinter) {
        this.userInputReader = userInputReader;
        this.dataPrinter = dataPrinter;
    }

    @Override
    public void make(final GameTable gameTable, final Sign sign) {
        while (true) {
            Cell cell = userInputReader.getUserInput();
            if(gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, sign);
                return;
            } else {
                dataPrinter.printErrorMessage("Клетка занята, выбери другую");
            }
        }
    }
}
