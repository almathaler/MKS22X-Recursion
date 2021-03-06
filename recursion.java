import java.util.ArrayList;
public class recursion{

  public static void main(String[] args) {
    for (int i = 0; i < 6; i++){
      testFib(i);
    }
    for (int k = 0; k<5; k++){
      testSqrt(k);
    }
  }

//testcase must be a valid index of your input/output array
  public static void testFib(int testcase){
    recursion r = new recursion();
    int[] input = {0,1,2,3,5,30};
    int[] output ={0,1,1,2,5,832040};
    int max = input.length;
    if(testcase < input.length){
    int in = input[testcase];
      try{
        int ans = r.fib(in);
        int correct = output[testcase];
        if(ans == correct){
          System.out.println("PASS test fib "+in+". "+correct);
        }
        else{
          System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

        }
      }catch(IllegalArgumentException n){
        if(in < 0){
          System.out.println("PASS test fib"+in+" IllegalArgumentException");
        }else{
          System.out.println(" FAIL IllegalArgumentException in test case:"+in);
        }
      }catch(Exception e){
        System.out.println(" FAIL Some exception in test case:"+in);
      }
    }
  }

  public static boolean closeEnough(double a, double b){
    if(a==0.0 && b==0.0)return true;
    if(a==0.0)return b < 0.00000000001;
    if(b==0.0)return a < 0.00000000001;
    return Math.abs(a-b)/a < 0.0001;//This is the normal % difference allowed

  }

  //testcase must be a valid index of your input/output array
  public static void testSqrt(int testcase){
    recursion r = new recursion();
    double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
    double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
    int max = input.length;
    if(testcase < input.length){
      double in = input[testcase];
      try{
        double ans = r.sqrt(in,.00001);
        double correct = Math.sqrt(in);
        if(closeEnough(ans,correct)){
          System.out.println("PASS test sqrt "+in+" "+ans);
        }
        else{
          System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

        }
      }catch(IllegalArgumentException n){
        if(in < 0){
        System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
        }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
        }
      }catch(Exception e){
        System.out.println(" FAIL Some exception in test case:"+in);
      }
    }
  }
    public static double sqrt(double n, double tolerance){
      if (n == 0){
        return 0;
      }
      return sqrtHelp(n, 1, tolerance);
    }
    private static double sqrtHelp(double n, double guess, double tolerance){
      double check;
      check = Math.abs(n - (guess*guess)) / ((n+guess*guess)/2) * 100;
      if (check <= tolerance){
        return guess;
      }
      else{
        return sqrtHelp(n, ((n/guess)+guess)/2, tolerance);
      }
    }

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
    public static int fib(int n){
      return fibHelp(n, 0 ,1);
    }
    private static int fibHelp(int n, int prev2, int prev){
      //so that its tail recursive, have to account for n being 0 or 1 in fib function not this, bc n is used as a counter
      if (n == 0){
        return prev2;
      }
      if (n == 1){
        return prev;
      }
      if (n == 2){
        return prev2 + prev;
      }
      return fibHelp(n-1, prev, prev+prev2);
    }
    /*As Per classwork
    */
    public static ArrayList<Integer> makeAllSums(int n){ //if n==0, toReturn.add(curAns);
      ArrayList<Integer> toReturn = new ArrayList<Integer>();
      makeAllSumsHelp(n, toReturn, 0);
      return toReturn;
    }
    private static void makeAllSumsHelp(int n, ArrayList<Integer> toReturn, int curAns){
      if (n>= 1){
        makeAllSumsHelp(n-1, toReturn, curAns+n);
        makeAllSumsHelp(n-1, toReturn, curAns);
      }
      else{
        toReturn.add(curAns);
      }
    }
    /*
      ArrayList<Integer> toReturn = new ArrayList<Integer>();
      sumsHelp(n, 0, toReturn);
      return toReturn;
    }
    private static void sumsHelp(int n, int curAns, ArrayList<Integer> toReturn){
      while (n>-1){
        if (n==0){
          toReturn.add(curAns);
        }
        sumsHelp(n-1, curAns+n, toReturn);
        sumsHelp(n-1, curAns, toReturn);
      }
    }
    */
}
