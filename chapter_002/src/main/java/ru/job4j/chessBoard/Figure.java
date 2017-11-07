package ru.job4j.chessBoard;

public abstract  class Figure {
    private String name;
    private boolean color;
    public Cell position;
    public int index;

    public Figure(String name, boolean color, int posX, int posY) {
        this.name = name;
        this.color = color;
        this.position.posX = posX;
        this.position.posY = posY;
    }
    public abstract Cell[] way(Cell desttination);


}
