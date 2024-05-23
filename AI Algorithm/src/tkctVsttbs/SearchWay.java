package tkctVsttbs;

import java.util.*;

// Tìm kiếm đường đi có giá cực tiểu với tri thức bổ sung

public class SearchWay {
    public static Scanner sc = new Scanner(System.in);
    public static List<Node> nodes_ = new ArrayList<Node>();
    public static boolean found = false;

    public static void main(String[] args) {
        while (true) {
            // Khởi tạo các node
            String error_ = "Đầu vào không đúng -> Vui lòng nhập lại!";
            int n_; // Số node có trong cây
            n_ = checkInt("Nhập số node trong cây: ", error_);
            // sc.nextLine();

            int count_ = 0;
            String nameNode_;
            int heuristic_;
            while (true) {
                nameNode_ = checkDuplicateNodeName(count_ + 1);
                heuristic_ = checkInt("Nhập h(" + nameNode_.toString() + ") = ", error_);
                // sc.nextLine();
                nodes_.add(new Node(nameNode_, heuristic_));
                count_++;
                if (count_ == n_)
                    break;
            }
            System.out.println("Tree: " + nodes_);
            // Khởi tạo cây với quan hệ giữa các node
            int link_;
            int glink_;
            for (int i = 0; i < nodes_.size(); i++) {
                Node nodeTemp_ = nodes_.get(i);
                while (true) {
                    link_ = checkInt("Nhập số liên kết của node " + nodes_.get(i).value + ": ", error_);
                    if (link_ <= nodes_.size() - 1) {
                        break;
                    }
                    System.err.print("\t\tSố liên kết không được vượt quá " + (nodes_.size() - 1));
                    sc.nextLine();
                }
                // sc.nextLine();
                nodes_.get(i).adjacencies = new Edge[link_];
                String temp_;
                int gtemp_;
                ArrayList ts = new ArrayList();
                for (int j = 0; j < link_; j++) {
                    boolean checkOver_ = false;
                    while (true) {
                        checkOver_ = false;
                        temp_ = checkNameNode(nodeTemp_);
                        if (ts.size() > 0) {
                            for (Object t : ts) {
                                if (Objects.equals(temp_, t)) {
                                    checkOver_ = true;
                                    System.err.print("\t\tNode " + t.toString() +
                                            " đã nhập -> Vui lòng nhập node khác!");
                                    sc.nextLine();
                                    break;
                                }
                            }
                        }
                        if (checkOver_ == false)
                            break;
                    }
                    ts.add(temp_);
                    gtemp_ = checkInt("g(" + nodeTemp_.value + "," + temp_ + ") = ", error_);
                    // sc.nextLine();
                    nodes_.get(i).adjacencies[j] = new Edge(returnNode(temp_), gtemp_);
                }
            }

            // Xác định đường đi (A -> H) có giá cực tiểu với tri thức bổ sung
            Node start_ = returnNode(checkNameNodeStart());
            Node end_ = returnNode(checkNameNodeEnd());

            Search(start_, end_);
            List<Node> path = printPath(end_);
            if (found) {
                System.out.println("Đường đi: " + path);
                System.out.println("Với " + "f[" + start_.toString() + ","
                        + end_.toString() + "] = " + end_.f_scores);
            } else {
                System.out.println("Không tìm thấy đường đi từ node " + start_.toString() + " -> " + end_.toString());
            }
            nodes_.clear();

            if (checkInt("Nhập 1 để tiếp tục, 0 để kết thúc!\n", "Lựa chọn không đúng -> Vui lòng nhập lại!") == 0) {
                System.out.println("Kết thúc thành công!");
                break;
            }
        }
    }

    public static String checkNameNodeStart() {
        String nameNode_;
        boolean check_ = false;
        while (true) {
            System.out.print("Nhập node start: ");
            nameNode_ = sc.nextLine();
            for (Node n : nodes_) {
                if (Objects.equals(nameNode_, n.value)) {
                    check_ = true;
                    break;
                }
            }
            if (check_ == false) {
                System.err.print("Node này không tồn tại -> Vui lòng nhập lại!");
                sc.nextLine();
            } else if (check_ == true)
                break;
        }
        return nameNode_;
    }

    public static String checkNameNodeEnd() {
        String nameNode_;
        boolean check_ = false;
        while (true) {
            System.out.print("Nhập node đích: ");
            nameNode_ = sc.nextLine();
            for (Node n : nodes_) {
                if (Objects.equals(nameNode_, n.value)) {
                    check_ = true;
                    break;
                }
            }
            if (check_ == false) {
                System.err.print("Node này không tồn tại -> Vui lòng nhập lại!");
                sc.nextLine();
            } else if (check_ == true)
                break;
        }
        return nameNode_;
    }

    public static String checkNameNode(Node t) {
        String nameNode_;
        boolean check_ = false;
        boolean Exist_ = false;
        while (true) {
            check_ = false;
            Exist_ = false;
            System.out.print("Nhập tên node kề với node " + t.value + ": ");
            nameNode_ = sc.nextLine();
            for (Node n : nodes_) {
                if (Objects.equals(nameNode_, n.value) && (!n.equals(t))) {
                    Exist_ = true;
                    check_ = true;
                    break;
                } else if (Objects.equals(nameNode_, n.value) && (n.equals(t))) {
                    Exist_ = true;
                    check_ = false;
                    System.err.print("Tên node nhập không được trùng lặp với node " + t.value);
                    sc.nextLine();
                    break;
                }
            }
            if (Exist_ == false) {
                System.err.print("Node nhập không tồn tại -> Vui lòng nhập lại!");
                sc.nextLine();
            }
            if (check_ == true)
                break;
        }
        return nameNode_;
    }

