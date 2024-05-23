package tkRong;

import java.util.*;

// Tìm kiếm rộng
public class tkRong {
    public static Scanner sc = new Scanner(System.in);
    public static List<Node> nodes_ = new ArrayList<Node>();
    public static boolean found = false;

    public static void main(String[] args) {
//        Node A = new Node("A");
//        Node B = new Node("B");
//        Node C = new Node("C");
//        Node D = new Node("D");
//        Node E = new Node("E");
//        Node F = new Node("F");
//        Node G = new Node("G");
//        Node H = new Node("H");
//        Node I = new Node("I");
//        Node J = new Node("J");
//
//        Node U = new Node("U");
//
//        A.adjacencies = new Edge[]{
//                new Edge(B),
//                new Edge(C),
//                new Edge(D)
//        };
//        B.adjacencies = new Edge[]{
//                new Edge(E),
//                new Edge(F)
//        };
//        C.adjacencies = new Edge[]{
//                new Edge(F),
//                new Edge(G)
//        };
//        E.adjacencies = new Edge[]{
//                new Edge(H),
//                new Edge(I)
//        };
//        F.adjacencies = new Edge[]{
//                new Edge(J)
//        };
//
//
//        D.adjacencies = new Edge[0];
//        G.adjacencies = new Edge[0];
//        H.adjacencies = new Edge[0];
//        I.adjacencies = new Edge[0];
//        J.adjacencies = new Edge[0];
//
//        Search(A, F);
//
//        List<Node> path = printPath(F);
//
//        if (found) {
//            System.out.println("Path: " + path);
//        } else {
//            System.out.println("Không tìm thấy đường đi");
//        }
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
                nodes_.add(new Node(nameNode_));
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

        Set<Node> explored = new HashSet<Node>();

        ArrayList<Node> queue = new ArrayList<Node>();

        //cost from start

        queue.add(source);
        found = false;
        while ((!queue.isEmpty()) && (!found)) {
            Node current = queue.get(0);
            queue.remove(0);
            explored.add(current);

            if (current.value.equals(goal.value)) {
                found = true;
            }

            //if (current.adjacencies != null) {
            for (Edge e : current.adjacencies) {
                Node child = e.target;

                if (explored.contains(child) || queue.contains(child)) {
                    continue;
                } else if (!queue.contains(child)) {
                    child.parent = current;
                    queue.add(child);

                }

            }
            // }
        }

    }

}

class Node {

    public final String value;
    public Edge[] adjacencies;
    public Node parent;

    public Node(String val) {
        value = val;
    }

    public String toString() {
        return value;
    }

}

class Edge {
    public final Node target;

    public Edge(Node targetNode) {
        target = targetNode;
    }
}
