package Kaledář;

public class Kalendar {
    private int[] pocetdnuvmesici = {31,28,31,30,31,30,31,31,30,31,30,31};

    public int Poctednuvroce(){
        int sum = 0;
        for(int s:pocetdnuvmesici){
            sum+=s;
        }
        return sum;
    }

    public static void main(String[] args) {
        Kalendar k = new Kalendar();
        System.out.println(k.Poctednuvroce());
    }
}
