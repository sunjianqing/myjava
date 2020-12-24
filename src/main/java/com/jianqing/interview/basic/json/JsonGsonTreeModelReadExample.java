package com.jianqing.interview.basic.json;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonGsonTreeModelReadExample {
    public static void main(String[] args) {
        JsonParser parser = new JsonParser();
        // {"k1":"v1","arr1":[1,2,3]}
        JsonElement element = parser.parse("{\"k1\":\"v1\", \"k2\":1, \"arr1\":[1,2,3]}");// Returns Root element(
        // which is a JsonElement,
        // can be object,array, null
        // or primitive)

        if (element.isJsonObject()) {
            JsonObject jobj = element.getAsJsonObject();
            System.out.println(jobj.get("k1").getAsString());//read as string
            System.out.println(jobj.get("k2").getAsInt());  //read as integer

            JsonArray arr = jobj.getAsJsonArray("arr1");//read as array
            for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i).getAsInt());
            }
        }

    }
}
