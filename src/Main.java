import Utils.GameTimer;
import Utils.GameTimer.TimeUnit;

public class Main {
    private final static Game game = new Game();
    private static GameTimer gameLoop;

    public static void main(String[] args) throws Exception {
        gameLoop = new GameTimer(TimeUnit.MILLISECONDS, 20.0, () -> {game.Update(); game.Draw();});
    }
}
