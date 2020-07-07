package com.codersbay;

public enum Umlaut {
    AE("Ä"),
    ae("ä"),
    OE("Ö"),
    oe("ö"),
    UE("Ü"),
    ue("ü");

    private String umlaut;

    Umlaut(String umlaut) {
        this.umlaut = umlaut;
    }

    public String getUmlaut() {
        return umlaut;
    }

    @Override
    public String toString() {
        return "Umlaut{" +
                "Umlaut='" + umlaut + '\'' +
                '}';
    }
}
