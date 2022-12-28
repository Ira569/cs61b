package hw2;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private int openNum;
    private WeightedQuickUnionUF sites;
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
        for (int i = 0; i< n; i++) {
            sites.union(i,N * N);
        }
        isOpen = new boolean[N * N];


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
        int up = xyTo1D(row - 1, col);
        int down = xyTo1D(row + 1, col);
        int left = xyTo1D(row, col-1);
        int right = xyTo1D(row, col+1);
        if(up >= 0 && up < n*n && isOpen[up]) {
            sites.union(up,pos);
        }
        if( down >= 0 && down < n*n && isOpen[down]) {
            sites.union(down,pos);
        }
        if(left >= 0 && left < n*n && isOpen[left]) {
            sites.union(left,pos);
        }
        if(right >= 0 && right < n*n && isOpen[right]) {
            sites.union(right,pos);
        }

        if (row == n-1 && sites.connected(pos,n * n)) {
            sites.union(pos, n * n + 1);
        }


    }      // open the site (row, col) if it is not open already
    public boolean isOpen(int row, int col) {
        if (row < 0 || col < 0 || row > this.n - 1 || col > this.n-1) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return isOpen[xyTo1D(row, col)];
    } // is the site (row, col) open?
    public boolean isFull(int row, int col) {
        /*if (row < 0 || col < 0 || row > this.n - 1 || col > this.n-1) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (isOpen(row, col)) {
            for (int i = 0; i < n; i += 1) {
                if (sites.connected(xyTo1D(row, col), i)) {
                    return true;
                }
            }
        }
        return false;*/

        return  isOpen(row, col) && sites.connected(xyTo1D(row, col), n * n);
    } // is the site (row, col) full?
    public int numberOfOpenSites() {
        return openNum;
    }          // number of open sites
    public boolean percolates() {
        return sites.connected(n * n, n * n + 1);
    }             // does the system percolate?
    public static void main(String[] args) {
       /*PercolationStats pstats = new PercolationStats(100,10000,new PercolationFactory());
       System.out.println(pstats.mean());
       System.out.println(pstats.stddev());
       System.out.println(pstats.confidenceLow());
       System.out.println(pstats.confidenceHigh());8*/


    }  // use for unit testing (not required)

}
