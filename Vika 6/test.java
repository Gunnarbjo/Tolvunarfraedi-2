import edu.princeton.cs.algs4.*;

public class test<Key extends Comparable<Key>> {
    private MaxPQ<Key> maxpq;
    private MinPQ<Key> minpq;

    public test() {
        // búið bæði trén
        maxpq = new MaxPQ<Key>(); // geymir stök frá miðju og niður
        minpq = new MinPQ<Key>(); // geymir stök frá miðju og upp
    }

    public Key findMedian() {
        int maxSize = maxpq.size();
        int minSize = minpq.size();

        if (maxpq.isEmpty() && minpq.isEmpty()) return null; // kemur í veg fyrir stack underflow
        else if (maxSize == minSize || maxSize > minSize) return maxpq.max(); // skilar miðjunni, rót í vinstra trénu
        else return minpq.min(); // skilar miðjunni, rót í hægra trénu
    }

    public Key deleteMedian() {
        int maxSize = maxpq.size();
        int minSize = minpq.size();
        Key deleted = null; // frumstilla skilagildið

        if (maxpq.isEmpty() && minpq.isEmpty()) return null; // kemur í veg fyrir stack underflow
        else if (maxpq.isEmpty() || minpq.isEmpty()) {
            if (maxpq.isEmpty()) deleted = minpq.delMin();
            else deleted = maxpq.delMax();
        }
        else if (maxSize == minSize || maxSize > minSize) deleted = maxpq.delMax(); // eyðir miðju, rót í vinstra trénu
        else deleted = minpq.delMin(); // eyðir miðju, rót í hægra trénu
        return deleted;
    }

    public void insert(Key key) {
        if (maxpq.isEmpty() || key.compareTo(maxpq.max()) < 0) maxpq.insert(key); // setur inn í vinstra tréð ef key er minna en rótin
        else minpq.insert(key); // setur inn í hægra tréð

        // passar að hæðarmunur á trjánum verði aldrei meiri en 1
        // ef hæðarmunur er meiri en einn, taka rót stærra trésins og setja í minna tréð

        if (maxpq.size() > minpq.size()+1) minpq.insert(maxpq.delMax());
        else if (minpq.size() > maxpq.size()+1) maxpq.insert(minpq.delMin());
    }

    public static void main(String[] args) {
        MedianFinder<String> m = new MedianFinder<String>();

        m.insert("A");
        m.insert("B");
        m.insert("C");
        m.insert("D");
        m.insert("E");

        System.out.println(m.findMedian());
        m.deleteMedian();
        System.out.println(m.findMedian());
        m.deleteMedian();
        System.out.println(m.findMedian());
        m.deleteMedian();
        System.out.println(m.findMedian());
        m.deleteMedian();
        System.out.println(m.findMedian());
        m.deleteMedian();
        System.out.println(m.findMedian());
    }
}
