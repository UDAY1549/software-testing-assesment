

import java.util.*;

public class Question_3 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Integer[] m=new Integer[5];
        for(int i=0;i<5;i++){
            m[i]=in.nextInt();
        }
        Arrays.sort(m);
        int x=0;
        int y=0;
        for(int i=0;i<4;i++){
            x+=m[i];
        }
        for(int i=1;i<5;i++){
            y+=m[i];
        }
        System.out.println(x+" "+y);
    }
}