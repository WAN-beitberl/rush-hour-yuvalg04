import java.util.ArrayList;
import java.util.Scanner;

class RushHour {
    private Board board;
    private ArrayList<Car> cars;
    private Car redCar;

    public RushHour(Board board, ArrayList<Car> cars) {
        this.board = board;
        this.cars = cars;
        redCar = cars.get(0);
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter car symbol and number of steps to move:");
            String carMove = input.nextLine();

            if (carMove.equals("exit")) {
                break;
            }

            char symbol = carMove.charAt(0);
            int steps = Integer.parseInt(carMove.substring(2));

            Car selectedCar = null;
            for (Car car : cars) {
                if (car.getSymbol() == symbol) {
                    selectedCar = car;
                    break;
                }
            }

            if (selectedCar == null) {
                System.out.println("Invalid car symbol, please try again.");
                continue;
            }

            int newX = selectedCar.getX();
            int newY = selectedCar.getY();
            if (selectedCar.isHorizontal()) {
                newY += steps;
            } else {
                newX += steps;
            }

            if (newX < 0 || newX >= board.getSize() || newY < 0 || newY >= board.getSize()) {
                System.out.println("Invalid move, car is out of bounds.");
                continue;
            }

            boolean isValidMove = true;
            for (int i = 0; i < selectedCar.getLength(); i++) {
                int x = selectedCar.getX();
                int y = selectedCar.getY();

                if (selectedCar.isHorizontal()) {
                    y += i;
                } else {
                    x += i;
                }

                int newPosX = newX;
                int newPosY = newY;

                if (selectedCar.isHorizontal()) {
                    newPosY = newY + i;
                } else {
                    newPosX = newX + i;
                }

                if (board.getGrid()[newPosX][newPosY] != '.' && board.getGrid()[newPosX][newPosY] != selectedCar.getSymbol()) {
                    System.out.println("Invalid move, car is blocked.");
                    isValidMove = false;
                    break;
                }
            }

            if (!isValidMove) {
                continue;
            }

            for (int i = 0; i < selectedCar.getLength(); i++) {
                int x = selectedCar.getX();
                int y = selectedCar.getY();

                if (selectedCar.isHorizontal()) {
                    y += i;
                } else {
                    x += i;
                }

                board.getGrid()[x][y] = '.';
            }

            selectedCar.setX(newX);
            selectedCar.setY(newY);

            for (int i = 0; i < selectedCar.getLength(); i++) {
                int x = selectedCar.getX();
                int y = selectedCar.getY();

                if (selectedCar.isHorizontal()) {
                    y += i;
                } else {
                    x += i;
                }

                board.getGrid()[x][y] = selectedCar.getSymbol();
            }

            board.displayBoard();

            if (redCar.getY() + redCar.getLength() - 1 == board.getSize() - 1) {
                System.out.println("\nYou have won the game! Congratulations.");
                break;
            }
        }
        input.close();
    }
}

