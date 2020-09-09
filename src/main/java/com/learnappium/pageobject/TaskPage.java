package com.learnappium.pageobject;

import java.time.LocalDate;
import java.util.List;

public interface TaskPage {

    void createTask(String taskName);

    void createTask(String taskName, LocalDate reminder);

    void deleteTask(String taskName);

    void deleteDoneTasks();

    boolean findTask(String taskname);

    List<String> getAllTasks();

    List<String> getTodayTasks();

    List<String> getNext7DaysTasks();

}
