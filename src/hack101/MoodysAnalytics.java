
package hack101;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

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
    
    public void asteriskExpressions(){
        int test = scanner.nextInt();
        for(int t=0;t<test;t++){
            String str = scanner.next();
            long num = 0,num1=0;
            long mul = 1,power = 1;
            long result=1;
            int flag2=0;
            int flag3=0;
            long sum = 0;
            int flag = 0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(0)=='*'){
                    System.out.println("Syntax Error");
                    flag=0;
                    break;
                }
                else if(str.charAt(str.length()-1)=='*'){
                    System.out.println("Syntax Error");
                    flag=0;
                    break;
                }
                else if(str.charAt(i)=='*'){
                    if(str.charAt(i+1)=='*'){
                        if(str.charAt(i+2)=='*'){
                            System.out.println("Syntax Error");
                            flag=0;
                            break;
                        }
                        else{
                            flag=1;
                        }
                    }
                    else{
                        flag=1;
                    }
                }
                else{
                    flag=1;
                }
            }
            Stack<Long> stack = new Stack<>();
            
            if(flag==1){
                String[] s1 = str.split("");
                for(int i=0;i<s1.length;i++){
                    if(!"*".equals(s1[i])){
                        num=Long.parseLong(s1[i]);
                        System.out.println("num:-"+num);
                        if(i<s1.length-1){
                            if("*".equals(s1[i+1])){
                                System.out.print("con1   ");
                                /*if(sum!=0){
                                    stack.push(sum);
                                    System.out.println("if sum:-"+sum);
                                    sum=0;
                                }*/
                                if("*".equals(s1[i+2])){
                                    System.out.print("con2 ");
                                    num1 = Long.parseLong(s1[i+3]);
                                    if(flag2!=1){
                                        power=(long)Math.pow(num, num1);
                                        if(!stack.empty())
                                            stack.pop();
                                        stack.push(power);
                                    }
                                    if(flag2==1){
                                        power=(int)Math.pow(power, num1);
                                        if(flag3==1)
                                            stack.push(power);
                                        else{
                                            stack.pop();
                                            stack.push(power);}
                                    }
                                    flag2=1;
                                    //System.out.println("power mul:-"+power);  

                                }
                                else{
                                    num1 = Long.parseLong(s1[i+2]);
                                    System.out.println("con else num1:-"+num1);
                                    if(s1.length>3 && !stack.empty()){
                                        if("*".equals(s1[i-1])){
                                            System.out.println("ifsum:-"+s1[i-1]+" i "+s1[i]);
                                            if("*".equals(s1[i-2])){
                                                stack.push(num1);
                                            }
                                            else{
                                                System.out.println("uof");
                                                stack.push(num);
                                                stack.push(num1);
                                            }
                                        }
                                    }
                                    else{
                                        System.out.println("string len;-"+s1.length);
                                        if(s1.length>3){
                                            if(stack.empty()){
                                                System.out.println("len");
                                                stack.push(num);
                                                //stack.push(num1);
                                                flag3=1;
                                            }
                                            else{
                                                System.out.println("lo");
                                                stack.pop();
                                                stack.push(num);
                                                stack.push(num1);
                                            }
                                        }
                                        else{
                                            System.out.println("uo");
                                            stack.push(num);
                                            stack.push(num1);
                                        }
                                    }
                                    flag2=0;
                                }
                                //flag3=0;
                            }
                            else{
                                /*sum=(sum*10)+num;
                                System.out.println("else sum:-"+sum);
                                flag3=1;*/
                            }
                        }
                    }
                }
                //if(flag3==1)
                    //result=Long.parseLong(str);
                //else{
                System.out.println("stack;-"+stack);
                    while(!stack.empty()){
                        result = stack.pop()*result;
                    }
                //}
                long power2 = (long)Math.pow(10, 9);
                long fibal = result%1000000007;
                System.out.println("ans:-"+fibal);
            }
            
        }
    }
}
