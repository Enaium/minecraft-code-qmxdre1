package cn.enaium.learn.qmxdre.event;

/**
 * @author Enaium
 */
public class Events {
    public static class KeyboardEvent {
        private final int key;

        public KeyboardEvent(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }
    }

    public static class UpdateEvent {

    }

    public static class Render2DEvent {

    }

    public static class Render3DEvent {

    }
}
