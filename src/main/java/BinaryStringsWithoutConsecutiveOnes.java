import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
    /*
    Count of binary strings without consecutive 1’s of length N
    Question

    A binary string of length N is made up only '0's and '1's.  Given the length of the string as N,
    please print count number of binary strings without consecutive 1’s of length N.

    Example

    // Input n = 3
    // Output : 5  (010 101 100 001 000 111)

     */

public class BinaryStringsWithoutConsecutiveOnes {
    private static void findNonConsecutiveOnesPermutations(int n,List<String> resultSet) {
        // Binary input array
        int input[] = {0,1};
        // Initialize size of result string
        int result[] = new int[n];
        // Enter recursion tree at level zero
        findNonConsecutiveOnesPermutationsUtil(input,result,0,resultSet,n);
    }

    private static void findNonConsecutiveOnesPermutationsUtil(int[] input, int[] result, int level,
                                                               List<String> resultSet, int n) {
        // Case where all the positions in result array are filled and hence time to add to result set
        if(level==n){
            StringBuffer sb = new StringBuffer("");
            for(int binary : result){
                sb.append(binary);
            }
            resultSet.add(sb.toString());
            return;
        }
        // Traverse input array to fill positions in result array
        for(int i=0;i<input.length;i++){
            // If current input binary digit is 1 and previous binary digit of result is 1 then ignore the iteration
            if(input[i]==1 && (level-1)>=0 && result[level-1]==1){
                continue;
            }
            //Add binary digit to result array filling the position at index level
            result[level]=input[i];
            //Further enter recursion tree to fill result array position at index level +1
            findNonConsecutiveOnesPermutationsUtil(input,result,level+1,resultSet,n);
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter size of expected result n : ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<String> resultSet = new ArrayList<String>();
        // Method to figure out permutations that meet criterion of non consecutive ones
        findNonConsecutiveOnesPermutations(n,resultSet);
        // Print the result
        System.out.println("Count of binary strings without consecutive 1’s of length "+n+" is "+resultSet.size());
        System.out.println("The binary strings of result set are : ");
        System.out.println(resultSet);
    }
}
