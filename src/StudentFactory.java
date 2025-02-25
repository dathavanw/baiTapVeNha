import java.time.LocalDate;

class StudentFactory {
    public static Student createStudent(String firstName , String lastName , LocalDate Birthdate, String address, String ClassName, Score score){
        return new Student(firstName,lastName,Birthdate,address,ClassName,score);
    }
}
