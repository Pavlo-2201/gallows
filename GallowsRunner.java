package project1;

public class GallowsRunner {
    public static void main(String[] args) {
        ConsolePrinter.printGameInfo();
        Game game = new Game();
        game.startGameLoop();
    }
}
