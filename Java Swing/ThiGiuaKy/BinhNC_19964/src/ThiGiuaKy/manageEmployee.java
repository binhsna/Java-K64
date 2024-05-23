package ThiGiuaKy;

import org.jetbrains.annotations.NotNull;

import java.util.*;

class manageEmployee {
    public static Scanner sc = new Scanner(System.in);
    private List<employee> employees;
    private EmployeeFile employeeFile;
    static int count = 0;

    public manageEmployee() {
        //employees = new ArrayList<employee>();
        employeeFile = new EmployeeFile();
        employees = employeeFile.read();
    }

    public int checkInt(String s_, String t_) {
        while (true) {
            System.out.print(s_);
            try {
                String s = sc.nextLine();
                int idT = Integer.parseInt(s);
                return idT;
                //break;
            } catch (NumberFormatException ex) {
                System.err.print(t_);
                sc.nextLine();
            }
        }
    }

    public employee Emp(int id_, @NotNull employee e) {
        e.setId(id_);

        System.out.print("Họ tên: ");
        String name_ = sc.nextLine();
        e.setName(name_);

        System.out.println("Ngày sinh: ");
        ThiGiuaKy.Date date_ = new Date();
        date_.Input();
        e.setDate(date_);

        System.out.print("Chức vụ: ");
        String job_ = sc.nextLine();
        e.setJob(job_);

        while (true) {
            System.out.print("Lương cơ bản: ");
            try {
                int salary_ = sc.nextInt();
                e.setSalary(salary_);
                break;
            } catch (Exception ex) {
                sc.nextLine();
                System.err.print("Đầu vào không đúng -> Vui lòng nhập lại!");
                sc.nextLine();
            }
        }
        while (true) {
            System.out.print("Hệ số lương: ");
            try {
                int nSal_ = sc.nextInt();
                e.setnSal(nSal_);
                break;
            } catch (Exception ex) {
                sc.nextLine();
                System.err.print("Đầu vào không đúng -> Vui lòng nhập lại!");
                sc.nextLine();
            }
        }
        return e;
    }

    public void addEmp() {
        employee e = new employee();
        count++;
        int id_;
        boolean idDuplicate = false; // Kiểm tra ID trùng lặp
        do {
            idDuplicate = false;
            id_ = checkInt("Mã số: ", "Mã số không hợp lệ -> vui lòng nhập lại!");
            //id_ = sc.nextInt();
            if (employees.size() > 0) {
                for (int i = 0; i < employees.size(); i++) {
                    if (id_ == employees.get(i).getId()) {
                        idDuplicate = true;
                        System.err.print("Mã số bị trùng lặp -> vui lòng nhập lại!");
                        sc.nextLine();
                        break;
                    }
                }
            }
        } while (idDuplicate == true);

        employees.add(Emp(id_, e));
        employeeFile.write(employees);
    }

