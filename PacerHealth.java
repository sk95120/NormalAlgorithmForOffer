/***
	https://app.codility.com/test/QEZQYT-VJH/ 
	Pacer Health
	2019.06.05

	1、代码里找bug
	2、Dp求最大数
	3、三个汽车加油

***/
package demo;
import java.util.* ;

public class Solution3 {
//    public static void main(String[] args_){
//        int[] A = new int[3];
//        A[0] = 1 ;
//        A[1] = 1 ;
//        A[2] = 2 ;
//        Solution3 solution3 = new Solution3();
//        System.out.println(solution3.solution(A));
//    }

    public int solution(int[] A) {
        int Max = -1 ;
        int profix_big = 0 ;
        int profix_small = 0 ;
        int profix_big_temp = 0 ;
        int profix_small_temp = 0 ;
        int Maxtemp ;

        Maxtemp=Max = A[0] + A[0] ;

        for(int i = 1 ; i < A.length; i++){

            if(A[i] + A[i] >= Max ){
                profix_big_temp = profix_small_temp = i;
                Maxtemp = A[i] + A[i] ;
            }

            if(A[i] + A[profix_small] + i - profix_small > Maxtemp){
                if(A[i] >= A[profix_small]){
                    profix_big_temp = i ;
                    profix_small_temp = profix_small;
                }else{
                    profix_big_temp =profix_small;
                    profix_small_temp = i ;
                }
                Maxtemp = A[i] + A[profix_small] + i - profix_small ;
            }

            if(A[profix_big]+A[i]+i - profix_big > Maxtemp){
                if( A[i] >= A[profix_big] ){
                    profix_big_temp = i ;
                    profix_small_temp = profix_big ;
                }else{
                    profix_big_temp = profix_big ;
                    profix_small_temp = i ;
                }
                Maxtemp =A[profix_big]+A[i]+i - profix_big;
            }

            Max = Maxtemp;
            profix_small = profix_small_temp;
            profix_big = profix_big_temp;
        }

        return Max ;
    }
}

