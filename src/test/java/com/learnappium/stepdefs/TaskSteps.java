package com.learnappium.stepdefs;

import com.github.javafaker.Faker;
import com.learnappium.pageobject.TaskPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TaskSteps {

    @Autowired
    private TaskPage taskPage;

    @Autowired
    private Faker faker;

    private String createdTask;


    @Given("that a task exists")
    @When("a task is created")
    public void aTaskIsCreated() {
        createdTask = faker.space().planet();
        taskPage.createTask(createdTask);
        taskPage.findTask(createdTask);
    }

    @Then("it should be displayed on the task list")
    public void itShouldBeDisplayedOnTheTaskList() {
        List<String> allTasks = taskPage.getAllTasks();

        assertThat(allTasks, hasItem(createdTask));
    }

    @When("the task is deleted")
    public void theTaskIsDeleted() {
        taskPage.deleteTask(createdTask);
    }

    @Then("it should be removed from the task list")
    public void itShouldBeRemovedFromTheTaskList() {
        boolean result = taskPage.findTask(createdTask);
        List<String> allTasks = taskPage.getAllTasks();

        assertThat(result, equalTo(false));
        assertThat(allTasks, not(hasItem(createdTask)));
    }
}
