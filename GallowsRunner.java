package project1.gallows;

public class GallowsRunner {
    public static void main(String[] args) {
        ConsolePrinter.printGameInfo();
        Game game = new Game();
        game.startGameLoop();
    }
}
