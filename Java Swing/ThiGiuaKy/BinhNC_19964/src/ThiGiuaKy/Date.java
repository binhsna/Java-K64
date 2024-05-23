package ThiGiuaKy;

import java.io.Serializable;
import java.util.Scanner;

public class Date implements Serializable{
    private int year;
    private int month;
    private int day;

    public Date() {
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    public void Input() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("\t- Ngày: ");
            //this.day = sc.nextInt();
            String day_ = sc.nextLine();
            if (day_ == null || day_ == "") {
                day_ = "0";
            }
            try {
                this.day = Integer.parseInt(day_);
            } catch (Exception e) {
                //e.printStackTrace();
                System.err.print("Error " + e.getMessage());
                sc.nextLine();
            }
            System.out.print("\t- Tháng: ");
            //this.month = sc.nextInt();
            String month_ = sc.nextLine();
            if (month_ == null || month_ == "") {
                month_ = "0";
            }
            try {
                this.month = Integer.parseInt(month_);
            } catch (Exception e) {
                System.err.print("Error " + e.getMessage());
                sc.nextLine();
            }

            System.out.print("\t- Năm: ");
            //this.year = sc.nextInt();
            String year_ = sc.nextLine();
            if (year_ == null || year_ == "") {
                year_ = "0";
            }
            try {
                this.year = Integer.parseInt(year_);
            } catch (Exception e) {
                System.err.print("Error " + e.getMessage());
                sc.nextLine();
            }

            if (day > 0 && month > 0 && year > 0) {
                if (month == 2 && day >= 1) {
                    if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                        //System.out.println("Đây là năm nhuận!");
                        if (day <= 29) {
                            break;
                        }
                    } else {
                        if (day <= 28) {
                            break;
                        }
                    }
                }

                // thang co 30 ngay:
                if ((month == 4 || month == 6 || month == 9 || month == 11) && day >= 1 && day <= 30) {
                    break;
                }

                // thang co 31 ngay:
                if ((month == 1 || month == 3 || month == 5 || month == 7 ||
                        month == 8 || month == 10 || month == 12) && day >= 1 && day <= 31) {
                    break;
                }
                System.err.print("Ngày sinh không hợp lệ -> Vui lòng nhập lại!");
                sc.nextLine();
            } else break;
        }
    }

    public String toString() {
        String day_ = "", month_ = "", year_ = "";
        if (this.day > 0 && this.day < 32) {
            day_ = String.valueOf(day);
        } else {
            day_ = "...";
        }
        if (this.month > 0 && this.month < 13) {
            month_ = String.valueOf(month);
        } else {
            month_ = "...";
        }
        if (this.year > 0) {
            year_ = String.valueOf(year);
        } else if (year <= 0) {
            year_ = "...";
        }
        return (day_ + "/" + month_ + "/" + year_);
    }
}
