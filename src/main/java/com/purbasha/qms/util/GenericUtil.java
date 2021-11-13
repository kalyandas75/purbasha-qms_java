package com.purbasha.qms.util;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

public class GenericUtil {
    private static DecimalFormat amountFormat = new DecimalFormat("#0.00");

    public static String formatAmount(BigDecimal amount) {
        if(amount == null) {
            return null;
        }
        return amountFormat.format(amount);
    }

    public static String calculateHash(String type, String str) {
        byte[] hashseq = str.getBytes();
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest algorithm = MessageDigest.getInstance(type);
            algorithm.reset();
            algorithm.update(hashseq);
            byte messageDigest[] = algorithm.digest();
            for (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xFF & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(hex);
            }

        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return hexString.toString();
    }
}
