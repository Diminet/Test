package org.example;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
public class JSONRead {
    public static void main(String[] args) throws Exception
    {
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("films.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;



        Map address = ((Map)jo.get("film = 0001"));

        Iterator<Map.Entry> itr1 = address.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        System.out.println();
        Map address1 = ((Map)jo.get("film= 0002"));


        Iterator<Map.Entry> itr11 = address1.entrySet().iterator();
        while (itr11.hasNext()) {
            Map.Entry pair = itr11.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        System.out.println();
        Map address2 = ((Map)jo.get("film= 0003"));


        Iterator<Map.Entry> itr2 = address2.entrySet().iterator();
        while (itr2.hasNext()) {
            Map.Entry pair = itr2.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());

        }


    }
    }




