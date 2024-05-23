package Student;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class StudentFrame extends JFrame {
    DefaultTableModel tableModel;
    List<Student> studentList = new ArrayList<>();
    JTable tblStudent;
    boolean add = false;
    public static boolean save = false;
    boolean delete = false;
    boolean edit = false;
    public static boolean rollback = false;
    private String idClass = "";
    private JTextField txtMaSoLop;
    private JTextField txtTenLop;
    private JTextField txtGvcn;

    private JButton btnThem;
    private JButton btnLuu;
    private JButton btnHuy;
    private JButton btnXoa;

    public StudentFrame() {
        initComponents();

        tableModel = (DefaultTableModel) tblStudent.getModel();
        // tblStudent.setModel(tableModel);
        showStudent();
    }

    private void showStudent() {
        studentList = StudentModify.findAll();

        tableModel.setRowCount(0); // Đặt lại số hàng là 0 (xóa tất cả dữ liệu)

        for (Student student : studentList) {
            tableModel.addRow(new Object[]{/*tableModel.getRowCount() + 1*/student.getMaSoLop(), student.getTenLop(),
                    student.getGvcn()});
        }
        StudentModify.test();
    }

    private void initComponents() {

        setSize(500, 500);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thông tin lớp học");
        setAlwaysOnTop(true);
        setResizable(false);
        setLocationRelativeTo(null);

        tblStudent = new JTable();
        tblStudent.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã số lớp", "Tên lớp", "Giáo viên CN"}
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        // Tạo layout tong
        JPanel pnTong = new JPanel();
        pnTong.setLayout(new BoxLayout(pnTong, BoxLayout.Y_AXIS));

        // Tạo layout tiêu đề
        JPanel pnHeader = new JPanel();
        JLabel lbHeader = new JLabel("THÔNG TIN LỚP HỌC");
        lbHeader.setForeground(Color.BLUE);
        lbHeader.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        pnHeader.add(lbHeader);
        // Tạo layout nội dung gồm nhập thông tin và bảng
        JPanel pnND = new JPanel(new GridLayout(2, 1));
        // Layout phần nội dung trên
        JPanel pnNDTren = new JPanel();
        pnNDTren.setLayout(new BoxLayout(pnNDTren, BoxLayout.Y_AXIS));
        // Tạo layout phần nhập thông tin
        JPanel pnMaSoLop = new JPanel();
        pnMaSoLop.add(new JLabel("Mã số lớp:"));
        txtMaSoLop = new JTextField(35);
        pnMaSoLop.add(txtMaSoLop);

        JPanel pnTenLop = new JPanel();
        pnTenLop.add(Box.createHorizontalStrut(5));
        pnTenLop.add(new JLabel("Tên lớp:"));
        txtTenLop = new JTextField(35);
        pnTenLop.add(txtTenLop);

        JPanel pnGvcn = new JPanel();
        pnGvcn.add(new JLabel("Giáo viên CN:"));
        txtGvcn = new JTextField(35);
        pnGvcn.add(txtGvcn);
        pnGvcn.add(Box.createHorizontalStrut(15));

        txtMaSoLop.setEnabled(false);
        txtTenLop.setEnabled(false);
        txtGvcn.setEnabled(false);
        // Tạo layout chứa các button
        JPanel pnButton = new JPanel(new FlowLayout());
        btnThem = new JButton("Thêm");
        btnLuu = new JButton("Lưu");
        btnHuy = new JButton("Hủy");
        btnXoa = new JButton("Xóa");
        btnLuu.setEnabled(false);
        btnXoa.setEnabled(false);
        btnHuy.setEnabled(false);

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLuu.setEnabled(true);
                btnHuy.setEnabled(true);
                // Đặt các trường nhập thành null
                setNullInput();

                txtMaSoLop.setEnabled(true);
                txtMaSoLop.requestFocus();
                txtMaSoLop.selectAll();

                txtTenLop.setEnabled(true);
                txtGvcn.setEnabled(true);

                add = true;

            }
        });

        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maSo = txtMaSoLop.getText().trim();
                String tenlop = txtTenLop.getText().trim();
                String gvcn = txtGvcn.getText();
                if (add && !edit && !delete) {
                    if (maSo.equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Mã số lớp học không được để trống!");
                    } else if (!StudentModify.checkDuplicate(maSo)) {
                        Student std = new Student(maSo, tenlop, gvcn);
                        // Lưu dữ liệu vào database
                        save = true;
                        StudentModify.insert(std);
                        JOptionPane.showMessageDialog(rootPane, "Thêm dữ liệu thành công!");
                        txtMaSoLop.setEnabled(false);
                        txtTenLop.setEnabled(false);
                        txtGvcn.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Mã số lớp học đã tồn tại\n-> Vui lòng nhập mã số khác!");
                    }
                    add = false;
                } else if (delete) {
                    save = true;
                    StudentModify.delete(idClass);
                    JOptionPane.showMessageDialog(rootPane, "Xóa dữ liệu thành công!");
                    delete = false;
                } else if (edit) {
                    if (maSo.equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Mã số lớp học không được để trống!");
                    } else if (!StudentModify.checkDuplicate(maSo)) {
                        save = true;
                        StudentModify.update(new Student(maSo, tenlop, gvcn),
                                studentList.get(tblStudent.getSelectedRow()).getMaSoLop());
                        JOptionPane.showMessageDialog(rootPane, "Sửa dữ liệu thành công!");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Mã số lớp học trùng lặp\n-> Vui lòng nhập mã số khác!");
                    }
                    edit = false;
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Không có dữ liệu mới!");
                }
                setNullInput();
                showStudent();
                save = false;
                // Tắt trạng thái các nút
                setEnableButton(false);
            }
        });

        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNullInput();
                //StudentModify.rollback();
                //rollback = true;
                //if (edit) {
                JOptionPane.showMessageDialog(rootPane, "Hủy thao tác thành công!");
                //rollback = false;
                //edit = false;
                add = false;
                save = false;
                edit = false;
                delete = false;
                //}
                showStudent();
                txtMaSoLop.setEnabled(false);
                setEnableButton(false);
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLuu.setEnabled(true);
                btnHuy.setEnabled(true);
                setNullInput();
                int selectedIndex = tblStudent.getSelectedRow();
                if (selectedIndex >= 0) {
                    Student std = studentList.get(selectedIndex);
                    idClass = std.getMaSoLop();
                    int option = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn xóa dữ liệu này?");
                    System.out.println("option : " + option);

                    if (option == 0) {
                        //StudentModify.delete(std.getMaSoLop());
                        //showStudent();
                        tableModel.removeRow(selectedIndex);
                        btnXoa.setEnabled(false);
                        delete = true;
                    }
                }
            }
        });
        tblStudent.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnLuu.setEnabled(true);
                btnXoa.setEnabled(true);
                btnHuy.setEnabled(true);
                int selectedIndex = tblStudent.getSelectedRow();
                if (selectedIndex >= 0) {
                    Student std = studentList.get(selectedIndex);
                    txtMaSoLop.setText(std.getMaSoLop());
                    txtTenLop.setText(std.getTenLop());
                    txtGvcn.setText(std.getGvcn());
                }
                if (!delete) {
                    edit = true;
                    txtMaSoLop.setEnabled(true);
                    txtTenLop.setEnabled(true);
                    txtGvcn.setEnabled(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        pnButton.add(Box.createHorizontalStrut(50));
        pnButton.add(btnThem);
        pnButton.add(btnLuu);
        pnButton.add(btnHuy);
        pnButton.add(btnXoa);


        pnNDTren.add(pnMaSoLop);
        pnNDTren.add(pnTenLop);
        pnNDTren.add(pnGvcn);
        pnNDTren.add(pnButton);

        // Tạo layout chứa bảng
        JPanel pnNDduoi = new JPanel();
        pnNDduoi.setBorder(BorderFactory.createTitledBorder("Danh sách lớp học "));
        // Tạo layout cho Bảng
        JPanel pnTable = new JPanel();
        JScrollPane pntbStudent = new JScrollPane(tblStudent);
        pnTable.add(pntbStudent);
        JScrollPane scpnTable = new JScrollPane(pnTable);
        pnNDduoi.add(scpnTable);

        // Add các layout thành phần vào layout tong
        pnND.add(pnNDTren);
        pnND.add(pnNDduoi);
        pnTong.add(pnHeader);
        pnTong.add(pnND);
        this.add(pnTong);

    }

    private void setNullInput() {
        txtMaSoLop.setText("");
        txtTenLop.setText("");
        txtGvcn.setText("");
    }

    // Tắt trạng thái các nút lưu, hủy, xóa
    private void setEnableButton(boolean b) {
        btnHuy.setEnabled(b);
        btnLuu.setEnabled(b);
        btnXoa.setEnabled(b);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentFrame().setVisible(true);
            }
        });
    }
}

