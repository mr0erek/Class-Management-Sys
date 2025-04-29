import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base class Person demonstrating encapsulation and abstraction
class Person {
    private String name; // Encapsulated data
    private int age;

    // Constructor with parameters
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods for accessing private fields
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Method overriding for polymorphism
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

// Student class inheriting from Person
class Student extends Person {
    private String studentId;
    private List<String> courses;

    public Student(String name, int age, String studentId) {
        super(name, age); // Calling parent constructor
        this.studentId = studentId;
        this.courses = new ArrayList<>();
    }

    // Instance method with parameter
    public void enrollCourse(String course) {
        courses.add(course);
    }

    public String getStudentId() {
        return studentId;
    }

    public List<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + studentId + ", Courses: " + courses;
    }
}

// Teacher class inheriting from Person
class Teacher extends Person {
    private String teacherId;
    private String subject;

    public Teacher(String name, int age, String teacherId, String subject) {
        super(name, age);
        this.teacherId = teacherId;
        this.subject = subject;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getSubject() {
        return subject;
    }

    // Method to modify object state
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + ", Teacher ID: " + teacherId + ", Subject: " + subject;
    }
}

// ManagementSystem class to manage students and teachers
class ManagementSystem {
    private List<Student> students;
    private List<Teacher> teachers;

    public ManagementSystem() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    // Methods with parameters to add objects
    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    // Methods with parameters to remove objects
    public void removeStudent(String studentId) {
        students.removeIf(s -> s.getStudentId().equals(studentId));
    }

    public void removeTeacher(String teacherId) {
        teachers.removeIf(t -> t.getTeacherId().equals(teacherId));
    }

    // Void methods to display information
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void viewTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers available.");
        } else {
            for (Teacher t : teachers) {
                System.out.println(t);
            }
        }
    }
}

// Main class with user interaction
public class ClassManagementSystem {
    public static void main(String[] args) {
        ManagementSystem system = new ManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nClass Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Add Teacher");
            System.out.println("5. View Teachers");
            System.out.println("6. Remove Teacher");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String sName = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int sAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String sId = scanner.nextLine();
                    Student student = new Student(sName, sAge, sId);
                    system.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    system.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID to remove: ");
                    String removeSId = scanner.nextLine();
                    system.removeStudent(removeSId);
                    System.out.println("Student removed if existed.");
                    break;

                case 4:
                    System.out.print("Enter teacher name: ");
                    String tName = scanner.nextLine();
                    System.out.print("Enter teacher age: ");
                    int tAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter teacher ID: ");
                    String tId = scanner.nextLine();
                    System.out.print("Enter subject: ");
                    String subject = scanner.nextLine();
                    Teacher teacher = new Teacher(tName, tAge, tId, subject);
                    system.addTeacher(teacher);
                    System.out.println("Teacher added successfully.");
                    break;

                case 5:
                    system.viewTeachers();
                    break;

                case 6:
                    System.out.print("Enter teacher ID to remove: ");
                    String removeTId = scanner.nextLine();
                    system.removeTeacher(removeTId);
                    System.out.println("Teacher removed if existed.");
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}