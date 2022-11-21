package rest_api_22.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static rest_api_22.constants.ProjectConstants.*;
import static rest_api_22.helpers.ReadJsonAsString.loadFile;


public class ClickUpClient {
    public static Response getSpaceInfo() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .pathParam("space_id", SPACE_ID)
                .when()
                .get("https://api.clickup.com/api/v2/space/{space_id}")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createANewFolder(JSONObject object, Integer space_id) {
        return RestAssured
                .given()
                .header("Authorization", API_TOKEN)
                .header("Content-Type", "application/json")
                .pathParam("space_id", space_id)
                .body(object)
                .when()
                .post("https://api.clickup.com/api/v2/space/{space_id}/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response creatAList(Integer folder_id, JSONObject object) {
        return RestAssured
                .given()
                .header("Authorization", API_TOKEN)
                .header("Content-Type", "application/json")
                .pathParam("folder_id", folder_id)
                .body(object)
                .when()
                .post("https://api.clickup.com/api/v2/folder/{folder_id}/list")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response createATask(Integer list_id, String taskName) {
        JSONObject body = loadFile("task.json");
        body.put("name", taskName);
        return RestAssured
                .given()
                .header("Authorization", API_TOKEN)
                .header("Content-Type", "application/json")
                .pathParam("list_id", list_id)
                .queryParam("custom_task_ids", false)
                .queryParam("team_id", TEAM_ID)
                .body(body)
                .when()
                .post("https://api.clickup.com/api/v2/list/{list_id}/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response deleteTaskFromList(String task_id) {
        return RestAssured
                .given()
                .header("Authorization", API_TOKEN)
                .header("Content-Type", "application/json")
                .pathParam("task_id", task_id)
                .queryParam("custom_task_ids", false)
                .queryParam("team_id", TEAM_ID)
                .when()
                .delete("https://api.clickup.com/api/v2/task/{task_id}")
                .then().log().all()
                .statusCode(204)
                .extract().response();
    }

    public static Response fetchAllTaskInAList(Integer list_id) {
        return RestAssured
                .given()
                .header("Authorization", API_TOKEN)
                .header("Content-Type", "application/json")
                .pathParam("list_id", list_id)
                .when()
                .get("https://api.clickup.com/api/v2/list/{list_id}/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }


    //The is done to reset the space at the end of the test. Test Purposes only
    public static Response deleteFolder(Integer folder_id) {

        return RestAssured
                .given()
                .header("Authorization", API_TOKEN)
                .header("Content-Type", "application/json")
                .pathParam("folder_id", folder_id)
                .when()
                .delete("https://api.clickup.com/api/v2/folder/{folder_id}")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

}

