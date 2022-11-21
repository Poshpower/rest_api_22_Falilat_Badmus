package rest_api_22.domian;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.simple.JSONArray;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllTask {


    @JsonProperty("id")
    private JSONArray id;

    @JsonProperty("name")
    private JSONArray name;

    public JSONArray getId() {
        return id;
    }

    public void setId(JSONArray id) {
        this.id = id;
    }

    public JSONArray getName() {
        return name;
    }

    public void setName(JSONArray name) {
        this.name = name;
    }

}
