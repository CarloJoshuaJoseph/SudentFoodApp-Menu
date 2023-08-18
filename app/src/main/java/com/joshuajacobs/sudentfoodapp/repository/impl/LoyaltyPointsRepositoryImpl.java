package com.joshuajacobs.sudentfoodapp.repository.impl;

/* LoyaltyPointsRepositoryImpl.java
 Entity for the BillRepositoryImpl
 Author: Joshua Jacobs (221144862)
 Date: 9 May 2023
*/
import com.joshuajacobs.sudentfoodapp.repository.LoyaltyPointsRepository;
import com.joshuajacobs.sudentfoodapp.domain.LoyaltyPoints;
import java.util.HashSet;
import java.util.Set;

public class LoyaltyPointsRepositoryImpl implements LoyaltyPointsRepository {
    private static LoyaltyPointsRepositoryImpl repository = null; // nothing in Bill repo
    private Set<LoyaltyPoints> LoyaltyPointsDB = null;

    private LoyaltyPointsRepositoryImpl() {
        LoyaltyPointsDB = new HashSet<LoyaltyPoints>();
    }

    public static LoyaltyPointsRepositoryImpl getRepository() {
        if (repository == null) { // will return null if empty
            repository = new LoyaltyPointsRepositoryImpl(); // will return an object if not
        }
        return repository;
    }

    @Override
    public LoyaltyPoints create(LoyaltyPoints loyaltyPoints) {
        boolean success = LoyaltyPointsDB.add(loyaltyPoints);
        if (!success)
            return null;
        return loyaltyPoints;
    }
    @Override
    public LoyaltyPoints read(String purchaseId) {
        for (LoyaltyPoints lp : LoyaltyPointsDB) {
            if (lp.getPurchaseId().equals(purchaseId)) // this will return null if bill id does not match
                return lp;
        }
        return null;
    }
    @Override
    public LoyaltyPoints update(LoyaltyPoints loyaltyPoints) {
        LoyaltyPoints oldPoints= read(loyaltyPoints.getPurchaseId());
        if (oldPoints != null) {
            LoyaltyPointsDB.remove(oldPoints); // getting the existing bill and comparing it , will update if needed and new bill is returned
            LoyaltyPointsDB.add(loyaltyPoints);
            return loyaltyPoints;
        }
        return null;
    }

    @Override
    public boolean delete(String purchaseId) { // read billId, is found will return true, else will return false
        LoyaltyPoints pointsToDelete = read(purchaseId);
        if (pointsToDelete == null) {
            return false;
        }
        LoyaltyPointsDB.remove(pointsToDelete);
        return true;
    }

    @Override
    public Set<LoyaltyPoints> getAll () {

        return LoyaltyPointsDB;
    }
}