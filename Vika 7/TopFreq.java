  import edu.princeton.cs.algs4.*;
  import java.util.ArrayList;
  import java.util.Arrays;

  public class TopFreq{
    public static void minAdferd(int k, int N){
      ArrayList<String> words = new ArrayList<String>();
      while(!StdIn.isEmpty()){
        String word = StdIn.readString();
        if(word.length() >= k){
          words.add(word);
        }
      }
      String[] array = new String[words.size()];
      array = words.toArray(array);
      Arrays.sort(array);

      String[] wordes = new String[N];
      int[] endt = new int[N];
      int cnt = 1;

      for (int i = 1; i < array.length; i++) {
           if (array[i].equals(array[i - 1]))
               cnt++;
           else {
               for (int j = 0; j < wordes.length; j++) {
                   if (endt[j] < cnt) {
                      int tempE = endt[j];
                      String tempW = wordes[j];
                       endt[j] = cnt;
                       wordes[j] = array[i - 1];
                       int t = j+1;
                       while(t <= wordes.length){
                         if(endt[t] < tempE){
                          int tempEn = endt[t];
                          String tempWo = wordes[t];
                          endt[t] = tempE;
                          wordes[t] = tempW;
                          tempE = tempEn;
                          tempW = tempWo;
                          t++;
                         }
                       }
                       break;
                   }
               }
               cnt = 1;
           }
       }
      for(int i = 0; i < wordes.length; i++){
        StdOut.println(endt[i] + " " + wordes[i]);
      }
    }
    public static void bokAdferd(int k,int N){

      int minlen = k; // key-length cutoff
      ST<String, Integer> st = new ST<String, Integer>();
      while (!StdIn.isEmpty())
      { // Build symbol table and count frequencies.
        String word = StdIn.readString();
        if (word.length() < minlen) continue; // Ignore short keys.
        if (!st.contains(word)) st.put(word, 1);
        else st.put(word, st.get(word) + 1);
      }
      for(int i = 0; i < N; i++){
        // Find a key with the highest frequency count.
        String max = "";
        st.put(max, 0);
        for (String word : st.keys())
        if (st.get(word) > st.get(max))
        max = word;
        StdOut.println(max + " " + st.get(max));
        st.delete(max);
        }
      }
      public static void main(String [] args){
      int k = Integer.parseInt(args[0]);
      int N = Integer.parseInt(args[1]);

      Stopwatch minKlukka = new Stopwatch();
      minAdferd(k,N);
      //bokAdferd(k,N);
      double mintimi = minKlukka.elapsedTime();
      StdOut.println(mintimi);
    }
  }
