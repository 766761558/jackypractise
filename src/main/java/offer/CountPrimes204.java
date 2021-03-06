package offer;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes204 {
    public int countPrimes(int n) {
        if (n == 1){
            return 0;
        }
        boolean [] flag = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++){
            if (flag[i] == false){
                count++;
            }
            for (int j = 2; j * i < n; j++){
                flag[j*i] = true;
            }
        }
        return count;
    }
}
