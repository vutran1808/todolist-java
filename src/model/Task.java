package model;

public class Task {

    public String desc;
    public boolean completed;
    public Task next;
    
    public Task() {
        this.next = null;
    }

    public Task(String desc) {
        this.desc = desc;
        this.completed = false;
    }

}
