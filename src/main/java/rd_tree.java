import java.util.Scanner;

class RedBlackTree {
    private Node root;

    class Node {
        int value;
        Node left;
        Node right;
        Color color;
        //boolean color; // true = RED, false = BLACK
    }

    enum Color {
        BLACK,
        RED
    }

    public void insert(int value) {
        if (root == null) {//обход начинаем с корня (он может быть пустой или нет)
            root = new Node();
            root.value = value;
            root.color = Color.BLACK;
        } else {
            insert(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
        }
//        root.color = Color.BLACK;
        //root.color = false;
    }

    private void insert(Node node, int value) {
        if (node.value != value) {
            if (node.value < value) { // вставка вправо если выполняется
                if (node.right == null) { // проверяем существование правой
                    node.right = new Node(); // если пусто то создаем справа потомка
                    node.right.value = value;
                    node.right.color = Color.RED;
                } else {
                    insert(node.right, value);
                    node.right = rebalance(node.right);
                }
            } else {                          // тоже самое слева
                if (node.left == null) {
                    node.left = new Node();
                    node.left.value = value;
                    node.left.color = Color.RED;
                } else {
                    insert(node.left, value);
                    node.left = rebalance(node.left);
                }
            }
        }
    }

    private Node rightSwap(Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }

    private Node leftSwap(Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }

    private void colorChange(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;

    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.right != null && result.right.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.left.left != null && result.left.left.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.right != null && result.right.color == Color.RED) {
                needRebalance = true;
                colorChange(result);
            }
        }
        while (needRebalance);
        return result;
    }


    public Node find(int value) {
        return find(root, value);
    }

    private Node find(Node node, int value) {
        if (node == null) {//если нода пустая но нулл
            return null;
        }
        if (node.value == value) {
            return node;
        }
        if (node.value < value) { //иначе классический бинарный поиск рекурсивный
            return find(node.right, value);
        } else {
            return find(node.left, value);
        }
    }
}


public class rd_tree {
    public static void main(String[] args) {

        RedBlackTree tree = new RedBlackTree();
//        for (int i = 1; i <= 10; i++)
//            tree.insert(i);
        int count = 10;
        Scanner in = new Scanner(System.in);
        for (int i = 1; i <= count; i++) {
            System.out.print("Input a number: ");
            int num = in.nextInt();
            tree.insert(num);

        }
        in.close();
    }
}
