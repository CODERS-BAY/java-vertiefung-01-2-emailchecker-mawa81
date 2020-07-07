package com.codersbay;

public class EmailChecker {
    private String email;

    public EmailChecker(String email) {
        if (email != null && !email.equals("")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email Address is not set or null!");
        }
    }

    public boolean checkATsign() {
        return email.contains("@");
    }

    public boolean checkDomain() {
        boolean state = false;
        for (Domain domain : Domain.values())
            if (email.contains("." + domain.getShorty())) {
                state = true;
            }
        return state;
    }

    public boolean checkSpecialCharacters() {
        boolean state = false;
        for (SpecialCharacter specialCharacter : SpecialCharacter.values())
            if (email.contains(String.valueOf(specialCharacter.getSpecialCharacter()))) {
                state = true;
            }
        return state;
    }

    public boolean checkMinimumXsignsBeforeAt(int signs) {
        boolean state = false;
        if (email.indexOf('@') + 1 > signs) {
            state = true;
        }
        return state;
    }

    public boolean checkSpace() {
        return email.contains(" ");
    }

    public boolean checkUmlaut() {
        boolean state = false;
        for (Umlaut umlaut : Umlaut.values())
            if (email.contains(String.valueOf(umlaut.getUmlaut()))) {
                state = true;
            }
        return state;
    }

    public boolean checkSharpS() {
        return email.contains("ß");
    }

    public boolean checkMaxLength(int lenght) {
        return email.length() > lenght;
    }

    public boolean checkForSecondAt() {
        boolean state = false;
        int count = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                count++;
            }
        }
        if (count > 1) {
            state = true;
        }
        return state;
    }

    public boolean checkForSecondPoint() {
        boolean state = false;
        int count = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '.') {
                count++;
            }
        }
        if (count > 1) {
            state = true;
        }
        return state;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailChecker that = (EmailChecker) o;

        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "EmailChecker{" +
                "email='" + email + '\'' +
                '}';
    }
}
