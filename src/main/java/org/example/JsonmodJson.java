package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonmodJson {
    public static void main(String[] args) throws IOException, ParseException {
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("films.json"));

        ObjectMapper mapper = new ObjectMapper();

        JSONObject jo = (JSONObject) obj;



        Map address = ((Map)jo.get("film= 0002"));

        Iterator<Map.Entry> itr1 = address.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();

        }

        try {

            String json = mapper.writeValueAsString(address);
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);

            try (FileWriter file = new FileWriter("filmsmod.json")) {
                file.write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}
