public class HomeWorkApp {

    //Шестое задание

    public static void main(String[] args){
        printTreeWords();
        printColor();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printTreeWords() {
        System.out.println("Orange");
       System.out.println("Banana");
       System.out.println("Apple");
    }

    public static void checkSumSign(){
        int a = 10;
        int b = 15;
    if(a+b >= 0){
        System.out.println("Сумма положительная");
    }
    if (a+b < 0) {
        System.out.println("Сумма отрицательная");
    }

   }

     public static void printColor() {
        int value = 17;
        if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        }
        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(){
        int a = 2;
        int b = 3;
        if (a >= b){
            System.out.println("a>=b");
        }
        if (a < b){
            System.out.println("a<b");
        }
    }

    }

