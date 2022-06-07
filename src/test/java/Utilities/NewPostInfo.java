package Utilities;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NewPostInfo {
    private final String body;
    private final String title;


    public NewPostInfo(String body, String title) {
        this.body = body;
        this.title = title;
    }

    public JSONObject postInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put("body", this.body);
        map.put("title", this.title);
        return new JSONObject(map);
    }
}
