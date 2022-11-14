Feature: This feature tests clickup api

  Scenario:Create a task on a list added to a newly created folder in a Space
    Given The space exists and contains the correct information
    And I create a new folder with title "New Folder"
    And I added a list with title "List Title" to the Folder
    Then I verify that list is added and the list name is "List Title"
    And I create a task with title "My Task" on the list
    Then I verify that the task name is "My Task"
    And I delete the newly created task with title "My Task"
    Then I check that the task "My Task" was deleted successfully


