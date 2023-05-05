package Game;
public class Constants {
    public static final Content content = new Content();

    public static enum TimeUnit {
        MINUTES,
        SECONDS,
        MILLISECONDS
    }

    public static class Content {
        public final String DIRECTORY = System.getProperty("user.dir");
    }
}
