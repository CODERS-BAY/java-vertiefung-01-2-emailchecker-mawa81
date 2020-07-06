package com.codersbay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailCheckerTest {

    @Test
    @DisplayName("test the not null exception")
    void checkForNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new EmailChecker(null);
        });
    }

    @Test
    @DisplayName("test the not set exception")
    void checkForNotSet() {
        assertThrows(IllegalArgumentException.class, () -> {
            new EmailChecker("");
        });
    }

    @Test
    @DisplayName("test for an @ sign in the address")
    void checkATsignTest() {
        EmailChecker email = new EmailChecker("mario@gmail.com");
        assertTrue(email.checkATsign());
    }

    @Test
    @DisplayName("test whether the Domain is valid")
    void checkDomainTest() {
        EmailChecker email = new EmailChecker("mario@gmail.com");
        assertTrue(email.checkDomain());
    }

    @Test
    @DisplayName("test for unauthorized special characters")
    void checkSpecialCharactersTest() {
        EmailChecker email = new EmailChecker("mario@gmail.com");
        assertFalse(email.checkSpecialCharacters());
    }

    @Test
    @DisplayName("test for minimum amount of signs before @")
    void checkMinimumXsignsBeforeAtTest() {
        EmailChecker email = new EmailChecker("mario@gmail.com");
        assertTrue(email.checkMinimumXsignsBeforeAt(5));
    }
}