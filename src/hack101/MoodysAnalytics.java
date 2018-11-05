
package hack101;

import java.util.Arrays;
import java.util.Scanner;

public class MoodysAnalytics {
    Scanner scanner = new Scanner(System.in);
    public void learningFromPast(){
        int n = scanner.nextInt();
        int[] result = new int[n];
        int[] temp = new int[3];
        for(int i=0;i<n;i++){
            temp[0]=scanner.nextInt();
            temp[1]=scanner.nextInt();
            temp[2]=scanner.nextInt();
            Arrays.sort(temp);
            result[i]=temp[1]+temp[2];
        }
        Arrays.sort(result);
        System.out.println(result[n-1]);
    }
    
    public void smallRiskTrade(){
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        double[] result = new double[n];
        double[] x = new double[n];
        double[] y = new double[n];
        double[] p = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            y[i] = scanner.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            result[i] = x[i] * p[i] - (1 - p[i]) * y[i];
        }
        Arrays.sort(result);
        double res = 0;
        int pos = n - 1;
        while (k > 0 && result[pos] > 0) {
            k--;
            res += result[pos--];
        }
        System.out.printf("%.2f", res);
    }
}