    public void editEmp(){
        if (employees.isEmpty()) {
            System.err.println("Không có nhân viên nào trong danh sách!");
        } else {
            int idEdit_;
            idEdit_ = checkInt("Nhập mã số của nhân viên cần sửa thông tin: ", "Mã số không hợp lệ -> Vui lòng nhập lại!");

            boolean checkEdit = false;
            for (int i = 0; i < employees.size(); i++) {
                if (idEdit_ == employees.get(i).getId()) {
                    checkEdit = true;
                    int id_;
                    boolean idDuplicate = false; // Kiểm tra ID trùng lặp
                    do {
                        idDuplicate = false;
                        id_ = checkInt("Mã số: ", "Mã số không hợp lệ -> Vui lòng nhập lại!");

                        if (employees.size() > 1) {
                            for (int j = 0; j < employees.size(); j++) {
                                if ((j != i) && (id_ == employees.get(j).getId())) {
                                    idDuplicate = true;
                                    System.err.print("Mã số bị trùng lặp -> vui lòng nhập lại!");
                                    sc.nextLine();
                                    break;
                                }
                            }
                        }
                    } while (idDuplicate == true);

                    Emp(id_, employees.get(i));

                    System.out.println("Sửa thông tin thành công!");
                    employeeFile.write(employees);
                    break;
                }
            }
            if (checkEdit == false) {
                System.err.println("Không tìm thấy nhân viên cần sửa!");
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEmp() {
        if (employees.isEmpty()) {
            System.err.println("Không có nhân viên nào trong danh sách!");
        } else {
            int idDelete_;
            idDelete_ = checkInt("Nhập mã số của nhân viên cần xóa: ", "Mã số không hợp lệ -> Vui lòng nhập lại!");
            boolean checkDelete_ = false;
            for (int i = 0; i < employees.size(); i++) {
                if (idDelete_ == employees.get(i).getId()) {
                    checkDelete_ = true;
                    employees.remove(i);
                    System.out.println("Xóa nhân viên thành công!");
                    employeeFile.write(employees);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
            }
            if (checkDelete_ == false) {
                System.err.print("Không tìm thấy nhân viên cần xóa!");
                sc.nextLine();
            }
        }
    }

    public void display() {
        if (employees.isEmpty()) {
            System.err.println("Không có nhân viên nào trong danh sách!");
        } else {
            int countID = 0;
            for (employee emp : employees) {
                countID++;
                if (countID < 2) {
                    System.out.print("---------------- Danh sách " + employees.size() + " nhân viên ----------------\n");
                }
                System.out.println("(Nhân viên số " + countID + ")" + "\t" + emp);
                System.out.println("----------------------------------------------------");
            }
        }
    }

    public void searchEmpName() {
        if (employees.isEmpty()) {
            System.err.println("Không có nhân viên nào trong danh sách!");
        } else {
            boolean tk = false;
            System.out.print("Nhập tên nhân viên muốn tìm kiếm: ");
            String name_ = sc.nextLine();
            int count = 0;
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getName().contains(name_)) {
                    count++;
                    tk = true;
                    if (count < 2) {
                        System.out.print("---------------- Thông tin tìm kiếm ----------------");
                    }
                    System.out.println(employees.get(i));
                    System.out.println("----------------------------------------------------");
                }
            }
            if (tk == false) {
                System.err.println("Không tìm thấy nhân viên có " +
                        "\"" + name_ + "\"" + " trong tên!");
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sortAscendingID() {
        Collections.sort(employees, new Comparator<employee>() {
            @Override
            public int compare(employee e1, employee e2) {
                if (e1.getId() < e2.getId()) {
                    return -1;
                } else {
                    if (e1.getId() == e2.getId()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
        });
        System.out.println("Sắp xếp thành công!");
        // --> In ra danh sách các nhân viên sau khi được sắp xếp
        display();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sortAscendingName()  {
        // Sắp xếp danh sách theo thứ tự a,b,c
        Collections.sort(employees, new Comparator<employee>() {
            @Override
            public int compare(employee e1, employee e2) {
                return (e1.getName().compareTo(e2.getName()));
                // Muốn đảo danh sách -> đổi thành
                // return(e2.getName().compareTo(e1.getName()));
            }
        });
        System.out.println("Sắp xếp thành công!");
        // --> In ra danh sách các nhân viên sau khi được sắp xếp
        display();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void menu() {
        byte choice;
        do {
            choice = 0;
            System.out.println("\n---------------- Menu ----------------" +
                    "\n1. Thêm mới nhân viên" +
                    "\n2. Sửa thông tin nhân viên" +
                    "\n3. Xóa nhân viên" +
                    "\n4. Hiển thị toàn bộ nhân viên" +
                    "\n5. Tìm kiếm nhân viên" +
                    "\n6. Sắp xếp nhân viên" +
                    "\n7. Thoát");

            while (choice < 1 || choice > 7) {
                while (true) {
                    System.out.print("Nhập lựa chọn: ");
                    try {
                        choice = sc.nextByte();
                        if (choice >= 1 && choice <= 7) sc.nextLine();
                        break;
                    } catch (Exception e) {
                        sc.nextLine();
                        System.err.print("Lựa chọn không hợp lệ -> Vui lòng nhập lại!");
                        sc.nextLine();
                    }
                }
                if (choice < 1 || choice > 7) {
                    sc.nextLine();
                    System.err.print("Lựa chọn không hợp lệ -> Vui lòng nhập lại!");
                    sc.nextLine();
                }
            }
            if (choice == 1) addEmp();
            else if (choice == 2) editEmp();
            else if (choice == 3) deleteEmp();
            else if (choice == 4) {
                display();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else if (choice != 5) {
                if (choice == 6) {
                    sortAscendingID();
                    //sortAscendingName();
                } else if (choice == 7) {
                    System.out.println("Thoát chương trình thành công!");
                    break;
                }
            } else searchEmpName();
        } while (choice != 7);
        System.exit(0);
    }
}
