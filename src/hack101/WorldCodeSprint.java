
package hack101;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class LinkList{
    char ch;
    int num;
}

public class WorldCodeSprint {
    Scanner in = new Scanner(System.in);
    public void sock(){
        int num = in.nextInt();
        int count = 0;
        int arr[] = new int[num];
        for(int i=0;i<num;i++){
            System.out.print("\nnum:-");
            arr[i]=in.nextInt();
        }
        for(int i=0;i<num;i++){
            for(int j=i+1;j<num;j++){
                if(arr[j]!=0){
                    if(arr[i]==arr[j]){
                        count++;
                        System.out.println("count:-"+count);
                        arr[j]=0;
                        break;
                    }
                }
            }
        }
        for(int i=0;i<num;i++){
            System.out.print("\narr:-"+arr[i]);
        }
        System.out.println("ans:-"+count);
    }
    
    public void acceptString(){
        int flag=0;
        String s = in.nextLine();
        String s3="";
        for(int i=0;i<s.length();i++){
            if(i+1<s.length()){
                if(s.charAt(i)==s.charAt(i+1)){
                    char ch = s.charAt(i);
                    String snew = Character.toString(ch);
                    s3 = s.replace(snew,"");
                    break;
                }
            }
        }
        int count=0;
        int arr[]= new int[s3.length()];
        for(int i=0;i<s3.length();i++){
            arr[i]=0;
        }
        List<LinkList> list = new LinkedList<>();
        for(int i=0;i<s3.length();i++){
            char ch=s3.charAt(i);
            for(int j=i;j<s3.length();j++){
                if(arr[j]==0 && s3.charAt(j)==ch){
                    count++;
                    arr[j]=1;
                }
            }
            if(count!=0){
                LinkList linkList=new LinkList();
                linkList.ch=ch;
                linkList.num=count;
            list.add(linkList);
            }
            count=0;
        }
        for(int i=0;i<list.size();i++){
            LinkList linkList2= list.get(i);
            System.out.println("\nlist:-"+linkList2.ch+" "+linkList2.num);
        }
    }
    
    public void train(){
        int row = in.nextInt();
        int col = in.nextInt();
        int track = in.nextInt();
        int sum=0;
        int mat[][]=new int[track][3];
        for(int i=0;i<track;i++){
            System.out.println("Enter three seperated values:-");
            int rowNo=in.nextInt();
            int start= in.nextInt();
            int end=in.nextInt();
            mat[i][0]=rowNo;
            mat[i][1]=start;
            mat[i][2]=end;
        }
        for(int i=0;i<track;i++){
            System.out.print("\n");
            for(int j=0;j<3;j++)
                System.out.print(" "+mat[i][j]);
        }
        
        int temp;
        int k=0;
        int inc=0;
        for(int i=0;i<track;i++){
            ArrayList<Integer> startList = new ArrayList<>();
            ArrayList<Integer> endList = new ArrayList<>();
            temp=mat[i][0];
            if(mat[i][0]!=-1){
                for(int j=i;j<track;j++){
                    if(temp==mat[j][0]){
                        mat[j][0]=-1;
                        startList.add(mat[j][1]);
                        endList.add(mat[j][2]);
                    }
                }
                ArrayList<Integer> arr = new ArrayList<>();
                Set<Integer> set = new HashSet<>();
                for(int n=0;n<startList.size();n++){
                    if(Math.abs(startList.get(n)-endList.get(n))==1){
                        arr.add(startList.get(n));
                        arr.add(endList.get(n));
                    }
                    else if(Math.abs(startList.get(n)-endList.get(n))>1){
                        for(int begin=startList.get(n)+1;begin<=endList.get(n)-1;begin++)
                            arr.add(begin);
                        arr.add(startList.get(n));
                        arr.add(endList.get(n));
                    }
                    else if(Math.abs(startList.get(n)-endList.get(n))==0){
                        arr.add(startList.get(n));
                    }
                }
                System.out.println("result:-"+arr);
                for(int size=0;size<arr.size();size++)
                    set.add(arr.get(size));
                System.out.println("set:-"+set);
                sum= sum+set.size();
                System.out.println("sum:-"+sum);
            }
        }
        int lamp = (row*col)-sum;
        System.out.println("lamp:-"+lamp);
    }
}
