package stacks_and_queues;

import java.util.*;

public class CircularTour {
    public static int circularTour(int[] petrol, int[] distance, int n) {
        int totalPetrol = 0;
        int currPetrol = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int diff = petrol[i] - distance[i];

            totalPetrol += diff;
            currPetrol += diff;
            if (currPetrol < 0) {
                start = i + 1;
                currPetrol = 0;
            }
        }
        return (totalPetrol >= 0) ? start : -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();
        int[] petrol = new int[n];
        int[] distance = new int[n];
        System.out.println("Enter petrol at each pump:");
        for (int i = 0; i < n; i++) {
            petrol[i] = sc.nextInt();
        }
        System.out.println("Enter distance to next pump:");
        for (int i = 0; i < n; i++) {
            distance[i] = sc.nextInt();
        }
        int result = circularTour(petrol, distance, n);
        if (result == -1) {
            System.out.println("No possible starting point");
        } else {
            System.out.println(result);
        }
        sc.close();
    }
}