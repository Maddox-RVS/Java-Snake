package Utils;

import java.awt.RenderingHints.Key;
import java.awt.event.*;
import java.util.HashMap;
public class Keyboard implements KeyListener{
    private Runnable whenKeyPressed, whenKeyReleased, whenKeyDown;
    private HashMap<String, Boolean> keys = new HashMap<String, Boolean>();

    public Keyboard() {
        keys.put("a", false);
        keys.put("b", false);
        keys.put("c", false);
        keys.put("d", false);
        keys.put("e", false);
        keys.put("f", false);
        keys.put("g", false);
        keys.put("h", false);
        keys.put("i", false);
        keys.put("j", false);
        keys.put("k", false);
        keys.put("l", false);
        keys.put("m", false);
        keys.put("n", false);
        keys.put("o", false);
        keys.put("p", false);
        keys.put("q", false);
        keys.put("r", false);
        keys.put("s", false);
        keys.put("t", false);
        keys.put("u", false);
        keys.put("v", false);
        keys.put("w", false);
        keys.put("x", false);
        keys.put("y", false);
        keys.put("z", false);

        keys.put("1", false);
        keys.put("2", false);
        keys.put("3", false);
        keys.put("4", false);
        keys.put("5", false);
        keys.put("6", false);
        keys.put("7", false);
        keys.put("8", false);
        keys.put("9", false);
        keys.put("0", false);

        keys.put("left", false);
        keys.put("right", false);
        keys.put("up", false);
        keys.put("down", false);

        keys.put("esc", false);
        keys.put("ctrl", false);
        keys.put("shift", false);
        keys.put("enter", false);

        keys.put("f1", false);
        keys.put("f2", false);
        keys.put("f3", false);
        keys.put("f4", false);
        keys.put("f5", false);
        keys.put("f6", false);
        keys.put("f7", false);
        keys.put("f8", false);
        keys.put("f9", false);
        keys.put("f10", false);
        keys.put("f11", false);
        keys.put("f12", false);
    }

