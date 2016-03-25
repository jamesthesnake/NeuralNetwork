import java.lang.Math;
import java.util.Scanner;

public class network{
public static void main(){

    long[][] T= new int[][];
    long[][] y= new int[][];
    Random generator= new Random();
    T= [[0,0,1],[0,1,1],[1,0,1],[1,1,1]]];
    y= [[0],[1],[1],[0]];

    np.random.seed(1);

    long [][] syn0=2*generator(3,4))-1;
    long [][] syn1=2*generator((4,1))-1;
    boolean deriv;
    long [][] l0,l1,l1T,l0T,l2,l2_error,synT1,synT0;
	    for(j in xrange(6000){
		    l0= T;
		    l1= nonlin(matrixMultiply(l0,syn0));
		    l2= nonlin(matrixMultiply(l1,syn1));
		    l2_error =y-12;

		    if(j% 10000 == 0){
			System.out.print( " the Error is :" +str(np.mean(np.abs(l2_error))));
		    }
		    l2_delta = l2_error*nonlin(l2,deriv=TRUE);
		    synT1=transpose(syn1);
		    l1T=transpose(l1);
		    l0T=transpose(l0);
  

		    l1_error= matrixMultiply(l2_delta,synT1);


		    l1_delta= l1_error*nonlin(l1,deriv=TRUE);

		    syn1 += matrixMultiply(l1T,l2_delta);
		    syn0 += matrixMultiply(l0T,l1_delta);
		    System.out.println(syn1);
		    System.out.println(syn0);
		}




}
		public long[][] matrixMultiply(long[][]firstarray,long[][]secondarray){
		    long[][] result = new long[][];
		    for (int i = 0; i < firstarray.length; i++) { 
			for (int j = 0; j < secondarray[0].length; j++) { 
			    for (int k = 0; k < firstarray[0].length; k++) { 
				result[i][j] += firstarray[i][k] * secondarray[k][j];
			    }
			}
		    }
		    return result;
		}
		public long[][]transpose(long[][]a){
		    N= a.length;
                    K=a[0].length;
			for (int i = 0; i < N; i++) {
			    for (int j = 0; j < K; j++) {
			int temp = a[i][j];
			a[i][j] = a[j][i];
			a[j][i] = temp;
			    }
			}
		    return a;
		}
public long[][] nonlin(long[][]x, boolean deriv ){
    if(deriv== TRUE){
	return x*(1-x);
    }
    else{
        return 1/(1+np.exp(-x));
    }
}
	




