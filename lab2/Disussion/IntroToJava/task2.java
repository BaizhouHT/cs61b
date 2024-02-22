package Disussion.IntroToJava;

/**
 * 2 Mystery
 * This is a function (a.k.a. method).
 * It takes an array of integers and an integer as arguments, and returns an integer.
 *
 * Describe what mystery returns if inputArray = [3, 0, 4, 6, 3] and k = 2.
 * return 4 (index).
 *
 * Can you explain in plain English what mystery does?
 * It returns the index of the smallest element that occurs at or after index k in the array, in this case, 4.
 *
 * Describe what mystery2 does if inputArray = [3, 0, 4, 6, 3].
 * selection sort, asc order.
 */
public class task2 {
    public static int mystery(int[] inputArray, int k) {
         int x = inputArray[k];
         int answer = k;
         int index = k + 1;
         while (index < inputArray.length) {// iterate to right
             if (inputArray[index] < x) { // compare to x=inputArr[k]
                 x = inputArray[index];// if smaller x=inputArray[index](smaller one)
                 answer = index;// smaller one's index
             }
             index = index + 1;
         }
         return answer;// return the smallest element's index after the give index k
    }

    public static void mystery2(int[] inputArray) {
        int index = 0;
        while (index < inputArray.length) {
            int targetIndex = mystery(inputArray, index);
            int temp = inputArray[targetIndex];
            inputArray[targetIndex] = inputArray[index];
            inputArray[index] = temp;
            index = index + 1;
        }
    }

    public static void main(String[] args) {
        int[] inputArr = new int[]{3, 0, 4, 6, 3};
//        System.out.println(mystery(inputArr, 2));
//        System.out.println("=====================");
        for (int i=0;i<inputArr.length;i++) {
            System.out.print(inputArr[i] + (i!=inputArr.length-1?",":"\n"));
        }
        mystery2(inputArr);
        for (int i=0;i<inputArr.length;i++) {
            System.out.print(inputArr[i] + (i!=inputArr.length-1?",":"\n"));
        }

    }

}
