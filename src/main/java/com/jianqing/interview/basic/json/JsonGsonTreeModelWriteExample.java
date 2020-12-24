package com.jianqing.interview.basic.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonGsonTreeModelWriteExample {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        JsonObject jobj = new JsonObject();
        jobj.addProperty("name", "john");
        JsonArray jarray = new JsonArray();
        jarray.add(1);
        jarray.add(2);


        jobj.add("array_property_name", jarray);

        String jsonOutput = gson.toJson(jobj);
        System.out.println(jsonOutput);
    }
}
