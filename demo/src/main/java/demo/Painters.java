package demo;

// Question:
// You are given two 0-indexed integer arrays, cost and time, of size n representing the costs and the time taken to paint n different walls respectively. There are two painters available:

// A paid painter that paints the ith wall in time[i] units of time and takes cost[i] units of money.
// A free painter that paints any wall in 1 unit of time at a cost of 0. But the free painter can only be used if the paid painter is already occupied.
// Return the minimum amount of money required to paint the n walls.

// Example :
// Input: cost = [2,3,4,2], time = [1,1,1,1]
// Output: 4
// Explanation: The walls at index 0 and 3 will be painted by the paid painter, and it will take 2 units of time; meanwhile, the free painter will paint the walls at index 1 and 2, free of cost in 2 units of time. Thus, the total cost is 2 + 2 = 4.

public class Painters {
    public int paintwalls(int[] cost, int[] time) {
        int n = cost.length;
        return (int) paintWallsHelper(cost, time, 0, 0, new Long[n][501]);
    }
    private long paintWallsHelper(int cost[], int time[], int ind, int total, Long[][] memo){
        if(total >= cost.length)
            return 0;
        if(ind >= cost.length)
            return Integer.MAX_VALUE;
        if(memo[ind][total] != null)
            return memo[ind][total];

        long with = cost[ind] + paintWallsHelper(cost, time, ind+1, total+time[ind]+1, memo);
        long without = paintWallsHelper(cost, time, ind+1,total,memo);
        return memo[ind][total] = Math.min(with,without);
    }
}
