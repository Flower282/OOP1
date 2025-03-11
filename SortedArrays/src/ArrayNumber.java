import java.util.Arrays;

import static java.util.Arrays.sort;

public class ArrayNumber {

    public static void main(String[] args) {
        int[] numbers = {20, 50, 60, 40, 10};
        System.out.println("Mảng ban đầu: " + Arrays.toString(numbers));

        sort(numbers);//dual-pivot Quicksort
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(numbers));
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("Tổng các phần tử trong mảng: " + sum);
        System.out.println("Trung bình cộng các phần tử trong mảng: " + (double) sum / numbers.length);
    }
}
