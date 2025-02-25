import java.time.LocalDate;

public class Student implements IStudent{
    private String firstName;
    private String lastName;
    private String address;
    private LocalDate Birthdate;
    private Score score;
    private String ClassName;

    public Student(String firstName , String lastName , LocalDate Birthdate, String address, String ClassName, Score score){
        this.firstName = firstName;
        this.lastName = lastName;
        this.Birthdate = Birthdate;
        this.address = address;
        this.score = score;
        this.ClassName = ClassName;
    }
    @Override
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
    @Override
    public Score getScore(){
        return score;
    }
}

