package com.example.bootstickverwaltung.ldap.util;

public class EntryBase {
    public static final String GROUP = "OU=Groups";
    public static final String USER = "OU=People";
    public static final String LEHRER = "OU=Lehrer," + USER;
    public static final String SCHUELER = "OU=Schueler," + USER;
    public static final String SCHUELER_HIT = "OU=HIT," + SCHUELER;
}