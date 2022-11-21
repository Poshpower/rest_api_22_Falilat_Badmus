package rest_api_22.helpers;


import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ReadJsonAsString {

    public static void main(String[] args) {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("task.json");
        String data = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        System.out.println(data);
        Object object = JSONValue.parse(data);
        JSONObject jsonObject = (JSONObject) object;
        System.out.println(jsonObject);
    }

    public static JSONObject loadFile(String fileName) {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(fileName);
        String stringJsonData = new BufferedReader(new InputStreamReader(is))
                .lines().collect(Collectors.joining("\n"));
        Object object = JSONValue.parse(stringJsonData);
        return (JSONObject) object;
    }
}