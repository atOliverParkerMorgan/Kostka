package School;


import cz.gyarab.util.Utils;

public class Main{
    public static void main(String[] args) {
        Kostka kostka = new Kostka(0);
        kostka.four();
        kostka.showKostka();
    }
    public static void random(){
        int cycle = 1000;

        Kostka kostka = new Kostka(0);
        for(int i =0; i<cycle; i++) {
            int r = (int) (Math.random()*10);
            kostka.setState(r);
            Utils.sleep(1000);
            kostka.showKostka();
        }
    }

    public static void postupne(){
        Kostka kostka = new Kostka(0);
        for(int i =0; i<10; i++) {
            kostka.setState(i);
            Utils.sleep(1000);
            kostka.showKostka();
        }
    }
}
