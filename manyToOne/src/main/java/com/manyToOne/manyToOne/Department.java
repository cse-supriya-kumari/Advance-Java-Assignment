package com.manyToOne.manyToOne;



import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String deptName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Student> students;

    public Department() {
        super();
    }

    public Department(String deptName) {
        this.deptName = deptName;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", deptName=" + deptName + "]";
    }
}
