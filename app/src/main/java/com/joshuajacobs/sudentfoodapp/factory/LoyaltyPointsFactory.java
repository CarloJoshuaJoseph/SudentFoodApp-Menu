package com.joshuajacobs.sudentfoodapp.factory;

/* LoyaltyPointsFactory.java
 Author: Joshua Jacobs (221144862)
 Date: 9 May 2023
*/
/*-purchaseId: String
-points:Int
-rewardsList: List<RewardsList>
-description: String
*/
import com.joshuajacobs.sudentfoodapp.domain.LoyaltyPoints;
import com.joshuajacobs.sudentfoodapp.util.Helper;

import java.util.ArrayList;


public class LoyaltyPointsFactory {
    public static LoyaltyPoints createLoyaltyPoints(String purchaseId,int points, ArrayList<String> rewardsList, String description) {
        purchaseId = Helper.generateID();
        if (Helper.isNullOrEmpty(purchaseId) || points <=0 || Helper.isNullOrEmpty(rewardsList.toString()) || (Helper.isNullOrEmpty(description))) {
            return null;
        }
        if (rewardsList.isEmpty()) {
            throw new IllegalArgumentException("Rewards are not yet Available!");
        }
        return new LoyaltyPoints.Builder()
                .setPurchaseId(purchaseId)
                .setRewardsList((ArrayList) rewardsList)
                .setDescription(description)
                .build();
    }
}
