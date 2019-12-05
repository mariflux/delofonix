package com.example.delofonix.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    /**
     * Sprawdza czy podany ciąg nie jest null lub pusty. Funkcjonalność pomija
     * wszystkie białe znaki na początku i na koncu badanego ciągu
     *
     * @param value
     * @return
     */
    public static boolean isNotEmptyValue(String value) {
        return isNotEmptyValue(value, true);
    }

    /**
     * Sprawdza czy podany ciąg jest null lub pusty.
     *
     * @param value
     *            badany ciąg
     * @param ignoreWhiteSpace
     *            flaga informująca czy pomijać białe znaki
     * @return
     */
    public static boolean isNotEmptyValue(String value, boolean ignoreWhiteSpace){
        return (value != null) && !((ignoreWhiteSpace ? value.trim() : value).equals(""));
    }

    /**
     * Sprawdza czy podany ciąg jest null lub pusty. Funkcjonalność pomija
     * wszystkie białe znaki na początku i na koncu badanego ciągu
     *
     * @param value
     *            badany ciąg
     * @return
     */
    public static boolean isEmptyValue(String value) {
        return !isNotEmptyValue(value);
    }

    /**
     * Sprawdza czy podany ciąg jest null lub pusty.
     *
     * @param value
     *            badany ciąg
     * @param ignoreWhiteSpace
     *            flaga informująca czy pomijać białe znaki
     * @return
     */
    public static boolean isEmptyValue(String value, boolean ignoreWhiteSpace) {
        return !isNotEmptyValue(value, ignoreWhiteSpace);
    }

    public static List<String> stringToListConverter(String s){
        String[] sArray = s.split(",");
        return new ArrayList<>(Arrays.asList(sArray));
    }
    public static String listToStringConverter(List<String> ls){
        StringBuilder sb = new StringBuilder();
        for(String i:ls){
            sb.append(i+",");
        }
        if(sb.charAt(sb.length()-1)==','){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
