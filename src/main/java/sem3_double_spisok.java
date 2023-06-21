class List {
    static Node head;
    static Node tail; //2


    static class Node {
        int value;
        Node next;
        Node prev; //2
    }

    public static void pushFront(int value) {
        Node node = new Node(); // выделяем память под ноду
        node.value = value; // ее значение равно валуе

        if (head == null) {//2
            tail = node;//2
        } else {//2
            node.next = head;
            head.prev = node;//2
        }
        head = node;
    }

    public static void popFront() {
        if (head != null) {//2
            if (head.next == null) {//2
                head = null;
                tail = null;//2
            } else {
                head = head.next;//2
                head.prev = null;//2
            }
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

        if (tail == null) {//2
            head = node;//2
        } else {//2
            node.prev = tail;
            head.next = node;//2
        }
        tail = node;
    }

    public static void popBack() {
        if (tail != null) {//2
            if (tail.prev == null) {//2
                head = null;
                tail = null;//2
            } else {
                tail = tail.prev;//2
                tail.next = null;//2
            }
        }
    }

    // сортировка пузырьком (c flaf)
    public static void sort() {
        boolean needSort = true;
        do {
            needSort = false;
            Node node = head;
            while (node != null && node.next != null) {
                if (node.value > node.next.value) {
                    Node before = node.prev;
                    Node cur = node;
                    Node next = node.next;
                    Node after = next.next;

                    cur.next = after;
                    cur.prev = next;
                    next.next = cur;
                    next.prev = before;

                    if (before != null) {
                        before.next = next;
                    } else {
                        head = next;
                    }
                    if (after != null) {
                        after.prev = cur;
                    } else {
                        tail = cur;
                    }

                    needSort = true;
                }
                node = node.next;
            }

        } while (needSort);

    }


}

public class sem3_double_spisok {
    public static void main(String[] args) {
        List list = new List();
        for (int i = 1; i <= 10; i++) {
            list.pushFront(i);
        }
//        list.print();
//
//        list.popFront();
//        list.popFront();
//
//        list.print();
//
//        list.pushBack(7);
//
//        list.print();
//
//        list.popBack();
        list.sort();


        list.print();
    }
}
