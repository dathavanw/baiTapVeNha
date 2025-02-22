import java.time.LocalDate;

public class Students {
    private String firstName, lastName, address;
    private LocalDate Birthdate;
    private Score score;
    private ClassRoom Class;

    public Students(String firstName , String lastName , LocalDate Birthdate,  String address, ClassRoom Class,Score score){
        this.firstName = firstName;
        this.lastName = lastName;
        this.Birthdate = Birthdate;
        this.address = address;
        this.score = score;
        this.Class = Class;
    }
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
    public Score getScore(){
        return this.score;
    }
}

