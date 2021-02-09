package com.pouillos.suiviseries.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BasicUtils {

    public static String afficherChiffre(int valeur) {
        String str = "";
        if (valeur<10) {
            str+="0";
        }
        str+=valeur;
        return str;
    }
}
