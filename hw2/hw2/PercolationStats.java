package hw2;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;
public class PercolationStats {
    private Percolation p;
    private double[] possibility;
    private double confidenceLow;
    private double confidenceHigh;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        possibility = new double[T];
        for (int i = 0; i < T; i++) {
            p = pf.make(N);
            while (!p.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                while (p.isOpen(row, col)) {
                    row = StdRandom.uniform(N);
                    col = StdRandom.uniform(N);
                }
                p.open(row, col);
            }
            possibility[i] = (double) p.numberOfOpenSites() / (N * N);
        }
        confidenceLow = mean() - 1.96 * stddev() / Math.sqrt((double) T);
        confidenceHigh = mean() + 1.96 * stddev() / Math.sqrt((double) T);

    }  // perform T independent experiments on an N-by-N grid
    public double mean() {
        return StdStats.mean(possibility);
    }                                          // sample mean of percolation threshold
    public double stddev() {
        return StdStats.stddev(possibility);
    }                                        // sample standard deviation of percolation threshold
    public double confidenceLow() {
        return confidenceLow;
    }                                 // low endpoint of 95% confidence interval
    public double confidenceHigh() {
        return confidenceHigh;
    }                                 // high endpoint of 95% confidence interval
}
