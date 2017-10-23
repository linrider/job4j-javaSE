package ru.job4j.chessBoard;

public class Cell {
    protected int posX;
    protected int posY;
    private boolean color;

    public Cell(int posX, int posY, boolean color) {
        this.posX = posX;
        this.posY = posY;
        this.color = color;
    }
}
