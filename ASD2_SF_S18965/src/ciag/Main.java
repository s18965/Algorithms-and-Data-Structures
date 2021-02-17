package ciag;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String line="";
        int dlugoscCiaguNierosnącego=1;
        int dlugoscNajdluzszegoCiągu=1;
        int sumaElementówCiąguNierosnącego=0;
        int dlugoscCiaguNiemalejącego=1;
        int dlugoscNajdluzszegoCiąguNiemalejącego=1;
        int dlugoscNajdluzszegoCiąguNierosnącego=1;
        int sumaElementówCiąguNiemalejącego=0;
        int sumaElementowNajdluzszegoCiaguNiemalejącego=0;
        int sumaElementowNajdluzszegoCiaguNierosnącego=0;
        int ciągNierosnący[];
        int ciągNiemalejący[];
        int indeksNiemalejący=1;
        int indeksNierosnący=1;
        int ostatecznaNiemalejąca[]=null;
        int ostatecznaNierosnąca[]=null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/ciag.txt"));
            while ((line = br.readLine()) != null) {
                System.out.println("Ciąg to: " + line);
                String wyrazy[] = line.split(" ");
                int pusta[]=new int[wyrazy.length];
                ciągNierosnący =new int[wyrazy.length];
                ciągNierosnący[0]=Integer.parseInt(wyrazy[0]);
                sumaElementówCiąguNierosnącego+=Integer.parseInt(wyrazy[0]);
                ciągNiemalejący =new int[wyrazy.length];
                ciągNiemalejący[0]=Integer.parseInt(wyrazy[0]);
                sumaElementówCiąguNiemalejącego+=Integer.parseInt(wyrazy[0]);
                
                for(int i=1; i<wyrazy.length; i++) {

                    if(Integer.parseInt(wyrazy[i])<=Integer.parseInt(wyrazy[i-1]))
                    {
                        dlugoscCiaguNierosnącego++;
                        sumaElementówCiąguNierosnącego += Integer.parseInt(wyrazy[i]);
                        ciągNierosnący[indeksNierosnący++] = Integer.parseInt(wyrazy[i]);
                    }

                    if(Integer.parseInt(wyrazy[i])>Integer.parseInt(wyrazy[i-1])||(i==wyrazy.length-1)){
                        if(dlugoscCiaguNierosnącego>dlugoscNajdluzszegoCiągu && dlugoscCiaguNierosnącego> dlugoscNajdluzszegoCiąguNierosnącego){
                            int tymczasowa[]=new int[indeksNierosnący];
                            for(int a=0; a<tymczasowa.length; a++){
                                tymczasowa[a]=ciągNierosnący[a];
                            }
                            ostatecznaNierosnąca=tymczasowa;
                            ciągNierosnący=pusta;
                            dlugoscNajdluzszegoCiąguNierosnącego=dlugoscCiaguNierosnącego;
                            sumaElementowNajdluzszegoCiaguNierosnącego=sumaElementówCiąguNierosnącego;
                        }
                        sumaElementówCiąguNierosnącego=0;
                        ciągNierosnący[0]=Integer.parseInt(wyrazy[i]);
                        dlugoscCiaguNierosnącego=1;
                        indeksNierosnący=1;
                        sumaElementówCiąguNierosnącego+=Integer.parseInt(wyrazy[i]);
                    }
                }

                for(int i=1; i<wyrazy.length; i++) {
                    if (Integer.parseInt(wyrazy[i]) >= Integer.parseInt(wyrazy[i - 1])) {
                        dlugoscCiaguNiemalejącego++;
                        sumaElementówCiąguNiemalejącego += Integer.parseInt(wyrazy[i]);
                        ciągNiemalejący[indeksNiemalejący++] = Integer.parseInt(wyrazy[i]);
                    }

                    if (Integer.parseInt(wyrazy[i]) < Integer.parseInt(wyrazy[i - 1]) || (i == wyrazy.length - 1)) {
                        if (dlugoscCiaguNiemalejącego > dlugoscNajdluzszegoCiągu && dlugoscCiaguNiemalejącego > dlugoscNajdluzszegoCiąguNiemalejącego) {
                            int tymczasowa[] = new int[indeksNiemalejący];
                            for (int a = 0; a < tymczasowa.length; a++) {
                                tymczasowa[a] = ciągNiemalejący[a];
                            }
                            ostatecznaNiemalejąca = tymczasowa;
                            ciągNiemalejący = pusta;
                            dlugoscNajdluzszegoCiąguNiemalejącego = dlugoscCiaguNiemalejącego;
                            sumaElementowNajdluzszegoCiaguNiemalejącego = sumaElementówCiąguNiemalejącego;
                        }
                        sumaElementówCiąguNiemalejącego = 0;
                        ciągNiemalejący[0] = Integer.parseInt(wyrazy[i]);
                        dlugoscCiaguNiemalejącego = 1;
                        indeksNiemalejący = 1;
                        sumaElementówCiąguNiemalejącego += Integer.parseInt(wyrazy[i]);
                    }
                }
                System.out.print("Największy podciąg to: ");

                if(dlugoscNajdluzszegoCiąguNiemalejącego>dlugoscNajdluzszegoCiąguNierosnącego){
                    for(int i=0; i<ostatecznaNiemalejąca.length;i++){
                        System.out.print(ostatecznaNiemalejąca[i] + " ");
                    }
                    System.out.println("\n" +dlugoscNajdluzszegoCiąguNiemalejącego + " " + sumaElementowNajdluzszegoCiaguNiemalejącego);
                }
                if(dlugoscNajdluzszegoCiąguNiemalejącego<dlugoscNajdluzszegoCiąguNierosnącego){
                    for(int i=0; i<ostatecznaNierosnąca.length;i++){
                        System.out.print(ostatecznaNierosnąca[i] + " ");
                    }
                    System.out.println("\n" + dlugoscNajdluzszegoCiąguNierosnącego + " " + sumaElementowNajdluzszegoCiaguNierosnącego);
                }
                if(dlugoscNajdluzszegoCiąguNiemalejącego==dlugoscNajdluzszegoCiąguNierosnącego) {
                    int dlugosc = dlugoscCiaguNiemalejącego;
                    int counterNiemalejacy=0;
                    int counterNierosnacy=0;
                    indeksNiemalejący=0;
                    indeksNierosnący=0;
                    boolean znaleziony =false;
                    for (int i = 0; i < wyrazy.length; i++) {
                        if(ostatecznaNiemalejąca[indeksNiemalejący]==Integer.parseInt(wyrazy[i])&&!znaleziony){
                            counterNiemalejacy++;
                            indeksNiemalejący++;
                        }
                        if(ostatecznaNierosnąca[indeksNierosnący]==Integer.parseInt(wyrazy[i])&&!znaleziony){
                            counterNierosnacy++;
                            indeksNierosnący++;
                        }

                        if(dlugosc==counterNiemalejacy &&!znaleziony){
                            znaleziony=true;
                            for(int a=0; a<ostatecznaNiemalejąca.length;a++){
                                System.out.print(ostatecznaNiemalejąca[a] + " ");
                            }
                            System.out.println("\n" + dlugoscNajdluzszegoCiąguNiemalejącego + " " + sumaElementowNajdluzszegoCiaguNiemalejącego);
                        }
                        if(dlugosc==counterNierosnacy&&!znaleziony){
                            znaleziony=true;
                            for(int b=0; b<ostatecznaNierosnąca.length;b++){
                                System.out.print(ostatecznaNierosnąca[b] + " ");
                            }
                            System.out.println("\n" + dlugoscNajdluzszegoCiąguNierosnącego + " " + sumaElementowNajdluzszegoCiaguNierosnącego);
                        }
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}