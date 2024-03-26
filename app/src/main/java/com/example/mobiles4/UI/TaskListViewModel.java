package com.example.mobiles4.UI;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mobiles4.Data.Task;
import com.example.mobiles4.Data.TaskList;
import com.example.mobiles4.Data.TaskListRepository;
import com.example.mobiles4.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskListViewModel extends ViewModel {
    private MutableLiveData<TaskListRepository> uiState =
            new MutableLiveData<>(new TaskList());
    private MutableLiveData<TaskListRepository> uiStateUser =
            new MutableLiveData<>(new TaskList());
    public LiveData<TaskListRepository> getUiState() {
        return uiState;
    }
    public LiveData<TaskListRepository> getUiStateUser() {
        return uiStateUser;
    }
    public Task getTask(int index) {
        return uiState.getValue().get(index);
    }
    public void addToList(Task task) {
        uiState.getValue().add(task);
    }
    public void clearTaskList() {
        uiState.getValue().clearAll();
    }
    public Task createRandomMathematicalTask() {
        Random random = new Random();
        Task task;
        int r = random.nextInt(2);
        if (r == 0) {
            task = setRandomArithmeticTask();
        }
        else {
            task = setRandomGeometricTask();
        }
        return task;
    }
    public void addUserTask(Task task) {
        uiStateUser.getValue().add(task);
    }
    public Task setRandomUserTask() {
        if (uiStateUser.getValue().isEmpty()) {
            return createRandomMathematicalTask();
        }
        Random random = new Random();
        Task task = uiStateUser.getValue().get(
                random.nextInt(uiStateUser.getValue().getSize())
        );
        return task;
    }
    private Task setRandomArithmeticTask() {
        Random random = new Random();
        int image = R.drawable.arithmetic_task;
        int first = random.nextInt(100);
        int second = random.nextInt(100);
        int coperator = random.nextInt(3);
        Integer answer = 0;
        String operator = null;
        switch (coperator) {
            case 0:
                operator=" + ";
                answer = first + second;
                break;
            case 1:
                operator=" - ";
                answer = first - second;
                break;
            case 2:
                operator=" * ";
                answer = first * second;
                break;
        }
        String text = "Вычислите: " + first + operator + second;
        return new Task(text, image, answer.toString());
    }
    private Task setRandomGeometricTask() {
        Random random = new Random();
        int image = R.drawable.geometry_task;
        String text = "Чему равен в градусах внутренний\nугол правильного ";
        int angles = random.nextInt(5);
        String answer = "none";
        switch (angles) {
            case 0:
                text+="треугольника?";
                answer = "60";
                break;
            case 1:
                text+="четырёхугольника?";
                answer = "90";
                break;
            case 2:
                text+="пятиугольника?";
                answer = "108";
                break;
            case 3:
                text+="шестиугольника?";
                answer = "120";
                break;
            case 4:
                text+="восьмиугольника?";
                answer = "135";
                break;
        }
        return new Task(text, image, answer.toString());
    }
}
