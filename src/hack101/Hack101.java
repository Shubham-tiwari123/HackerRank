package hack101;

import java.util.Arrays;
import java.util.Scanner;

class LeafNode{
    LeafNode left;
    LeafNode right;
    int data;
}

public class Hack101 {

    Scanner in = new Scanner(System.in);
    LeafNode leafNode = new LeafNode();
    public void problem1(){
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        int friends[] = new int[k];
        int flag=0;
        int count=1;
        for(int friends_i=0; friends_i < k; friends_i++){
            friends[friends_i] = in.nextInt();
        }
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(friends[i]-1);
            if(c.equals('0')){
                System.out.println("if");
                flag=0;
                break;
            }
            else{
                flag=1;
                if(count==k){
                    break;
                }
                count++;
            }
        }
        if(flag==0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public void problem2(){
        int n = in.nextInt();
        int k = in.nextInt();
        long[] p = new long[n];
        long[] d = new long[n];
        long[] result = new long[n];
        long sum = 0;
        for(int i=0;i<n;i++){
            p[i]= in.nextLong();
            d[i]= in.nextLong();
            result[i] = p[i]+d[i];
            sum -= d[i];
        }
        Arrays.sort(result);
        for (int i = 0; i < k && i < n; i++) {
            sum += result[n-i-1];
        }
        System.out.println(sum>0?sum:0l);
    }
    
    public void problem3(){
        LeafNode head,temp;
        int num = in.nextInt();
        int leaf[] = new int[num];
        for(int i=0;i<num;i++){
            leaf[i]=in.nextInt();
        }
        int parent[] = new int[num-1];
        for(int i=0;i<num-1;i++){
            parent[i]=in.nextInt();
        }
        leafNode.data=1;
        leafNode.left=null;
        leafNode.right=null;
        head = leafNode;
        int j=1;
        for(int i=0;i<num-1;i++){
            if(parent[i]==j){
                
            }
        }
    }
    public static void main(String[] args) {
        Hack101 hack101 = new Hack101();
        hack101.problem1();
        hack101.problem2();
        hack101.problem3();
    }
    
}
