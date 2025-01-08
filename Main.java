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
            rettangoli[i] = new Rettangolo();
            double[] dimensioni = rettangoli[i].createRettangolo(i + 1, scanner);
            double base = dimensioni[0];
            double altezza = dimensioni[1];
            perimetri[i] = rettangoli[i].Perimetro(base, altezza);
            aree[i] = rettangoli[i].Area(base, altezza);

            System.out.println("Il perimetro del rettangolo è: " + rettangoli[i].Perimetro(base, altezza));
            System.out.println("L'area del rettangolo è: " + rettangoli[i].Area(base, altezza));
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

class Rettangolo {

    public double[] createRettangolo(int n, Scanner scanner) {
        System.out.print("Inserisci la base del rettangolo [ " + n + " ]: ");
        double base = scanner.nextDouble();
        System.out.print("Inserisci l'altezza del rettangolo [ " + n + " ]: ");
        double altezza = scanner.nextDouble();
        return new double[] { base, altezza };
    }

    public double Perimetro(double base, double altezza) {
        return 2 * (base + altezza);
    }

    public double Area(double base, double altezza) {
        return base * altezza;
    }
}