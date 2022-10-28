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

    //public int a,b,c;

    public void printAllBoards(){
        //a = column 1; b = column 2; c = column 3

        //print all legal 3x3 boards
        for(int a = 3; a >= 1; a--){
            for(int b = 3; b>= 0; b--){
                for (int c = 3; c>= 0; c--){
                    if(a >= b && b >= c) {
                        System.out.println(a + "" + b + "" + c);
                        System.out.println("move boards");
                        printAllMoveBoards(a,b,c);
                        System.out.println();
                    }
                }
            }
        }

    }

    public void printAllMoveBoards(int a, int b, int c) {
        //print all good moves from 3x3 boards

        for (int z = (c - 1); z >= 0; z--) {            // third column
            System.out.println((a) + "" + (b) + "" + (z));
        }

        for (int z = (b - 1); z >= 0; z--) {            // second column
            if (a >= z && z >= c) {
                System.out.println((a) + "" + (z) + "" + (c));
            }
        }

        for (int z = (a - 1); z >= 0; z--) {            //first column
            if (z >= b && b >= c) {
                System.out.println((z) + "" + (b) + "" + (c));
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
