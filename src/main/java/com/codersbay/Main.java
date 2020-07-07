package com.codersbay;

public class Main {

    public static void main(String[] args) {

        //EmailChecker email1 = new EmailChecker(null);

        //EmailChecker email2 = new EmailChecker("");

        EmailChecker email = new EmailChecker("mario@gmail.com");
        System.out.println(email.toString());
        System.out.println("have \"@\": " + email.checkATsign());

        System.out.println("is listed Domain: " + email.checkDomain());

        System.out.println("has unauthorized Special Character: " + email.checkSpecialCharacters());

        System.out.println("has x signs before \"@\": " + email.checkMinimumXsignsBeforeAt(5));

        System.out.println("umlaut: " + Umlaut.AE.toString());

        System.out.println(Domain.COMPANY.toString());
        System.out.println(Domain.COMPANY.getShorty());
    }

}
