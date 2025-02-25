import java.util.ArrayList;

public class ClassRoom {
        private String ClassName ;
        private ArrayList<IStudent> studentList;

        public ClassRoom (String ClassName){
            this.ClassName = ClassName;
            this.studentList = new ArrayList<>();
        }
        public String getClassName(){
            return this.ClassName;
        }
        public void addStudent(IStudent student){
            studentList.add(student);
        }
        public void viewListStudents(){
            System.out.println("Danh sách sinh viên lớp "+this.ClassName+":");
            for(IStudent student : studentList){
                System.out.println(student.getFullName());
            }
        }
        public void countRank(){
            int countRank_A = 0, countRank_B = 0, countRank_C = 0, countRank_D = 0, countRank_F = 0;
            for (IStudent student : studentList){
                String rank = student.getScore().rankScore();
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
            return "Tên lớp: " + this.ClassName;
        }
    }


