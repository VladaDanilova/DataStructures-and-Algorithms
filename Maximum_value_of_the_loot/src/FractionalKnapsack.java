import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author vladadanilova
 * The goal of this code problem is to implement an algorithm for the fractional knapsack problem.
 */
public class FractionalKnapsack {
    private static double getOptimalValue(double capacity, int[] values, int[] weights) {
        double value = 0;
        ArrayList<Double> dev = new ArrayList<>();
        ArrayList<Double> dev2 = new ArrayList<>();
        double res = 0;
        int n = values.length;
        for (int i = 0; i < n; i++)
        {
            res = values[i]/weights[i];
            dev.add(res);
            dev2.add(res);
        }
        Collections.sort(dev2);
        int checkW = 0;
        int checkV = 0;
        while (capacity > 0) {
            checkW = weights[dev.indexOf(dev2.get(dev2.size() - 1))];//take a weight with the max dev
            checkV = values[dev.indexOf(dev2.get(dev2.size() - 1))];//take a value with the max dev
            if (checkW <= capacity) {
                value = value + checkV;
                capacity = capacity - checkW;
                dev2.remove(dev2.size()-1); //delete this option
            }
            else
            {
                double k = capacity/checkW;
                value = value + k * (double) checkV;
                capacity = 0;
            }
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double capacity = scanner.nextDouble();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
