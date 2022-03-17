package ru.ylabs.crosszero.console;

import static java.lang.String.format;
import ru.ylabs.crosszero.model.Cell;

public class ConsoleNumberConverter implements CellNumberConverter{

    private final char[][] fields = {
        {'7', '8', '9'},
        {'4', '5', '6'},
        {'1', '2', '3'}
    };

    @Override
    public Cell toCell(final char number) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (fields[i][j] == number) {
                    return new Cell(i, j);
                }
            }
        }
        throw new IllegalArgumentException(
            format("Число должно быть от 1 до 9! На текущий момент: '%s'!", number)
        );
    }

    @Override
    public char toNumber(final Cell cell) {
        try {
            return fields[cell.getRow()][cell.getCol()];
        } catch (final ArrayIndexOutOfBoundsException ignore) {
            throw new IllegalArgumentException(
                format(
                    "Значения строк и столбцов в пределах от 0 до 2! Строка тек-ая %s, колонка тек-ая %s!",
                    cell.getRow(), cell.getCol()
                )
            );
        }
    }
}
