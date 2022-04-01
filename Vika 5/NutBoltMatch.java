import edu.princeton.cs.algs4.*;
public class NutBoltMatch {
  public static void match(Nut[] a, Bolt[] b) {
    findSame(a, b, 0, a.length-1);
  }
  private static void findSame(Nut[] a, Bolt[] b, int begin, int end){
    if(end <= begin){
      return;
    }
    int split = splitNuts(a, begin, end, b[end]);
    splitBolts(b, begin, end, a[split]);
    findSame(a, b, begin, split - 1);
    findSame(a, b, split + 1, end);
  }
  //Sér um Nuts
  private static int splitNuts(Nut[] a, int begin, int end, Bolt b){
    int j = begin;

    for(int i = begin; i < end; i++){
      if(a[i].compareTo(b) > 0){
        switchNuts(a, j, i);
        j++;
      }else if(a[i].compareTo(b) == 0){
        switchNuts(a, i, end);
        i--;
      }
    }
    switchNuts(a, j , end);
    return j;
  }
  private static void switchNuts(Nut[] a, int j, int i){
    Nut temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }
  //Sér um Bolts
  private static int splitBolts(Bolt[] b,int begin, int end, Nut a){
    int j = begin;

    for(int i = begin; i < end; i++){
      if(a.compareTo(b[i]) < 0){
        switchBolts(b, j, i);
        j++;
      }else if(a.compareTo(b[i]) == 0){
        switchBolts(b, i, end);
        i--;
      }
    }
    switchBolts(b, j , end);
    return j;
  }
  private static void switchBolts(Bolt[] b, int j, int i){
    Bolt temp = b[j];
    b[j] = b[i];
    b[i] = temp;
  }

}
