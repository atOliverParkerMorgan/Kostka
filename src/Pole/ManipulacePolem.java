package Pole;

public class ManipulacePolem {

    static double Soucet(double[] pole){
        double celkem = 0;
        for (double element:pole) {
            celkem+=element;
        }
        return celkem;
    }

    static double Prumer(double[] pole){
        return Soucet(pole)/pole.length;
    }

    static double GeometrickyPrumer(double[] pole){
        double celkem = pole[0];
        for (int i =1; i<pole.length;i++) {
            celkem*=pole[i];
        }

        return Math.pow(celkem, 1.0/pole.length);
    }
    static double KvadratickyPrumer(double[] pole){
        double celkem = 0;
        for (double v : pole) {
            celkem += v * v;
        }
        double prumer = celkem/pole.length;
        return Math.pow(prumer,0.5);
    }
    static double odchylka(double[] pole){
        return Prumer(pole)-KvadratickyPrumer(pole)<0?-(Prumer(pole)-KvadratickyPrumer(pole)):(Prumer(pole)-KvadratickyPrumer(pole));
    }
    static double vazenyPrumer(double[] pole, double[] vahy){
        double celkem = 0;
        for (int i = 0; i <pole.length ; i++) {
            celkem+=pole[i]*vahy[i];
        }
        return celkem/pole.length;
    }

    static double[] klon(double[] pole){
        double[] poleN = new double[pole.length];
        for (int i = 0; i <pole.length ; i++) {
            poleN[i] = pole[i];
        }
        return poleN;
    }
    static double[] spoj (double[] pole1,double[] pole2){
        double[] pole3 = new double[pole1.length+pole2.length];

        for (int i = 0; i < pole3.length; i++) {
            pole3[i] = pole1.length>i? pole1[i]:pole2[i-pole1.length];
        }
        return pole3;
    }
    static boolean logickySoucin(boolean[] pole){
        boolean konjunkce = true;
        for (int i = 0; i < pole.length-1; i++) {
            konjunkce = pole[i] && pole[i+1] && konjunkce;
        }
        return konjunkce;
    }
    static boolean logickySoucet(boolean[] pole){
        boolean disjunkce = false;
        for (int i = 0; i < pole.length-1; i++) {
            disjunkce = pole[i] || pole[i+1] || disjunkce;
        }
        return disjunkce;
    }



}
