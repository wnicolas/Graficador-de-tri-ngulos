package triangle;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class Triangulo {

    private Punto punto1;
    private Punto punto2;
    private Punto punto3;

    private double lado1;
    private double lado2;
    private double lado3;

    private double perimetro;
    private double area;
    private double altura;

    public Triangulo(Punto punto1, Punto punto2, Punto punto3) {
        this.punto1 = punto1;
        this.punto2 = punto2;
        this.punto3 = punto3;

        this.lado1 = calcularLado(this.punto1, this.punto2);
        this.lado2 = calcularLado(this.punto2, this.punto3);
        this.lado3 = calcularLado(this.punto3, this.punto1);
    }

    public double calcularLado(Punto p1, Punto p2) {
        double ladoCuadrado = (Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2));
        double lado = Math.pow(ladoCuadrado, 0.5);
        return lado;
    }

    public double calcularPerimetro() {
        this.perimetro = lado1 + lado2 + lado3;
        return this.perimetro;
    }

    public double calcularArea() {
        double s = this.perimetro / 2;
        this.area = Math.pow(((s) * (s - lado1) * (s - lado2) * (s - lado3)), 0.5);
        return this.area;
    }

    public double calcularAltura(int lado) {
        if (lado == 1) {
            altura = (2 * area) / lado1;
            return altura;
        } else if (lado == 2) {
            altura = (2 * area) / lado2;
            return altura;
        } else{
            altura = (2 * area) / lado3;
            return altura;
        }

    }

    public Punto getPunto1() {
        return punto1;
    }

    public Punto getPunto2() {
        return punto2;
    }

    public Punto getPunto3() {
        return punto3;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public double getArea() {
        return area;
    }

    public double getAltura() {
        return altura;
    }
    

}
