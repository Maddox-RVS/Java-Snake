package Utils;

import java.awt.event.*;
import java.util.HashMap;
public class Keyboard implements KeyListener{
    private HashMap<String, Boolean> keys = new HashMap<String, Boolean>();
    private HashMap<String, Boolean> previousKeyState = new HashMap<String, Boolean>();

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

        previousKeyState.put("a", false);
        previousKeyState.put("b", false);
        previousKeyState.put("c", false);
        previousKeyState.put("d", false);
        previousKeyState.put("e", false);
        previousKeyState.put("f", false);
        previousKeyState.put("g", false);
        previousKeyState.put("h", false);
        previousKeyState.put("i", false);
        previousKeyState.put("j", false);
        previousKeyState.put("k", false);
        previousKeyState.put("l", false);
        previousKeyState.put("m", false);
        previousKeyState.put("n", false);
        previousKeyState.put("o", false);
        previousKeyState.put("p", false);
        previousKeyState.put("q", false);
        previousKeyState.put("r", false);
        previousKeyState.put("s", false);
        previousKeyState.put("t", false);
        previousKeyState.put("u", false);
        previousKeyState.put("v", false);
        previousKeyState.put("w", false);
        previousKeyState.put("x", false);
        previousKeyState.put("y", false);
        previousKeyState.put("z", false);

        previousKeyState.put("1", false);
        previousKeyState.put("2", false);
        previousKeyState.put("3", false);
        previousKeyState.put("4", false);
        previousKeyState.put("5", false);
        previousKeyState.put("6", false);
        previousKeyState.put("7", false);
        previousKeyState.put("8", false);
        previousKeyState.put("9", false);
        previousKeyState.put("0", false);

        previousKeyState.put("left", false);
        previousKeyState.put("right", false);
        previousKeyState.put("up", false);
        previousKeyState.put("down", false);

        previousKeyState.put("esc", false);
        previousKeyState.put("ctrl", false);
        previousKeyState.put("shift", false);
        previousKeyState.put("enter", false);

