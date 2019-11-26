import cz.gyarab.util.light.Matrix;

public class Коstka {
    private int state;
    private Matrix matrix;
    private final int width = 3;
    private final int height = width;


    public Коstka(int state){
        this.state = state;
        this.matrix = Matrix.createMatrix(width,height);

    }
    private void fillRow(int index){
        for(int x=0;x<width;x++){
            this.matrix.setOn(index,x);
        }

    }private void fillCol(int index){
        for(int y=0;y<height;y++){
            this.matrix.setOn(y,index);
        }
    }

    private void nine(){
       for(int i=0;i<width;i++){
           fillRow(i);
       }

    }private void eight(){
        nine();
        this.matrix.setOff(1,1);
    }
    private void seven(){
        nine();
        this.matrix.setOff(0,1);
        this.matrix.setOff(2,1);
    }private void six(){
        fillCol(0);
        fillCol(2);
    }private void five(){
        for(int i;i<width;i++){

        }
    }


}
