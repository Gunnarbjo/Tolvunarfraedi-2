import edu.princeton.cs.algs4.*;

public class prufa {
    public static void match(Nut[] a, Bolt[] b) {
        sorta(a, 0, a.length - 1, b);
    }

    private static void sorta(Nut[] a, int lo, int hi, Bolt[] b) {
        if (hi < lo)
            return;
        int part = partition(a, lo, hi, b[hi]);
        partition(b, lo, hi, a[part]);
        sorta(a, lo, part - 1, b);
        sorta(a, part + 1, hi, b);
    }

    private static int partition(Nut[] a, int lo, int hi, Bolt v) {
        int i = lo;

        for (int j = lo; j < hi; j++) {
            if (a[j].compareTo(v) > 0) {
                switchN(a, i, j);
                i++;
            } else if (a[j].compareTo(v) == 0) {
                switchN(a, j, hi);
                j--;
            }
        }

        switchN(a, i, hi);
        return i;
    }

    private static void switchN(Nut[] n, int i, int j) {
        Nut temp1 = n[i];
        n[i] = n[j];
        n[j] = temp1;
    }

    private static int partition(Bolt[] b, int lo, int hi, Nut v) {
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (v.compareTo(b[j]) < 0) {
                switchB(b, i, j);
                i++;
            } else if (v.compareTo(b[j]) == 0) {
                switchB(b, j, hi);
                j--;
            }
        }
        switchB(b, i, hi);
        return i;
    }

    private static void switchB(Bolt[] b, int i, int j) {
        Bolt temp2 = b[i];
        b[i] = b[j];
        b[j] = temp2;
    }


    private static String prenta(Nut[] x) {
    String s = "";
    for (Nut n : x) {
    s += n.value + " ";
    }
    return s;
    }

    private static String prenta(Bolt[] x) {
        String s = "";
        for (Bolt b : x) {
            s += b.value + " ";
       }
        return s;
    }

    public static void main(String[] args) {
        Nut[] a = { new Nut(1), new Nut(2), new Nut(3), new Nut(4) };
        Bolt[] b = { new Bolt(4), new Bolt(1), new Bolt(3), new Bolt(2)};

        System.out.println(prenta(a));
        System.out.println(prenta(b));

        match(a, b);

        System.out.println(prenta(a));
        System.out.println(prenta(b));
    }
}
