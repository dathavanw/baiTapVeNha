import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<ClassRoom> ClassRoomList = new ArrayList<>();
        // tạo các lớp học
        ClassRoom classRoom1 = Factory.createClasRoom("64HTTT1");
        ClassRoom classRoom2 = Factory.createClasRoom("64HTTT2");
        ClassRoom classRoom3 = Factory.createClasRoom("64HTTT3");
        ClassRoom classRoom4 = Factory.createClasRoom("64HTTT4");

        ClassRoomList.add(classRoom1);
        ClassRoomList.add(classRoom2);
        ClassRoomList.add(classRoom3);
        ClassRoomList.add(classRoom4);
        // điểm của các sinh viên
        Score score1 = Factory.createScore(9, 10, 8, 8, 9);
        Score score2 = Factory.createScore(10, 5, 6, 2, 1);
        Score score3 = Factory.createScore(1, 2, 1, 1, 1);
        Score score4 = Factory.createScore(9, 9, 9, 9, 9);
        Score score5 = Factory.createScore(8, 8, 8, 8, 8);
        Score score6 = Factory.createScore(7, 7, 7, 7, 7);
        Score score7 = Factory.createScore(6, 6, 6, 6, 6);
        Score score8 = Factory.createScore(5, 5, 5, 5, 5);
        Score score9 = Factory.createScore(4, 4, 4, 4, 4);
        Score score10 = Factory.createScore(3, 3, 3, 3, 3);
        Score score11 = Factory.createScore(3.6, 6.5, 8.3, 7.3, 3.9);
        Score score12 = Factory.createScore(5.4, 6.7, 9.5, 7.8, 9.3);
        Score score13 = Factory.createScore(2.9, 8.8, 9.3, 6.3, 5.5);
        Score score14 = Factory.createScore(9.9, 9, 4.4, 6.7, 6.9);

        //tạo các sinh vien
        Students student1 = Factory.createStudent( "Nguyen", "Thi Hoa", LocalDate.of(2003, 5, 11), "Ninh Binh",classRoom1,score1);
        Students student2 = Factory.createStudent("Nguyen", "Thi Huyen", LocalDate.of(2003, 6, 12), "Thanh Hoa", classRoom1,score2);
        Students student3 = Factory.createStudent("Nguyen", "Thi Tam", LocalDate.of(2003, 7, 13), "Nam Dinh", classRoom1,score3);
        Students student4 = Factory.createStudent("Ha", "Van Dat", LocalDate.of(2003, 8, 14), "Lao Cai", classRoom1,score4);
        Students student5 = Factory.createStudent("Ha", "Van Huy", LocalDate.of(2003, 9, 15), "Son La",classRoom2,score5);
        Students student6 = Factory.createStudent("Ha", "Van Van", LocalDate.of(2003, 10, 16), "Thai Nguyen", classRoom2, score6);
        Students student7 = Factory.createStudent("Nguyen", "Van Teo", LocalDate.of(2003, 11, 17), "Cao Bang", classRoom2, score7);
        Students student8 = Factory.createStudent("Nguyen", "Van Ti", LocalDate.of(2003, 12, 18), "Ha Nam", classRoom2, score8);
        Students student9 = Factory.createStudent("Nguyen", "Trung Hieu", LocalDate.of(2003, 1, 19), "Nghe An", classRoom3, score9);
        Students student10 = Factory.createStudent("Nguyen", "Trung Van", LocalDate.of(2003, 5, 20), "Quang Binh", classRoom3, score10);
        Students student11 = Factory.createStudent("Nguyen", "Nam Trung", LocalDate.of(2003, 5, 21), "Ha Noi", classRoom3, score11);
        Students student12 = Factory.createStudent("Nguyen", "Quang Khanh", LocalDate.of(2003, 3, 22), "Hung Yen", classRoom3, score12);
        Students student13 = Factory.createStudent("Nguyen", "Nam Sau", LocalDate.of(2003, 2, 23), "Hoa Binh", classRoom4, score13);
        Students student14 = Factory.createStudent("Nguyen", "Cao Tam", LocalDate.of(2003, 6, 24), "Tay Nguyen", classRoom4, score14);

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