import java.util.*;

public class markov {

    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        // System.out.print("Ingresa el numero de estados: ");
        int estados = sc.nextInt();

        double decimal[][] = new double[estados][estados];
        double numerador[][] = new double[estados][estados];
        double denominador[][] = new double[estados][estados];

        int iteraciones = sc.nextInt();
    }

    public static void matrix(double[][] decimal, double[][] numerador, double[][] denominador) {
        Scanner sc;
        sc = new Scanner(System.in);
        for (int i = 0; i < numerador.length; i++) {
            for (int j = 0; j < numerador.length; j++) {
                numerador[i][j] = sc.nextInt();
                denominador[i][j] = sc.nextInt();
                decimal[i][j] = numerador[i][j] / denominador[i][j];
            }
        }
    }

    public static void trans(int iteraciones, double[][] decimal, double[][] numerador, double[][] denominador) {
        
    }

    public static String convert(double n) {
        double tolerance = 1.0E-6;
        double h1=1; double h2=0;
        double k1=0; double k2=1;
        double b = n;
        do {
            double a = Math.floor(b);
            double aux = h1; 
            h1 = a*h1+h2; 
            h2 = aux;
            aux = k1; 
            k1 = a*k1+k2; 
            k2 = aux;
            b = 1/(b-a);
        } while (Math.abs(n-h1/k1) > n*tolerance);

        String str = " "+(int)h1+"/"+(int)k1+" ";
        
        return str;
    }

}