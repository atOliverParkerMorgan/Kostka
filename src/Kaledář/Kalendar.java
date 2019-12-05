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


        if(mesic>12||mesic<1){
            System.out.println("Error: input out bounds");
            return -1;
        }else if(den>pocetdnuvmesici[mesic-1]||den<0){
            System.out.println("Error: input out bounds");
            return -1;
        }
        if(den==0){
            if(mesic!=1) {
                System.out.println("!!! index alert !!! 0. " + mesic + ". == " + pocetdnuvmesici[mesic - 2] + ". " + mesic + ".");
            }
        }
        for(int i=0;i<mesic-1;i++){
            poradi +=pocetdnuvmesici[i];
        }
        return poradi;
    }
    private int[] denVPoradi(int poradi){
        int mesic;
        if(prestupny&&poradi>366||!prestupny&&poradi>365){
            System.out.println("Error: input out bounds");
            return new int[]{-1,-1};
        }
        for(mesic = 0;poradi-pocetdnuvmesici[mesic]>0;mesic++){
            poradi-=pocetdnuvmesici[mesic];
        }

        return new int[]{mesic+1,poradi};
    }

    private int interval(int mesicOd, int denOd, int mesicDo, int denDo){
        if(poradiDne(mesicDo,denDo)<poradiDne(mesicOd,denOd)){
            int celkem = prestupny? 366: 365;
            return celkem-poradiDne(mesicOd, denOd) + poradiDne(mesicDo, denDo);

        }
        return poradiDne(mesicOd,denOd)-poradiDne(mesicDo,denDo);
    }
    public static void main(String[] args) {
        Kalendar k = new Kalendar(true);
        System.out.println(k.poradiDne(1,31));
        int[] a = k.denVPoradi(367);
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println();
        System.out.println(k.interval(12,31,1,1));
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
            //změna únoru
            pocetdnuvmesici[1]--;
        }else if(prestupny && !this.prestupny){
            //změna únoru
            pocetdnuvmesici[1]++;
        }
        this.prestupny = prestupny;



    }
}
