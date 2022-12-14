

import java.util.Scanner;

class Question_2 {

    static void miniMaxSum(int[] arr) {
        // System.out.println(Arrays.toString(arr));
        long min = (long) Integer.MAX_VALUE, max = (long)Integer.MIN_VALUE;
        long currSum = 0;
        for (int j : arr) {
            currSum += j;
            if (j < min) {
                min = j;
            }
            if (j > max) {
                max = j;
            }
        }
        System.out.println((currSum-max) + " " + (currSum - min));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}