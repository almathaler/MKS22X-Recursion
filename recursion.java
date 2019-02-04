import java.util.ArrayList;
public class recursion{
/*
  public static void main(String[] args) {
      System.out.println("sqrt()");
      System.out.println("-----------------------\n");

      System.out.println("sqrt(4, 0.00001)");
      System.out.println("EXPECTED: 2");
      System.out.println(sqrt(4, 0.00001));         // 2

      System.out.println("----");

      System.out.println("sqrt(8, 0.00001)");
      System.out.println("EXPECTED: ~2.8284");
      System.out.println(sqrt(8, 0.00001));         // ~2.8284

      System.out.println("----");

      System.out.println("sqrt(0, 0.00001)");
      System.out.println("EXPECTED: 0");
      System.out.println(sqrt(0, 0.00001));         // 0

      System.out.println("\n");

      System.out.println("fib()");
      System.out.println("-----------------------\n");

      System.out.println("fib(0)");
      System.out.println("EXPECTED: 0");
      System.out.println(fib(0));                   // 0

      System.out.println("----");

      System.out.println("fib(1)");
      System.out.println("EXPECTED: 1");
      System.out.println(fib(1));                   // 1

      System.out.println("----");

      System.out.println("fib(7)");
      System.out.println("EXPECTED: 13");
      System.out.println(fib(7));                   // 13

      System.out.println("makeAllSums()");
      System.out.println("-----------------------\n");

      System.out.println("makeAllSums(0)");
      System.out.println("EXPECTED: [0]");
      System.out.println(makeAllSums(0));           // [0]

      System.out.println("----");

      System.out.println("makeAllSums(1)");
      System.out.println("EXPECTED: [1, 0]");
      System.out.println(makeAllSums(1));           // [1, 0]

      System.out.println("----");

      System.out.println("makeAllSums(3)");
      System.out.println("EXPECTED: [0, 3, 2, 5, 1, 4, 3, 6]");
      System.out.println(makeAllSums(3));           // [0, 3, 2, 5, 1, 4, 3, 6]
}
*/
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
