class armstrong {
    public static boolean isArmstrong(int x) {
        int sum = 0;
        int num = x;
        while (num != 0) {
            int remainder = num % 10;
            sum += remainder * remainder * remainder;
            num /= 10;
        }
        return sum == x;
    }

    public static void main(String args[]) {
        int x = 153;
        if (isArmstrong(x)) {
            System.out.println(x + " is an Armstrong number.");
        } else {
            System.out.println(x + " is not an Armstrong number.");
        }
    }
}