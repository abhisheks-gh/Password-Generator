/** Password generator application that creates strong and secure passwords using a
    customizable character set. It offers an interactive console interface for users
    to specify password length and quickly generate passwords for various online accounts
    and services */

package org.example;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        PasswordGenerator startGenerationProcess = new PasswordGenerator();
        startGenerationProcess.inputPasswordLength();
    }

    /** Inputs the length of the password and implicitly call generatePassword() method.
     * 8 <= passwordLength <= 20 */
    private void inputPasswordLength() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length you want for your password: ");
        int passwordLength = sc.nextInt();
        if (passwordLength >= 8 && passwordLength <= 20) {
            System.out.println("Generating a password of length " + passwordLength + "...");
            System.out.println(generatePassword(passwordLength));
        } else {
            System.out.println("Invalid password length! Please choose a value between 8 and 20");
            inputPasswordLength();
        }
    }

    /** Randomly add characters from a pre-defined character set into a string and
     returns a password of the desired length. */
    private String generatePassword(int passwordLength) {
        char[] characterSet = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
                'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
                'z', 'x', 'c', 'v', 'b', 'n', 'm',
                'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
                'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L',
                'Z', 'X', 'C', 'V', 'B', 'N', 'M',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '!', '@', '#', '_', '-', '.'};


        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < passwordLength-2; i++) {
            sb.append(characterSet[rand.nextInt(0, 68)]);
        }

        // making sure that password contains atleast 1 special character and 1 digit as required by most of the platforms
        
        for (int i = sb.length(); i < passwordLength-1; i++) {
            sb.append(characterSet[rand.nextInt(52, 68)]);
        }
        for (int i = sb.length(); i < passwordLength; i++) {
            sb.append(characterSet[rand.nextInt(62, 68)]);
        }
        

        return "Your password is: " + sb.toString();
    }
}
