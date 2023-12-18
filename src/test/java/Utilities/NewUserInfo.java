package Utilities;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NewUserInfo{
    private final int id;
    private final String name;
    private final String email;
    private final String website;


    public NewUserInfo(int id, String name, String email, String website) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.website = website;
    }

    public JSONObject userInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("name", this.name);
        map.put("email", this.email);
        map.put("website", this.website);
        return new JSONObject(map);
    }
}
