package com.joshuajacobs.sudentfoodapp.domain;

import java.util.ArrayList;

/*-purchaseId: String
-points:Int
-rewardsList: List<RewardsList>
-description: String
*/
public class LoyaltyPoints {
    private String purchaseId;
    private int points;
    private ArrayList<Reward> rewardsList;
    private String description;

    public LoyaltyPoints(LoyaltyPoints.Builder builder){
        purchaseId = builder.purchaseId;
        points = builder.points;
        rewardsList = builder.rewardsList;
        description = builder.description;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public int getPoints() {
        return points;
    }

    public ArrayList<Reward> getRewardsList() {
        return rewardsList;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "LoyaltyPoints{" +
                "purchaseId='" + purchaseId + '\'' +
                ", points=" + points +
                ", rewardsList=" + rewardsList +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder{
        private String purchaseId;
        private int points;
        private ArrayList<Reward> rewardsList;
        private String description;

        public Builder setPurchaseId(String purchaseId) {
            this.purchaseId = purchaseId;
            return this;
        }

        public Builder setPoints(int points) {
            this.points = points;
            return this;
        }

        public Builder setRewardsList(ArrayList rewardsList) {
            this.rewardsList = rewardsList;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(LoyaltyPoints loyaltyPoints){
            purchaseId = this.purchaseId;
            points = this.points;
            rewardsList = this.rewardsList;
            description = this.description;
            return this;
        }
        public LoyaltyPoints build(){return new LoyaltyPoints(this);}
    }
}
