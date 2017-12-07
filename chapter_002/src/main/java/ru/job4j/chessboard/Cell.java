package ru.job4j.chessboard;

public class Cell {
    protected int posX;
    protected int posY;
    private boolean color;

    public Cell(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
}