        previousKeyState.put("f1", false);
        previousKeyState.put("f2", false);
        previousKeyState.put("f3", false);
        previousKeyState.put("f4", false);
        previousKeyState.put("f5", false);
        previousKeyState.put("f6", false);
        previousKeyState.put("f7", false);
        previousKeyState.put("f8", false);
        previousKeyState.put("f9", false);
        previousKeyState.put("f10", false);
        previousKeyState.put("f11", false);
        previousKeyState.put("f12", false);
    }

    public Boolean isKeyDown(String key) {
        key = key.toLowerCase();
        try {
            return keys.get(key);
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean wasKeyPressed(String key) {
        key = key.toLowerCase();
        try {
            if (isKeyDown(key) && !previousKeyState.get(key)) {
                previousKeyState.put(key, isKeyDown(key));
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        checkKeys(e, true);
        resetPreviousState();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        checkKeys(e, false);
        resetPreviousState();
    }

    public void resetPreviousState() {
        previousKeyState.forEach((String, Boolean) -> {
            if (!isKeyDown(String)) previousKeyState.put(String, false);
        });
    }

    public void checkKeys(KeyEvent e, boolean status) {
        if (e.getKeyCode() == KeyEvent.VK_A) keys.put("a", status);
        if (e.getKeyCode() == KeyEvent.VK_B) keys.put("b", status);
        if (e.getKeyCode() == KeyEvent.VK_C) keys.put("c", status);
        if (e.getKeyCode() == KeyEvent.VK_D) keys.put("d", status);
        if (e.getKeyCode() == KeyEvent.VK_E) keys.put("e", status);
        if (e.getKeyCode() == KeyEvent.VK_F) keys.put("f", status);
        if (e.getKeyCode() == KeyEvent.VK_G) keys.put("g", status);
        if (e.getKeyCode() == KeyEvent.VK_H) keys.put("h", status);
        if (e.getKeyCode() == KeyEvent.VK_I) keys.put("i", status);
        if (e.getKeyCode() == KeyEvent.VK_J) keys.put("j", status);
        if (e.getKeyCode() == KeyEvent.VK_K) keys.put("k", status);
        if (e.getKeyCode() == KeyEvent.VK_L) keys.put("l", status);
        if (e.getKeyCode() == KeyEvent.VK_M) keys.put("m", status);
        if (e.getKeyCode() == KeyEvent.VK_N) keys.put("n", status);
        if (e.getKeyCode() == KeyEvent.VK_O) keys.put("o", status);
        if (e.getKeyCode() == KeyEvent.VK_P) keys.put("p", status);
        if (e.getKeyCode() == KeyEvent.VK_Q) keys.put("q", status);
        if (e.getKeyCode() == KeyEvent.VK_R) keys.put("r", status);
        if (e.getKeyCode() == KeyEvent.VK_S) keys.put("s", status);
        if (e.getKeyCode() == KeyEvent.VK_T) keys.put("t", status);
        if (e.getKeyCode() == KeyEvent.VK_U) keys.put("u", status);
        if (e.getKeyCode() == KeyEvent.VK_V) keys.put("v", status);
        if (e.getKeyCode() == KeyEvent.VK_W) keys.put("w", status);
        if (e.getKeyCode() == KeyEvent.VK_X) keys.put("x", status);
        if (e.getKeyCode() == KeyEvent.VK_Y) keys.put("y", status);
        if (e.getKeyCode() == KeyEvent.VK_Z) keys.put("z", status);

        if (e.getKeyCode() == KeyEvent.VK_1) keys.put("1", status);
        if (e.getKeyCode() == KeyEvent.VK_2) keys.put("2", status);
        if (e.getKeyCode() == KeyEvent.VK_3) keys.put("3", status);
        if (e.getKeyCode() == KeyEvent.VK_4) keys.put("4", status);
        if (e.getKeyCode() == KeyEvent.VK_5) keys.put("5", status);
        if (e.getKeyCode() == KeyEvent.VK_6) keys.put("6", status);
        if (e.getKeyCode() == KeyEvent.VK_7) keys.put("7", status);
        if (e.getKeyCode() == KeyEvent.VK_8) keys.put("8", status);
        if (e.getKeyCode() == KeyEvent.VK_9) keys.put("9", status);
        if (e.getKeyCode() == KeyEvent.VK_0) keys.put("0", status);

        if (e.getKeyCode() == KeyEvent.VK_LEFT) keys.put("left", status);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) keys.put("right", status);
        if (e.getKeyCode() == KeyEvent.VK_UP) keys.put("up", status);
        if (e.getKeyCode() == KeyEvent.VK_DOWN) keys.put("down", status);

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) keys.put("esc", status);
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) keys.put("ctrl", status);
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) keys.put("shift", status);
        if (e.getKeyCode() == KeyEvent.VK_ENTER) keys.put("enter", status);

        if (e.getKeyCode() == KeyEvent.VK_F1) keys.put("f1", status);
        if (e.getKeyCode() == KeyEvent.VK_F2) keys.put("f2", status);
        if (e.getKeyCode() == KeyEvent.VK_F3) keys.put("f3", status);
        if (e.getKeyCode() == KeyEvent.VK_F4) keys.put("f4", status);
        if (e.getKeyCode() == KeyEvent.VK_F5) keys.put("f5", status);
        if (e.getKeyCode() == KeyEvent.VK_F6) keys.put("f6", status);
        if (e.getKeyCode() == KeyEvent.VK_F7) keys.put("f7", status);
        if (e.getKeyCode() == KeyEvent.VK_F8) keys.put("f8", status);
        if (e.getKeyCode() == KeyEvent.VK_F9) keys.put("f9", status);
        if (e.getKeyCode() == KeyEvent.VK_F10) keys.put("f10", status);
        if (e.getKeyCode() == KeyEvent.VK_F11) keys.put("f11", status);
        if (e.getKeyCode() == KeyEvent.VK_F12) keys.put("f12", status);
    }
}
