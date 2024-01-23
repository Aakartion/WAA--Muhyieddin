package edu.miu.Lab4.utility;

import java.time.LocalDateTime;

public class Utility {
    public static String generateTransactionId(){
        return LocalDateTime.now().toString();
    }
}
