class List_2 {
    static Node head;

    static class Node {
        int value;
        Node next;
    }

    public static void pushFront(int value) {
        Node node = new Node(); // выделяем память под ноду
        node.value = value; // ее значение равно валуе
        node.next = head;
        head = node;
    }

    public static void popFront() {
        if (head != null) {
            head = head.next;
        }
    }

    // метод вывода списка
    public static void print() {
        Node cur = head;
        while (cur != null) {
            System.out.printf("%d ", cur.value);
            cur = cur.next;
        }
        System.out.println();
    }

    // Функция вхождения
    public static boolean contains(int value) {
        Node cur = head;
        while (cur != null) {
            if (cur.value == value) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public static void pushBack(int value) {
        Node node = new Node();
        node.value = value;

        if (head == null) {
            head = node;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public static void popBack() {
        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                Node cur = head;
                while (cur.next.next != null) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
    }
}

public class sem3_str_odn_spisok {
    public static void main(String[] args) {
        List_2 list = new List_2();
        for (int i = 1; i <= 5; i++) {
            list.pushFront(i);
        }
        list.print();

        list.popFront();
        list.popFront();

        list.print();

        list.pushBack(7);

        list.print();

        list.popBack();

        list.print();
    }
}
