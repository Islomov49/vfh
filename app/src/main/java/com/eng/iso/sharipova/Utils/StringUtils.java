package com.eng.iso.sharipova.Utils;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by developer on 11.02.2017.
 */

public class StringUtils {
    public static ArrayList<String> spillter(String text,String splitChar){
        StringTokenizer tokens = new StringTokenizer(text, splitChar);
        ArrayList<String> strings = new ArrayList<>();
        while (tokens.hasMoreElements()){
            strings.add(tokens.nextToken());
        }
        return strings;
    }
}
