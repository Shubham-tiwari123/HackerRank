
package hack101;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class HourRank13 {
     Scanner scanner = new Scanner(System.in);

    public void coPrimeNumber(){
        int div;
        List<Integer> list = new LinkedList<>();
        //list.remove(9);
        int n= scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        int num=n;
        for(int i=2;i<n;i++){
            if(num%i==0){
                stack.push(i);
                num = num/i;
                //i=0;
            }
        }
        System.out.println("stack:-"+stack);
        int count=1;
        while(!stack.empty()){
            div=stack.pop();
            for(int j=2;j<n;j++){
                if(j%div!=0){
                    if(count==1){
                        list.add(j);
                    }
                }
                else if(j%div==0){
                    if(list.contains(j)){
                        list.remove(list.indexOf(j));
                    }
                }
            }
            System.out.println("lsi:-"+list);
            count++;
        }
        System.out.println("List:-"+list);
    }
}
