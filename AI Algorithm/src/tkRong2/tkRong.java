package tkRong2;

import java.util.*;

public class tkRong {
    public static Scanner sc = new Scanner(System.in);
    public static boolean found = false;

    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        Node J = new Node("J");

        Node U = new Node("U");

        A.link = new nodeChild[]{
                new nodeChild(B),
                new nodeChild(C),
                new nodeChild(D)
        };
        B.link = new nodeChild[]{
                new nodeChild(E),
                new nodeChild(F)
        };
        C.link = new nodeChild[]{
                new nodeChild(F),
                new nodeChild(G)
        };
        E.link = new nodeChild[]{
                new nodeChild(H),
                new nodeChild(I)
        };
        F.link = new nodeChild[]{
                new nodeChild(J)
        };

        timKiem(A, G);

        List<Node> duongDi = duongDi(G);
        System.out.println("================== Tìm kiếm rộng ==================");
        if (found) {
            System.out.println("Đường đi từ " + A + " -> " + G + " là: ");
            for (Node a : duongDi) {
                System.out.print(a.toString());
                if (a != duongDi.get(duongDi.size() - 1))
                    System.out.print(" -> ");
            }
        } else {
            System.out.println("Không tìm thấy đường đi từ node " + A + " -> " + G);
        }
    }

    public static LinkedList<Node> duongDi(Node target) {
        LinkedList<Node> path = new LinkedList<Node>();

        for (Node node = target; node != null; node = node.parent) {
            path.add(node);
        }

        Collections.reverse(path);

        return path;
    }

    public static void timKiem(Node source, Node goal) {
        // Tập DONG
        Set<Node> DONG = new HashSet<Node>();
        // Tập MO
        Queue<Node> MO = new LinkedList<Node>();

        MO.add(source);
        found = false;
        while ((!MO.isEmpty()) && (!found)) {
            // Nút S
            Node current = MO.poll(); // Lấy ra phần tử đầu tiên của tập MO xong xóa nó khỏi MO
            DONG.add(current);

            if (current.value.equals(goal.value)) {
                found = true;
            }
            if (current.link != null) {
                for (nodeChild e : current.link) {
                    Node child = e.target;

                    if (DONG.contains(child) || MO.contains(child)) {
                        continue;
                    } else if (!MO.contains(child)) {
                        child.parent = current;
                        MO.add(child);
                    }
                }
            }
        }
    }

}

class Node {

    public final String value;
    public nodeChild[] link;
    public Node parent;

    public Node(String val) {
        value = val;
    }

    public String toString() {
        return value;
    }

}

class nodeChild {
    public final Node target;

    public nodeChild(Node targetNode) {
        target = targetNode;
    }
}
