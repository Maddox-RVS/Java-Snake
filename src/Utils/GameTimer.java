package Utils;

public class GameTimer {
    private final TimeUnit timeUnit;
    private final double loopTime;
    private final Runnable action;
    private final long universalStartTime;
    private long startTime;

    public GameTimer(TimeUnit timeUnit, double loopTime, Runnable action) {
        this.timeUnit = timeUnit;
        universalStartTime = System.currentTimeMillis();
        this.loopTime = loopTime;
        Logger.write("[Init] Initializing time units");
        this.action = action;
        Logger.write("[Init] Initializing runnable action Update and Draw");
        Start();
    }

    public enum TimeUnit {
        MINUTES,
        SECONDS,
        MILLISECONDS
    }

    public void Start() {
        Logger.write("[Init] Finished loop initialization\n[Init] Starting loop");
        while (true) {
            if (getGameLoopTimeElapsed() >= loopTime) Run(); 
        }
    }

    public void Run() {
        startTime = System.currentTimeMillis();
        action.run();
    }

    public double getTotalTimeElapsed(TimeUnit timeUnit) {
        if (timeUnit == TimeUnit.MILLISECONDS) return getMillisecondsElapsed(universalStartTime);
        else if (timeUnit == TimeUnit.SECONDS) return getSecondsElapsed(universalStartTime);
        else if (timeUnit == TimeUnit.MINUTES) return getMinutesElapsed(universalStartTime);
        return 0.0;
    }

    public double getGameLoopTimeElapsed() {
        if (timeUnit == TimeUnit.MILLISECONDS) return getMillisecondsElapsed(startTime);
        else if (timeUnit == TimeUnit.SECONDS) return getSecondsElapsed(startTime);
        else if (timeUnit == TimeUnit.MINUTES) return getMinutesElapsed(startTime);
        return 0.0;
    }

    public double getMillisecondsElapsed(long start) { return (double) (System.currentTimeMillis()-start); }
    public double getSecondsElapsed(long start) { return (int) (getMillisecondsElapsed(start)/1000); }
    public double getMinutesElapsed(long start) { return (int) (getSecondsElapsed(start)/60); }
}
