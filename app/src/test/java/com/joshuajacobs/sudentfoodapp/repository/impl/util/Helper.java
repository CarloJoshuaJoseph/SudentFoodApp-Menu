package com.joshuajacobs.sudentfoodapp.repository.impl.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.ArrayList;
import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String str){
        return str == null || str.isEmpty();
    }

    public static String generateID(){
        return UUID.randomUUID().toString();
    }

    public static boolean isListEmpty(ArrayList list){

        if(list.isEmpty()){
            return true;
        }

        return false;
    }

    public static boolean isValidEmail(String email){
        EmailValidator ev=EmailValidator.getInstance();
        return ev.isValid(email);


    }

}