package com.codersbay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailCheckerTest {

    @Test
    void checkATsignTest() {
        EmailChecker email = new EmailChecker("mario@gmail.com");
        assertTrue(email.checkATsign());
    }
}