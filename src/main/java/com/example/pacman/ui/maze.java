package com.example.pacman.ui;

public class maze {
    private char[][] easyArray;
    private char[][] medArray;
    private char[][] hardArray;

    /**
     * Constructs a new easyMaze object
     */
    public maze() {
        easyArray = new char[][]{
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
                {'W', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'W'},
                {'W', 'P', 'W', 'W', 'P', 'P', 'P', 'P', 'W', 'W', 'W', 'S', 'S', 'S', 'S', 'S', 'W', 'W', 'W', 'P', 'P', 'P', 'P', 'W', 'W', 'P', 'W'},
                {'W', 'P', 'W', 'B', 'P', 'W', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'B', 'W', 'P', 'W'},
                {'W', 'P', 'W', 'W', 'P', 'W', 'P', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'P', 'W', 'W', 'P', 'W'},
                {'W', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'W'},
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}
        };


        medArray = new char[][]{
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W','W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
                {'W', 'B', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'B', 'W'},
                {'W', 'P', 'W', 'W', 'P', 'W', 'P', 'W', 'W', 'P', 'P', 'W', 'W', 'P', 'W', 'P', 'W', 'W', 'P', 'W'},
                {'W', 'P', 'P', 'P','P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'W'},
                {'W', 'P', 'W', 'P', 'W', 'W', 'P', 'W', 'W', 'W', 'W', 'W', 'W', 'P', 'W', 'W', 'P', 'W', 'P', 'W'},
                {'W', 'P', 'W', 'P', 'P', 'P', 'P', 'W', 'S', 'S', 'S', 'S', 'W', 'P', 'W', 'P', 'P', 'W', 'P', 'W'},
                {'W', 'P', 'W', 'P', 'W', 'W', 'P', 'W', 'W', 'S', 'S', 'W', 'W', 'P', 'W', 'P', 'W', 'W', 'P', 'W'},
                {'W', 'B', 'W', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'P', 'W'},
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}
        };

        hardArray = new char[][]{
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
                {'W', 'P', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'P', 'W'},
                {'W', 'B', 'W', 'W', 'P', 'W', 'P', 'W', 'W', 'W', 'W', 'W', 'P', 'W', 'P', 'W', 'W', 'B', 'W'},
                {'W', 'P', 'P', 'W', 'P', 'P', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'P', 'P', 'W', 'P', 'P', 'W'},
                {'W', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'W'},
                {'S', 'S', 'P', 'P', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'P', 'P', 'S', 'S'},
                {'W', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'P', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'W'},
                {'S', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'W', 'W', 'W', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'S'},
                {'W', 'W', 'P', 'W', 'P', 'P', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'P', 'P', 'W', 'P', 'W', 'W'},
                {'W', 'P', 'P', 'P', 'P', 'W', 'S', 'W', 'S', 'W', 'S', 'W', 'S', 'W', 'P', 'P', 'P', 'P', 'W'},
                {'W', 'W', 'P', 'W', 'W', 'W', 'S', 'W', 'S', 'S', 'S', 'W', 'S', 'W', 'W', 'W', 'P', 'W', 'W'},
                {'W', 'P', 'P', 'P', 'P', 'W', 'S', 'W', 'W', 'W', 'W', 'W', 'S', 'W', 'P', 'P', 'P', 'P', 'W'},
                {'W', 'P', 'W', 'W', 'P', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'P', 'W', 'W', 'P', 'W'},
                {'W', 'P', 'P', 'W', 'P', 'W', 'P', 'W', 'W', 'W', 'W', 'W', 'P', 'W', 'P', 'W', 'P', 'P', 'W'},
                {'W', 'W', 'P', 'W', 'P', 'W', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'W', 'P', 'W', 'P', 'W', 'W'},
                {'S', 'S', 'P', 'P', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'P', 'P', 'S', 'S'},
                {'W', 'W', 'P', 'W', 'P', 'W', 'W', 'W', 'P', 'W', 'P', 'W', 'W', 'W', 'P', 'W', 'P', 'W', 'W'},
                {'W', 'P', 'P', 'W', 'P', 'P', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'P', 'P', 'W', 'P', 'P', 'W'},
                {'W', 'B', 'W', 'W', 'P', 'W', 'P', 'W', 'W', 'W', 'W', 'W', 'P', 'W', 'P', 'W', 'W', 'B', 'W'},
                {'W', 'P', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'P', 'W'},
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}
        };
    }

    public char[][] getEasyArray() {
        return this.easyArray;
    }


    public char[][] getMedArray() {
        return this.medArray;
    }
  
    public char[][] getHardArray() {
        return this.hardArray;
    }
}
