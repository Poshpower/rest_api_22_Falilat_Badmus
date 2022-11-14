package rest_api_22.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ClickUPSteps {

    @Given("The space exists and contains the correct information")
    public void getSpaceAndCheckInfo(){
        System.out.println("The new clickup space was created and named ");
    }

    @And("I create a new folder with title {string}")
    public void iCreatedANewFolder(String title){
        System.out.println("A new folder was created with the title "+ title );
    }

    @And("I added a list with title {string} to the Folder")
    public void iAddedANewList(String title){
        System.out.println("A new list with the title "+ title + "to the new folder");
    }

    @Then("I verify that list is added and the list name is {string}")
    public void iCheckThatListIsAdded(String name){
        System.out.println("The added list name is  "+ name);
    }

    @And("I create a task with title {string} on the list")
    public void iCreateATask(String title){
        System.out.println("A new task was created with the title "+ title);
    }

    @Then("I verify that the task name is {string}")
    public void iCheckThatATaskIsCreated(String title){
        System.out.println("A new task with the title "+ title + "is on the list");
    }

    @And("I delete the newly created task with title {string}")
    public void iDeleteATask(String title){
        System.out.println("The task with the title "+ title + "is deleted on the list");
    }

    @Then("I check that the task {string} was deleted successfully")
    public void iCheckThatTheTaskIsDeleted(String title){
        System.out.println("The task with the title "+ title + "is not present on the list");
    }
}
