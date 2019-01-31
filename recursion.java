public class recursion{
    public static void main(String[] args){
      for (int i = 0; i<100; i++){
        System.out.println("fib(" + i + "): " + fib(i));
      }
    }
    /*You may write additional private methods */

    /*Recursively find the sqrt using Newton's approximation
     *tolerance is the allowed percent error the squared answer is away from n.
     *precondition: n is non-negative

    */
    public static double sqrt(double n, double tolerance){
      if (n == 0){
        return 0;
      }
      return sqrtHelp(n, 1);
    }
    private static double sqrtHelp(double n, double guess){
      double check;
      check = Math.abs(n - (guess*guess)) / ((n+guess*guess)/2) * 100;
      if (check <= .001){
        return guess;
      }
      else{
        return sqrtHelp(n, ((n/guess)+guess)/2);
      }
    }

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
    public static long fib(int n){
      return fibHelp(n, 0 ,1);
    }
    private static long fibHelp(int n, int prev2, int prev){
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
    public static ArrayList<Integer> makeAllSums(){
    }
    */
}
