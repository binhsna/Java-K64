package ThiGiuaKy;

import java.io.Serializable;

public class employee implements Serializable {
    private int id; // Mã số
    private String name; // Tên
    private Date date; // Ngày sinh
    private String job; // Chức vụ
    private int salary; // Lương cơ bản
    private int nSal; // Hệ số lương

    public employee() {
    }

    public employee(int id, String name, Date date, String job, int salary, int nSal) {
        super();
        this.id = id;
        this.name = name;
        this.date = date;
        this.job = job;
        this.salary = salary;
        this.nSal = nSal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getnSal() {
        return nSal;
    }

    public void setnSal(int nSal) {
        this.nSal = nSal;
    }

    public String toString() {
        return "\nMã số: " + id +
                "\nHọ tên: " + name +
                "\nNgày sinh (dd/mm/yyyy): " + date.toString() +
                "\nChức vụ: " + job +
                "\nLương cơ bản: " + salary +
                "\nHệ số lương: " + nSal;
    }
}
