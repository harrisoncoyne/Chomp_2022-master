import java.awt.*;
import java.util.Arrays;

public class Chip {
    //variables
    public int xpos;
    public int ypos;
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle rec;

    public Chip(int row, int col, int xOff, int yOff, int size){

        isAlive = true;
        xpos = col*size+xOff;
        ypos = (9-row)*size+yOff;
        rec = new Rectangle(xpos,ypos, size, size);
    }

}


//    public void checkLose(int a,int b,int c){
//        int column1 = a;
//        int column2 = b;
//        int column3 = c;
//
//        for(int[] x : tempBoard.boards){
//            for (Board z: winBoards){
//                if(Arrays.toString(x).equals(column1 + "" + column2 + "" + column3)){
//                    System.out.println("lose");
//                }
//            }
//        }
//    }