    public Boolean isKeyDown(String key) {
        key = key.toLowerCase();
        try {
            return keys.get(key);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) keys.put("a", true);
        if (e.getKeyCode() == KeyEvent.VK_B) keys.put("b", true);
        if (e.getKeyCode() == KeyEvent.VK_C) keys.put("c", true);
        if (e.getKeyCode() == KeyEvent.VK_D) keys.put("d", true);
        if (e.getKeyCode() == KeyEvent.VK_E) keys.put("e", true);
        if (e.getKeyCode() == KeyEvent.VK_F) keys.put("f", true);
        if (e.getKeyCode() == KeyEvent.VK_G) keys.put("g", true);
        if (e.getKeyCode() == KeyEvent.VK_H) keys.put("h", true);
        if (e.getKeyCode() == KeyEvent.VK_I) keys.put("i", true);
        if (e.getKeyCode() == KeyEvent.VK_J) keys.put("j", true);
        if (e.getKeyCode() == KeyEvent.VK_K) keys.put("k", true);
        if (e.getKeyCode() == KeyEvent.VK_L) keys.put("l", true);
        if (e.getKeyCode() == KeyEvent.VK_M) keys.put("m", true);
        if (e.getKeyCode() == KeyEvent.VK_N) keys.put("n", true);
        if (e.getKeyCode() == KeyEvent.VK_O) keys.put("o", true);
        if (e.getKeyCode() == KeyEvent.VK_P) keys.put("p", true);
        if (e.getKeyCode() == KeyEvent.VK_Q) keys.put("q", true);
        if (e.getKeyCode() == KeyEvent.VK_R) keys.put("r", true);
        if (e.getKeyCode() == KeyEvent.VK_S) keys.put("s", true);
        if (e.getKeyCode() == KeyEvent.VK_T) keys.put("t", true);
        if (e.getKeyCode() == KeyEvent.VK_U) keys.put("u", true);
        if (e.getKeyCode() == KeyEvent.VK_V) keys.put("v", true);
        if (e.getKeyCode() == KeyEvent.VK_W) keys.put("w", true);
        if (e.getKeyCode() == KeyEvent.VK_X) keys.put("x", true);
        if (e.getKeyCode() == KeyEvent.VK_Y) keys.put("y", true);
        if (e.getKeyCode() == KeyEvent.VK_Z) keys.put("z", true);

        if (e.getKeyCode() == KeyEvent.VK_1) keys.put("1", true);
        if (e.getKeyCode() == KeyEvent.VK_2) keys.put("2", true);
        if (e.getKeyCode() == KeyEvent.VK_3) keys.put("3", true);
        if (e.getKeyCode() == KeyEvent.VK_4) keys.put("4", true);
        if (e.getKeyCode() == KeyEvent.VK_5) keys.put("5", true);
        if (e.getKeyCode() == KeyEvent.VK_6) keys.put("6", true);
        if (e.getKeyCode() == KeyEvent.VK_7) keys.put("7", true);
        if (e.getKeyCode() == KeyEvent.VK_8) keys.put("8", true);
        if (e.getKeyCode() == KeyEvent.VK_9) keys.put("9", true);
        if (e.getKeyCode() == KeyEvent.VK_0) keys.put("0", true);

        if (e.getKeyCode() == KeyEvent.VK_LEFT) keys.put("left", true);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) keys.put("right", true);
        if (e.getKeyCode() == KeyEvent.VK_UP) keys.put("up", true);
        if (e.getKeyCode() == KeyEvent.VK_DOWN) keys.put("down", true);

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) keys.put("esc", true);
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) keys.put("ctrl", true);
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) keys.put("shift", true);
        if (e.getKeyCode() == KeyEvent.VK_ENTER) keys.put("enter", true);

        if (e.getKeyCode() == KeyEvent.VK_F1) keys.put("f1", true);
        if (e.getKeyCode() == KeyEvent.VK_F2) keys.put("f2", true);
        if (e.getKeyCode() == KeyEvent.VK_F3) keys.put("f3", true);
        if (e.getKeyCode() == KeyEvent.VK_F4) keys.put("f4", true);
        if (e.getKeyCode() == KeyEvent.VK_F5) keys.put("f5", true);
        if (e.getKeyCode() == KeyEvent.VK_F6) keys.put("f6", true);
        if (e.getKeyCode() == KeyEvent.VK_F7) keys.put("f7", true);
        if (e.getKeyCode() == KeyEvent.VK_F8) keys.put("f8", true);
        if (e.getKeyCode() == KeyEvent.VK_F9) keys.put("f9", true);
        if (e.getKeyCode() == KeyEvent.VK_F10) keys.put("f10", true);
        if (e.getKeyCode() == KeyEvent.VK_F11) keys.put("f11", true);
        if (e.getKeyCode() == KeyEvent.VK_F12) keys.put("f12", true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) keys.put("a", false);
        if (e.getKeyCode() == KeyEvent.VK_B) keys.put("b", false);
        if (e.getKeyCode() == KeyEvent.VK_C) keys.put("c", false);
        if (e.getKeyCode() == KeyEvent.VK_D) keys.put("d", false);
        if (e.getKeyCode() == KeyEvent.VK_E) keys.put("e", false);
        if (e.getKeyCode() == KeyEvent.VK_F) keys.put("f", false);
        if (e.getKeyCode() == KeyEvent.VK_G) keys.put("g", false);
        if (e.getKeyCode() == KeyEvent.VK_H) keys.put("h", false);
        if (e.getKeyCode() == KeyEvent.VK_I) keys.put("i", false);
        if (e.getKeyCode() == KeyEvent.VK_J) keys.put("j", false);
        if (e.getKeyCode() == KeyEvent.VK_K) keys.put("k", false);
        if (e.getKeyCode() == KeyEvent.VK_L) keys.put("l", false);
        if (e.getKeyCode() == KeyEvent.VK_M) keys.put("m", false);
        if (e.getKeyCode() == KeyEvent.VK_N) keys.put("n", false);
        if (e.getKeyCode() == KeyEvent.VK_O) keys.put("o", false);
        if (e.getKeyCode() == KeyEvent.VK_P) keys.put("p", false);
        if (e.getKeyCode() == KeyEvent.VK_Q) keys.put("q", false);
        if (e.getKeyCode() == KeyEvent.VK_R) keys.put("r", false);
        if (e.getKeyCode() == KeyEvent.VK_S) keys.put("s", false);
        if (e.getKeyCode() == KeyEvent.VK_T) keys.put("t", false);
        if (e.getKeyCode() == KeyEvent.VK_U) keys.put("u", false);
        if (e.getKeyCode() == KeyEvent.VK_V) keys.put("v", false);
        if (e.getKeyCode() == KeyEvent.VK_W) keys.put("w", false);
        if (e.getKeyCode() == KeyEvent.VK_X) keys.put("x", false);
        if (e.getKeyCode() == KeyEvent.VK_Y) keys.put("y", false);
        if (e.getKeyCode() == KeyEvent.VK_Z) keys.put("z", false);

        if (e.getKeyCode() == KeyEvent.VK_1) keys.put("1", false);
        if (e.getKeyCode() == KeyEvent.VK_2) keys.put("2", false);
        if (e.getKeyCode() == KeyEvent.VK_3) keys.put("3", false);
        if (e.getKeyCode() == KeyEvent.VK_4) keys.put("4", false);
        if (e.getKeyCode() == KeyEvent.VK_5) keys.put("5", false);
        if (e.getKeyCode() == KeyEvent.VK_6) keys.put("6", false);
        if (e.getKeyCode() == KeyEvent.VK_7) keys.put("7", false);
        if (e.getKeyCode() == KeyEvent.VK_8) keys.put("8", false);
        if (e.getKeyCode() == KeyEvent.VK_9) keys.put("9", false);
        if (e.getKeyCode() == KeyEvent.VK_0) keys.put("0", false);

        if (e.getKeyCode() == KeyEvent.VK_LEFT) keys.put("left", false);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) keys.put("right", false);
        if (e.getKeyCode() == KeyEvent.VK_UP) keys.put("up", false);
        if (e.getKeyCode() == KeyEvent.VK_DOWN) keys.put("down", false);

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) keys.put("esc", false);
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) keys.put("ctrl", false);
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) keys.put("shift", false);
        if (e.getKeyCode() == KeyEvent.VK_ENTER) keys.put("enter", false);

        if (e.getKeyCode() == KeyEvent.VK_F1) keys.put("f1", false);
        if (e.getKeyCode() == KeyEvent.VK_F2) keys.put("f2", false);
        if (e.getKeyCode() == KeyEvent.VK_F3) keys.put("f3", false);
        if (e.getKeyCode() == KeyEvent.VK_F4) keys.put("f4", false);
        if (e.getKeyCode() == KeyEvent.VK_F5) keys.put("f5", false);
        if (e.getKeyCode() == KeyEvent.VK_F6) keys.put("f6", false);
        if (e.getKeyCode() == KeyEvent.VK_F7) keys.put("f7", false);
        if (e.getKeyCode() == KeyEvent.VK_F8) keys.put("f8", false);
        if (e.getKeyCode() == KeyEvent.VK_F9) keys.put("f9", false);
        if (e.getKeyCode() == KeyEvent.VK_F10) keys.put("f10", false);
        if (e.getKeyCode() == KeyEvent.VK_F11) keys.put("f11", false);
        if (e.getKeyCode() == KeyEvent.VK_F12) keys.put("f12", false);
    }
}
