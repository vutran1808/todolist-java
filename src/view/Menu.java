/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public abstract class Menu<T> {

    private String title;
    private ArrayList taskList;
    Scanner sc = new Scanner(System.in);

    public Menu() {
        taskList = new ArrayList<>();
    }

    public Menu(String td, String[] arr) {
        this.title = td;
        taskList = new ArrayList<>();
        for (String s : arr) {
            taskList.add((T) s);
        }
    }

    public void display() {
        System.out.println(title);
        System.out.println("----------------------");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + "." + taskList.get(i));
        }
        System.out.println("----------------------");
    }

    public int getSelection() {
        display();
        return sc.nextInt();
    }

    public String getDesc() {
        return sc.nextLine();
    }

    public abstract void execute(int n);

    public void run() {
        while (true) {
            int n = getSelection();
            execute(n);
            if (n > taskList.size()) {
                break;
            }
        }

    }

}
