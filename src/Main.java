import Utils.GameTimer;
import Utils.Grid;
import Utils.Logger;
import Utils.GameTimer.TimeUnit;

public class Main {
    private final static Game game = new Game();
    private static GameTimer gameLoop;

    public static void main(String[] args) throws Exception {
        Grid grid = new Grid(50, 50);
        System.out.println(grid.get(100, 150, Grid.Translate.TO_GRID).toString());
        Logger.clearLatestLog();
        Logger.write("[Init] New log file created\n[Init] Initializing game loop");
        try {
            gameLoop = new GameTimer(TimeUnit.MILLISECONDS, 20.0, () -> {game.Update(); game.Draw();});
        } catch (Exception e) {
            Logger.write("[ERROR] Loop not initialized, something went wrong", e.getMessage(), e);
        }
    }
}
