Feature: This feature tests clickup api

  Scenario:Create a task on a list added to a newly created folder in a Space
    Given The space exists and contains the correct information
    And I create a new folder with title "First Folder"
    And I added a list with title "First List" to the Folder
    Then I verify that list "First List" is added to the folder
    And I create a task with name "Sample Task"
    Then I verify that the task name is "Sample Task"
    And I delete the newly created task
    Then I fetch the list to verify task is deleted successfully





