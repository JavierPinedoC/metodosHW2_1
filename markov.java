import java.util.*;

public class markov {

    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int estados = sc.nextInt();

        double decimal[][] = new double[estados][estados];
        double numerador[][] = new double[estados][estados];
        double denominador[][] = new double[estados][estados];

        matrix(decimal, numerador, denominador);

        int iteraciones = sc.nextInt();

        pasos(iteraciones, decimal, numerador, denominador, estados);
        vector(decimal);
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

    public static void pasos(int iteraciones, double[][] decimal, double[][] numerador, double[][] denominador, int estados) {
        if(iteraciones==1){
            System.out.println("P1");
            ImprimirM(decimal);
        }
        else{
            System.out.println("P1");
                ImprimirM(decimal);
            double aux[][] = new double[estados][estados];

            aux = decimal;
            for (int control = 0; control < iteraciones; control++) {
                double[][] c = new double[estados][estados];
                
                if (aux[0].length == decimal.length) {
                    for (int i = 0; i < aux.length; i++) {
                        for (int j = 0; j < decimal[0].length; j++) {
                            for (int k = 0; k < aux[0].length; k++) {
                                c[i][j] += aux[i][k] * decimal[k][j];
                            }
                        }
                    }
                }
                aux = c;
                
                System.out.println("P" + (control+2));
                ImprimirM(aux);
            }
        }
    }

    public static void ImprimirM(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(convert(m[i][j]));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void vector(double[][] p){
        System.out.print("Vector de punto fijo: (");
        double x = (-p[1][0]+p[1][1]-1)/(p[0][0]-p[1][0]-p[0][1]+p[1][1]-2);
        System.out.println(convert(x) +", " + convert(1-x) + ")");
    }

    public static String convert(double n) {
        double tolerance = 1.0E-6;
        double h1 = 1;
        double h2 = 0;
        double k1 = 0;
        double k2 = 1;
        double b = n;
        do {
            double a = Math.floor(b);
            double aux = h1;
            h1 = a * h1 + h2;
            h2 = aux;
            aux = k1;
            k1 = a * k1 + k2;
            k2 = aux;
            b = 1 / (b - a);
        } while (Math.abs(n - h1 / k1) > n * tolerance);

        String str = " " + (int) h1 + "/" + (int) k1 + " ";

        return str;
    }

}