    public static Node returnNode(String name_) {
        for (Node n : nodes_) {
            if (Objects.equals(name_, n.value)) {
                return n;
            }
        }
        return null;
    }

    public static int checkInt(String s1, String s2) {
        int n_;
        while (true) {
            System.out.print(s1);
            try {
                while (true) {
                    n_ = sc.nextInt();
                    if (n_ < 0) {
                        sc.nextLine();
                        System.err.print("Số không được âm!");
                        sc.nextLine();
                        System.out.print(s1);
                    } else
                        break;
                }
                sc.nextLine();
                return n_;
            } catch (Exception e) {
                sc.nextLine();
                System.err.print(s2);
                sc.nextLine();
            }
        }
    }

    public static String checkDuplicateNodeName(int n_) {
        String name_;
        boolean nameDuplicate_ = false; // Kiểm tra ID trùng lặp
        do {
            nameDuplicate_ = false;
            System.out.print("Nhập tên node thứ " + n_ + ": ");
            name_ = sc.nextLine();
            if (nodes_.size() > 0) {
                for (int i = 0; i < nodes_.size(); i++) {
                    if (Objects.equals(name_, nodes_.get(i).value)) {
                        nameDuplicate_ = true;
                        System.err.print("Tên node bị trùng lặp -> vui lòng nhập lại!");
                        sc.nextLine();
                        break;
                    }
                }
            }
        } while (nameDuplicate_ == true);

        return name_;
    }

    public static List<Node> printPath(Node target) {
        List<Node> path = new ArrayList<Node>();

        for (Node node = target; node != null; node = node.parent) {
            path.add(node);
        }

        Collections.reverse(path);

        return path;
    }

    public static void Search(Node source, Node goal) {
        // Tập DONG (chứa các node khác nhau)
        Set<Node> DONG = new HashSet<Node>();

        // Tập MO
        ArrayList<Node> MO = new ArrayList<Node>();
        // Giá của nút gốc (nút A)
        source.g_scores = 0;

        // Add node gốc (nút A) vào tập MO
        MO.add(source);

        // Kiểm tra đã tìm thấy đích ?
        found = false;

        while ((!MO.isEmpty()) && (!found)) {

            // Lấy phần tử đầu tiên -> xóa nó
            Collections.sort(MO, new Comparator<Node>() {
                @Override
                public int compare(Node n1, Node n2) {
                    if (n1.f_scores < n2.f_scores) {
                        return -1;
                    } else {
                        if (n1.f_scores == n2.f_scores) {
                            return 0;
                        } else {
                            return 1;
                        }
                    }
                }
            });
            Node current = MO.get(0);
            MO.remove(0);

            // Add node vào tập DONG
            DONG.add(current);

            // Nếu nút S là nút đích thì stop
            if (current.value.equals(goal.value)) {
                found = true;
            }

            // Kiểm tra các nút con của nút đang xét (current.adjacencies)
            for (Edge e : current.adjacencies) {
                Node child = e.target; // xét nút con
                double cost = e.cost; // giá cần để node current đến nút con đó
                double temp_g_scores = current.g_scores + cost; // Cập nhật lại giá của đường đi từ So -> nút con
                double temp_f_scores = temp_g_scores + child.h_scores;

                // Nếu nút con đã được xét và f_score mới không nhỏ hơn f_score cũ thì bỏ qua ->
                // thực hiện lần lặp mới
                if ((DONG.contains(child)) &&
                        (temp_f_scores /* mới */ >= child.f_scores /* cũ */)) {
                    continue;
                }

                // Nếu nút con không có trong hàng đợi hoặc có f_score mới thấp hơn
                // Thì ta sẽ bắt đầu xét nút con đó (S = child)

                else if ((!MO.contains(child)) ||
                        (temp_f_scores < child.f_scores)) {

                    child.parent = current;
                    child.g_scores = temp_g_scores;
                    child.f_scores = temp_f_scores;

                    // Add node child vào tập MO
                    // (nếu node child có rùi -> cập nhật lại giá trị f_scores
                    if (MO.contains(child)) {
                        MO.remove(child);
                    }
                    MO.add(child);
                }

            }

        }

    }

}

class Node {

    public final String value; // Tên của node
    public double g_scores; // Giá của đường đi
    public final double h_scores;
    public double f_scores = 0;
    public Edge[] adjacencies; // adjacencies: Bổ sung
    public Node parent; // nút cha

    public Node(String val, double hVal) {
        value = val;
        h_scores = hVal;
    }

    public String toString() {
        return value;
    }

}

class Edge { // Liên kết giữa 1 node -> 1 node (target: mục tiêu)
    public final double cost; // Giá của đường đi
    public final Node target; // node đích của liên kết

    public Edge(Node targetNode, double costVal) {
        target = targetNode;
        cost = costVal;
    }
}
