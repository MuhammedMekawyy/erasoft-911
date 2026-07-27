package Task3;

import java.util.ArrayList;
import java.util.List;

public class Language {

    private int id;
    private String name;
    private List<Teacher> teachers;

    public Language() {
        teachers = new ArrayList<>();
    }

    public Language(int id, String name) {
        this.id = id;
        this.name = name;
        this.teachers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
}
