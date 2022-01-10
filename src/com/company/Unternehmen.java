package com.company;

import java.util.Objects;

public class Unternehmen {
    private int id;
    private String name;
    private Unternehmensgrosse unternehmensgrosse;
    private int mitareiter;
    private int einkommen;
    private String ort;

    public Unternehmen(int id, String name, Unternehmensgrosse unternehmensgrosse, int mitareiter, int einkommen, String ort) {
        this.id = id;
        this.name = name;
        this.unternehmensgrosse = unternehmensgrosse;
        this.mitareiter = mitareiter;
        this.einkommen = einkommen;
        this.ort = ort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unternehmensgrosse getUnternehmensgrosse() {
        return unternehmensgrosse;
    }

    public void setUnternehmensgrosse(Unternehmensgrosse unternehmensgrosse) {
        this.unternehmensgrosse = unternehmensgrosse;
    }

    public int getMitareiter() {
        return mitareiter;
    }

    public void setMitareiter(int mitareiter) {
        this.mitareiter = mitareiter;
    }

    public int getEinkommen() {
        return einkommen;
    }

    public void setEinkommen(int einkommen) {
        this.einkommen = einkommen;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unternehmen)) return false;
        Unternehmen that = (Unternehmen) o;
        return getId() == that.getId() && getMitareiter() == that.getMitareiter() && getEinkommen() == that.getEinkommen() && Objects.equals(getName(), that.getName()) && getUnternehmensgrosse() == that.getUnternehmensgrosse() && Objects.equals(getOrt(), that.getOrt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getUnternehmensgrosse(), getMitareiter(), getEinkommen(), getOrt());
    }

    @Override
    public String toString() {
        return "Unternehmen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unternehmensgrosse=" + unternehmensgrosse +
                ", mitareiter=" + mitareiter +
                ", einkommen=" + einkommen +
                ", ort='" + ort + '\'' +
                '}';
    }

}
