package view;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {

  public MapPanel(JComponent map_view) {
        setLayout(new BorderLayout());
        add(map_view, BorderLayout.CENTER);
    }

}
