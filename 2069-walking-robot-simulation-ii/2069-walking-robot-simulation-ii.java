class Robot {

    int width, height;
    int x, y;          // current position
    int dir;           // 0=East, 1=North, 2=West, 3=South
    int perimeter;
    boolean moved;     // to handle initial state

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.dir = 0; // East
        this.perimeter = 2 * (width + height) - 4;
        this.moved = false;
    }

    public void step(int num) {
        moved = true;

        num %= perimeter;  // optimize large steps

        while (num > 0) {

            if (dir == 0) { // East
                int move = Math.min(num, width - 1 - x);
                x += move;
                num -= move;
                if (num > 0) dir = 1;
            }

            else if (dir == 1) { // North
                int move = Math.min(num, height - 1 - y);
                y += move;
                num -= move;
                if (num > 0) dir = 2;
            }

            else if (dir == 2) { // West
                int move = Math.min(num, x);
                x -= move;
                num -= move;
                if (num > 0) dir = 3;
            }

            else { // South
                int move = Math.min(num, y);
                y -= move;
                num -= move;
                if (num > 0) dir = 0;
            }
        }

        // Special case: if completes full loop
        if (x == 0 && y == 0 && moved) {
            dir = 3; // South
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
}