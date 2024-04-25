import java.lang.Math;

abstract class Figuras {

    abstract double calcularArea();

    abstract double calcularPerimetro();
}

class Circulo extends Figuras {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

class Rectangulo extends Figuras {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    double calcularArea() {
        return base * altura;
    }

    double calcularPerimetro() {
        return 2 * (base + altura);
    }
}

class Cuadrado extends Rectangulo {

    public Cuadrado(double lado) {
        super(lado, lado);
    }
}

class TrianguloRectangulo extends Figuras {
    private double base;
    private double altura;

    public TrianguloRectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularHipotenusa() {
        return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
    }

    public String determinarTipoTriangulo() {
        if (base == altura)
            return "Equilátero";
        else if (base == altura || base == calcularHipotenusa() || altura == calcularHipotenusa())
            return "Isósceles";
        else
            return "Escaleno";
    }

    double calcularArea() {
        return (base * altura) / 2;
    }

    double calcularPerimetro() {
        return base + altura + calcularHipotenusa();
    }
}

public class PruebaFiguras {
    public static void main(String[] args) {

        Circulo circulo = new Circulo(5);
        Rectangulo rectangulo = new Rectangulo(4, 6);
        Cuadrado cuadrado = new Cuadrado(5);
        TrianguloRectangulo triangulo = new TrianguloRectangulo(3, 4);

        System.out.println("Área del círculo: " + circulo.calcularArea());
        System.out.println("Perímetro del círculo: " + circulo.calcularPerimetro());

        System.out.println("Área del rectángulo: " + rectangulo.calcularArea());
        System.out.println("Perímetro del rectángulo: " + rectangulo.calcularPerimetro());

        System.out.println("Área del cuadrado: " + cuadrado.calcularArea());
        System.out.println("Perímetro del cuadrado: " + cuadrado.calcularPerimetro());

        System.out.println("Área del triángulo rectángulo: " + triangulo.calcularArea());
        System.out.println("Perímetro del triángulo rectángulo: " + triangulo.calcularPerimetro());
        System.out.println("Hipotenusa del triángulo rectángulo: " + triangulo.calcularHipotenusa());
        System.out.println("Tipo de triángulo: " + triangulo.determinarTipoTriangulo());
    }
}