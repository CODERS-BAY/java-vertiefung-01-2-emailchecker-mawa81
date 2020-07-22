package com.codersbay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class EmailCheckerTest {

    @Test
    @DisplayName("test the not null exception")
    void checkForNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new EmailChecker(null);
        });
        assertDoesNotThrow(() -> {
            new EmailChecker("mario@gmail.com");
        });
    }

    @Test
    @DisplayName("test the not set exception")
    void checkForNotSet() {
        assertThrows(IllegalArgumentException.class, () -> {
            new EmailChecker("");
        });
        assertDoesNotThrow(() -> {
            new EmailChecker("mario@gmail.com");
        });
    }

    @ParameterizedTest
    @CsvSource({"mario@gmail.com,true", "marioagmail.com,false"})
    @DisplayName("test for an @ sign in the address")
    void containsATsignTest(String input, boolean expected) {
        EmailChecker email = new EmailChecker(input);
        assertEquals(expected, email.containsATsign());
    }

    @Test
    @DisplayName("test whether the Domain is valid")
    void checkDomainTest() {
        EmailChecker email = new EmailChecker("mario@gmail.com");
        assertTrue(email.checkDomain());
    }

    @Test
    @DisplayName("test for unauthorized special characters")
    void containsSpecialCharactersTest() {
        EmailChecker email = new EmailChecker("mario@gmail.com");
        assertFalse(email.containsSpecialCharacters());
    }

    @Test
    @DisplayName("test for minimum amount of signs before @")
    void containsMinimumXsignsBeforeAtTest() {
        EmailChecker email = new EmailChecker("mario@gmail.com");
        assertTrue(email.containsMinimumXsignsBeforeAt(5));
    }

    @Test
    @DisplayName("test for space in Address")
    void containsSpaceTest() {
        EmailChecker email = new EmailChecker("ma rio@gmail.com");
        assertTrue(email.containsSpace());
    }

    @Test
    @DisplayName("test for Umlauts")
    void containsUmlautTest() {
        EmailChecker email = new EmailChecker("märio@gmail.com");
        assertTrue(email.containsUmlaut());
    }

    @Test
    @DisplayName("test for sharp S")
    void containsSharpSTest() {
        EmailChecker email = new EmailChecker("sharpß@gmail.com");
        assertTrue(email.containsSharpS());
    }

    @Test
    @DisplayName("test for max length is exceeded")
    void checkMaxLengthTest() {
        EmailChecker email = new EmailChecker("aaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com");
        assertTrue(email.checkMaxLength(50));
    }

    @Test
    @DisplayName("test for more than 1 @")
    void containsSecondAtTest() {
        EmailChecker email = new EmailChecker("m@@@rio@gmail.com");
        assertTrue(email.containsSecondAt());
    }

    @Test
    @DisplayName("test for more than 1 '.'")
    void containsSecondPointTest() {
        EmailChecker email = new EmailChecker("m..rio@gmail.com");
        assertTrue(email.containsSecondPoint());
    }


}