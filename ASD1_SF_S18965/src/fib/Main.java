package fib;

import java.util.Scanner;

public class Main {

    static int indeks=1;

    public static void main(String[] args) {
        System.out.println("Podaj liczbę");
        Scanner scanner = new Scanner(System.in);
        long wartoscN= scanner.nextLong();
        scanner.close();
        System.out.println("Szukamy " + wartoscN + "-tego wyrazu ciągu");
        System.out.println();
        System.out.println(wartoscN+ "-ty wyraz ciągu Fibonacciego to " + fib(wartoscN));
    }

    static long fib(long wartoscN) {
        long F[][] = new long[][]{{1, 1}, {1, 0}};

        if (wartoscN == 0 || wartoscN == 1) {
            return wartoscN;
        } else {
            potega(F, wartoscN - 1);//podnosimy macierz do (wartoscN-1) potęgi
            return F[0][0];
        }
    }

    //    --   n      --           --
    //  | 11 |    =  | F(n+1)  F(n)  |
    //  | 10 |       | F(n)    F(n-1)|
    //    --          --           --

    static void potega(long F[][], long n)
    {
        if( n == 0 || n == 1)
        {
            return;//w tym miejscu kończymy funkcję, inaczej występuje stackoverflow
        }

        long M[][] = new long[][]{{1,1},{1,0}};

        potega(F, n/2);//wywołujemy rekurencję, aby dotrzeć do n najbliższych do 0, których wykonanie funkcji potęga() nastąpi najpierw
        System.out.println("Nastąpiła rekurencja nr " + indeks++);
        //dzieląc przez 2 nie osiągniemy wartości pomiędzy (np 3/2=1 nie osiągamy 2)i aby osiągnąć 2 wartość musimy pomnożyć przez macierz {{1,1},{1,0}}
        mnozenie(F, F); //aby uzyskać 0(logn) wykurzystujemy potęgi które pozwalają nam na osiągniecie mniejszej złożoności obliczeniowa niż w podczas iteracji
        System.out.println("Dla n = " +n+ "  Wymnożono dwie takie same macierze" + "\n" +F[0][0] +" "+ F[0][1]+"\n" +F[1][0]+" "+F[1][1] + "\n");

        if (n%2 != 0){
            mnozenie(F, M); // aby uzyskać element ciągu fibonacciego kiedy n przyjmuje wartość nieparzystą musimy pomnożyć jednorazowo przez macierz {{1,1},{1,0}}
            System.out.println("Dla n = "+ n + "  Wymnożono macierz F z {{1,1},{1,0}}" + "\n" +F[0][0] +" "+ F[0][1]+"\n" +F[1][0]+" "+F[1][1] + "\n");
        }
    }

    static void mnozenie(long F[][], long B[][])
    {
        long a =  F[0][0]*B[0][0] + F[0][1]*B[1][0];
        long b =  F[0][0]*B[0][1] + F[0][1]*B[1][1];
        long c =  F[1][0]*B[0][0] + F[1][1]*B[1][0];
        long d =  F[1][0]*B[0][1] + F[1][1]*B[1][1];

        F[0][0] = a;
        F[0][1] = b;
        F[1][0] = c;
        F[1][1] = d;
    }
}
