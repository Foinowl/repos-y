package ru.ylabs.crosszero.console;

import java.util.Scanner;
import ru.ylabs.crosszero.model.Cell;

public class UserInputReaderImpl implements UserInputReader{

    private final CellNumberConverter cellNumberConverter;

    private final DataPrinter dataPrinter;

    public UserInputReaderImpl(final CellNumberConverter cellNumberConverter,
                                  final DataPrinter dataPrinter) {
        this.cellNumberConverter = cellNumberConverter;
        this.dataPrinter = dataPrinter;
    }

    @Override
    public Cell getUserInput() {
        while (true) {
            dataPrinter.printInfoMessage("Please type number between 1 and 9:");
            final String userInput = new Scanner(System.in).nextLine();
            if (userInput.length() == 1) {
                final char ch = userInput.charAt(0);
                if (ch >= '1' && ch <= '9') {
                    return cellNumberConverter.toCell(ch);
                }
            }
        }
    }
}
