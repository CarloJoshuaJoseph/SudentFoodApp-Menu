package com.joshuajacobs.sudentfoodapp.domain;
/*- rewardId: int
- name: String
- description: String
- points: int */
public class Reward {
    private String rewardId;
    private String name;
    private String description;
    private int points;

    public Reward(Reward.Builder builder){
        this.rewardId = builder.rewardId;
        this.name = builder.name;
        this.description = builder.description;
        this.points = builder.points;
    }

    public String getRewardId() {
        return rewardId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "rewardId='" + rewardId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", points=" + points +
                '}';
    }

    public static class Builder{
        private String rewardId;
        private String name;
        private String description;
        private int points;

        public Builder setRewardId(String rewardId) {
            this.rewardId = rewardId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPoints(int points) {
            this.points = points;
            return this;
        }
        public Builder copy(Reward reward){
            rewardId = this.rewardId;
            name = this.name;
            description = this.description;
            points = this.points;
            return this;
        }
        public Reward build(){return new Reward(this);}
    }
}
