package ru.job4j.chessBoard;

public class Bishop extends Figure{

    public Bishop(String name, boolean color, Cell position) {
        super(name, color, position);
    }

    @Override
    public Cell move(Cell newPos, Cell oldPos) {
        Cell[] way = new Cell[this.getDistanace(newPos, oldPos)];
        if (newPos.posX > oldPos.posX && newPos.posX > oldPos.posX) {
            //вычислить длину пути, массив траектории сделать этой длины
            for (int i = 0; i < way.length; i++) {
                way[i].posX = oldPos.posX++;
                way[i].posY = oldPos.posY++;
            }
            //заполнить массив трактории
        }

        return newPos;
    }
}
