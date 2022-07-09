package net.tdiant.hnist.homework.staffmanagersystem;

import net.tdiant.hnist.homework.staffmanagersystem.util.StringUtils;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

public class PasswordTest {
    @Test
    public void passwordTest() throws NoSuchAlgorithmException {
        System.out.println(StringUtils.sha1("123456"));
    }
}
