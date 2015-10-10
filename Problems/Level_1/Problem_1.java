package Problems.Level_1;

import java.util.*;

/**
 * Created by Manish on 10/9/2015.
 * first problem in Project Euler - generating sum of multiples of natural numbers
 */
public class Problem_1 {

    private static Scanner scanner = new Scanner(System.in);
    
    //method to compute the sum from an array of numbers
    public int computeSum(int[] numbers) {
        int result = 0;
        for (int i: numbers) {
            result += i;
        }

        return result;
    }
    
    //method to generate a List of unique multiples of the natural numbers
    public List<Integer> generateNaturalNumberMultiples(int n1, int n2) {
        System.out.println("Enter the limit.");
        int limit = scanner.nextInt();
        List<Integer> numbersList = new ArrayList<>();

        //DON'T VIOLATE DRY
        /*
        //for first number
        int num1 = 1;
        int res1 = 0;
        while(res1 < limit) {
            res1 = n1 * num1;
            if(res1 > limit) {
                break;
            }
            numbersList.add(res1);
            num1++;
        }

        //for second number
        int num2 = 1;
        int res2 = 0;
        while(res2 < limit) {
            res2 = n2 * num2;
            if(res2 >= limit) {
                break;
            }
            numbersList.add(res2);
            num2++;
        }*/

        int[] selection = {n1, n2};

        for(int n: selection) {
            int num = 1;
            int res = 0;
            while (res < limit) {
                res = n * num;
                if(res >= limit) {
                    break;
                }

                numbersList.add(res);
                num++;
            }
        }

        System.out.println("The multiples of " + n1 + " and " + n2 + " are: " + numbersList);
        //System.out.println("The multiples of " + n2 + " are: " + );

        //remove duplicates from list by turning it into set and back
        Set<Integer> set = new HashSet<>();
        set.addAll(numbersList);
        //clear numberlist completely
        numbersList.clear();
        //add numbers from set back to numberlist
        numbersList.addAll(set);

        return numbersList;
    }

    public int[] buildIntArray(List<Integer> integers) {
        int[] ints = new int[integers.size()];
        int i = 0;
        for (Integer n : integers) {
            ints[i++] = n;
        }
        return ints;
    }

    public static void main(String[] args) {
        Problem_1 p1 = new Problem_1();
        List<Integer> naturalNumbers = p1.generateNaturalNumberMultiples(3, 5);
        int[] naturalNumbersList = p1.buildIntArray(naturalNumbers);
        int sum = p1.computeSum(naturalNumbersList);

        System.out.println("The sum of the natural numbers is " + sum);

    }
}
