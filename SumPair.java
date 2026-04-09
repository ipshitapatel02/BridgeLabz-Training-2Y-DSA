package hashmaps_and_hashfunctions;

import java.util.*;

public class SumPair {
    public static List<Integer> findPair(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                return Arrays.asList(complement, num);
            }
            set.add(num);
        }
        return new ArrayList<>();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();
        List<Integer> result = findPair(arr, target);
        if (!result.isEmpty()) {
            System.out.println(result);
        } else {
            System.out.println("No pair exists with given sum.");
        }
        sc.close();
    }
}