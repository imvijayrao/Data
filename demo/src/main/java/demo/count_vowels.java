package demo;

// Question:
// Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

// Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
// Each vowel 'a' may only be followed by an 'e'.
// Each vowel 'e' may only be followed by an 'a' or an 'i'.
// Each vowel 'i' may not be followed by another 'i'.
// Each vowel 'o' may only be followed by an 'i' or a 'u'.
// Each vowel 'u' may only be followed by an 'a'.
// Since the answer may be too large, return it modulo 10^9 + 7.

// Example :
// Input: n = 2
// Output: 10
// Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".


public class count_vowels{
    public void countvowelPermutation(int n){
        int mod = 1000000007;

        long countA = 1, countE = 1, countI = 1, countO = 1, countU = 1;
        for(int i = 1; i < n; i++){

            long nextcountA = countE;
            long nextcountE = (countA + countI) % mod;
            long nextcountI = (countA + countE + countO + countU) % mod;
            long nextcountO = (countI + countU) % mod;
            long nextcountU = countA;

            countA = nextcountA;
            countE = nextcountE;
            countI = nextcountI;
            countO = nextcountO;
            countU = nextcountU;
        }

        long total = (countA + countE + countI + countO + countU) % mod;

        System.out.println("Permutation of vowels count : " + total);
    }
}