package net.tdiant.hnist.homework.staffmanagersystem.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {

    public static String sha1(String data) throws NoSuchAlgorithmException {
        data += "tdiant"; //salt
        MessageDigest md = MessageDigest.getInstance("SHA1");
        byte[] b = data.getBytes();
        md.update(b);
        byte[] b2 = md.digest();
        int len = b2.length;
        String str = "0123456789abcdef";
        char[] ch = str.toCharArray();

        char[] chs = new char[len * 2];
        for (int i = 0, k = 0; i < len; i++) {
            byte b3 = b2[i];
            chs[k++] = ch[b3 >>> 4 & 0xf];
            chs[k++] = ch[b3 & 0xf];
        }

        return new String(chs);
    }


}
