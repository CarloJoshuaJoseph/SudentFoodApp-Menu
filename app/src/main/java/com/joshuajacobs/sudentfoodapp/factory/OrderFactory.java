package com.joshuajacobs.sudentfoodapp.factory;
import com.joshuajacobs.sudentfoodapp.util.Helper;
import com.joshuajacobs.sudentfoodapp.domain.Order;

import java.util.ArrayList;

public class OrderFactory {
    public static Order createOrder(String orderId, String customerId, String orderDate, double totalAmount, String vendorName, ArrayList<String> items) {

        orderId = Helper.generateID();
       //totalAmount = Double.parseDouble(String.valueOf(totalAmount));

        if (Helper.isNullOrEmpty(orderId) || Helper.isNullOrEmpty(customerId) ||
                Helper.isNullOrEmpty(orderDate) || Double.isNaN(totalAmount) || Helper.isNullOrEmpty(vendorName) ||Helper.isListEmpty(items)){
            return null;
        }
        return new Order.Builder()
                .setOrderId(orderId)
                .setCustomerId(customerId)
                .setOrderDate(orderDate)
                .setTotalAmount(totalAmount)
                .setVendorName(vendorName)
                .setItems(items)
                .build();
    }
}


