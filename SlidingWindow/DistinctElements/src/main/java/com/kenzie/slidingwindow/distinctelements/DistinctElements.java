package com.kenzie.slidingwindow.distinctelements;

import java.util.*;

/**
 * Contains a problem that can be solved using the Sliding Window Technique.
 */
public class DistinctElements {

    /**
     * Given a list of integers, find the number of distinct elements in every subset of size k.
     *
     * Example:
     *   input = [1, 3, 4, 2, 2, 5, 2]
     *   k = 3
     *
     *   result = [3, 3, 2, 2, 2]
     *
     * @param input - the list of integers from which to identify the distinct counts, size >= k
     * @param k - the size of sublists that should be considered when calculating the distinct counts, k >= 1
     * @return a list of distinct counts ordered by the sublist they relate to - the count of distinct
     *         elements for the sublist with items 0, 1, 2 should be first in the list followed by the
     *         count for items 1, 2, 3
     */
    public static List<Integer> countDistinctElements(List<Integer> input, int k) {
        // TODO: Implement an algorithm that utilizes the sliding window technique
        List<Integer> result = new ArrayList<>();

        //store distinct elements in a list
        List<Integer> distinctElements;

        //track the frequency of each element in the current window
        Map<Integer, Integer> frequencyOfElement = new HashMap<>();

        //Initialize the map for the first window
        for(int i =0; i < k; i++){
            frequencyOfElement.put(input.get(i), frequencyOfElement.getOrDefault(input.get(i), 0) +1);
        }
        //calculate number of distinct elements in first window
        result.add(frequencyOfElement.size());

        //slide window over the rest of the list
        for(int i = k; i < input.size(); i++){
            int previous = input.get(i -k);
            int current = input.get(i);

            //decrement dropped value
            frequencyOfElement.put(previous, frequencyOfElement.get(previous) - 1);

            //if element is no longer present in window, remove it from frequencyOfElement
            if(frequencyOfElement.get(previous) == 0){
                frequencyOfElement.remove(previous);
            }

            //increment the frequency of the new element in the window
            frequencyOfElement.put(current, frequencyOfElement.getOrDefault(current, 0) + 1);

            //calculate number of distinct elements in the current window and add it to "reult"
            result.add(frequencyOfElement.size());
        }

        return result;
    }

}
