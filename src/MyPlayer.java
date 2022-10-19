import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */

        printAllBoards();



    }

    public void printAllBoards(){
        //o = column 1; t = column 2; x = column 3

        //print all legal 3x3 boards
        for(int o = 3; o >= 1; o--){
            for(int t = 3; t>= 0; t--){
                for(int x = 3; x>= 0; x--){
                    if(o >= t && t >= x) {
                        //System.out.println(o + "" + t + "" + x);
                        printAllMoveBoards();
                        System.out.println();

                    }
                }
            }
        }

    }

    public void printAllMoveBoards(){
        //print all good moves from 3x3 boards
        for (int q = 0; q<=3;q++) {
            for(int o = 3; o >= 1; o--){
                for(int t = 3; t>= 0; t--){
                    for(int x = 3; x>= 0; x--){
                        if(x!=3 && o >= t && t >= x) {
                            //System.out.println(o + "" + t + "" + x);

                            int one = o-q;
                            int two = t-q;
                            int three = x-q;

                            if (one >= 0 && two >= 0 && three >= 0) {
                                System.out.println(one + "" + two + "" + three);
                                //System.out.println();
                            }
                        }
                    }
                }
            }
        }
    }


    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;
    }

}
