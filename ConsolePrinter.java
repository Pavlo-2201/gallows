package project1.gallows;

import java.util.*;

public class ConsolePrinter {
    static void printGameInfo() {
        printGameDescription();
        printGameRules();
        printGameStart();
    }

    private static void printGameDescription() {
        System.out.println("***");
        System.out.println("ОПИСАНИЕ ИГРЫ.");
        System.out.println("«Виселица» - это игра в слова.");
        System.out.println("Один игрок загадывает слово, а второй игрок пытается его отгадать, предлагая свой вариант по одной букве.");
        System.out.println("За каждую неверную букву, к виселице добавлять часть тела. Цель игры – отгадать слово до того, как висельник будет повешен.\n");
    }

    private static void printGameRules() {
        System.out.println("***");
        System.out.println("ПРАВИЛА ИГРЫ.");
        System.out.println("""
                1. ПРОГРАММА загадывает случайное слово русского языка.
                   Слово – имя существительное в единственном числе или множественном числе при отсутствии у слова формы единственного числа.
                   ПОЛЬЗОВАТЕЛЬ будет видеть количество букв загаданного слова (каждая буква загаданного слова засекречена и представлена в виде символа “_”).""");
        System.out.println("2. ПОЛЬЗОВАТЕЛЬ угадывает слово по буквам.");
        System.out.println("3. Если такая буква есть, ПРОГРАММА показывает ПОЛЬЗОВАТЕЛЮ позиции буквы в загаданном слове.");
        System.out.println("""
                4. Всего у ПОЛЬЗОВАТЕЛЯ будет 6 попыток отгадать слово.
                   За каждый неправильный ответ счетчик попыток увеличивается, и ПРОГРАММА добавлять к виселице одну из 6 части тела: голова, тело, 2 руки и 2 ноги.
                   Если на виселице тело нарисовано полностью, ПОЛЬЗОВАТЕЛЬ проигрывает и считается повешенным.
                """);
    }

    private static void printGameStart() {
        System.out.println("***");
        System.out.println("Начало игры.");
        System.out.println("***");
    }

    static void printValidationException() {
        System.out.println("__________________________________");
        System.out.println("Ошибка! Принимаются только одиночные буквы русского алфавита");
        System.out.print("Ожидание ввода... -> ");
    }

    public static void printProcessedGuess(StringBuilder maskedWord, int attempts, Set<Character> usedLetters) {
        System.out.println("__________________________________");
        System.out.printf("Отгадайте слово: %s%n", maskedWord);
        System.out.printf("Использованы буквы: %s%n", usedLetters.toString());
        System.out.println(PicturesOfGameProcess.printPicture(6 - attempts));
        if (attempts > 0) {
            System.out.printf("До поражения осталось ошибок: %d%n", attempts);
            System.out.print("Ожидание ввода... -> ");
        }
    }

    public static void printGuess(StringBuilder maskedWord) {
        System.out.println("__________________________________");
        System.out.println("Буква отгадана");
        System.out.printf("Отгадайте слово: %s%n", maskedWord);
        System.out.print("Ожидание ввода... -> ");
    }

    public static void printChar(StringBuilder maskedWord) {
        System.out.println("__________________________________");
        System.out.printf("Отгадайте слово: %s%n", maskedWord);
        System.out.print("Ожидание ввода... -> ");
    }

    public static void printVictory(String word) {
        System.out.println("\n__________________________________");
        System.out.printf("Поздравляем, вы отгадали слово \"%s\" %n%n", word);
    }

    public static void printDefeat(String word) {
        System.out.println("\n__________________________________");
        System.out.println("\nВы проиграли!");
        System.out.printf("Было загаданно слово: \"%s\" %n%n", word);
    }

    public static void printMenu(String restartCommand, String exitCommand) {
        System.out.printf("Введите \"%s\" чтобы начать новую игру, для выхода \"%s\"%n",
                restartCommand, exitCommand);
        System.out.print("Ожидание ввода... -> ");
    }

    public static void printErrorMessage(String message) {
        System.out.println("__________________________________");
        System.out.printf("Ошибка! %s%n", message);
    }
}
