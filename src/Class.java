import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


class Student {
    private String firstName;
    private String lastName;
    private String birthdate;
    private String address;
    private String className;

    private double diemOOP;      
    private double diemQLDA;     
    private double diemHM;       
    private double diemCSDL;     
    private double diemLTUD;     

    public Student(String firstName, String lastName, String birthdate, String address, String className,
                   double diemOOP, double diemQLDA, double diemHM, double diemCSDL, double diemLTUD) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.className = className;
        this.diemOOP = diemOOP;
        this.diemQLDA = diemQLDA;
        this.diemHM = diemHM;
        this.diemCSDL = diemCSDL;
        this.diemLTUD = diemLTUD;
    }

    public double tinhDiemTrungBinh() {
        return (diemOOP + diemQLDA + diemHM + diemCSDL + diemLTUD) / 5.0;
    }

    public String xepLoai() {
        double avg = tinhDiemTrungBinh();
        if (avg >= 8.5)
            return "A";
        else if (avg >= 7.0)
            return "B";
        else if (avg >= 5.5)
            return "C";
        else if (avg >= 4.0)
            return "D";
        else
            return "<D";
    }

    @Override
    public String toString() {
        return String.format("Ten: %s %s, Ngay sinh: %s, Dia chi: %s, Lop: %s, Diem TB: %.2f, Xep loai: %s",
                firstName, lastName, birthdate, address, className, tinhDiemTrungBinh(), xepLoai());
    }
}


class LopHoc {
    private String maLop;
    private List<Student> danhSachSinhVien;

    public LopHoc(String maLop) {
        this.maLop = maLop;
        danhSachSinhVien = new ArrayList<>();
    }

    public String getMaLop() {
        return maLop;
    }

    public void themSinhVien(Student s) {
        danhSachSinhVien.add(s);
    }

    public void hienThiDanhSachSinhVien() {
        for (Student s : danhSachSinhVien) {
            System.out.println(s);
        }
    }
    public Map<String, Integer> demSoLuongTheoHang() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("B", 0);
        map.put("C", 0);
        map.put("D", 0);
        map.put("<D", 0);  
        for (Student s : danhSachSinhVien) {
            String rank = s.xepLoai();
            map.put(rank, map.get(rank) + 1);
        }
        return map;
    }
}

public class Class {
    public static void main(String[] args) {
        
        List<LopHoc> danhSachLop = new ArrayList<>();

        LopHoc lop1 = new LopHoc("CNTT1");
        lop1.themSinhVien(new Student("Le", "Binh", "2001-02-10", "Ha Noi", "CNTT1",
                8.5, 9.0, 7.5, 8.0, 7.0));
        lop1.themSinhVien(new Student("Nguyen", "Nam", "2004-12-12", "Ha Noi", "CNTT1",
                7.0, 8.0, 6.5, 7.5, 6.0));
        lop1.themSinhVien(new Student("Tran", "Cung", "2002-05-10", "Ha Noi", "CNTT1",
                9.0, 9.5, 8.5, 9.0, 8.0));
        danhSachLop.add(lop1);

        LopHoc lop2 = new LopHoc("CNTT2");
        lop2.themSinhVien(new Student("Pham", "Dung", "2001-03-03", "Ha Noi", "CNTT2",
                6.0, 6.5, 5.0, 5.5, 4.5));
        lop2.themSinhVien(new Student("Do", "E", "2003-05-09", "Ha Noi", "CNTT2",
                4.0, 4.5, 5.0, 4.0, 3.5));
        danhSachLop.add(lop2);

        System.out.println("Danh sach cac lop:");
        for (LopHoc lop : danhSachLop) {
            System.out.println("- " + lop.getMaLop());
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma lop can hien thi: ");
        String maLopNhap = sc.nextLine();

        boolean timThay = false;
        for (LopHoc lop : danhSachLop) {
            if (lop.getMaLop().equalsIgnoreCase(maLopNhap)) {
                timThay = true;
                System.out.println("\nThong tin sinh vien lop " + lop.getMaLop() + ":");
                lop.hienThiDanhSachSinhVien();

                Map<String, Integer> bangXepLoai = lop.demSoLuongTheoHang();
                System.out.println("\nTong ket so sinh vien theo xep loai:");
                System.out.println("A: " + bangXepLoai.get("A") + " sinh vien") ;
                System.out.println("B: " + bangXepLoai.get("B") +" sinh vien" );
                System.out.println("C: " + bangXepLoai.get("C") +" sinh vien" );
                System.out.println("D: " + bangXepLoai.get("D") +" sinh vien" );
                System.out.println("<D: " + bangXepLoai.get("<D") +" sinh vien");
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay lop: " + maLopNhap);
        }

        sc.close();
    }
}
