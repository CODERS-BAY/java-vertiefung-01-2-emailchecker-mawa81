package com.codersbay;

public class EmailChecker {
    private String email;

    public EmailChecker(String email) {
        this.email = email;
    }

    public boolean checkATsign() {
        if (email.contains("@")) {
            return true;
        } else {
            return false;
        }
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
            if (email.contains("." + specialCharacter.getSpecialCharacter())) {
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
