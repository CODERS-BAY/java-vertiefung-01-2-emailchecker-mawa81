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

    @ParameterizedTest
    @CsvSource({"mario@gmail.com,true", "mario@gmail.to,false"})
    @DisplayName("test whether the Domain is valid")
    void checkDomainTest(String input, boolean expected) {
        EmailChecker email = new EmailChecker(input);
        assertEquals(expected, email.checkDomain());
    }

    @ParameterizedTest
    @CsvSource({"ma%ri$o@gmail.com,true", "mario@gmail.com,false"})
    @DisplayName("test for unauthorized special characters")
    void containsSpecialCharactersTest(String input, boolean expected) {
        EmailChecker email = new EmailChecker(input);
        assertEquals(expected, email.containsSpecialCharacters());
    }

    @ParameterizedTest
    @CsvSource({"mario@gmail.com,true", "ma@gmail.com,false"})
    @DisplayName("test for minimum amount of signs before @")
    void containsMinimumXsignsBeforeAtTest(String input, boolean expected) {
        EmailChecker email = new EmailChecker(input);
        assertEquals(expected, email.containsMinimumXsignsBeforeAt(5));
    }

    @ParameterizedTest
    @CsvSource({"ma rio@gmail.com,true", "mario@gmail.com,false"})
    @DisplayName("test for space in Address")
    void containsSpaceTest(String input, boolean expected) {
        EmailChecker email = new EmailChecker(input);
        assertEquals(expected, email.containsSpace());
    }

    @ParameterizedTest
    @CsvSource({"märiö@gmail.com,true", "mario@gmail.com,false"})
    @DisplayName("test for Umlauts")
    void containsUmlautTest(String input, boolean expected) {
        EmailChecker email = new EmailChecker(input);
        assertEquals(expected, email.containsUmlaut());
    }

    @ParameterizedTest
    @CsvSource({"ßupermario@gmail.com,true", "mario@gmail.com,false"})
    @DisplayName("test for sharp S")
    void containsSharpSTest(String input, boolean expected) {
        EmailChecker email = new EmailChecker(input);
        assertEquals(expected, email.containsSharpS());
    }

    @ParameterizedTest
    @CsvSource({"aaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com,true", "mario@gmail.com,false"})
    @DisplayName("test for max length is exceeded")
    void checkMaxLengthTest(String input, boolean expected) {
        EmailChecker email = new EmailChecker(input);
        assertEquals(expected, email.checkMaxLength(50));
    }

    @ParameterizedTest
    @CsvSource({"m@rio@gmail.com,true", "mario@gmail.com,false"})
    @DisplayName("test for more than 1 @")
    void containsSecondAtTest(String input, boolean expected) {
        EmailChecker email = new EmailChecker(input);
        assertEquals(expected, email.containsSecondAt());
    }

    @ParameterizedTest
    @CsvSource({"mario@gmail.com.at,true", "mario@gmail.com,false"})
    @DisplayName("test for more than 1 '.'")
    void containsSecondPointTest(String input, boolean expected) {
        EmailChecker email = new EmailChecker(input);
        assertEquals(expected, email.containsSecondPoint());
    }


}