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
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
                {'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W', 'W', 'W', 'W', 'S', 'S', 'S', 'S', 'S', 'W', 'W', 'W', 'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'P', 'S', 'W', 'S', 'B', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'B', 'S', 'W', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}
        };

        medArray = new char[][]{
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W','W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
                {'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W',  'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S',  'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'B', 'S', 'P',  'S', 'P', 'S', 'P', 'S', 'W',  'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'B', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W',  'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S',  'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'W', 'W', 'W',  'S', 'P', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W',  'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W', 'W', 'W', 'W', 'W', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'P', 'S', 'W',  'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W',  'S', 'P', 'S', 'B', 'S', 'B', 'S', 'B', 'S', 'W',  'S', 'P', 'S', 'W', 'S', 'P', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W',  'S', 'P', 'S', 'W', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W',  'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'B', 'S', 'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W',  'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W','W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}
        };

        hardArray = new char[][]{
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
                {'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W', 'W', 'W', 'W', 'S', 'S', 'S', 'S', 'S', 'W', 'W', 'W', 'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'P', 'S', 'W', 'S', 'B', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'B', 'S', 'W', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'W', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'S', 'P', 'S', 'W', 'S', 'P', 'S', 'W', 'W', 'W', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'P', 'S', 'W'},
                {'W', 'S', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}
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
