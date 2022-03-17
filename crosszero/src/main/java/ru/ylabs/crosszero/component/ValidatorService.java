package ru.ylabs.crosszero.component;

import ru.ylabs.crosszero.model.Cell;
import ru.ylabs.crosszero.model.GameTable;
import ru.ylabs.crosszero.model.Player;
import ru.ylabs.crosszero.model.Sign;


// TODO: Create factory service, we'll return all service that responsibility of validate any objects
public class ValidatorService implements WinnerVerifier, TableValidate{

    @Override
    public boolean isFilled(GameTable gameTable) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable.isEmpty(new Cell(i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWinner(GameTable gameTable, final Player player) {
        return isWinnerByRows(gameTable, player.getSign()) ||
            isWinnerByCols(gameTable, player.getSign()) ||
            isWinnerByMainDiagonal(gameTable, player.getSign()) ||
            isWinnerBySecondaryDiagonal(gameTable, player.getSign());
    }

    private boolean isWinnerByRows(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == gameTable.getSign(new Cell(i, 1)) &&
                gameTable.getSign(new Cell(i, 1)) == gameTable.getSign(new Cell(i, 2)) &&
                gameTable.getSign(new Cell(i, 2)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerByCols(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(0, i)) == gameTable.getSign(new Cell(1, i)) &&
                gameTable.getSign(new Cell(1, i)) == gameTable.getSign(new Cell(2, i)) &&
                gameTable.getSign(new Cell(2, i)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerByMainDiagonal(final GameTable gameTable, final Sign sign) {
        return gameTable.getSign(new Cell(0, 0)) == gameTable.getSign(new Cell(1, 1)) &&
            gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(2, 2)) &&
            gameTable.getSign(new Cell(2, 2)) == sign;
    }

    private boolean isWinnerBySecondaryDiagonal(final GameTable gameTable, final Sign sign) {
        return gameTable.getSign(new Cell(2, 0)) == gameTable.getSign(new Cell(1, 1)) &&
            gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(0, 2)) &&
            gameTable.getSign(new Cell(0, 2)) == sign;
    }
}
