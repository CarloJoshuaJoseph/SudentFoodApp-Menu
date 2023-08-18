package com.joshuajacobs.sudentfoodapp.repository.impl;

/* LoyaltyPointsRepositoryImplTest.java
 Author: Joshua Jacobs (221144862)
 Date: 9 April 2023
*/
/*-purchaseId: String
-points:Int
-rewardsList: List<RewardsList>
-description: String
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import com.joshuajacobs.sudentfoodapp.domain.LoyaltyPoints;
        import com.joshuajacobs.sudentfoodapp.factory.LoyaltyPointsFactory;
import com.joshuajacobs.sudentfoodapp.repository.impl.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class LoyaltyPointsRepositoryImplTest {
    private static LoyaltyPointsRepositoryImpl repository=LoyaltyPointsRepositoryImpl.getRepository();
    private static LoyaltyPoints loyaltyPoints = LoyaltyPointsFactory.createLoyaltyPoints(
            Helper.generateID(),100,
            new ArrayList<>(Arrays.asList("Free Fries", "Free Drink", "100 points discount")),"Test Points"
    );
    @Test
    void a_create() {
        LoyaltyPoints newPoints = LoyaltyPointsFactory.createLoyaltyPoints(Helper.generateID(),100,
                new ArrayList<>(Arrays.asList("Free Fries", "Free Drink", "100 points discount")),"Test Points");
        assertNotNull(repository.create(newPoints));
        System.out.println("Bill Created: "+newPoints);
    }


    @Test
    void b_read() {
        LoyaltyPoints newPoints = LoyaltyPointsFactory.createLoyaltyPoints(Helper.generateID(),100,
                new ArrayList<>(Arrays.asList("Free Fries", "Free Drink", "100 points discount")),"Test Points");
        repository.create(newPoints);
        LoyaltyPoints readPoints = repository.read(newPoints.getPurchaseId());
        assertNotNull(readPoints);
        assertEquals(newPoints.getPurchaseId(), readPoints.getPurchaseId());
        System.out.println("View Bill: "+newPoints);
    }
    @Test
    void c_update() {
        LoyaltyPoints updated = new LoyaltyPoints.Builder()
                .copy(loyaltyPoints)
                .setPurchaseId("1564-45612")
                .setPoints(120)
                .setRewardsList(new ArrayList<>(Arrays.asList("111-4444", "Free Drink","Free zero sugar soda",100)))
                .setDescription("Updated Description")
                .build();
        //assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);

    }

    @Test
    void d_delete() {
        boolean success = repository.delete(loyaltyPoints.getPurchaseId());
        //assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}