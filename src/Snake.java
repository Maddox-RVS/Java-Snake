import Utils.*;

public class Snake {
    private BodyType bodyType;
    private Sprite bodyTexture;

    public Snake(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public enum BodyType {
        HEAD,
        LINE_BODY,
        CORNER_BODY,
        TAIL
    }
}
