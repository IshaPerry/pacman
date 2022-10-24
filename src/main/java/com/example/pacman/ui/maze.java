package com.example.pacman.ui;

public class maze {
    private char[][] easyArray;
    private char[][] medArray;
    private char[][] hardArray;
    private final int EASYROW = 13;
    private final int EASYCOL = 45;
    private final int MEDROW = 17;
    private final int MEDCOL = 39;
    private final int HARDROW = 63;
    private final int HARDCOL = 55;


    /**
     * Constructs a new maze object
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
                {'W', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W'},
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}
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

    public int getEASYROW() {
        return EASYROW;
    }

    public int getEASYCOL() {
        return EASYCOL;
    }

    public int getMEDROW() {
        return MEDROW;
    }

    public int getMEDCOL() {
        return MEDCOL;
    }

    public int getHARDROW() {
        return HARDROW;
    }

    public int getHARDCOL() {
        return HARDCOL;
    }
}
