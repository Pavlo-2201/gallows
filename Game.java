package project1.gallows;

import java.util.*;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    boolean isGameOver = false;
    private static final String EXIT_COMMAND = "0";
    private static final String RESTART_COMMAND = "1";

    public Game() {
    }

    void startGameLoop() {
        do {
            startGameRound();
            ConsolePrinter.printMenu(RESTART_COMMAND, EXIT_COMMAND);
            String input = scanner.nextLine();
            if (input.equals(EXIT_COMMAND)) {
                isGameOver = true;
                System.exit(0);
            } else if (input.equals(RESTART_COMMAND)) {
                continue;
            } else {
                ConsolePrinter.printErrorMessage("Некорректный символ.");
                break;
            }
        } while (!isGameOver);
    }

    void startGameRound() {
        MaskaOfWord maskaOfWord = new MaskaOfWord(Words.GetWordForGame());
        Set<Character> incorrectLetters = new HashSet<>();
        int attempts = 6;
        ConsolePrinter.printChar(maskaOfWord.getMask());
        while (attempts > 0) {

            String input = scanner.nextLine();
            if (!Validator.isValid(input)) {
                ConsolePrinter.printValidationException();
                continue;
            }
            char letter = input.toLowerCase().charAt(0);
            if (maskaOfWord.openLetter(letter)) {
                ConsolePrinter.printGuess(maskaOfWord.getMask());
            } else {
                if (!incorrectLetters.contains(letter)) {
                    incorrectLetters.add(letter);
                    attempts--;
                    ConsolePrinter.printProcessedGuess(maskaOfWord.getMask(), attempts, incorrectLetters);
                } else {
                    ConsolePrinter.printErrorMessage("Буква уже была использована");
                }
            }
            if (attempts <= 0 || maskaOfWord.isTargetEqualsMask()) {
                checkGameRoundState(attempts, maskaOfWord);
                return;
            }
        }
    }


    void checkGameRoundState(int attempts, MaskaOfWord maskaOfWord) {
        if (attempts > 0 && maskaOfWord.isTargetEqualsMask()) {
            ConsolePrinter.printVictory(maskaOfWord.getTargetWord());
        } else if (attempts <= 0 && !maskaOfWord.isTargetEqualsMask()) {
            ConsolePrinter.printDefeat(maskaOfWord.getTargetWord());
        }
    }
}
