package hashmaps_and_hashfunctions;

import java.util.*;

public class ZeroSumSubarray {
    public static List<List<Integer>> zeroSum(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                List<Integer> list = map.get(sum);
                for (int start : list) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = start + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray);
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<List<Integer>> result = zeroSum(arr);
        for (List<Integer> sub : result) {
            System.out.println(sub);
        }
        sc.close();
    }
}