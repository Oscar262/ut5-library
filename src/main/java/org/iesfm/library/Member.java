package org.iesfm.library;

import java.util.Objects;

public class Member {

    private String nif;
    private String name;
    private String surname;
    private int numMember;
    private int zipCode;





    public Member(String nif, String name, String surname, int numMember, int zipCode) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.numMember = numMember;
        this.zipCode = zipCode;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNumMember() {
        return numMember;
    }

    public void setNumMember(int numMember) {
        this.numMember = numMember;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return numMember == member.numMember && zipCode == member.zipCode && Objects.equals(nif, member.nif) && Objects.equals(name, member.name) && Objects.equals(surname, member.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surname, numMember, zipCode);
    }

    @Override
    public String toString() {
        return "org.iesf.library.Member{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", numMember=" + numMember +
                ", zipCode=" + zipCode +
                '}';
    }
}
