class Board {
    private int size;
    private char[][] grid;

    public Board(int size) {
        this.size = size;
        grid = new char[size][size];
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    public char[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return size;
    }

    public void displayBoard() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}