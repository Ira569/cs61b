package hw3.hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        boolean res = true;
        int N = oomages.size();
        List<Oomage> [] lists = (LinkedList<Oomage> []) new LinkedList<?>[M];
        for (int i = 0; i < M; i++) {
           lists[i] = new LinkedList<Oomage>();
        }
        int bucketNum;
        for (int i = 0; i < oomages.size(); i += 1) {
            bucketNum = (oomages.get(i).hashCode() & 0x7FFFFFFF) % M;
            lists[bucketNum].add(oomages.get(i));
        }
        for (int i = 0; i < M; i++) {
            if (lists[i].size() < N / 50.0 || lists[i].size() > N / 2.5) {
                res = false;
                break;
            }
        }
        return res;
    }
}
