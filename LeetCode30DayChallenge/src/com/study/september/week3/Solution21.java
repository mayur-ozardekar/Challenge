package com.study.september.week3;

import java.util.Arrays;

/**
 * Car Pooling
 *
 * You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)
 *
 * Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.
 *
 * Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
 *
 * Example 1:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 *
 * Example 2:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 *
 * Example 3:
 *
 * Input: trips = [[2,1,5],[3,5,7]], capacity = 3
 * Output: true
 *
 * Example 4:
 *
 * Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
 * Output: true
 *
 * Constraints:
 *
 * trips.length <= 1000
 * trips[i].length == 3
 * 1 <= trips[i][0] <= 100
 * 0 <= trips[i][1] < trips[i][2] <= 1000
 * 1 <= capacity <= 100000
 *
 */
public class Solution21 {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] timeStamp = new int[1001];

        for(int[] trip : trips){
            timeStamp[trip[1]] += trip[0];
            timeStamp[trip[2]] -= trip[0];
        }

        int usedCapacity = 0;

        for(int number : timeStamp){
            usedCapacity += number;
            if(usedCapacity > capacity)
                return false;
        }

        return true;
    }

    public boolean carPooling_n2(int[][] trips, int capacity) {

        int[] count = new int[1001];

        for(int[] trip : trips){
            for(int i = trip[1]; i < trip[2]; i ++){
                count[i] += trip[0];
            }
        }

        return Arrays.stream(count).max().getAsInt() <= capacity;
    }
}
