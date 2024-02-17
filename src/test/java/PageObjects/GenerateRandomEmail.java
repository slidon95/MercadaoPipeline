package PageObjects;

import java.util.Random;

public class GenerateRandomEmail {
    // Function to generate a random string of given length
    private static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // ASCII values for lowercase letters (a=97, z=122)
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            sb.append(randomChar);
        }

        return sb.toString();
    }

    // Function to generate a random email with a random string
    public static String generateRandomEmail() {
        String randomString = generateRandomString(8);  // You can adjust the length as needed
        return randomString + "@gmail.com";
    }

}
