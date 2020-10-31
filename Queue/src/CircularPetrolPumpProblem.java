/*
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
		
		int start = 0;
		
		int n = gas.length;
		int tank = 0;
		int deficit = 0;
		for(int i=0; i<n; i++) {
			
			tank += (gas[i] - cost[i]);
			if(tank < 0) {
				deficit += tank;
				tank = 0;
				start = i+1;
			}
		}
		
		return (deficit + tank >= 0)? start: -1;
    }
}
*/

import java.util.LinkedList;
import java.util.Queue;

public class CircularPetrolPumpProblem {

    public int solve(int[] petrol, int[] distance) {

        int n = petrol.length;
        int start = 0;
        int end = 1; // not including this item

        int curr_petrol = petrol[start] - distance[start];

        int total_pumps = 1;

        while(total_pumps < n) {
            while(curr_petrol < 0  && total_pumps < n) {
                curr_petrol -= (petrol[start] - distance[start]);
                start = (start + 1)%n;
                total_pumps--;

                if(start == 0) {
                    return -1; // no solution possible
                }
            }
            curr_petrol += (petrol[end] - distance[end]);
            end = (end+1)%n;
            total_pumps++;

        }
        return start;


    }

    public void test() {
//        int[] petrol = {4, 6, 7, 4};
//        int[] distance = {6, 5, 3, 5}; // ans = 1

        int[] petrol = {6, 3, 7};
        int[] distance = {4, 6, 3}; // ans = 2

        int ans = solve(petrol, distance);

        if(ans == -1) {
            System.out.println("No solution possible");
        } else {
            System.out.println("Start with petrol pump : " + ans);
        }

    }
}
