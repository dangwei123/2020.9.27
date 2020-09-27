import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            int T=sc.nextInt();
            for(int t=0;t<T;t++){
                int n=sc.nextInt();
                Map<Integer,String> map=new HashMap<>();
                PriorityQueue<Integer> pq=new PriorityQueue<>();
                int count=0;
                for(int i=0;i<n;i++){
                    String left=sc.next();
                    if(left.equals("open")){
                        String right=sc.next();
                        if(!pq.isEmpty()){
                            int num=pq.poll();
                            map.put(num,right);
                            System.out.println(num);
                        }else{
                            System.out.println(count);
                            map.put(count++,right);
                        }
                    }else if(left.equals("dup")){
                        int target=sc.nextInt();
                        String right=map.get(target);
                        if(!pq.isEmpty()){
                            int num=pq.poll();
                            map.put(num,right);
                            System.out.println(num);
                        }else{
                            System.out.println(count);
                            map.put(count++,right);
                        }
                    }else if(left.equals("dup2")){
                        int num1=sc.nextInt();
                        int num2=sc.nextInt();
                        /*if(!map.getOrDefault(num2,"").equals("")){
                            map.remove(num2);
                        }*/
                        map.put(num2, map.get(num1));
                    }else if(left.equals("close")){
                        int num=sc.nextInt();
                        for(Integer entry:map.keySet()){
                            if(entry==num){
                                map.remove(entry);
                            }
                        }
                        pq.add(num);
                    }else{
                        int num=sc.nextInt();
                        System.out.println(map.get(Integer.valueOf(num)));
                    }
                }
            }
        }
    }
}

/*
*
*
1
10
open libc.so
open libm.so
open libdl.so
dup 2
dup2 0 2
close 0
query 1
query 2
query 3
open log.txt
*
1
10
open output.txt
dup2 0 1000000
close 0
open output2.txt
dup2 0 100000
close 0
open 1.txt
dup 100000
query 1
query 0
*
*
0
1
2
3
libm.so
libc.so
libdl.so
0
0
0
0
1
output2.txt
1.txt
*
* */


/*
public class Main{
    public static void main(String[] args){
          Scanner sc=new Scanner(System.in);
          while(sc.hasNext()){
              int C=sc.nextInt();
              for(int c=0;c<C;c++){
                  int n=sc.nextInt();
                  int m=sc.nextInt();
                  int[][] arr=new int[n][n];
                  fillIn(arr,n);
                  for(int i=0;i<m;i++){
                      int row=sc.nextInt();
                      int col=sc.nextInt();
                      System.out.println(arr[row][col]);
                  }
              }
          }
    }

    private static void fillIn(int[][] arr,int n){
        int num=1;
        int left=0;
        int right=n-1;
        int up=0;
        int down=n-1;
        boolean flag=true;
        while(num<=n*n){
            if(flag){
                //上
                for(int i=left;i<=right;i++){
                    arr[up][i]=num++;
                }
                if(++up>down) break;
                //右
                for(int i=up;i<=down;i++){
                    arr[i][right]=num++;
                }
                if(--right<left) break;
                //下
                for(int i=right;i>=left;i--){
                    arr[down][i]=num++;
                }
                if(--down<up) break;
                //左
                for(int i=down;i>=up;i--){
                    arr[i][left]=num++;
                }
                if(++left>right) break;
                flag=false;
            }else{
                //左
                for(int i=up;i<=down;i++){
                    arr[i][left]=num++;
                }
                if(++left>right) break;
                //下
                for(int i=left;i<=right;i++){
                    arr[down][i]=num++;
                }
                if(--down<up) break;
                //右
                for(int i=down;i>=up;i--){
                    arr[i][right]=num++;
                }
                if(--right<left) break;
                //上
                for(int i=right;i>=left;i--){
                    arr[up][i]=num++;
                }
                if(++up>down) break;
                flag=true;
            }
        }
    }
}
*/
