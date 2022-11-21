package rest_api_22.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import rest_api_22.helpers.TestCaseContext;

import static rest_api_22.clients.ClickUpClient.deleteFolder;


public class Hooks {
    @Before
    public void beforeHook() {
        System.out.println("This is the start of the test");
        TestCaseContext.init();
    }

    @After
    public void afterHook() {
        deleteFolder(TestCaseContext.getFolder().getId());
        System.out.println("This is the end of the test");
    }
}