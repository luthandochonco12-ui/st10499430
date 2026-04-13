package com.mycompany.loginsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginSystemTest {

    // ---------------- USERNAME TESTS ----------------
    @Test
    public void testCheckUserName_Valid() {
        assertTrue(LoginSystem.checkUserName("user_"));
    }

    @Test
    public void testCheckUserName_Invalid_NoUnderscore() {
        assertFalse(LoginSystem.checkUserName("user"));
    }

    @Test
    public void testCheckUserName_Invalid_TooLong() {
        assertFalse(LoginSystem.checkUserName("user_name"));
    }

    // ---------------- PASSWORD TESTS ----------------
    @Test
    public void testCheckPasswordComplexity_Valid() {
        assertTrue(LoginSystem.checkPasswordComplexity("Pass123!"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid() {
        assertFalse(LoginSystem.checkPasswordComplexity("password"));
    }

    // ---------------- CELL NUMBER TESTS ----------------
    @Test
    public void testCheckCellPhoneNumber_Valid() {
        assertTrue(LoginSystem.checkCellPhoneNumber("+27123456789"));
    }

    @Test
    public void testCheckCellPhoneNumber_Invalid() {
        assertFalse(LoginSystem.checkCellPhoneNumber("0712345678"));
    }

    // ---------------- REGISTER USER ----------------
    @Test
    public void testRegisterUser_Success() {
        String result = LoginSystem.registerUser("user_", "Pass123!");
        assertEquals("Username and password successfully captured. User registered!", result);
    }

    @Test
    public void testRegisterUser_FailUsername() {
        String result = LoginSystem.registerUser("user", "Pass123!");
        assertEquals("Username is not correct. Must have _ and max 5 chars.", result);
    }

    @Test
    public void testRegisterUser_FailPassword() {
        String result = LoginSystem.registerUser("user_", "password");
        assertEquals("Password is not correct. Must have 8+ chars, capital letter, number, and special char.", result);
    }

    // ---------------- LOGIN TESTS ----------------
    @Test
    public void testLoginUser_Success() {
        assertTrue(LoginSystem.loginUser("user_", "Pass123!", "user_", "Pass123!"));
    }

    @Test
    public void testLoginUser_Fail() {
        assertFalse(LoginSystem.loginUser("user_", "wrong", "user_", "Pass123!"));
    }

    // ---------------- STATUS TEST ----------------
    @Test
    public void testReturnLoginStatus_Success() {
        assertEquals("Login successful! Welcome back!", LoginSystem.returnLoginStatus(true));
    }

    @Test
    public void testReturnLoginStatus_Fail() {
        assertEquals("Username or password incorrect, please try again.", LoginSystem.returnLoginStatus(false));
    }
}