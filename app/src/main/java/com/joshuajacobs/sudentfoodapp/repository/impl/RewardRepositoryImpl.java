package com.joshuajacobs.sudentfoodapp.repository.impl;

/* RewardRepositoryImpl.java
 Entity for the BillRepositoryImpl
 Author: Joshua Jacobs (221144862)
 Date: 9 May 2023
*/

import com.joshuajacobs.sudentfoodapp.domain.LoyaltyPoints;
import com.joshuajacobs.sudentfoodapp.domain.Reward;
import com.joshuajacobs.sudentfoodapp.repository.RewardRepository;

import java.util.HashSet;
import java.util.Set;

public class RewardRepositoryImpl implements RewardRepository {
    private static RewardRepositoryImpl repository = null; // nothing in Bill repo
    private Set<Reward> RewardDB = null;

    private RewardRepositoryImpl() {
        RewardDB = new HashSet<Reward>();
    }

    public static RewardRepositoryImpl getRepository() {
        if (repository == null) { // will return null if empty
            repository = new RewardRepositoryImpl(); // will return an object if not
        }
        return repository;
    }

    @Override
    public Reward create(Reward reward) {
        boolean success = RewardDB.add(reward);
        if (!success)
            return null;
        return reward;
    }
    @Override
    public Reward read(String rewardId) {
        for (Reward r : RewardDB) {
            if (r.getRewardId().equals(rewardId)) // this will return null if bill id does not match
                return r;
        }
        return null;
    }
    @Override
    public Reward update(Reward reward) {
        Reward oldReward= read(reward.getRewardId());
        if (oldReward != null) {
            RewardDB.remove(oldReward); // getting the existing bill and comparing it , will update if needed and new bill is returned
            RewardDB.add(reward);
            return reward;
        }
        return null;
    }

    @Override
    public boolean delete(String rewardId) { // read billId, is found will return true, else will return false
        Reward rewardToDelete = read(rewardId);
        if (rewardToDelete == null) {
            return false;
        }
        RewardDB.remove(rewardToDelete);
        return true;
    }

    @Override
    public Set<Reward> getAll () {

        return RewardDB;
    }
}
