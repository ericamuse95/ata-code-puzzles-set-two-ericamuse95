package com.kenzie.greedy.backpacking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Contains a problem that can be solved using the Greedy Technique.
 */
public class Backpacking {

    /**
     * Given a list of snacks with their weight, and a given weight limit, return the maximum number
     * of snacks that you could pack without exceeding the weight limit. Assume you only have one of each snack.
     *
     * Example: [(snackName, weight)]
     * snacks = [(peanuts, 8), (chips, 3), (protein bar, 9), (berries, 7), (banana, 4), (cookies, 10)]
     * weightLimit = 20
     *
     * result = [(chips, 3), (banana, 4), (berries, 7)] -> 3 snacks
     *
     * @param snacks      - the list of snacks from which to identify the maximum snacks to pack
     * @param weightLimit - the maximum weight of snacks we can pack
     * @return the maximum number of snacks we can pack
     */
    public static int getMaximumSnacks(List<Snack> snacks, int weightLimit) {
        // TODO: Implement an algorithm that utilizes the greedy technique
        //variable to store results
        int results = 0;
        //set weight variable to 0
        int currentWeight = 0;

        //sort snacks in descending order by weight
        snacks.sort(Comparator.comparing(Snack::getWeight));

        //iterate through data to determine if snack is feasible based on weight limit
        for(Snack snack : snacks){
            if(currentWeight + snack.getWeight() <= weightLimit){
                currentWeight += snack.getWeight();
                results++;
            } else {
                break;
            }
        }
        return results;
    }
}
