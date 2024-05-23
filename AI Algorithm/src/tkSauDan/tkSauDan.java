
package tkSauDan;

import java.util.*;

// Tìm kiếm sâu dần
public class tkSauDan {
    public static Scanner sc = new Scanner(System.in);
    public static List<Node> nodes_ = new ArrayList<Node>();
    public static boolean found = false;
    public static int h;
    public static int DS;
    public static String error_ = "Đầu vào không đúng -> Vui lòng nhập lại!";

    public static void main(String[] args) {

//        Node a = new Node("a");
//        Node b = new Node("b");
//        Node c = new Node("c");
//        Node d = new Node("d");
//        Node e = new Node("e");
//        Node f = new Node("f");
//        Node g = new Node("g");
//        Node h = new Node("h");
//        Node i = new Node("i");
//        Node k = new Node("k");
//        a.doSau = 0;
//
//        a.adjacencies = new Edge[]{new Edge(b), new Edge(c), new Edge(d)};
//        b.adjacencies = new Edge[]{new Edge(e), new Edge(f), new Edge(g)};
//        c.adjacencies = new Edge[]{new Edge(g)};
//        g.adjacencies = new Edge[]{new Edge(h)};
//        h.adjacencies = new Edge[]{new Edge(k), new Edge(i)};
//
//        b.doSau = 1;
//        c.doSau = 1;
//        d.doSau = 1;
//        e.doSau = 2;
//        f.doSau = 2;
//        g.doSau = 2;
//        h.doSau = 3;
//        k.doSau = 4;
//        i.doSau = 4;
//        Search(a, h);
//        List<Node> path = printPath(h);
//        if (found) {
//            System.out.println("Path: " + path);
//        } else {
//            System.out.println("Không tìm thấy đường đi từ node " + a.toString() + " -> " + h.toString());
//        }
        h = checkInt("Nhập độ sâu giới hạn: ", error_);
        DS = h;
        while (true) {
            int n_; // Số node có trong cây
            n_ = checkInt("Nhập số node trong cây: ", error_);
            int count_ = 0;
            String nameNode_;
            while (true) {
                Node d;
                if (count_ == 0) {
                    System.out.print("Nhập node gốc: ");
                    nameNode_ = sc.nextLine();
                    d = new Node(nameNode_);
                    d.doSau = 0;
                } else {
                    nameNode_ = checkDuplicateNodeName(count_ + 1);
                    d = new Node(nameNode_);
                }
                nodes_.add(d);
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
                    link_ = checkInt("Nhập số node con của node " + nodes_.get(i).value + ": ", error_);
                    if (link_ <= nodes_.size() - 1) {
                        break;
                    }
                    System.err.print("\t\tSố node con không được vượt quá " + (nodes_.size() - 1));
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
                    // Gán độ sâu tự động cho các node khác node gốc
                    nodes_.get(i).adjacencies[j].target.doSau = nodes_.get(i).doSau + 1;
                    System.out.println(nodes_.get(i).adjacencies[j].target.value + " có độ sâu = "
                            + nodes_.get(i).adjacencies[j].target.doSau);
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
        Set<Node> explored = new HashSet<Node>();

        ArrayList<Node> queue = new ArrayList<Node>();

        queue.add(source);
        found = false;
        while ((!queue.isEmpty()) && (!found)) {
            Node current = queue.get(0);
            queue.remove(0);
            explored.add(current);

            if (current.value.equals(goal.value)) {
                found = true;
            }
            if (current.adjacencies != null) {
                for (Edge e : current.adjacencies) {
                    Node child = e.target;
                    if ((explored.contains(child) || queue.contains(child))) {
                        continue;
                    } else if (!queue.contains(child) && child != null) {
                        child.parent = current;
                        if (current.doSau >= 0 && current.doSau <= (DS - 1)) {
                            queue.add(0, child);
                        } else if (current.doSau == DS) {
                            queue.add(child);
                        } else if (current.doSau == (DS + 1)) {
                            DS += h;
                            if (h == 1) {
                                queue.add(child);
                            } else queue.add(0, child);
                        }
                    }
                }
            }
        }

    }
}

class Node {
    public final String value; // Tên của node

    public int doSau;
    public Edge[] adjacencies; // adjacencies: Bổ sung
    public Node parent; // nút cha

    public Node(String val) {
        value = val;
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