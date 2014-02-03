package interview;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 9/16/13
 * Time: 6:33 PM
 *
 * Question :
 *  Given an array of integers (positive and negative), find the largest continuous sum
 */
public class LargestContinuousSum {

    public static int[] numbers1 = {4, 5, 6, -4, -8, -5, 2, 8, 9};
    public static int[] numbers2 = {4, -5, 6, -4, -8, -5, 2, -8, 9};
    public static int[] numbers3 = {-3,-2,-1,-1};


    public static void main(String[] args) {
        solve(numbers1);
        solve(numbers2);
        solve(numbers3);

    }

    public static void solve(int[] numbers){
        if(numbers == null || numbers.length == 0){
            return;
        }

        int currentMax = numbers[0];
        int max = numbers[0];
        int start = 0;
        int end = 0;

        for(int pos = 1; pos < numbers.length ; pos++){

            if(currentMax + numbers[pos] > numbers[pos]){
                // numbers[pos] 以前的数加上 numbers[pos] 没有导致连续和减小
                currentMax = currentMax + numbers[pos];
                end = pos;
            }
            else {
                // numbers[pos] 比以前连续和还大， 所以以前的可以不要了， 设立新的currentMax
                currentMax =  numbers[pos];
                start = pos;
                end = pos;
            }

            if(currentMax > max){
                max = currentMax;
            }

        }

        System.out.println("Largest Continuous Sum is");
        System.out.println(max);
        System.out.println("Start pos " + String.valueOf(start));
        System.out.println("End pos " + String.valueOf(end));

    }

}
