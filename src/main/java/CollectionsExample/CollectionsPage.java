package CollectionsExample;

import java.util.*;

class Book {
    public Book(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    String nameAuthor;

    @Override
    public String toString() {
        return "Book{" +
                "nameAuthor='" + nameAuthor + '\'' +
                '}';
    }
}

public class CollectionsPage {


    public static void main(String[] args) {
        int[] array = new int[10];

        //_______________________________________________________________________________________________

        Collection collection = new ArrayList();
        collection.add("1");
        collection.add("2");
        collection.add("13");
        collection.remove("2");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println("While : Collections Array - " + iterator.next());
        }
        //THE SAME
        for (Object o : collection) {
            System.out.println("For each :Collections Array - " + o);
        }


        //_______________________________________________________________________________________________
        //Extends from Collections
        List list = new ArrayList();
        list.add("3");
        list.add("6");
        list.add("9");
        list.add("12");
        list.add("15");
        list.set(1, "7");
        System.out.println("List get index '1' - " + list.get(1));
        for (int i = 0; i < list.size(); i++) {
            System.out.println("For : List collections " + list.get(i));
        }
        //_______________________________________________________________________________________________

        //Extends from Collections
        Queue queue = new PriorityQueue();

        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");
        queue.offer("5");
        Iterator iterator1 = queue.iterator();
        while (iterator1.hasNext()) {
            System.out.println("queue - " + queue.poll());
        }

        System.out.println(queue.size());
        //_______________________________________________________________________________________________
        //Extends from Collections
        Set set = new HashSet();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        for (Object o : set) {
            System.out.println("Set - " + o);
        }
        //_______________________________________________________________________________________________


        Map map = new HashMap();
        map.put("1", "Perumov");
        map.put("2", new Book("Dancova"));
        map.put("3", "Karnegi");
        map.put("4", "Jack london");
        System.out.println("Book is - " + map.get("2"));
        Set set1 = map.entrySet();
        for (Object o : set1) {
            System.out.println(o);
        }
        Set set2 = map.keySet();
        for (Object o : set2) {
            System.out.println(o);
        }
    }
}
