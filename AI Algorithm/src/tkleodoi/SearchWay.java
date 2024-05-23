package tkleodoi;

import java.util.*;

// Tìm kiếm leo đồi

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
                    // sc.nextLine();
                    nodes_.get(i).adjacencies[j] = new Edge(returnNode(temp_));
                }
            }

            // Xác định đường đi (A -> H) có giá cực tiểu với tri thức bổ sung
            Node start_ = returnNode(checkNameNodeStart());
            Node end_ = returnNode(checkNameNodeEnd());

            Search(start_, end_);
            List<Node> path = printPath(end_);
            if (found) {
                System.out.println("Đường đi: " + path);
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
        Node MO;

        // Add node gốc (nút A) vào MO
        MO = source;
        // Tập L
        ArrayList<Node> L = new ArrayList<Node>();
        // Kiểm tra đã tìm thấy đích ?
        found = false;

        while (MO != null && !found) {

            // Lấy phần tử đầu tiên -> xóa nó
            Node S = MO;

            // Add node vào tập DONG
            if (!DONG.contains(S)) {
                DONG.add(S);
            } else {
                found = false;
                break;
            }

            // Nếu nút S là nút đích thì stop
            if (S.value.equals(goal.value)) {
                found = true;
            }

            // Kiểm tra các nút con của nút đang xét (current.adjacencies)
            if (S.adjacencies != null) {
                L.clear();
                for (Edge e : S.adjacencies) {
                    Node child = e.target; // xét nút con
                    if (!DONG.contains(child)) {
                        L.add(child);
                        child.parent = S;
                    }
                }
                Collections.sort(L, new Comparator<Node>() {
                    @Override
                    public int compare(Node n1, Node n2) {
                        if (n1.h_scores < n2.h_scores) {
                            return -1;
                        } else {
                            if (n1.h_scores == n2.h_scores) {
                                return 0;
                            } else {
                                return 1;
                            }
                        }
                    }
                });
                Node S_ = L.get(0);
                if (S_.h_scores <= S.h_scores) {
                    MO = S_;
                }
            }
        }

    }

}

class Node {

    public final String value; // Tên của node
    public final double h_scores;
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
    public final Node target; // node đích của liên kết

    public Edge(Node targetNode) {
        target = targetNode;
    }
}
