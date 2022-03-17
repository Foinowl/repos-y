package ru.ylabs.crosszero;

import ru.ylabs.crosszero.component.Game;
import ru.ylabs.crosszero.component.GameMoveService;
import ru.ylabs.crosszero.component.Move;
import ru.ylabs.crosszero.component.ValidatorService;
import ru.ylabs.crosszero.config.CommandLineArgumentParser;
import ru.ylabs.crosszero.console.CellNumberConverter;
import ru.ylabs.crosszero.console.ConsoleNumberConverter;
import ru.ylabs.crosszero.console.DataPrinter;
import ru.ylabs.crosszero.console.DataPrinterImpl;
import ru.ylabs.crosszero.console.UserInputReader;
import ru.ylabs.crosszero.console.UserInputReaderImpl;
import ru.ylabs.crosszero.model.GameTable;

public class Runner {
    public static void main(String[] args) {
        CommandLineArgumentParser commandParser = new CommandLineArgumentParser(args);

        final CellNumberConverter consoleNumberConverter = new ConsoleNumberConverter();
        final DataPrinter dataPrinter = new DataPrinterImpl(consoleNumberConverter);

        final UserInputReader userInputReader = new UserInputReaderImpl(consoleNumberConverter, dataPrinter);
        final Move move = new GameMoveService(userInputReader, dataPrinter);
        final GameTable gameTable = new GameTable();

        CommandLineArgumentParser.CommandLineArguments lineArguments = commandParser.parse(move);

        final ValidatorService validatorService = new ValidatorService();

        new Game(lineArguments.getPlayer1(), lineArguments.getPlayer2(), dataPrinter, validatorService, gameTable).play();
    }
}
