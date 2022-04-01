import edu.princeton.cs.algs4.*;

public class MedianFinder<Key extends Comparable<Key>> {
  private MaxPQ<Key> maxpq;
  private MinPQ<Key> minpq;

  public MedianFinder() {
    //Búa til maxpq,minpq
      MaxPQ maxpq = new MaxPQ<Key>();
      MinPQ minpq = new MinPQ<Key>();

  }

  public Key findMedian() {
    if(minpq.isEmpty() && maxpq.isEmpty()){
      return null;
    }
    if(minpq.size() >= maxpq.size()){
      return maxpq.max();
    }else
      return minpq.min();
  }

  public Key deleteMedian() {
    Key del = null;

    if (maxpq.isEmpty() && minpq.isEmpty()){
       return null;
     }
    else if (maxpq.isEmpty() || minpq.isEmpty()) {
       if (maxpq.isEmpty()) del = minpq.delMin();
       else del = maxpq.delMax();
    }
    else if (maxpq.size() >= minpq.size()){
      del = maxpq.delMax();
    }
    else del = minpq.delMin();
    return del;
  }

  public void insert(Key key) {
    if (maxpq.isEmpty() || key.compareTo(maxpq.max()) < 0){
      maxpq.insert(key);
    }else{
      minpq.insert(key);
    }

    if (maxpq.size() - minpq.size() > 1){
      minpq.insert(maxpq.delMax());
      }
    else if (minpq.size() - maxpq.size() > 1){
      maxpq.insert(minpq.delMin());
      }
    }

  public static void main(String[] args) {
    MedianFinder<String> m = new MedianFinder<String>();

    m.insert("A");
    m.insert("B");
    m.insert("C");
    m.insert("D");
    m.insert("E");
    /*System.out.println(m.findMedian());
    m.deleteMedian();
    /*System.out.println(m.findMedian());
    m.deleteMedian();
    System.out.println(m.findMedian());
    m.deleteMedian();
    System.out.println(m.findMedian());
    m.deleteMedian();
    System.out.println(m.findMedian());
    m.deleteMedian();
    System.out.println(m.findMedian());*/
  }


}
