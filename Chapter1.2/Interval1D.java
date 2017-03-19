/******************************************************************************
 *  Compilation:  javac Interval1D.java
 *  Execution:    java Interval1D
 *  Dependencies: StdOut.java
 *  
 *  1-dimensional interval data type.
 *
 ******************************************************************************/

import java.util.Arrays;
import java.util.Comparator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

/**
 *  The {@code Interval1D} class represents a one-dimensional interval.
 *  The interval is <em>closed</em>???it contains both endpoints.
 *  Intervals are immutable: their values cannot be changed after they are created.
 *  The class {@code Interval1D} includes methods for checking whether
 *  an interval contains a point and determining whether two intervals intersect.
 *  <p>
 *  For additional documentation, 
 *  see <a href="http://algs4.cs.princeton.edu/12oop">Section 1.2</a> of 
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne. 
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Interval1D {

    /**
     * Compares two intervals by min endpoint.
     */
    public static final Comparator<Interval1D> MIN_ENDPOINT_ORDER  = new MinEndpointComparator();

    /**
     * Compares two intervals by max endpoint.
     */
    public static final Comparator<Interval1D> MAX_ENDPOINT_ORDER = new MaxEndpointComparator();

    /**
     * Compares two intervals by length.
     */
    public static final Comparator<Interval1D> LENGTH_ORDER = new LengthComparator();

    private final double min;
    private final double max;

    /**
     * Initializes a closed interval [min, max].
     *
     * @param  min the smaller endpoint
     * @param  max the larger endpoint
     * @throws IllegalArgumentException if the min endpoint is greater than the max endpoint
     * @throws IllegalArgumentException if either {@code min} or {@code max}
     *         is {@code Double.NaN}, {@code Double.POSITIVE_INFINITY} or
     *         {@code Double.NEGATIVE_INFINITY}

     */
    public Interval1D(double min, double max) {
        if (Double.isInfinite(min) || Double.isInfinite(max))
            throw new IllegalArgumentException("Endpoints must be finite");
        if (Double.isNaN(min) || Double.isNaN(max))
            throw new IllegalArgumentException("Endpoints cannot be NaN");

        // convert -0.0 to +0.0
        if (min == 0.0) min = 0.0;
        if (max == 0.0) max = 0.0;

        if (min <= max) {
            this.min = min;
            this.max = max;
        }
        else throw new IllegalArgumentException("Illegal interval");
    }

    /**
     * Returns the left endpoint of this interval.
     *
     * @return the left endpoint of this interval
     * @deprecated Replaced by {@link #min()}.
     */
    @Deprecated
    public double left() { 
        return min;
    }

    /**
     * Returns the right endpoint of this interval.
     * @return the right endpoint of this interval
     * @deprecated Replaced by {@link #max()}.
     */
    @Deprecated
    public double right() { 
        return max;
    }

    /**
     * Returns the min endpoint of this interval.
     *
     * @return the min endpoint of this interval
     */
    public double min() { 
        return min;
    }

    /**
     * Returns the max endpoint of this interval.
     *
     * @return the max endpoint of this interval
     */
    public double max() { 
        return max;
    }

    /**
     * Returns true if this interval intersects the specified interval.
     *
     * @param  that the other interval
     * @return {@code true} if this interval intersects the argument interval;
     *         {@code false} otherwise
     */
    public boolean intersects(Interval1D that) {
        if (this.max < that.min) return false;
        if (that.max < this.min) return false;
        return true;
    }

    /**
     * Returns true if this interval contains the specified value.
     *
     * @param x the value
     * @return {@code true} if this interval contains the value {@code x};
     *         {@code false} otherwise
     */
    public boolean contains(double x) {
        return (min <= x) && (x <= max);
    }

    /**
     * Returns the length of this interval.
     *
     * @return the length of this interval (max - min)
     */
    public double length() {
        return max - min;
    }

    /**
     * Returns a string representation of this interval.
     *
     * @return a string representation of this interval in the form [min, max]
     */
    public String toString() {
        return "[" + min + ", " + max + "]";
    }

    /**
     * Compares this transaction to the specified object.
     *
     * @param  other the other interval
     * @return {@code true} if this interval equals the other interval;
     *         {@code false} otherwise
     */
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Interval1D that = (Interval1D) other;
        return this.min == that.min && this.max == that.max;
    }

    /**
     * Returns an integer hash code for this interval.
     *
     * @return an integer hash code for this interval
     */
    public int hashCode() {
        int hash1 = ((Double) min).hashCode();
        int hash2 = ((Double) max).hashCode();
        return 31*hash1 + hash2;
    }

    // ascending order of min endpoint, breaking ties by max endpoint
    private static class MinEndpointComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            if      (a.min < b.min) return -1;
            else if (a.min > b.min) return +1;
            else if (a.max < b.max) return -1;
            else if (a.max > b.max) return +1;
            else                    return  0;
        }
    }

    // ascending order of max endpoint, breaking ties by min endpoint
    private static class MaxEndpointComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            if      (a.min < b.max) return -1;
            else if (a.min > b.max) return +1;
            else if (a.min < b.min) return -1;
            else if (a.min > b.min) return +1;
            else                    return  0;
        }
    }

    // ascending order of length
    private static class LengthComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            double alen = a.length();
            double blen = b.length();
            if      (alen < blen) return -1;
            else if (alen > blen) return +1;
            else                  return  0;
        }
    }




    /**
     * Unit tests the {@code Interval1D} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Interval1D[] inters = new Interval1D[N];
        for (int i = 0; i < N; i++) {
            double i1 = StdIn.readDouble();
            double i2 = StdIn.readDouble();
            Interval1D inter = new Interval1D(i1, i2);
            inters[i] = inter;
        }
        
        for (int i = 0; i < inters.length; i++) {
            for (int j = i + 1; j < inters.length; j++) {
                if (inters[i].intersects(inters[j]))
                    StdOut.println(inters[i] + " intersects with " + inters[j]);
            }
        }
    }
}