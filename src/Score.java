public class Score {
    private double lapTrinhHuongDoiTuong, quanLyDuAn, hocMay, coSoDuLieu, lapTrinhUngDungChoTBDD;

    public Score(double lapTrinhHuongDoiTuong, double quanLyDuAn, double hocMay, double coSoDuLieu, double lapTrinhUngDungChoTBDD) {
        if(!checkScoreInput(lapTrinhHuongDoiTuong) ||
                !checkScoreInput(quanLyDuAn) ||
                !checkScoreInput(hocMay) ||
                !checkScoreInput(coSoDuLieu) ||
                !checkScoreInput(lapTrinhUngDungChoTBDD)){
            throw new IllegalArgumentException("Điểm số phải nằm trong khoảng từ 1.0 đến 10.0");
        }else{
            this.lapTrinhHuongDoiTuong = lapTrinhHuongDoiTuong;
            this.quanLyDuAn = quanLyDuAn;
            this.hocMay = hocMay;
            this.coSoDuLieu = coSoDuLieu;
            this.lapTrinhUngDungChoTBDD = lapTrinhUngDungChoTBDD;
        }
    }
    public boolean checkScoreInput(double score){
        return  score >=0.0 && score <=10;
    }

    public double averageScore() {
        return (this.lapTrinhUngDungChoTBDD + this.lapTrinhHuongDoiTuong + this.hocMay + this.coSoDuLieu + this.quanLyDuAn) / 5;
    }

    public String rankScore() {
        double score = this.averageScore();
        if (score < 4.0) {
            return "< D";
        } else if (score >= 4.0 && score < 5.5) {
            return "D";
        } else if (score >= 5.5 && score < 7.0) {
            return "C";
        } else if (score >= 7.0 && score < 8.5) {
            return "B";
        } else {
            return "A";
        }
    }
}
