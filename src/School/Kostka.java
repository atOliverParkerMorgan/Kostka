package School;

import cz.gyarab.util.light.Matrix;

public class Kostka {
    private int state;

    private Matrix matrix;
    private static final int width = 5;
    private static final int height = width;

    private static final int[] center = new int[]{2,2};

    public Kostka(int state){
        if(state>9){
            state = 9;
        }else if(state<0){
            state = 0;
        }
        this.state = state;
        this.matrix = Matrix.createMatrix(width,height);


    }
    public Kostka(){

        this.state = 5;
        this.matrix = Matrix.createMatrix(width,height);


    }

    private void fillRow(int index){
        for(int y=0;y<width;y+=2){
            this.matrix.setOn(index,y);
        }

    }private void fillCol(int index){
        for(int x=0;x<height;x+=2){
            this.matrix.setOn(x,index);
        }
    }
    public void showKostka(){
       switch (state){
           case 0:
               zero();
               break;
           case 1:
               one();
               break;
           case 2:
               two();
               break;
           case 3:
               three();
               break;
           case 4:
               four();
               break;
           case 5:
               five();
               break;
           case 6:
               six();
               break;
           case 7:
               seven();
               break;
           case 8:
               eight();
               break;
           case 9:
               nine();
               break;
       }
       matrix.showWindow();
    }

    private void nine(){
        zero();
        for(int i=0;i<width;i+=2){
            fillCol(i);
        }

    }private void eight(){
        nine();
        this.matrix.setOff(center[0],center[1]);
    }
    private void seven(){
        nine();
        this.matrix.setOff(center[0],center[1]-2);
        this.matrix.setOff(center[0],center[1]+2);
    }private void six(){
        zero();
        fillRow(0);
        fillRow(width-1);
    }private void five(){
        zero();
        for(int i=0;i<3;i++){
            if(i%2==1){
                this.matrix.setOn(center[0],center[1]);
            }else{
                for(int r=0;r<3;r++) {
                    if(r%2==0){
                        this.matrix.setOn(i*2,r*2);
                    }
                }
            }

        }
    }public void four(){
        five();
        this.matrix.setOff(center[0],center[1]);
    }private void three(){
        five();
        this.matrix.setOff(0,4);
        this.matrix.setOff(4,0);
    }private void two(){
        three();
        this.matrix.setOff(center[0],center[1]);
    }private void one(){
        zero();
        this.matrix.setOn(2,2);
    }private void zero(){
        for(int x=0;x<width;x++) {
            for (int y = 0; y < height; y++) {
                this.matrix.setOff(x, y);
            }
        }
    }

    public int getState() {
        return state;
    }
    public void setState(int state){
        if(state>9){
            state = 9;
        }else if(state<0){
            state = 0;
        }
        this.state = state;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

}
