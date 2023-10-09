package OOP_todoList.Entity;

public class Todo {

    private Long id;
    private String text;
    private boolean done;

    public Todo (String text, boolean done) {
        this.text = text;
        this.done = done;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public boolean getDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
}
