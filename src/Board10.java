import java.awt.*;
import java.util.ArrayList;

public class Board10 {

    public Point move;

    int[] boards = new int[10];


    public Board10 (int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, Point move){
        boards[0] = a;
        boards[1] = b;
        boards[2] = c;
        boards[3] = d;
        boards[4] = e;
        boards[5] = f;
        boards[6] = g;
        boards[7] = h;
        boards[8] = i;
        boards[9] = j;

        this.move = move;
    }

}