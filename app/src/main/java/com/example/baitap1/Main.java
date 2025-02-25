package com.example.baitap1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Student {
    private String firstName;
    private String lastName;
    private String birthDay;
    private String address;
    private double[] grades;

    public static final int SUBJECT_COUNT = 5;
    public static final String[] SUBJECTS = {
            "Lap trinh huong doi tuong",
            "Quan ly di an",
            "Hoc may",
            "Co so di lieu",
            "Lap trinh ung dung cho TBDĐ"
    };

    public Student(String firstName, String lastName, String birthDay, String address, double[] grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
        this.grades = grades;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    public double getAverageGrade() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    public String getRank() {
        double average = getAverageGrade();
        if (average >= 9) return "A";
        else if (average >= 8) return "B";
        else if (average >= 7) return "C";
        else if (average >= 5) return "D";
        else return "<D";
    }

    public void display() {
        System.out.println("Ten sinh vien: " + firstName + " " + lastName);
        System.out.println("Ngay sinh: " + birthDay);
        System.out.println("Dia chi: " + address);
    }
}

class ClassRoom {
    private String className;
    private List<Student> students;

    public ClassRoom(String className) {
        this.className = className;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getClassName() {
        return className;
    }


public void displayRankCounts() {
    int countA = 0, countB = 0, countC = 0, countD = 0, countLessD = 0;

    for (Student student : students) {
        String rank = student.getRank();
        switch (rank) {
            case "A": countA++; break;
            case "B": countB++; break;
            case "C": countC++; break;
            case "D": countD++; break;
            default: countLessD++; break;
        }
    }

    System.out.println("\nTong ket so sinh vien theo rank:");
    System.out.println("A: " + countA);
    System.out.println("B: " + countB);
    System.out.println("C: " + countC);
    System.out.println("D: " + countD);
    System.out.println("<D: " + countLessD);
}

    public void displayStudents() {
        for (Student student : students) {
            student.display();
            System.out.println("DTB: " + student.getAverageGrade());
            System.out.println("Rank: " + student.getRank());
            System.out.println("------------------------------");
        }
        displayRankCounts();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ClassRoom> classRooms = new ArrayList<>();

        ClassRoom class1 = new ClassRoom("HT3");
        class1.addStudent(new Student("Nguyen", "An", "2002-05-12", "Ha Noi", new double[]{9, 8, 7, 8, 9}));
        class1.addStudent(new Student("Le", "Binh", "2001-09-23", "Da Nang", new double[]{6, 7, 8, 5, 7}));
        class1.addStudent(new Student("Tran", "Chi", "2003-03-18", "TP HCM", new double[]{4, 5, 6, 4, 3}));

        ClassRoom class2 = new ClassRoom("HT4");
        class2.addStudent(new Student("Pham", "Duc", "2002-07-25", "Hai Phong", new double[]{8, 8, 9, 7, 8}));
        class2.addStudent(new Student("Do", "Hoang", "2000-12-01", "Can Tho", new double[]{5, 6, 5, 5, 6}));

        classRooms.add(class1);
        classRooms.add(class2);

        System.out.print("Chon lop hien thi danh sach:");
        for(ClassRoom classRoom : classRooms)
        {
            System.out.println(classRoom.getClassName());
        }
        System.out.print("\nNhap ten lop de xem thong tin sinh vien: ");
        String classNameInput = scanner.nextLine();

        ClassRoom selectedClass = null;
        for (ClassRoom classRoom : classRooms) {
            if (classRoom.getClassName().equalsIgnoreCase(classNameInput)) {
                selectedClass = classRoom;
                break;
            }
        }

        if (selectedClass != null) {
            System.out.println("\nThong tin sinh vien trong lop " + selectedClass.getClassName() + ":");
            selectedClass.displayStudents();
        } else {
            System.out.println("Lop khong ton tai!");
        }

        scanner.close();

    }
}
