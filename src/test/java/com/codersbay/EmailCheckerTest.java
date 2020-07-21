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
        assertTrue(email.containsATsign());
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
        assertFalse(email.containsSpecialCharacters());
    }

    @Test
    @DisplayName("test for minimum amount of signs before @")
    void checkMinimumXsignsBeforeAtTest() {
        EmailChecker email = new EmailChecker("mario@gmail.com");
        assertTrue(email.containsMinimumXsignsBeforeAt(5));
    }

    @Test
    @DisplayName("test for space in Address")
    void checkSpaceTest() {
        EmailChecker email = new EmailChecker("ma rio@gmail.com");
        assertTrue(email.containsSpace());
    }

    @Test
    @DisplayName("test for Umlauts")
    void checkUmlautTest() {
        EmailChecker email = new EmailChecker("märio@gmail.com");
        assertTrue(email.containsUmlaut());
    }

    @Test
    @DisplayName("test for sharp S")
    void checkSharpSTest() {
        EmailChecker email = new EmailChecker("sharpß@gmail.com");
        assertTrue(email.containsSharpS());
    }

    @Test
    @DisplayName("test for max length is exceeded")
    void checkMaxLengthTest() {
        EmailChecker email = new EmailChecker("aaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com");
        assertTrue(email.containsMaxLength(50));
    }

    @Test
    @DisplayName("test for more than 1 @")
    void checkForSecondAtTest() {
        EmailChecker email = new EmailChecker("m@@@rio@gmail.com");
        assertTrue(email.containsSecondAt());
    }

    @Test
    @DisplayName("test for more than 1 '.'")
    void checkForSecondPointTest() {
        EmailChecker email = new EmailChecker("m..rio@gmail.com");
        assertTrue(email.containsSecondPoint());
    }


}