package Utilities;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NewCommentInfo{
    private final String name;
    private final String body;
    private final String title;


    public NewCommentInfo(String name, String body, String title) {
        this.name = name;
        this.body = body;
        this.title = title;
    }

    public JSONObject commentInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", this.name);
        map.put("body", this.body);
        map.put("title", this.title);
        return new JSONObject(map);
    }
}
