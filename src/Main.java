import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(6);
        char[][] grid = {
                {'A', 'A', '.', '.', '.', 'B'},
                {'C', 'C', '.', 'D', 'D', 'B'},
                {'.', '.', 'E', 'E', '.', '.'},
                {'F', 'F', '.', '.', '.', 'G'},
                {'H', 'H', 'I', 'I', '.', 'G'},
                {'.', '.', 'J', 'J', 'K', 'K'}
        };
        board.setGrid(grid);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car('A', 2, true, 0, 0));
        cars.add(new Car('B', 2, false, 0, 5));
        cars.add(new Car('C', 2, true, 1, 0));
        cars.add(new Car('D', 2, true, 1, 3));
        cars.add(new Car('E', 2, true, 2, 2));
        cars.add(new Car('F', 2, true, 3, 0));
        cars.add(new Car('G', 2, false, 3, 5));
        cars.add(new Car('H', 2, false, 4, 0));
        cars.add(new Car('I', 2, true, 4, 2));
        cars.add(new Car('J', 2, true, 5, 2));
        cars.add(new Car('K', 2, true, 5, 4));

        board.displayBoard();

        RushHour game = new RushHour(board, cars);
        game.start();
    }
}