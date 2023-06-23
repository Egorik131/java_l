
class HashMap {
    class Entity {
        int key;
        int value;
    }

    class Basket {
        Node head;

        class Node {
            Entity entity;
            Node next;
        }

        private boolean push(Entity entity) { // операция вставки, вставляем в конец, проверяем есть ли еще такой в списке не во всех хеш таблице
            Node node = new Node();
            node.entity = entity;

            if (head == null) {
                head = node;
            } else {
                Node cur = head;
                while (cur != null) {
                    if (cur.entity.key == entity.key) { //
                        return false;
                    }
                    if (cur.next == null) {
                        cur.next = node;
                        return true;
                    }
                    cur = cur.next;
                }
            }
            return true;
        }

        private Integer find(int key) {
            Node cur = head;
            while (cur != null) {
                if (cur.entity.key == key) {
                    return cur.entity.value; // ответ на запрос файнд
                }
                cur = cur.next;
            }
            return null;
        }

        private boolean remove(int key) {
            if (head != null) {
                if (head.entity.key == key) {
                    head = head.next;
                    return true; // если хед удалился тру
                } else {
                    Node cur = head;
                    while (cur.next != null) {
                        if (cur.next.entity.key == key) {
                            cur.next = cur.next.next;
                            return true; // если какой то объект удалился тру
                        }
                        cur = cur.next;
                    }
                }
            }
            return false; // иначе фолс
        }
    }

    static final int INIT_SIZE = 16;
    Basket[] baskets;

    public HashMap() {
        this(INIT_SIZE);
    }

    public HashMap(int size) {
        baskets = new Basket[size];
    }

    private int getIndex(int key) {
//        return key % baskets.length; //+ baskets.length) % baskets.length; // [0, length -1] для положительных значений ключа
        return (key % baskets.length + baskets.length) % baskets.length; // для отрицательных значений ключа
        // key = 22, getIndex(22) = 22 % 16 = 6 // если ключ 22 то в ингедкс 6 ячейке массива будет лежать ск лючем 22
    }

    public boolean push(int key, int value) {
        int index = getIndex(key); // ищем индекс
        Basket basket = baskets[index]; // выбираем карзину по индексу
        if (basket == null) { // проверяем карзину если 0 то создаем карзину и в массив карзинок добавляем казину
            basket = new Basket();
            baskets[index] = basket;
        }
        Entity entity = new Entity(); // добавляем сущность, ключ кей,
        entity.key = key;
        entity.value = value;
        return basket.push(entity); // помещаем во внутрь хеш таблицы  сущность (в список еще не добавили) проваливаемся в функцию пуш
    }

    public Integer find(int key) { // ищем только key
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket != null) {
            return basket.find(key);
        }
        return null;
    }

    public boolean remove(int key) { //удаляем по ключу (индекс ячейки массива хэш таблицы завист от параметра ключ)
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket != null) {
            return basket.remove(key);
        }
        return false;
    }
}
public class hash_map {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.push(-1, 2);
        map.push(17, 3);
        map.push(3, 4);

        System.out.println(map.find(-1));
        System.out.println(map.find(17));
        System.out.println(map.find(3));
        System.out.println(map.find(5));

        map.remove(17);
        System.out.println(map.find(17));
    }
}
