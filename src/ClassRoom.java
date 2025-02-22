import java.util.ArrayList;

public class ClassRoom {
        private String name ;
        private ArrayList<Students> studentList;

        public ClassRoom (String name){
            this.name = name;
            this.studentList = new ArrayList<>();
        }
        public String getClassName(){
            return this.name;
        }
        public void addStudent(Students students){
            studentList.add(students);
        }
        public void viewListStudents(){
            System.out.println("Danh sách sinh viên lớp "+this.name+":");
            for(Students students : studentList){
                System.out.println(students.getFullName());
            }
        }
        public void countRank(){
            int countRank_A = 0, countRank_B = 0, countRank_C = 0, countRank_D = 0, countRank_F = 0;
            for (Students students : studentList){
                String rank = students.getScore().rankScore();
                switch (rank){
                    case "A": countRank_A++;break;
                    case "B": countRank_B++;break;
                    case "C": countRank_C++;break;
                    case "D": countRank_D++;break;
                    case "< D": countRank_F++;break;
                }
            }
            System.out.println("Số lượng sinh viên theo từng rank : ");
            System.out.println("Rank A : "+countRank_A);
            System.out.println("Rank B : "+countRank_B);
            System.out.println("Rank C : "+countRank_C);
            System.out.println("Rank D : "+countRank_D);
            System.out.println("Rank <D : "+countRank_F);
        }

        @Override
        public String toString() {
            return "Tên lớp: " + this.name;
        }
    }


