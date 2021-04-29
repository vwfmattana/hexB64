package com.truevolve;

import java.util.Base64;
import java.util.Scanner;

public class Main {

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static void main(String[] args) {
        hexB64Convertor();
    }
    public static void hexB64Convertor()
    {
        String option="";
        while ((option.compareTo("q") != 0) ||(option.compareTo("quit") != 0) ||(option.compareTo("Q") != 0) || (option.compareTo("QUIT") != 0)) {
            System.out.println("#####################################################");
            System.out.println("#                   HEX <-> B64                     #");
            System.out.println("#####################################################");
            System.out.println("Please select an option:");
            System.out.println("(A) HEX -> B64");
            System.out.println("(B) B64 -> HEX");

            Scanner reader = new Scanner(System.in);
            option = reader.nextLine();
            if ((option.compareTo("a") == 0) || (option.compareTo("A")) == 0) {

                System.out.println("Option (A) selected");
                System.out.println("Provide the HEX string to convert to B64.");
                String hexString = reader.nextLine();

                byte[] data = hexStringToByteArray(hexString);
                String encoded = Base64.getEncoder().encodeToString(data);
                System.out.println("HEX STRING: " + hexString.toString());
                System.out.println("B64 STRING: " + encoded);

            } else if ((option.compareTo("b") == 0) || (option.compareTo("B") == 0))  {

                System.out.println("Option (B) selected");
                System.out.println("Provide the B64 string to convert to HEX.");
                String b64String = reader.nextLine();

                byte[] decoded = Base64.getDecoder().decode(b64String);
                String encoded = bytesToHex(decoded);
                String decodedString = new String(decoded);
                System.out.println("B64 STRING: " + b64String.toString());
                System.out.println("HEX STRING: " + encoded);

            } else {
                System.out.println("Please select a valid option.");
            }
        }
    }


    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
