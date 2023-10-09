package OOP_attendance.Entity;

public class Professor {

    private Long id;

    private String name;

    private static Professor instance;

    public static Professor getInstance() {
        if (instance == null) {
            instance = new Professor();
        }
        return instance;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Professor() {
    }

    public Professor(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
