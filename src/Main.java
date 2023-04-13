import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 1. Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
        // Метод должен пройтись по каждому элементу и проверить что он не равен null.
        Integer[] arr = {4, 2, 6, null, 7, 8, null, 3, 2, 1, null, 7};
        String result = checkArray(arr);
        if (result.equals("")) {
            System.out.println("Массив не содержит null-элементов");
        }
        else {
            System.out.println(result);
        }


        // 2. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
        // каждый элемент которого равен сумме элементов двух входящих массивов в той же ячейке. Если длины массивов
        // не равны, необходимо как-то оповестить пользователя.
        int[] array1 = {4, 2, 6, 7, 8, 3, 2, 1, 7};
        int[] array2 = {1, 3, 9, 1, 2, 5, 0, 4, 9};
        int[] resultArray = arraySum(array1, array2);
        System.out.print("Сумма соответствующих элементов массивов: ");
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + " ");
        }
        System.out.println();


        //3*. Реализуйте метод, принимающий в качестве аргументов двумерный массив. Метод должен проверить что
        // длина строк и столбцов с одинаковым индексом одинакова, детализировать какие строки со столбцами не требуется.
        int [][] twoDimARray = {
                {11, 12, 13, 14, 15},
                {21, 22, 23, 24},
                {31, 32, 33},
                {41, 42},
                {51}
        };
        if (checkTwoDimArray(twoDimARray)) {
            System.out.println("Длина строк и столбцов в двумерном массиве одинакова");
        }
    }

    private static String checkArray(Integer[] arr) {
        if (arr == null) {
            return "Массив не может быть null";
        }
        String mess = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                mess = (mess.equals("") ? "null-элементы в индексах массива: " + String.valueOf(i) : mess + ", " + String.valueOf(i));
            }
        }
        return mess;
    }

    private static int[] arraySum(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("Длины массивов не равны");
        }
        int[] resultArray = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            resultArray[i] = array1[i] + array2[i];
        }
        return resultArray;
    }

    private static boolean checkTwoDimArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {

            int rowLength = array[i].length;
            int colLength = 0;

            for (int j = 0; j < array.length; j++) {
                if (array[j].length >= i + 1) {
                    colLength ++;
                }
            }

            if (rowLength != colLength) {
                throw new RuntimeException("Длина строк и столбцов в двумерном массиве не одинакова");
            }
        }
        return true;
    }
}