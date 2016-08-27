package practice.dev.problemsolving;

import java.util.Arrays;

/**
 * 
 * @author dev
 *
Q. Minimum number of platform required for a railway station ->>>>>
Given arrival and departure times of all trains for a particular railway station, write code to find the minimum number of platforms required on that railway station, so that all trains can run according to their schedule.

Input can be in any form, but we essentially need two information about each train, the arrival time and departure time. Since we need to return only the minimum number of platforms and not the schedule of the trains, we don’t need other informations, like, name of the train, etc.

So, if the input is as given below:

TrainName	   Arrival Time         Departure Time
Train-1         9:00                9:15
Train-2         9:35                11:45
Train-3         9:45                11:05
Train-4        11:00                12:00
Train-5        14:30                18:15
Train-6        18:00                19:00 

then we need at least 3 platforms, otherwise the railway station will not be able to accommodate all the trains.

First let us receive the input in the form of two arrays, first array holding all the arrival times, and second array holding all the departure time. For the above input, the two arrays will be:
double arivl[] = {9.00,  9.58,  9.75, 11.00, 14.00, 18.00};
double deprt[] = {9.25, 11.75, 11.08, 12.00, 18.25, 19.00};

Minimum number of platforms needed on the railway station is equal to the Maximum number of trains that can be there at any given time on the railway station.

Solution -1: ->>>>>>>>>
One way to get this number is to find the number of intervals (arrival till departure is one time interval) that every train time is overlapping with. The maximum out of all these numbers is the number of platforms needed.
int maxOverlaps = 0; 

FOR i = 0 TO n-1 
    int numberOfOverLaps = 0;
    FOR j = i+1 TO n-1
        IF train[i] OVERLAPS WITH train[j] THEN
            numberOfOverLaps++;
    IF numberOfOverLaps > maxOverlaps THEN
        maxOverlaps = numberOfOverLaps;

RETURN maxOverlaps;

But the above algorithm takes O(n2) time. We can optimize this by using the below greedy programming solution.

Solution -2: O(nlg(n)) time ->>>>>>>>>>>>>
Code:

    1. Sort both the arrays holding arrival time and departure time.
    2. After sorting use the merging logic (without doing the actual merge). Compare the current element in arrival and departure array and pick which ever is smaller and increment the pointer of that array whose value is picked.
    3. If time is picked from the arrival array, increment the total number of trains on the station and if time is picked from the departure array decrease the total number of trains on the station.
    4. While doing the above process, we keep the count of maximum value reached till now. At the end this maximum value is returned.

 *
 */
public class MinPlatformsRequired {

	/**
	 * Calculate the minimum number of platforms required for given schedule of
	 * trains
	 */
	int minPlatformsRequired(double arivl[], double deprt[], int noOfTrains) {
		// Implement this function that sort two arrays or use library function.
		Arrays.sort(arivl);
		Arrays.sort(deprt);

		int maxPlatforms = 0;
		int platformsRequired = 0;
		int i = 0, j = 0;

		// Logic simlar to Merging of two arrays
		while (i < noOfTrains && j < noOfTrains) {
			if (arivl[i] < deprt[j]) {
				// New train has arrived.
				platformsRequired++;
				i++;
				if (platformsRequired > maxPlatforms)
					maxPlatforms = platformsRequired;
			} else {
				// Train left the platform.
				platformsRequired--;
				j++;
			}
		}

		return maxPlatforms;
	}
}
