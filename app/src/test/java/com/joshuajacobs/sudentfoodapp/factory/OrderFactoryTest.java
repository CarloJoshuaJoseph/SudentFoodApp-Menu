package com.joshuajacobs.sudentfoodapp.factory;

import static org.junit.jupiter.api.Assertions.*;
import com.joshuajacobs.sudentfoodapp.domain.Order;
import com.joshuajacobs.sudentfoodapp.util.Helper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class OrderFactoryTest {

    @Test
   public void testOrder() {

        ArrayList<String> items = new ArrayList<>();
        items.add("Small hot chips");
        items.add("500ml coke");
        items.add("Mexican chilli simba chips");
        items.add("Jungle oats energy bar");
        items.add("Bubblegum");

        Order order = OrderFactory.createOrder(Helper.generateID(),"214038033", "02/02/2023",85.00,"Campus Craving 1", items);
        assertNotNull(order);
        System.out.println(order);
    }
}