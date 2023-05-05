package Utils;
public class WindowConfiguration {
    private Integer width, height, x, y, defaultCloseOperation;
    private Boolean visible;
    private String title;
    private Runnable runWhenClosed;

    public void setSize(int width, int height) { this.width = width; this.height = height; }
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public void setLocation(int x, int y) { this.x = x; this.y = y; }
    public void setLocationX(int x) { this.x = x; }
    public void setLocationY(int y) { this.y = y; }
    public void setVisible(boolean visible) { this.visible = visible; }
    public void setDefaultCloseOperation(int defaultCloseOperation) { this.defaultCloseOperation = defaultCloseOperation; }
    public void setTitle(String title) { this.title = title; }
    public void setRunWhenClosed(Runnable runWhenClosed) { this.runWhenClosed = runWhenClosed; }

    public void configureAllSettings(Window window) {
        if (width != null && height != null) window.get().setSize(width, height);
        else if (width != null) window.get().setSize(window.get().getWidth(), height);
        else if (height != null) window.get().setSize(width, window.get().getHeight());

        if (x != null && y != null) window.get().setLocation(x, y);
        else if (x != null) window.get().setLocation(x, (int) window.get().getLocation().getY());
        else if (y != null) window.get().setLocation((int) window.get().getLocation().getX(), y);

        if (visible != null) window.get().setVisible(visible);
        if (defaultCloseOperation != null) window.get().setDefaultCloseOperation(defaultCloseOperation); 
        if (title != null) window.get().setTitle(title);
        if (runWhenClosed != null) window.setRunWhenClosed(runWhenClosed);
    }
}
