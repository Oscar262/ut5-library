package org.iesfm.library.exceptions;

public class MemberNotFoundException extends Exception{

    private String nif;

    public MemberNotFoundException(String nif) {
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }
}
