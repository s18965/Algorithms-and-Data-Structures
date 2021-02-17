package labirynt;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int dlugoscSciezki=0;
        char labirynt[][] = new char[10][10];
        List<Integer> ścieżka = new ArrayList<>();
        List<String> odwiedzoneŚcieżki = new ArrayList<>();
        List<Integer> znalezionaDroga = new ArrayList<>();
        int dlugoscNajkrotszejSciezki=1000;
        int aktualnaPozycja;
        int poprzednik;
        boolean koniec=false;
        String listString = "";

        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                labirynt[a][b] = Character.forDigit((int) (Math.random() * 2), 10);
            }
        }
        int SX=(int) (Math.random() * 10);
        int SY=(int) (Math.random() * 10);
        int KX=(int) (Math.random() * 10);
        int KY=(int) (Math.random() * 10);

        while(KX!=0 && KX!=9 && KY!=0 && KY!=9){
            KX=(int) (Math.random() * 10);
            KY=(int) (Math.random() * 10);
        }
        if((SX*10+SY)==(KX*10+KY)){
            KX=(int) (Math.random() * 10);
            KY=(int) (Math.random() * 10);
        }

        labirynt[SX][SY] = 'S';
        labirynt[KX][KY] = 'K';
        int y=SY;
        int x=SX;
        aktualnaPozycja=x*10+y;
        poprzednik=aktualnaPozycja;
        System.out.println("Start (" + (SX+1) +"," + (SY+1)+ "), Koniec (" + (KX+1) +"," + (KY+1)+ ")");

        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                System.out.print(labirynt[a][b] + " ");
            }
            System.out.println();
        }
        System.out.println();
        ścieżka.add(new Integer(x*10+y));
        int i=0;
        while(koniec!=true){

            for (Integer integer : ścieżka)
            {
                listString += integer;
            }
            String doGory=listString+String.valueOf((x-1)*10+y);
            String doDolu=listString+String.valueOf((x+1)*10+y);
            String doPrawej=listString+String.valueOf((x)*10+y+1);
            String doLewej=listString+String.valueOf((x)*10+y-1);

            if((x-1)>=0 &&(labirynt[x-1][y] == '1'|| labirynt[x-1][y] == 'K')&& !odwiedzoneŚcieżki.contains(doGory)
                    && !ścieżka.contains((x-1)*10+y)){
                    poprzednik=aktualnaPozycja;
                    x--;
                    aktualnaPozycja=x*10+y;
                    ścieżka.add(aktualnaPozycja);
            }else if((y+1)<10 &&(labirynt[x][y+1] == '1'|| labirynt[x][y+1] == 'K')&&! odwiedzoneŚcieżki.contains(doPrawej)
                   && !ścieżka.contains((x)*10+y+1)){
                    poprzednik=aktualnaPozycja;
                    y++;
                    aktualnaPozycja=x*10+y;
                    ścieżka.add(aktualnaPozycja);
            }else if((x+1)<10 &&(labirynt[x+1][y] == '1' || labirynt[x+1][y] == 'K')&& !odwiedzoneŚcieżki.contains(doDolu)
                    && !ścieżka.contains((x+1)*10+y)){
                    poprzednik=aktualnaPozycja;
                    x++;
                    aktualnaPozycja=x*10+y;
                    ścieżka.add(aktualnaPozycja);
            }else if((y-1)>=0 &&(labirynt[x][y-1] == '1'|| labirynt[x][y-1] == 'K')&& !odwiedzoneŚcieżki.contains(doLewej)&&
                    !ścieżka.contains((x)*10+y-1)){
                    poprzednik=aktualnaPozycja;
                    y--;
                    aktualnaPozycja=x*10+y;
                    ścieżka.add(aktualnaPozycja);
            }else if(ścieżka.size()==1) {
                koniec=true;
            }else
            {
                odwiedzoneŚcieżki.add(listString);
                listString="";
                ścieżka.remove(ścieżka.size()-1);
                aktualnaPozycja=poprzednik;
                if(ścieżka.size()==1){
                    poprzednik=ścieżka.get(ścieżka.size()-1);
                }else{
                    poprzednik=ścieżka.get(ścieżka.size()-2);
                }
                x=aktualnaPozycja/10;
                y=aktualnaPozycja%10;
            }

            if(x==KX && y==KY){
                dlugoscSciezki=ścieżka.size();
                if(dlugoscSciezki<dlugoscNajkrotszejSciezki){
                    znalezionaDroga.clear();
                    znalezionaDroga.addAll(ścieżka);
                    dlugoscNajkrotszejSciezki=dlugoscSciezki;
                }
                listString="";
                for (Integer integer : ścieżka)
                {
                    listString += integer;
                }

                if(!odwiedzoneŚcieżki.contains(listString)){
                    odwiedzoneŚcieżki.add(listString);
                }

                ścieżka.remove(ścieżka.size()-1);
                aktualnaPozycja=poprzednik;
                if(ścieżka.size()==1){
                    poprzednik=ścieżka.get(ścieżka.size()-1);
                }else{
                    poprzednik=ścieżka.get(ścieżka.size()-2);
                }
                x=aktualnaPozycja/10;
                y=aktualnaPozycja%10;
            }
            listString="";
        }
        if(znalezionaDroga.size()>0){
            System.out.print("Istnieje droga: ");
            for(int a=0; a<znalezionaDroga.size();a++){
                if(a==znalezionaDroga.size()-1){
                    System.out.print("("+(znalezionaDroga.get(a)/10+1)+","+(znalezionaDroga.get(a)%10+1)+")");
                }else{
                    System.out.print("("+(znalezionaDroga.get(a)/10+1)+","+(znalezionaDroga.get(a)%10+1)+"),");
                }
            }
        }else{
            System.out.println("Nie istnieje droga");
        }
    }
}