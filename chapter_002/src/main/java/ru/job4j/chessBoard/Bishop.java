package ru.job4j.chessBoard;

public class Bishop extends Figure{

    public Bishop(String name, boolean color, Cell position) {
        super(name, color, position);
    }

    @Override
    public Cell[] way(Cell destination) throws ImpossibleMoveException {
        Cell[] way = new Cell[Math.abs(this.position.posX - destination.posX)];

        int x = this.position.posX;
        int y = this.position.posY;

        if (destination.posX > x && destination.posY > y) {
            for (int i = 0; i < way.length; i++) {
                way[i].posX = x++;
                way[i].posY = y++;
            }
        }
        else if (destination.posX > x && destination.posY < y) {
            for (int i = 0; i < way.length; i++) {
                way[i].posX = x++;
                way[i].posY = y--;
            }
        }
        else if (destination.posX < x && destination.posY > y) {
            for (int i = 0; i < way.length; i++) {
                way[i].posX = x--;
                way[i].posY = y++;
            }
        }
        else if (destination.posX < x && destination.posY < y) {
            for (int i = 0; i < way.length; i++) {
                way[i].posX = x--;
                way[i].posY = y--;
            }
        }

        return way;
    }
}
