public class DZ2 {
    public static void main(String[] args) {
        System.out.println(within10and20(5, 8));
        isPositiveOrNegative(-7);
        System.out.println(isNegative(-1));
        printWordNTimes();
    }

    //Задание 1
    static boolean within10and20(int a, int b) {
        System.out.println("Задание 1");
        int sum = a + b;
        if (sum > 10 && sum < 20) return true;
        else return false;
    }
    //Задание 2
    static void isPositiveOrNegative(int a) {
        System.out.println("Задание 2");
        if (a >= 0) System.out.println("Число " + a + "положительное");
        else System.out.println("Число " + a + " отрицательное");
    }
    //Задание 3
    static boolean isNegative(int a) {
        System.out.println("Задание 3");
        if (a < 0) return true;
        return false;
    }
        //Задание 4
    static void printWordNTimes() {
        System.out.println("Задание 4");
        for (int i = 0; i < 4; i++) {
                       System.out.println("Привет, Александр!");
        }
    }

}



