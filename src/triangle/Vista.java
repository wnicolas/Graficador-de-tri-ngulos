package triangle;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Vista extends JFrame {

    public Vista() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Graficador de triángulos");
        setLayout(new BorderLayout());

        PanelPrincipal panelPrincipal = new PanelPrincipal();
        PanelRespuesta panelRespuesta=new PanelRespuesta();
        PanelControles panelControles = new PanelControles(panelPrincipal,panelRespuesta);

        add(panelControles, BorderLayout.NORTH);
        add(panelPrincipal, BorderLayout.CENTER);
        add(panelRespuesta, BorderLayout.SOUTH);

        setVisible(true);
    }
}
