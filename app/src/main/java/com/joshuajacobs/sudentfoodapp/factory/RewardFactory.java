package com.joshuajacobs.sudentfoodapp.factory;

/* RewardFactory.java
 Author: Joshua Jacobs (221144862)
 Date: 9 May 2023
*/
/*- rewardId: int
- name: String
- description: String
- points: int */


import com.joshuajacobs.sudentfoodapp.domain.Reward;
import com.joshuajacobs.sudentfoodapp.util.Helper;


public class RewardFactory {
    public static Reward createReward(String rewardId, String name, String description, int points) {
        rewardId = Helper.generateID();
        if (Helper.isNullOrEmpty(rewardId) || Helper.isNullOrEmpty(name) || (Helper.isNullOrEmpty(description))) {
            return null;
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Error:Reward is incomplete!");
        }
        return new Reward.Builder()
                .setRewardId(rewardId)
                .setName(name)
                .setDescription(description)
                .build();
    }
}