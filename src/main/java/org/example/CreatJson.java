package org.example;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CreatJson {
    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        JSONArray ja = new JSONArray();
        Map m0 =new LinkedHashMap();

        Map m = new LinkedHashMap();
        m.put("Regizor", "Simon Stone");
        m.put("Name", "The Dig");

        m.put("Publication", "2222");
        m.put("availability", "true");
        obj.put("film = 0001", m);

        JSONArray list = new JSONArray();
        list.add("Lily James");
        list.add("Ralph Fiennes");
        list.add("Carey Mulligan");

        m.put("casts", list);

        Map m1 = new LinkedHashMap();

        m1.put("Regizor", "Thomas Kail");
        m1.put("Name", "Hamilton");
        m1.put("Publication", "2020");

        m1.put("availability", "true");
        obj.put("film= 0002", m1);
        JSONArray list1 = new JSONArray();
        list1.add("Brego");
        list1.add("Daveed Diggs");
        list1.add("Lin‑Manuel Miranda");

        m1.put("casts", list1);


        Map m2 = new LinkedHashMap();

        m2.put("Regizor", "Aaron Sorkin");
        m2.put("Name", "The Trial of the Chicago 7");
        m2.put("Publication", "2020");

        m2.put("availability", "true");
        obj.put("film= 0003", m2);
        JSONArray list2 = new JSONArray();
        list2.add("Eddie Redmayne");
        list2.add("Sacha Baron Cohen");
        list2.add("Jeremy Strong");

        m2.put("casts", list2);




        try (FileWriter file = new FileWriter("films.json")) {
            file.write(obj.toJSONString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }
}
