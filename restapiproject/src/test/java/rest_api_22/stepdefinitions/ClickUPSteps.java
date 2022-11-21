package rest_api_22.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;
import rest_api_22.domian.*;
import rest_api_22.helpers.TestCaseContext;

import static rest_api_22.clients.ClickUpClient.*;
import static rest_api_22.constants.ProjectConstants.*;

@SuppressWarnings("ALL")
public class ClickUPSteps {

    @Given("The space exists and contains the correct information")
    public void getSpaceAndCheckInfo() {
        Response response = getSpaceInfo();
        Space space = response.as(Space.class);
        TestCaseContext.setSpace(space);

        Assertions.assertThat(space.getId())
                .as("I check that the Space ID is correct ")
                .isEqualTo(SPACE_ID);

        Assertions.assertThat(space.getName())
                .as("I check that the Space ID is correct ")
                .isEqualTo(SPACE_NAME);
    }

    @And("I create a new folder with title {string}")
    public void iCreatedANewFolder(String title) {
        JSONObject object = new JSONObject();
        object.put("name", title);

        Response response = createANewFolder(object, TestCaseContext.getSpace().getId());
        Folder folder = response.as(Folder.class);
        TestCaseContext.setFolder(folder);

        Assertions.assertThat(folder.getName())
                .as("We verify that the Folder name is correct")
                .isEqualTo(title);
    }

    @And("I added a list with title {string} to the Folder")
    public void iAddedANewList(String title) {
        JSONObject object = new JSONObject();
        object.put("name", title);
        object.put("content", "Rest Assured Api Testing List");
        object.put("due_date", 1690675249);
        object.put("due_date_time", false);
        object.put("priority", 1);
        object.put("assignee", USER_ID);
        object.put("status", "red");
        Response response = creatAList(TestCaseContext.getFolder().getId(), object);
        List list = response.as(List.class);
        TestCaseContext.setList(list);

    }

    @Then("I verify that list {string} is added to the folder")
    public void iCheckThatListIsAddedToTheCorrectFolder(String name) {

        Assertions.assertThat(TestCaseContext.getList().getName())
                .as("The list with the correct name is added to the folder")
                .isEqualTo(name);
    }

    @And("I create a task with name {string}")
    public void iCreateATask(String taskName) {
        Response response = createATask(TestCaseContext.getList().getId(), taskName);
        Task task = response.as(Task.class);
        TestCaseContext.setTask(task);
    }

    @Then("I verify that the task name is {string}")
    public void iCheckThatATaskIsCreated(String title) {

        Assertions.assertThat(TestCaseContext.getTask().getName())
                .as("We verify that the task is created and  name is correct")
                .isEqualTo(title);
    }

    @And("I delete the newly created task")
    public void iRemoveTask() {
        Response response = deleteTaskFromList(TestCaseContext.getTask().getId());
        Assertions.assertThat(response.statusCode())
                .as("The task has been deleted and the response is empty")
                .isEqualTo(204);
    }

    @Then("I fetch the list to verify task is deleted successfully")
    public void iCheckThatTheTaskIsDeleted() {
        Response response = fetchAllTaskInAList(TestCaseContext.getList().getId());
        AllTask allTask = response.as(AllTask.class);
        TestCaseContext.setAllTask(allTask);
        Assertions.assertThat(TestCaseContext.getAllTask().getId())
                .as("I verified that the task was deleted")
                .isNull();
    }

}

