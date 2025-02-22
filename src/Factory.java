import java.time.LocalDate;

public class Factory {
    public Students createStudent(String firstName , String lastName , LocalDate Birthdate,String address, ClassRoom Class, Score score){
        return new Students(firstName,lastName,Birthdate,address,Class,score);
    }
    public ClassRoom createClasRoom(String name){
        return new ClassRoom(name);
    }

    public Score createScore(double lapTrinhHuongDoiTuong, double quanLyDuAn, double hocMay, double coSoDuLieu, double lapTrinhUngDungChoTBDD){
        return new Score(lapTrinhHuongDoiTuong,quanLyDuAn,hocMay,coSoDuLieu,lapTrinhUngDungChoTBDD);
    }





}
