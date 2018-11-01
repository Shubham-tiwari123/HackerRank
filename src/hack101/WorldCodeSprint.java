
package hack101;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
}
