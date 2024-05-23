package Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentModify {
    private static Connection connection = null;
    private static String linkDatabase_ = "jdbc:sqlserver://localhost:1433;databaseName=JavaSwingExam;user=sa;password=123;encrypt=false;";

    //    "jdbc:sqlserver://localhost:1433;databaseName=Test;integratedSecurity=true;encrypt=false;"
    public static List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = getConnection(linkDatabase_);

            //query
            String sql = "select * from student";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Student std = new Student(resultSet.getString("maSoLop"),
                        resultSet.getString("tenLop"), resultSet.getString("gvcn"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return studentList;
    }

    public static void test() {
        //lay tat ca danh sach sinh vien
        connection = getConnection(linkDatabase_);

        //query
        String sql = "{call testproc (?)}";
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall(sql);
            statement.setInt(1, 1);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if (rs.getInt("ketqua") == 0) {
                    System.out.println("Lấy danh sách thất bại!");
                } else if (rs.getInt("ketqua") == 1) {
                    System.out.println("Lấy danh sách thành công!");
                }
            }

//        } catch (SQLException ex) {
//            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        // Kiểm tra khi thêm sửa mã số lớp (khóa chính) tránh trùng lặp
    public static boolean checkDuplicate(String maSoLop) {
        List<Student> studentList = new ArrayList<>();

        //Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = getConnection(linkDatabase_);
            //query
            String sql = "select * from student where maSoLop like '" + maSoLop + "'";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return false;
    }

    public static void insert(Student std) {
        //Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = getConnection(linkDatabase_);

            // Ngăn ko cho database tự động lưu dữ liệu
            connection.setAutoCommit(false);
            //query
            String sql = "insert into student(maSoLop, tenLop, gvcn) values(?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, std.getMaSoLop());
            statement.setString(2, std.getTenLop());
            statement.setString(3, std.getGvcn());

            statement.execute();
            if (StudentFrame.save == true) {
                connection.commit();
            } else if (StudentFrame.rollback == true) {
                connection.rollback();
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void rollback() {
        //Connection connection = null;
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void update(Student std, String maSoLop) {
        //Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = getConnection(linkDatabase_);

            // Ngăn ko cho database tự động lưu dữ liệu
            connection.setAutoCommit(false);
            //query
            String sql = "update student set tenLop=?,gvcn=? where maSoLop = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, std.getTenLop());
            statement.setString(2, std.getGvcn());
            statement.setString(3, maSoLop);

            statement.execute();
            if (StudentFrame.save == true) {
                connection.commit();
            } else if (StudentFrame.rollback == true) {
                rollback();
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void delete(String maSoLop) {
        //Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = getConnection(linkDatabase_);

            // Ngăn ko cho database tự động lưu dữ liệu
            connection.setAutoCommit(false);
            //query
            String sql = "delete from student where maSoLop = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, maSoLop);

            statement.execute();
            if (StudentFrame.save == true) {
                connection.commit();
            } else if (StudentFrame.rollback == true) {
                rollback();
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static List<Student> findByFullname(String hoten) {
        List<Student> studentList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = getConnection(linkDatabase_);

            //query
            String sql = "select * from student where hoten like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%" + hoten + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student std = new Student(resultSet.getString("maSoLop"),
                        resultSet.getString("tenLop"), resultSet.getString("gvcn"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return studentList;
    }

    public static Connection getConnection(String dbURL) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL);
            System.out.println("Test.connect successfully!");
        } catch (Exception ex) {
            System.out.println("Test.connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}

