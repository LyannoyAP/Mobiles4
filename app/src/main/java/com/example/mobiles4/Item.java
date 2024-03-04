package com.example.mobiles4;

import java.util.List;
import java.util.Random;

public class Item {
    private String text;
    private int image;
    public Item(String text, int image) {
        this.text = text;
        this.image = image;
    }
    public Item(int type) {
        Random random = new Random();
        if (type == 0) {
            int choose = random.nextInt(2);
            if (choose == 0) {
                image = R.drawable.arithmetic_task;
                int first = random.nextInt(100);
                int second = random.nextInt(100);
                int coperator = random.nextInt(4);
                String operator = null;
                switch (coperator) {
                    case 0:
                        operator=" + ";
                        break;
                    case 1:
                        operator=" - ";
                        break;
                    case 2:
                        operator=" * ";
                        break;
                    case 3:
                        operator=" : ";
                        break;
                }
                text = "Вычислите: " + first + operator + second;

            }
            else{
                image = R.drawable.geometry_task;
                text = "Чему равен в градусах внутренний\nугол ";
                int angles = random.nextInt(5);
                switch (angles) {
                    case 0:
                        text+="треугольника?";
                        break;
                    case 1:
                        text+="квадрата?";
                        break;
                    case 2:
                        text+="пятиугольника?";
                        break;
                    case 3:
                        text+="шестиугольника?";
                        break;
                    case 4:
                        text+="восьмиугольника?";
                        break;
                }
            }
        }
        else {
            image = R.drawable.nature;
            int choose = random.nextInt(6);
            switch (choose) {
                case 0:
                    text = "Классификация растений";
                    break;
                case 1:
                    text = "Классификация животных";
                    break;
                case 2:
                    text = "Назовите 10 примеров\nмлекопитающих";
                    break;
                case 3:
                    text = "Строение глаза";
                    break;
                case 4:
                    text = "Строение уха";
                    break;
                case 5:
                    text = "Строение гортани";
                    break;
            }
        }
    }
    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }
}
