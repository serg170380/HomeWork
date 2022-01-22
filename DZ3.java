
public class DZ3 {
    public static void main(String[] args) {
        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();
        fillarr(7,1);
    }



    //Задание 1.
    public static void invertArray(){
        System.out.println("Задание 1.");

        int arr[] = {1, 0, 1, 0, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                arr[i] = 0;
            else
                arr[i] = 1;
            System.out.println(arr[i]);
        }
    }

    //Задание 2.
    public static void fillArray() {
        System.out.println("Задание 2");
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
    }

    //Задание 3.

    public static void changeArray() {
        System.out.println("Задание 3.");
     int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
     for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
            System.out.print(arr[i] + " | ");
        }
        System.out.println("Задание 3.");
          }


    //Задание 4.

    public static void fillDiagonal() {
        System.out.println("Задание 4");
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Задание 5.

    public static void fillarr(int len, int initialValue){
        System.out.println(" Задание 5.");
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
            System.out.print("[" + i + "]" + arr[i] + " ");
        }
    }





        }


















