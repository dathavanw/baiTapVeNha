import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<ClassRoom> ClassRoomList = new ArrayList<>();

        // tạo các lớp học
        ClassRoom classRoom1 = ClassRoomFactory.createClassRoom("64HTTT1");
        ClassRoom classRoom2 = ClassRoomFactory.createClassRoom("64HTTT2");
        ClassRoom classRoom3 = ClassRoomFactory.createClassRoom("64HTTT3");
        ClassRoom classRoom4 = ClassRoomFactory.createClassRoom("64HTTT4");

        ClassRoomList.add(classRoom1);
        ClassRoomList.add(classRoom2);
        ClassRoomList.add(classRoom3);
        ClassRoomList.add(classRoom4);


        // điểm của các sinh viên
        Score score1 = ScoreFactory.createScore(9, 10, 8, 8, 9);
        Score score2 = ScoreFactory.createScore(10, 5, 6, 2, 1);
        Score score3 = ScoreFactory.createScore(1, 2, 1, 1, 1);
        Score score4 = ScoreFactory.createScore(9, 9, 9, 9, 9);
        Score score5 = ScoreFactory.createScore(8, 8, 8, 8, 8);
        Score score6 = ScoreFactory.createScore(7, 7, 7, 7, 7);
        Score score7 = ScoreFactory.createScore(6, 6, 6, 6, 6);
        Score score8 = ScoreFactory.createScore(5, 5, 5, 5, 5);
        Score score9 = ScoreFactory.createScore(4, 4, 4, 4, 4);
        Score score10 = ScoreFactory.createScore(3, 3, 3, 3, 3);
        Score score11 = ScoreFactory.createScore(3.6, 6.5, 8.3, 7.3, 3.9);
        Score score12 = ScoreFactory.createScore(5.4, 6.7, 9.5, 7.8, 9.3);
        Score score13 = ScoreFactory.createScore(2.9, 8.8, 9.3, 6.3, 5.5);
        Score score14 = ScoreFactory.createScore(9.9, 9, 4.4, 6.7, 6.9);

        //tạo các sinh vien
        Student student1 = StudentFactory.createStudent( "Nguyen", "Thi Hoa", LocalDate.of(2003, 5, 11), "Ninh Binh",classRoom1.getClassName(),score1);
        Student student2 = StudentFactory.createStudent("Nguyen", "Thi Huyen", LocalDate.of(2003, 6, 12), "Thanh Hoa", classRoom1.getClassName(),score2);
        Student student3 = StudentFactory.createStudent("Nguyen", "Thi Tam", LocalDate.of(2003, 7, 13), "Nam Dinh", classRoom1.getClassName(),score3);
        Student student4 = StudentFactory.createStudent("Ha", "Van Dat", LocalDate.of(2003, 8, 14), "Lao Cai", classRoom1.getClassName(),score4);
        Student student5 = StudentFactory.createStudent("Ha", "Van Huy", LocalDate.of(2003, 9, 15), "Son La",classRoom2.getClassName(),score5);
        Student student6 = StudentFactory.createStudent("Ha", "Van Van", LocalDate.of(2003, 10, 16), "Thai Nguyen", classRoom2.getClassName(), score6);
        Student student7 = StudentFactory.createStudent("Nguyen", "Van Teo", LocalDate.of(2003, 11, 17), "Cao Bang", classRoom2.getClassName(), score7);
        Student student8 = StudentFactory.createStudent("Nguyen", "Van Ti", LocalDate.of(2003, 12, 18), "Ha Nam", classRoom2.getClassName(), score8);
        Student student9 = StudentFactory.createStudent("Nguyen", "Trung Hieu", LocalDate.of(2003, 1, 19), "Nghe An", classRoom3.getClassName(), score9);
        Student student10 = StudentFactory.createStudent("Nguyen", "Trung Van", LocalDate.of(2003, 5, 20), "Quang Binh", classRoom3.getClassName(), score10);
        Student student11 = StudentFactory.createStudent("Nguyen", "Nam Trung", LocalDate.of(2003, 5, 21), "Ha Noi", classRoom3.getClassName(), score11);
        Student student12 = StudentFactory.createStudent("Nguyen", "Quang Khanh", LocalDate.of(2003, 3, 22), "Hung Yen", classRoom3.getClassName(), score12);
        Student student13 = StudentFactory.createStudent("Nguyen", "Nam Sau", LocalDate.of(2003, 2, 23), "Hoa Binh", classRoom4.getClassName(), score13);
        Student student14 = StudentFactory.createStudent("Nguyen", "Cao Tam", LocalDate.of(2003, 6, 24), "Tay Nguyen", classRoom4.getClassName(), score14);

        classRoom1.addStudent(student1);
        classRoom1.addStudent(student2);
        classRoom1.addStudent(student3);
        classRoom1.addStudent(student4);
        classRoom2.addStudent(student5);
        classRoom2.addStudent(student6);
        classRoom2.addStudent(student7);
        classRoom2.addStudent(student8);
        classRoom3.addStudent(student9);
        classRoom3.addStudent(student10);
        classRoom3.addStudent(student11);
        classRoom3.addStudent(student12);
        classRoom4.addStudent(student13);
        classRoom4.addStudent(student14);

        Scanner sc = new Scanner(System.in);
        System.out.println("--------Danh sách các lớp CNTT--------");
        for (ClassRoom classRoom : ClassRoomList) {
            System.out.println(classRoom.getClassName());
        }
        boolean find;
        do{
            System.out.println("Hãy nhập mã lớp cần xem thông tin ! ");
            String maLop = sc.nextLine().trim();
            find = false;
            for (ClassRoom classRoom : ClassRoomList) {
                if(classRoom.getClassName().equals(maLop)){
                    find = true;
                    classRoom.viewListStudents();
                    classRoom.countRank();
                    break;
                }
            }
            if(!find){System.out.println("Mã lớp không tồn tại ! Vui lòng nhập lại.....");}

        }while(!find);
        sc.close();

    }
}