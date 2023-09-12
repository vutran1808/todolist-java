package controller;

import model.Task;
import view.Menu;
import java.util.Scanner;
public class todoTask extends Menu<String>{
    
    protected Task head;
    protected Task tail;
    protected Task next;
    Scanner sc = new Scanner(System.in);
    public todoTask() {
        super("TODOLIST", new String[]{"Add task","Display Task","Mark task as completed","Remove Task","Exit"});
        this.head = null;
        this.tail = null;
        this.next = null;
    }

    public void addTask() {
        System.out.println("Add new Task");
        System.out.println("-----------------");
        System.out.println("Enter the description: ");
        String desc = sc.nextLine();
        Task newTask = new Task(desc);
        if (head == null) {
            head = newTask;
            tail = newTask;
        } else {
            tail.next = newTask;
            tail = newTask;
        }
    }

    public void displayTask() {
        Task current = head;
        if (head == null) {
            System.out.println("List is emply");
            return;
        }
        System.out.println("To Do Task : ");
        while (current != null) {
            String status = current.completed ? "[x]" : "[]";
            System.out.println(status + "" + current.desc);
            current = current.next;
        }
    }

    public void isCompleted() {
        System.out.println("Mark task as completed:");
        System.out.println("------------------------");
        System.out.println("Enter the desc of the task completed: ");
        String desc = sc.nextLine();
        Task current = head;
        while (current != null) {
            if (current.desc.equals(desc)) {
                current.completed = true;
                System.out.println("Task marked as completed" + desc);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found" + desc);
    }

    public void removedTask() {
        System.out.println("Remove Task");
        System.out.println("--------------------");
        System.out.println("Enter the desc of the task removed");
        String desc = sc.nextLine();
        Task current = head;
        if (head == null) {
            System.out.println("Task is emply");
        }
        if (head.desc.equals(desc)) {
            head = head.next;
            System.out.println("Task removed" + desc);
            return;
        }
        while (current != null) {
            if (current.next.desc.equals(desc)) {
                current.next = current.next.next;
                System.out.println("Task removed " + desc);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found" + desc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addTask();
                break;
            case 2:
                displayTask();
                break;
            case 3:
                isCompleted();
                break;
            case 4:
                removedTask();
                break;
            case 5:
                System.exit(0);
        }
    }
    public static void main(String[] args) {
        todoTask tdt = new todoTask();
        tdt.run();
    }

}
