package ru.job4j.chessBoard;

public abstract  class Figure implements Movable{
    private String name;
    private boolean color;
    public Cell position;

    public Figure(String name, boolean color, Cell position) {
        this.name = name;
        this.color = color;
        this.position = position;
    }

    public int getDistanace(Cell newPos, Cell oldPos) {
        return (int) Math.sqrt(Math.pow((newPos.posX - oldPos.posX), 2) + Math.pow((newPos.posY - oldPos.posY), 2));
    }

}
