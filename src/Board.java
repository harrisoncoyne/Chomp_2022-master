import java.awt.*;
import java.util.ArrayList;

public class Board {

    public Point move;

    int[] boards = new int[3];


    public Board (int a, int b, int c, Point move){
        boards[0] = a;
        boards[1] = b;
        boards[2] = c;

        this.move = move;
    }

}