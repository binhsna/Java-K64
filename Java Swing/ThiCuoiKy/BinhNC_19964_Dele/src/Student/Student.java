package Student;

public class Student {
    private String maSoLop;
    private String tenLop;
    private String gvcn;

    public Student() {

    }

    public Student(String maSoLop, String tenLop, String gvcn) {
        this.maSoLop = maSoLop;
        this.tenLop = tenLop;
        this.gvcn = gvcn;
    }

    public String getMaSoLop() {
        return maSoLop;
    }

    public void setMaSoLop(String maSoLop) {
        this.maSoLop = maSoLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getGvcn() {
        return gvcn;
    }

    public void setGvcn(String gvcn) {
        this.gvcn = gvcn;
    }
}

