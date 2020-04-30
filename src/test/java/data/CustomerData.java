package data;

import java.util.Random;

public class CustomerData {
    public static String customerName = "FirstName";
    public static String customerLastName = "LastName";
    public static String customerEmail = "Email@outlook.com";
    public static String customerPassword = "1111111Qq";

    public static String generateRandomEmail() {
        Random randomEmailSuffix = new Random();
        String customerEmail = "fakeEmail" + randomEmailSuffix.nextInt(99999) + "@outlook.com";
        return customerEmail;
    }
}

/*
КАК ИСПОЛЬЗОВАТЬ РАНДОМНЫЙ EMAIL
 */