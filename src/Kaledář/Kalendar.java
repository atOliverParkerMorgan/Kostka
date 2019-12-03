package Kaledář;

public class Kalendar {
    private int[] pocetdnuvmesici = {31,28,31,30,31,30,31,31,30,31,30,31};
    private boolean prestupny;

    Kalendar(boolean prestupny){
        this.prestupny = prestupny;
        if(prestupny){
            pocetdnuvmesici[1]++;
        }
    }

    private int poradiDne(int mesic, int den){
        int poradi = den;
        for(int i=0;i<mesic-1;i++){
            poradi +=pocetdnuvmesici[i];
        }
        return poradi;
    }
    private int[] denVPoradi(int poradi){
        int mesic;
        for(mesic = 0;poradi-pocetdnuvmesici[mesic]>0;mesic++){
            poradi-=pocetdnuvmesici[mesic];
        }

        return new int[]{mesic+1,poradi};
    }

    public int interval(int mesicOd, int denOd, int mesicDo, int denDo){
        return poradiDne(mesicOd,denOd)-poradiDne(mesicDo,denDo);
    }
    public static void main(String[] args) {
        Kalendar k = new Kalendar(true);
        System.out.println(k.poradiDne(12,31));
        int[] a = k.denVPoradi(365);
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println();
        System.out.println(k.interval(1,0,1,0));
    }

    public int[] getPocetdnuvmesici() {
        return pocetdnuvmesici;
    }

    public boolean isPrestupny() {
        return prestupny;
    }

    public void setPocetdnuvmesici(int[] pocetdnuvmesici) {
        if(pocetdnuvmesici.length!=12){
            System.out.println("Error: array has to have twelve elements");
        }else {
            this.pocetdnuvmesici = pocetdnuvmesici;
        }
    }

    public void setPrestupny(boolean prestupny) {
        if(!prestupny && this.prestupny) {
            pocetdnuvmesici[1]--;
        }else if(prestupny && !this.prestupny){
            pocetdnuvmesici[1]++;
        }
        this.prestupny = prestupny;



    }
}
