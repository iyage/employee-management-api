package com.example.demo;

/* Import SDK classes */
import com.africastalking.Callback;
import com.africastalking.AfricasTalking;
import com.africastalking.AirtimeService;
import com.africastalking.airtime.AirtimeResponse;

import java.util.HashMap;
import java.io.IOException;

public class TestSending
{
    public static void main(String[] args)
    {
        /* Set your app credentials */
        String USERNAME = "MyAppUsername";
        String API_KEY = "MyAppAPIKey";

        /* Initialize SDK */
        AfricasTalking.initialize(USERNAME, API_KEY);

        /* Get the airtime service */
        AirtimeService airtime = AfricasTalking.getService(AfricasTalking.SERVICE_AIRTIME);

        /* Set the phone number, currency code and amount in the format below */
        String phoneNumber = "MyPhoneNumber";
        String currencyCode = "RWF";
        float amount = 12333;

        /* That’s it hit send and we’ll take care of the rest */
        try {
            AirtimeResponse response = airtime.send(phoneNumber, currencyCode, amount);
            System.out.println(response.toString());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}