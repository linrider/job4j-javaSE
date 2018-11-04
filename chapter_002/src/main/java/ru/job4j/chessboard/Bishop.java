package ru.job4j.chessboard;

public class Bishop extends Figure implements Cloneable{

    public Bishop(Cell position) {
        super(position);
        }

        private static Cell addNewStep(int x, int y) {
            return  new Cell(x, y);
    }

    @Override
    public Cell[] way(Cell destination) throws ImpossibleMoveException {
        Cell[] way = new Cell[Math.abs(this.position.posX - destination.posX)];

        int x = this.position.posX;
        int y = this.position.posY;

        if (destination.posX - x != destination.posY - y) {
            throw new ImpossibleMoveException("This figure can't move like this!");
        }

        if (destination.posX > x && destination.posY > y) {
            for (int i = 0; i < way.length; i++) {
                way[i] = addNewStep(++x, ++y);
            }
        } else if (destination.posX > x && destination.posY < y) {
            for (int i = 0; i < way.length; i++) {
                way[i] = addNewStep(++x, --y);
            }
        } else if (destination.posX < x && destination.posY > y) {
            for (int i = 0; i < way.length; i++) {
                way[i] = addNewStep(--x, ++y);
            }
        } else if (destination.posX < x && destination.posY < y) {
            for (int i = 0; i < way.length; i++) {
                way[i] = addNewStep(--x, --y);
            }
        }

        return way;
    }

    @Override
    public Figure copy(Cell destination) {
        return new Bishop(destination);
    }
}
