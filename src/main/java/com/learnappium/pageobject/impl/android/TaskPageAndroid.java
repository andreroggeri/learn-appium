package com.learnappium.pageobject.impl.android;

import com.learnappium.pageobject.TaskPage;
import com.learnappium.pageobject.impl.BasePage;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskPageAndroid extends BasePage implements TaskPage {

    @FindBy(id = "actionButton")
    private AndroidElement createTaskButton;

    @FindBy(id = "todoEditText")
    private AndroidElement todoInput;

    @FindBy(id = "addTodoBtn")
    private AndroidElement addTodoButton;

    @FindBy(id = "deleteTodoBtn")
    private AndroidElement deleteTodoButton;

    @FindBy(id = "todoContent")
    private List<MobileElement> todoList;

    @FindBy(id = "to_do_list")
    private AndroidElement todoListContainer;

    @FindBy(id = "android:id/button1")
    private AndroidElement confirmDeleteButton;


    public TaskPageAndroid(MobileDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void createTask(String taskName) {
        createTaskButton.click();
        todoInput.sendKeys(taskName);
        addTodoButton.click();
    }

    public void createTask(String taskName, LocalDate reminder) {

    }

    public boolean findTask(String taskName) {
        return scrollUntilElementVisible(todoListContainer, todoList, taskName);
    }

    public void deleteTask(String taskName) {
        MobileElement task = todoList.stream()
                .filter(element -> element.getText().equals(taskName))
                .findFirst()
                .orElseThrow(RuntimeException::new);

        task.click();
        deleteTodoButton.click();
        confirmDeleteButton.click();
    }

    public void deleteDoneTasks() {

    }

    public List<String> getAllTasks() {
        return todoList.stream().map(MobileElement::getText).collect(Collectors.toList());
    }

    public List<String> getTodayTasks() {
        return null;
    }

    public List<String> getNext7DaysTasks() {
        return null;
    }
}
