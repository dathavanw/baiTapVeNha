package com.example.baitap1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Student(String firstName, String lastName, String birthDay, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
        this.grades = new double[SUBJECT_COUNT];
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


    // Hàm xếp hạng rank
    public Map<String, Integer> getRankCounts() {
        Map<String, Integer> rankCounts = new HashMap<>();
        for (Student student : students) {
            String rank = student.getRank();
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
        return rankCounts;
    }

// Chat ho tro
    public void displayRankCounts() {
        Map<String, Integer> rankCounts = getRankCounts();
        System.out.println("\nTong ket so sinh vien theo rank:");
        System.out.println("A: " + rankCounts.getOrDefault("A", 0));
        System.out.println("B: " + rankCounts.getOrDefault("B", 0));
        System.out.println("C: " + rankCounts.getOrDefault("C", 0));
        System.out.println("D: " + rankCounts.getOrDefault("D", 0));
        System.out.println("<D: " + rankCounts.getOrDefault("<D", 0));
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

        System.out.print("Nhap so luong lop: ");
        int classCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < classCount; i++) {
            System.out.println("Nhap thong tin lop thu " + (i + 1) + ": ");
            System.out.print("Ten lop: ");
            String className = scanner.nextLine();
            ClassRoom classRoom = new ClassRoom(className);

            System.out.print("Nhap so luong sinh vien trong lop: ");
            int studentCount = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < studentCount; j++) {
                System.out.println("Nhap thong tin sinh vien thu " + (j + 1) + ":");
                System.out.print("Ho: ");
                String firstName = scanner.nextLine();
                System.out.print("Ten: ");
                String lastName = scanner.nextLine();
                System.out.print("Ngay sinh: ");
                String birthDay = scanner.nextLine();
                System.out.print("Dia chi: ");
                String address = scanner.nextLine();

                Student student = new Student(firstName, lastName, birthDay, address);

                double[] grades = new double[Student.SUBJECT_COUNT];
                for (int k = 0; k < Student.SUBJECT_COUNT; k++) {
                    System.out.print("Nhap diem " + Student.SUBJECTS[k] + ": ");
                    grades[k] = scanner.nextDouble();
                }
                scanner.nextLine();
                student.setGrades(grades);

                classRoom.addStudent(student);
            }
            classRooms.add(classRoom);
        }


        System.out.println("\nDanh sach cac lop:");
        for (ClassRoom classRoom : classRooms) {
            System.out.println(classRoom.getClassName());
        }

        System.out.print("Nhap ten lop đe xem thong tin sinh vien: ");
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
