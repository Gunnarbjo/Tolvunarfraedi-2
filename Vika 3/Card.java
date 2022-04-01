import edu.princeton.cs.algs4.*;

public class Card implements Comparable<Card> {
  private int suit;
  private int rank;

  public Card (int suit, int rank){
    this.suit = suit;
    this.rank = rank;
  }
  public int compareTo(Card that){
    if(this.suit < that.suit) return -1;
    if(this.suit > that.suit) return 1;

    //eftir að klára þetta með röð innan sortar
    if(this.rank == 1 && that.rank == 1) return 0;
    if(this.rank == 1 && that.rank != 1) return 1;
    if(this.rank != 1 && that.rank == 1) return -1;
    if(this.rank < that.rank) return -1;
    if(this.rank > that.rank) return 1;
    return 0;
  }
  public static void main(String[] args){
    Card spadaAs = new Card(0,1);
    Card spadaAsTvo = new Card(0,1);
    Card spadaTvistur = new Card(0,2);
    Card spadaTvisturTvo = new Card(0,2);
    Card hjartaAs = new Card(1,2);

    StdOut.println("spadaas vs spadaas " + spadaAs.compareTo(spadaAsTvo));
    StdOut.println("spadatvistur vs spadaas " + spadaTvistur.compareTo(spadaAs));
    StdOut.println("spadatvistur vs spadatvistur " + spadaTvistur.compareTo(spadaTvisturTvo));

      }
    }
