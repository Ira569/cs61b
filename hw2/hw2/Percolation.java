package hw2;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private int openNum;
    private WeightedQuickUnionUF sites;
    private WeightedQuickUnionUF sites2;
    private boolean[] isOpen;

    private int xyTo1D(int r, int c) {
       return r * this.n + c;
    }
    public Percolation(int N) {
        if (N <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.n = N;
        openNum = 0;
        sites = new WeightedQuickUnionUF(N * N + 2);// N*N represent top, N*N+1 represent bottom
        sites2 = new WeightedQuickUnionUF(N * N + 2);
        for (int i = 0; i< n; i++) {
            sites.union(i,N * N);
            sites2.union(i,N * N);
        }

        isOpen = new boolean[N * N];
        for (int i = 0; i< n; i++) {
            sites.union(n * n - 1 - i, n * n + 1);
        }

    }              // create N-by-N grid, with all sites initially blocked
    public void open(int row, int col) {
        if (row < 0 || col < 0 || row > this.n - 1 || col > this.n-1) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (!isOpen(row, col)) {
            isOpen[xyTo1D(row, col)] = true;
            openNum += 1;
        }
        int pos = xyTo1D(row, col);
        int near;
        if (row + 1 < n) {
            near = xyTo1D(row + 1, col);
            if(isOpen[near]) {
                sites.union(near,pos);
                sites2.union(near,pos);
            }
        }
        if (row - 1 >= 0) {
            near = xyTo1D(row - 1, col);
            if(isOpen[near]) {
                sites.union(near,pos);
                sites2.union(near,pos);
            }
        }
        if (col + 1 < n) {
            near = xyTo1D(row, col + 1);
            if(isOpen[near]) {
                sites.union(near,pos);
                sites2.union(near,pos);
            }
        }
        if (col - 1 >= 0) {
            near = xyTo1D(row, col - 1);
            if(isOpen[near]) {
                sites.union(near,pos);
                sites2.union(near,pos);
            }
        }



    }      // open the site (row, col) if it is not open already
    public boolean isOpen(int row, int col) {
        if (row < 0 || col < 0 || row > this.n - 1 || col > this.n-1) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return isOpen[xyTo1D(row, col)];
    } // is the site (row, col) open?
    public boolean isFull(int row, int col) {
        return  isOpen(row, col) && sites2.connected(xyTo1D(row, col), n * n);
    } // is the site (row, col) full?
    public int numberOfOpenSites() {
        return openNum;
    }          // number of open sites
    public boolean percolates() {
        if (n == 1) {
            return isOpen(0,0);
        }
        return sites.connected(n * n, n * n + 1);
    }             // does the system percolate?
    public static void main(String[] args) {
       PercolationStats test = new PercolationStats(100,1000,new PercolationFactory());
       System.out.println(test.mean());
       System.out.println(test.stddev());



    }  // use for unit testing (not required)

}
