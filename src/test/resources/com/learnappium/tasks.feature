Feature: Tasks

  Background:
    Given that the user is authenticated

  Scenario: Create a task
    When a task is created
    Then it should be displayed on the task list

  Scenario: Delete a task
    Given that a task exists
    When the task is deleted
    Then it should be removed from the task list

  Scenario: Delete finished tasks

  Scenario: Edit a task

  Scenario: Create a task with a reminder for today

  Scenario: Create a task with a reminder for 7 days ahead

  Scenario: Create a task with a reminder for 8 days ahead