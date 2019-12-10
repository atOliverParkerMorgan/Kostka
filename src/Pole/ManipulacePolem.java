package Pole;

public class ManipulacePolem {
    public static void main(String[] args) {
        System.out.println(ManipulacePolem.GeometrickyPrumer(new double[]{1,2,3,4,5,6,7,8,9,200}));
    }

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

}
