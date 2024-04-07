package src.com.leetcode.s1603;

class ParkingSystem {

    int big;
    int medium;
    int small;

    private static final int BIG = 1;
    private static final int MEDIUM = 2;
    private static final int SMALL = 3;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == BIG && big - 1 >= 0) {
            big--;
            return true;
        } else if (carType == MEDIUM && medium - 1 >= 0) {
            medium--;
            return true;
        } else if (carType == SMALL && small - 1 >= 0) {
            small--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */