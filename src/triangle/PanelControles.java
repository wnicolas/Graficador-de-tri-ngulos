package triangle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelControles extends JPanel implements ActionListener {

    private Button agregarPuntos;
    private Button cambiarColorRelleno;
    private Button cambiarColorLineas;

    PanelPrincipal panelPrincipal;
    PanelRespuesta panelRespuesta;

    Triangulo triangulo;

    int[] x = new int[3];
    int[] y = new int[3];

    public PanelControles(PanelPrincipal p, PanelRespuesta respuesta) {
        panelPrincipal = p;
        panelRespuesta=respuesta;
        setBackground(Color.YELLOW);

        agregarPuntos = new Button("Agregar puntos al triángulo");
        add(agregarPuntos);
        agregarPuntos.addActionListener(this);

        cambiarColorRelleno = new Button("Cambiar color de triángulo");
        add(cambiarColorRelleno);
        cambiarColorRelleno.addActionListener(this);

        cambiarColorLineas = new Button("Cambiar color de las líneas");
        add(cambiarColorLineas);
        cambiarColorLineas.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(agregarPuntos)) {

            int punto1x = Integer.parseInt(JOptionPane.showInputDialog(null, "Agregue la coordenada x del primer punto"));
            int punto1y = Integer.parseInt(JOptionPane.showInputDialog(null, "Agregue la coordenada y del primer punto"));

            int punto2x = Integer.parseInt(JOptionPane.showInputDialog(null, "Agregue la coordenada x del segundo punto"));
            int punto2y = Integer.parseInt(JOptionPane.showInputDialog(null, "Agregue la coordenada y del segundo punto"));

            int punto3x = Integer.parseInt(JOptionPane.showInputDialog(null, "Agregue la coordenada x del tercer punto"));
            int punto3y = Integer.parseInt(JOptionPane.showInputDialog(null, "Agregue la coordenada y del tercer punto"));

            Punto punto1 = new Punto(punto1x, punto1y);
            Punto punto2 = new Punto(punto2x, punto2y);
            Punto punto3 = new Punto(punto3x, punto3y);

            triangulo = new Triangulo(punto1, punto2, punto3);

            x[0] = triangulo.getPunto1().getX();
            x[1] = triangulo.getPunto2().getX();
            x[2] = triangulo.getPunto3().getX();
            y[0] = triangulo.getPunto1().getY();
            y[1] = triangulo.getPunto2().getY();
            y[2] = triangulo.getPunto3().getY();

            Graphics g = panelPrincipal.getGraphics();

            g.setColor(new Color(255, 0, 0));
            g.fillPolygon(x, y, x.length);

            g.setColor(Color.BLACK);
            g.drawPolygon(x, y, x.length);

            String resumen
                    = "Lado 1: " + triangulo.getLado1() + "\n"
                    + "Lado 2: " + triangulo.getLado2() + "\n"
                    + "Lado 3: " + triangulo.getLado3() + "\n"
                    + "**************************************** \n"
                    + "Perímetro: " + triangulo.calcularPerimetro() + "\n"
                    + "Área: " + triangulo.calcularArea() + "\n"
                    + "Altura respecto al lado 1: " + triangulo.calcularAltura(1) + "\n"
                    + "Altura respecto al lado 2: " + triangulo.calcularAltura(2) + "\n"
                    + "Altura respecto al lado 3: " + triangulo.calcularAltura(3);

            JOptionPane.showMessageDialog(null, resumen);
            panelRespuesta.respuesta.setText(resumen);

        } else if (e.getSource().equals(cambiarColorRelleno)) {

            String color = JOptionPane.showInputDialog(null, "Ingrese color de relleno en RGB");
            String colores[] = color.split(",");

            Color relleno = new Color(Integer.parseInt(colores[0]), Integer.parseInt(colores[1]), Integer.parseInt(colores[2]));
            Graphics g = panelPrincipal.getGraphics();

            g.setColor(relleno);
            g.fillPolygon(x, y, x.length);

        } else if (e.getSource().equals(cambiarColorLineas)) {
            String color = JOptionPane.showInputDialog(null, "Ingrese color de las líneas en RGB");
            String colores[] = color.split(",");

            Color relleno = new Color(Integer.parseInt(colores[0]), Integer.parseInt(colores[1]), Integer.parseInt(colores[2]));
            Graphics g = panelPrincipal.getGraphics();

            g.setColor(relleno);
            g.drawPolygon(x, y, x.length);

        }
    }
}
