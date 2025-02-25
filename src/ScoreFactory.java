class ScoreFactory {
    public static Score createScore(double lapTrinhHuongDoiTuong, double quanLyDuAn, double hocMay, double coSoDuLieu, double lapTrinhUngDungChoTBDD) {
        return new Score(lapTrinhHuongDoiTuong, quanLyDuAn, hocMay, coSoDuLieu, lapTrinhUngDungChoTBDD);
    }
}


