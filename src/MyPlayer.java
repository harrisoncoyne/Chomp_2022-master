import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;

    public int[] columns;

    public int column;
    public int row;

    public Point myMove;

    int[] cols = new int[10];


    ArrayList<Board> boards3 = new ArrayList<Board>();
    ArrayList<Board> winBoards3 = new ArrayList<Board>();
    ArrayList<Board> loseBoards3 = new ArrayList<Board>();

    ArrayList<Board10> boards10 = new ArrayList<Board10>();
    ArrayList<Board10> winBoards10 = new ArrayList<Board10>();
    ArrayList<Board10> loseBoards10 = new ArrayList<Board10>();

    public boolean select;

    public MyPlayer() {

        columns = new int[10];
        for (int x = 0; x < 10; x++) {
            columns[x] = 10;
        }

        loseBoards3.add(new Board(1, 0, 0, new Point(0, 0)));

        loseBoards10.add(new Board10(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Point(0, 0)));

        System.out.println();

        //3x3 board
        //printAllBoards3();


//        System.out.println();
//        System.out.println("lose boards (3)");
//        for (Board x : loseBoards3) {
//            System.out.println(x.boards[0] + " " + x.boards[1] + " " + x.boards[2] + " : " + x.move.x + ", " + x.move.y);
//        }
//        System.out.println();
//        System.out.println("win boards (3)");
//        for (Board x : winBoards3) {
//            System.out.println(x.boards[0] + " " + x.boards[1] + " " + x.boards[2] + " : " + x.move.x + ", " + x.move.y);
//        }

//        boards = (ArrayList<Board>) winBoards3.clone();
//        boards.addAll(loseBoards3);

//        System.out.println();
//        System.out.println("all boards (3)");
//        for (Board x : boards) {
//            System.out.println(x.boards[0] + " " + x.boards[1] + " " + x.boards[2] + " : " + x.move.x + ", " + x.move.y);
//        }

//        10x10 board
        printAllBoards10();
        boards10 = (ArrayList<Board10>) winBoards10.clone();
        boards10.addAll(loseBoards10);
//        System.out.println();
//        System.out.println("lose boards (10)");
//        for (Board10 x : loseBoards10){
//            System.out.println(x.boards[0]+ "" + x.boards[1]+ "" + x.boards[2] + "" + x.boards[3]+ "" + x.boards[4]+ "" + x.boards[5] + "" + x.boards[6]+ "" + x.boards[7] + "" + x.boards[8] + "" + x.boards[9] + " " + x.move.x+ ", " + x.move.y);
//        }
//        System.out.println();
//
//        System.out.println("win boards (10)");
//        for (Board10 x : winBoards10){
//            System.out.println(x.boards[0]+ "" + x.boards[1]+ "" + x.boards[2] + "" + x.boards[3]+ "" + x.boards[4]+ "" + x.boards[5] + "" + x.boards[6]+ "" + x.boards[7] + "" + x.boards[8] + "" + x.boards[9] + " " + x.move.x+ ", " + x.move.y);
//        }

    }

    public void printAllBoards3() {   //print all legal 3x3 boards

        for (int a = 1; a <= 3; a++) {            //1st
            for (int b = 0; b <= a; b++) {         //2nd
                for (int c = 0; c <= b; c++) {    //3rd

                    System.out.println(a + " " + b + " " + c);

                    System.out.println("move boards");
                    printAllMoveBoards3(a, b, c);

                    System.out.println();

                }
            }
        }
    }

    public void printAllBoards10() {
        for (int a = 1; a <= 10; a++) {
            for (int b = 0; b <= a; b++) {
                for (int c = 0; c <= b; c++) {
                    for (int d = 0; d <= c; d++) {
                        for (int e = 0; e <= d; e++) {
                            for (int f = 0; f <= e; f++) {
                                for (int g = 0; g <= f; g++) {
                                    for (int h = 0; h <= g; h++) {
                                        for (int i = 0; i <= h; i++) {
                                            for (int j = 0; j <= i; j++) {
                                                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + h + " " + i + " " + j);

                                                //System.out.println("move boards");
                                                printAllMoveBoards10(a, b, c, d, e, f, g, h, i, j);

                                                //System.out.println();

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void printAllMoveBoards3(int a, int b, int c) {
        //print all good moves from 3x3 boards

        boolean hasLoser = false;
        Point move = new Point(0, 0);

        for (int z = (c - 1); z >= 0; z--) {            // third column
            column = z;
            row = 2;
            System.out.println((a) + "" + (b) + "" + (z) + ":" + " (" + column + "," + row  + ")");
            if (checkLose3(a, b, z) == true) {
                hasLoser = true;
                move = new Point(column, row);
            }
        }

        for (int z = (b - 1); z >= 0; z--) {            // second column
            column = z;
            row = 1;
            if (z < c) {
                System.out.println((a) + "" + (z) + "" + (z) + ":" + " (" + column + "," + row + ")");
                if (checkLose3(a, z, z) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else {
                System.out.println((a) + "" + (z) + "" + (c) + ":" + " (" + column + "," + row + ")");
                if (checkLose3(a, z, c) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            }
        }

        for (int z = (a - 1); z >= 0; z--) {            //first column
            column = z;
            row = 0;
            if (z < b && z < c) {
                System.out.println((z) + "" + (z) + "" + (z) + ":" + " (" + column + "," + row + ")");
                if (checkLose3(z, z, z) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < b) {
                System.out.println((z) + "" + (z) + "" + (c) + ":" + " (" + column + "," + row + ")");
                if (checkLose3(z, z, c) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else {
                System.out.println((z) + "" + (b) + "" + (c) + ":" + " (" + column + "," + row + ")");
                if (checkLose3(z, b, c) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            }
        }


        if (hasLoser == true) {
            System.out.println("win board");
            winBoards3.add(new Board(a, b, c, move));
        } else {
            System.out.println("lose board");
            loseBoards3.add(new Board(a, b, c, move));
        }
        // if you find a losing board that equals a result, you know the original board abc is a winner
        // if you don't find a losing board, the original abc board is a loser
    }

    public void printAllMoveBoards10(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j) {
        //print all good moves from 3x3 boards

        boolean hasLoser = false;
        Point move = new Point(0, 0);

        for (int z = (j - 1); z >= 0; z--) {            // 10th column
            column = z;
            row = 9;
            //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + h + " " + i + " " + z + ":" + " (" + column + "," + row + ")");
            if (checkLose10(a, b, c, d, e, f, g, h, i, z) == true) {
                hasLoser = true;
                move = new Point(column, row);
            }
        }

        for (int z = (i - 1); z >= 0; z--) {            // 9th column
            column = z;
            row = 8;
            if (z < j) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + h + " " + z + " " + z + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, e, f, g, h, z, z) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + h + " " + z + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, e, f, g, h, z, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            }
        }

        for (int z = (h - 1); z >= 0; z--) {            //8th column
            column = z;
            row = 7;
            if (z < i && z < j) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + z + " " + z + " " + z + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, e, f, g, z, z, z) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < i) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + z + " " + z + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, e, f, g, z, z, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + z + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, e, f, g, z, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            }
        }

        for (int z = (g - 1); z >= 0; z--) {            //7th column
            column = z;
            row = 6;
            if (z < h && z < i && z < j) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + z + " " + z + " " + z + " " + z + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, e, f, z, z, z, z) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < h && z < i) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + z + " " + z + " " + z + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, e, f, z, z, z, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < h) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + z + " " + z + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, e, f, z, z, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + z + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, e, f, z, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            }
        }

        for (int z = (f - 1); z >= 0; z--) {            //6th column
            column = z;
            row = 5;
            if (z < g && z < h && z < i && z < j) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + z + " " + z + " " + z + " " + z + " " + z + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, e, z, z, z, z, z) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < g && z < h && z < i) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + z + " " + z + " " + z + " " + z + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, e, z, z, z, z, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < g && z < h) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + z + " " + z + " " + z + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, e, z, z, z, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < g) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + z + " " + z + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, e, z, z, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + z + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, e, z, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            }
        }

        for (int z = (e - 1); z >= 0; z--) {            //5th column
            column = z;
            row = 4;
            if (z < f && z < g && z < h && z < i && z < j) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, z, z, z, z, z, z) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < f && z < g && z < h && z < i) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + z + " " + z + " " + z + " " + z + " " + z + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, z, z, z, z, z, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < f && z < g && z < h) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + z + " " + z + " " + z + " " + z + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, z, z, z, z, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < f && z < g) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + z + " " + z + " " + z + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, z, z, z, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < f) {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + z + " " + z + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, z, z, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + z + " " + f + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, d, z, f, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            }
        }

        for (int z = (d - 1); z >= 0; z--) {            //4th column
            column = z;
            row = 3;
            if (z < e && z < f && z < g && z < h && z < i && z < j) {
                //System.out.println(a + " " + b + " " + c + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, z, z, z, z, z, z, z) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < e && z < f && z < g && z < h && z < i) {
                //System.out.println(a + " " + b + " " + c + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, z, z, z, z, z, z, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < e && z < f && z < g && z < h) {
                //System.out.println(a + " " + b + " " + c + " " + z + " " + z + " " + z + " " + z + " " + z + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, z, z, z, z, z, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < e && z < f && z < g) {
                //System.out.println(a + " " + b + " " + c + " " + z + " " + z + " " + z + " " + z + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, z, z, z, z, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < e && z < f) {
                //System.out.println(a + " " + b + " " + c + " " + z + " " + z + " " + z + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, z, z, z, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < e) {
                //System.out.println(a + " " + b + " " + c + " " + z + " " + z + " " + f + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, z, z, f, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else {
                //System.out.println(a + " " + b + " " + c + " " + z + " " + e + " " + f + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, c, z, e, f, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            }
        }

        for (int z = (c - 1); z >= 0; z--) {            //3rd column
            column = z;
            row = 2;
            if (z < d && z < e && z < f && z < g && z < h && z < i && z < j) {
                //System.out.println(a + " " + b + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, z, z, z, z, z, z, z, z) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < d && z < e && z < f && z < g && z < h && z < i) {
                //System.out.println(a + " " + b + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, z, z, z, z, z, z, z, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < d && z < e && z < f && z < g && z < h) {
                //System.out.println(a + " " + b + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, z, z, z, z, z, z, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < d && z < e && z < f && z < g) {
                //System.out.println(a + " " + b + " " + z + " " + z + " " + z + " " + z + " " + z + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, z, z, z, z, z, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < d && z < e && z < f) {
                //System.out.println(a + " " + b + " " + z + " " + z + " " + z + " " + z + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, z, z, z, z, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < d && z < e) {
                //System.out.println(a + " " + b + " " + z + " " + z + " " + z + " " + f + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, z, z, z, f, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < d) {
                //System.out.println(a + " " + b + " " + z + " " + z + " " + e + " " + f + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, z, z, e, f, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else {
                //System.out.println(a + " " + b + " " + z + " " + d + " " + e + " " + f + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, b, z, d, e, f, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            }
        }

        for (int z = (b - 1); z >= 0; z--) {            //2nd column
            column = z;
            row = 1;
            if (z < c && z < d && z < e && z < f && z < g && z < h && z < i && z < j) {
                //System.out.println(a + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, z, z, z, z, z, z, z, z, z) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < c && z < d && z < e && z < f && z < g && z < h && z < i) {
                //System.out.println(a + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, z, z, z, z, z, z, z, z, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < c && z < d && z < e && z < f && z < g && z < h) {
                //System.out.println(a + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, z, z, z, z, z, z, z, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < c && z < d && z < e && z < f && z < g) {
                //System.out.println(a + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, z, z, z, z, z, z, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < c && z < d && z < e && z < f) {
                //System.out.println(a + " " + z + " " + z + " " + z + " " + z + " " + z + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, z, z, z, z, z, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < c && z < d && z < e) {
                //System.out.println(a + " " + z + " " + z + " " + z + " " + z + " " + f + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, z, z, z, z, f, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < c && z < d) {
                //System.out.println(a + " " + z + " " + z + " " + z + " " + e + " " + f + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, z, z, z, e, f, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z < c) {
                //System.out.println(a + " " + z + " " + z + " " + d + " " + e + " " + f + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, z, z, d, e, f, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else {
                //System.out.println(a + " " + z + " " + c + " " + d + " " + e + " " + f + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(a, z, c, d, e, f, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            }
        }

        for (int z = (a - 1); z >= 0; z--) {            //1st column
            column = z;
            row = 0;
            if (z > b && z < c && z < d && z < e && z < f && z < g && z < h && z < i && z < j) {
                //System.out.println(z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + ":" + " (" + column + "," + row + ")");
                if (checkLose10(z, z, z, z, z, z, z, z, z, z) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z > b && z < c && z < d && z < e && z < f && z < g && z < h && z < i) {
                //System.out.println(z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(z, z, z, z, z, z, z, z, z, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z > b && z < c && z < d && z < e && z < f && z < g && z < h) {
                //System.out.println(a + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(z, z, z, z, z, z, z, z, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z > b && z < c && z < d && z < e && z < f && z < g) {
                //System.out.println(z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(z, z, z, z, z, z, z, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z > b && z < c && z < d && z < e && z < f) {
                //System.out.println(z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(z, z, z, z, z, z, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z > b && z < c && z < d && z < e) {
                //System.out.println(z + " " + z + " " + z + " " + z + " " + z + " " + f + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(z, z, z, z, z, f, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z > b && z < c && z < d) {
                //System.out.println(z + " " + z + " " + z + " " + z + " " + e + " " + f + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(z, z, z, z, e, f, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z > b && z < c) {
                //System.out.println(z + " " + z + " " + z + " " + d + " " + e + " " + f + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(z, z, z, d, e, f, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else if (z > b) {
                //System.out.println(z + " " + z + " " + c + " " + d + " " + e + " " + f + " " + g + " " + h + " " + i + " " + j + ":" + " (" + column + "," + row + ")");
                if (checkLose10(z, z, c, d, e, f, g, h, i, j) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            } else {
                //System.out.println(z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + " " + z + ":" + " (" + column + "," + row + ")");
                if (checkLose10(z, z, z, z, z, z, z, z, z, z) == true) {
                    hasLoser = true;
                    move = new Point(column, row);
                }
            }
        }


        if (hasLoser == true) {
            winBoards10.add(new Board10(a, b, c, d, e, f, g, h, i, j, move));
        } else {
            loseBoards10.add(new Board10(a, b, c, d, e, f, g, h, i, j, move));
        }
    }

    public boolean checkLose3(int a, int b, int c) {
        int column1 = a;
        int column2 = b;
        int column3 = c;
        boolean foundOne = false;

        // loop through losing boards
        for (Board x : loseBoards3) {
            // is abc = lBoard?
            if (x.boards[0] == column1 && x.boards[1] == column2 && x.boards[2] == column3) {
                // if yes, foundOne = true;
                foundOne = true;
            }
        }
        return foundOne;
    }

    public boolean checkLose10(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j) {
        int column1 = a;
        int column2 = b;
        int column3 = c;
        int column4 = d;
        int column5 = e;
        int column6 = f;
        int column7 = g;
        int column8 = h;
        int column9 = i;
        int column10 = j;


        boolean foundOne = false;

        for (Board10 x : loseBoards10) {
            if (x.boards[0] == column1 && x.boards[1] == column2 && x.boards[2] == column3 && x.boards[3] == column4 && x.boards[4] == column5 && x.boards[5] == column6 && x.boards[6] == column7 && x.boards[7] == column8 && x.boards[8] == column9 && x.boards[9] == column10) {
                foundOne = true;
            }
        }
        return foundOne;
    }


    public Point move(Chip[][] pBoard) {

        cols = new int[10];
        myMove = new Point (0,0);

        for(int y = 0; y < boards10.size(); y++) {
            System.out.println("MyPlayer Move: " + boards10.get(y).move);
        }

        gameBoard = pBoard;
        checkChips(gameBoard);

        for(int y = 0; y < boards10.size(); y++) {
            boolean check = true;

            for (int z = 0; z < 10; z++) {
                if (boards10.get(y).boards[z] != cols[z]) {
                    check = false;
                }
            }
            if (check == true) {
                System.out.println(boards10.get(y).move);
                myMove = boards10.get(y).move;
                break;
            }

        }
        return myMove;
    }

    public void checkChips(Chip[][] gameBoard) {

        for (int c = 0; c < 3; c++){
            for( int r = 0; r < 3; r++){
                if(gameBoard[r][c].isAlive == true) {
                    cols[c]++;
                }
            }
        }
    }

}
