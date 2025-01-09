package u4.d2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quanti rettangoli?: ");
        int n = scanner.nextInt();

        // Spazio vuoto
        System.out.println();

        Rettangolo[] rettangoli = new Rettangolo[n];
        double[] perimetri = new double[n];
        double[] aree = new double[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Inserisci la base del rettangolo [ " + (i+1)  + " ]: ");
            double base = scanner.nextDouble();
            System.out.print("Inserisci l'altezza del rettangolo [ " + (i+1) + " ]: ");
            double altezza = scanner.nextDouble();

            rettangoli[i] = new Rettangolo(base, altezza);

            perimetri[i] = rettangoli[i].getPerimetro();
            aree[i] = rettangoli[i].getArea();

            System.out.println("Il perimetro del rettangolo è: " + perimetri[i]);
            System.out.println("L'area del rettangolo è: " + aree[i]);
            System.out.println();
        }

        System.out.println("Perimetri: " + Arrays.toString(perimetri));
        System.out.println("Aree: " + Arrays.toString(aree));
        System.out.println();

        System.out.println("Somma dei Perimetri: " + Arrays.stream(perimetri).sum());
        System.out.println("Somma delle Aree: " + Arrays.stream(aree).sum());
        System.out.println();

        scanner.close();
    }
}

class Rettangolo{

    private double base;
    private double altezza;
    private double perimetro;
    private double area;

    Rettangolo( double base, double altezza){
        //System.out.println("* Classe Rettangolo istanziata! *");
        this.base = base;
        this.altezza = altezza;
        this.perimetro = this.calcolaPerimetro();
        this.area = this.calcolaArea();
    }

    private double calcolaPerimetro() {
        return 2 * (this.base + this.altezza);
    }

    private double calcolaArea() {
        return this.base * this.altezza;
    }

    public double getPerimetro() {
        return this.perimetro;
    }

    public double getArea() {
        return this.area;
    }
}