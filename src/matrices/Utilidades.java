/*
(1) Multiplicar dos matrices suministradas por teclado.
(2) Determinar la suma del cuadrado de los elementos de la diagonal principal de la matriz suministrada por teclado.
(3) Devolver la transpuesta de la matriz introducida por teclado.
(4) Determinar la moda de un grupo de elementos introducidos por teclado. 
 */
package matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static matrices.Utilidades.moda;

/**
 *
 * @author ncampusano
 */

public class Utilidades {
    static Scanner sc;
public static double moda(double a[]) {
       double maxValue = 0, maxCount = 0;

       for (int i = 0; i < a.length; ++i) {
           int count = 0;
           for (int j = 0; j < a.length; ++j) {
               if (a[j] == a[i]) ++count;
           }
           if (count > maxCount) {
               maxCount = count;
               maxValue = a[i];
           }
       }

       return maxValue;
}

    public static int[][] carga (int FILAS, int COLUMNAS){
        int i, j;
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[FILAS][COLUMNAS];
        for (i = 0; i < FILAS; i++) {
            int num=i+1;
            for (j = 0; j < COLUMNAS; j++) {
                int nu=j+1;
                System.out.print("A[" + num + "][" + nu + "]= ");
                a[i][j] = sc.nextInt();
            }
        }
        return a;

}
    public static int[][] multiplicar(int[][]a, int [][]b, int fila, int columna, int columna2){

        int[][] product = new int[fila][columna2];
        for(int i = 0; i < fila; i++) {
            for (int j = 0; j < columna2; j++) {
                for (int k = 0; k < columna; k++) {
                    product[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return product;
    }
   
    
    public static int sumacu (int[][]a){
        int sd1 = 0;
            for( int i=0; i<a.length; i++ )
        {
            for(int j=0; j<a.length; j++ )
                {
              if( i==j ){
              sd1 += a[i][j];
              }
}
            
    }   
        return sd1;
    }

    public static int[][] transpuesta (int[][] a, int fila, int columna){
    int [][] mt = new int[fila][columna];
    
    for (int i = 0; i < a.length; i++) {
    for (int j = 0; j < a.length; j++) {
     mt[i][j]=(a[j][i]);
     }       
    }
    return mt;
    }
 
    public static void imprimir(int[][] m){
        /*int lado = m.length;
    int fila = lado;
    int columna = lado;
    for (int i = 0; i <= 2 * (fila - 1); i++) {
        for (int j = 0; j < columna; j++) {
            int x = i - j;
            if (x >= 0 && x < m.length) {
                System.out.print(m[j][x]+" ");
            }
        }

    }*/
        for (int matriz[]: m){
        System.out.println(Arrays.toString(matriz));
        }
    }
   
    public static void main(String[] args) {
        int opcion, cantidad, filas, columnas, i, j;
        Scanner sc = new Scanner (System.in);

        System.out.println("Menú de opciones:");         
        System.out.println("1. Multiplicar matrices");         
        System.out.println("2. Suma del cuadrado de los elementos de la diagonal principal.\n" +
                           "3. Devolver la transpuesta de la matriz.\n" +
                           "4. Determinar la moda de un grupo de elementos.\n"+
                           "0. Salir");    
        opcion= sc.nextInt();
        
        switch (opcion) {
            case 1:
                System.out.println("Cuantas filas tiene la matriz A?");
                filas=sc.nextInt();
                System.out.println("Cuantas columnas tiene la matriz A?");
                columnas=sc.nextInt();
                int[][] e,d,r;
                e=carga (filas,columnas);
                int fila2, columna2;
                System.out.println("Cuantas filas tiene la matriz B?");
                fila2=sc.nextInt();
                System.out.println("Cuantas columnas tiene la matriz B?");
                columna2=sc.nextInt();
                d=carga (fila2,columna2);
                r=multiplicar(e,d,filas, columnas, columna2);

                System.out.println("El resultado de la multiplicacion es:");
                System.out.println("--------------------------------------");
                imprimir(r);
                
                break;
            case 2:
                System.out.println("Cuantas filas tiene la matriz?");
                filas=sc.nextInt();
                System.out.println("Cuantas columnas tiene la matriz?");
                columnas=sc.nextInt();
                int[][] t;
                int q;
                t=carga (filas,columnas);
                q= sumacu(t);
                System.out.println("Suma de elementos de la diagonal.");
                System.out.println("--------------------------------------");
                System.out.println(" ");
                System.out.println("La matriz original es: ");
                imprimir(t);
                System.out.println("");
                System.out.println("La suma de la diagonal principal es: "+q);
                
                
                break;
            case 3:
                System.out.println("Cuantas filas tiene la matriz?");
                filas=sc.nextInt();
                System.out.println("Cuantas columnas tiene la matriz?");
                columnas=sc.nextInt();
                int[][] b,c;
                b=carga (filas,columnas);
                /*imprimir(b);*/
                c=transpuesta(b, filas,columnas);
                System.out.println("La matriz original: ");
                imprimir(b);
                System.out.println("La matriz transpuesta: ");

                imprimir(c);
                
                break;
            case 4:
               System.out.print("Cuantos numeros ingresara: ");
               cantidad=sc.nextInt();
               double moda[], result = 0;
               moda= new double[cantidad];
               for (int k = 0; k<cantidad;k++){
                   int num=k+1;
               System.out.print("Ingrese el numero #"+num+": ");
               moda[k]=sc.nextDouble();
               }
               double value;
               value= moda (moda);
               System.out.println("La moda es: "+ value );
                      
                break;

                
            case 0:
                System.out.println("Bye!");
                System.exit(0);

                break;
            default:
                System.out.println("Opcion invalida.");
                System.exit(0);
                break;
                        
        
        }
    }
    
    }

