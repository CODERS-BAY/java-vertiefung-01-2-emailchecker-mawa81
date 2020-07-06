package com.codersbay;

public enum Domain {
    COMPANY("com"),
    AUSTRIA("at"),
    GERMANY("de"),
    GOVERNMENT("gov"),
    ORGANISATION("org");

    private String shorty;

    Domain(String shorty) {
        this.shorty = shorty;
    }

    public String getShorty() {
        return shorty;
    }

    @Override
    public String toString() {
        return "Domain{" +
                "shorty='" + shorty + '\'' +
                '}';
    }
}
