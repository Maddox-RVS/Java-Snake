public class Main {
    private final static Game game = new Game();
    private static GameTimer gameLoop;

    public static void main(String[] args) throws Exception {
        gameLoop = new GameTimer(Constants.TimeUnit.MILLISECONDS, 1.0, () -> {game.Update(); game.Draw();});
        game.Initialize();
    }
}
