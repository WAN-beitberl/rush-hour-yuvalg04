class Car {
    private char symbol;
    private int length;
    private boolean isHorizontal;
    private int x, y;

    public Car(char symbol, int length, boolean isHorizontal, int x, int y) {
        this.symbol = symbol;
        this.length = length;
        this.isHorizontal = isHorizontal;
        this.x = x;
        this.y = y;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getLength() {
        return length;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int steps) {
        if (isHorizontal) {
            y += steps;
        } else {
            x += steps;
        }
    }
}
