import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;


public class Game{
    public static void build(){
        Board b = new Board();
        initializeFontSize();
        b.setPreferredSize(new Dimension(500,500)); //need to use this instead of setSize
        b.setLocation(500, 250);
        b.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        b.pack();
        b.setVisible(true);
    }
    public static void initializeFontSize() {
        String fontSizeParam = System.getProperty("Board.fontSize");
        if (fontSizeParam != null) {
            float multiplier = Integer.parseInt(fontSizeParam) / 100.0f;
            UIDefaults defaults = UIManager.getDefaults();
            int i = 0;
            for (Enumeration e = defaults.keys(); e.hasMoreElements(); i++) {
                Object key = e.nextElement();
                Object value = defaults.get(key);
                if (value instanceof Font) {
                    Font font = (Font) value;
                    int newSize = Math.round(font.getSize() * multiplier);
                    if (value instanceof FontUIResource) {
                        defaults.put(key, new FontUIResource(font.getName(), font.getStyle(), newSize));
                    } else {
                        defaults.put(key, new Font(font.getName(), font.getStyle(), newSize));
                    }
                }
            }
        }
    }

}