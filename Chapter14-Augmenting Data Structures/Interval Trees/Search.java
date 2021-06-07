/**
 * @author AJWuu
 */

package intervalTree;

public class Search {

	public static <T extends Comparable<T>> boolean isExact(interval<T> a, interval<T> b) {
		int cmp = a.low.compareTo(b.low);
		if (cmp == 0) {
			cmp = a.high.compareTo(b.high);
			if (cmp == 0) {
				return true;
			}
		}
		return false;
	}

	public static <T extends Comparable<T>> boolean overlap(interval<T> a, interval<T> b) {
		boolean condition = (a.low.compareTo(b.low) > 0 && a.low.compareTo(b.high) < 0)
							|| (a.high.compareTo(b.low) > 0 && a.high.compareTo(b.high) < 0)
							|| (b.low.compareTo(a.low) > 0 && b.high.compareTo(a.high) < 0)
							|| (b.high.compareTo(a.low) > 0 && b.high.compareTo(a.high) < 0);
		if (condition) {
			return true;
		}
		else {
			return false;
		}
	}

	public static <T extends Comparable<T>> ITNode<T> searchExact(IntervalTree<T> itt, interval<T> i) {
		ITNode<T> x = itt.getRoot();
		boolean isExact;
		int cmp;
		while (x != null) {
			isExact = isExact(i, x.interval);
			if (isExact == false) {
				if (x.left != null) {
					cmp = x.interval.low.compareTo(i.low);
					if (cmp > 0) {
						x = x.left;
					}
					else {
						x = x.right;
					}
				}
				else {
					x = x.right;
				}
			}
			else {
				return x;
			}
		}
		return null;
	}

	public static <T extends Comparable<T>> ITNode<T> firstOverlap(IntervalTree<T> itt, interval<T> i) {
		ITNode<T> x = itt.getRoot();
		if (x == null) {
			return null;
		}

		boolean overlap;
		int cmp;
		while (x != null) {
			overlap = overlap(i, x.interval);
			if (overlap == false) {
				if (x.left != null) {
					cmp = x.left.max.compareTo(i.low);
					if (cmp > 0) {
						x = x.left;
					}
					else {
						x = x.right;
					}
				}
				else {
					x = x.right;
				}
			}
			else {
				return x;
			}
		}
		return null;
	}

	public static <T extends Comparable<T>> void allOverlap(IntervalTree<T> itt, ITNode<T> x, interval<T> i) {
		if (x == null) {
			return ;
		}

		int cmp;
		boolean overlap = overlap(i, x.interval);
		if (overlap == true) {
			System.out.print("[" + x.interval.low + "," + x.interval.high + ") ");
		}
		if (x.left != null) {
			cmp = i.low.compareTo(x.left.max);
			if (cmp < 0) {
				allOverlap(itt, x.left, i);
			}
		}
		if (x.right != null) {
			cmp = i.high.compareTo(x.interval.low);
			if (cmp > 0) {
				cmp = i.low.compareTo(x.right.max);
				if (cmp < 0) {
					allOverlap(itt, x.right, i);
				}
			}
		}
	}

	public static <T extends Comparable<T>> void allSameHigh(IntervalTree<T> itt, ITNode<T> x, interval<T> i) {
		if (x == null) {
			return ;
		}

		if (i.high.compareTo(x.interval.high) == 0) {
			System.out.print("[" + x.interval.low + "," + x.interval.high + ") ");
		}
		if (x.left != null) {
			if (i.high.compareTo(x.left.max) > 0) {
				return ;
			}
			allSameHigh(itt, x.left, i);
		}
		if (x.right != null) {
			if (i.high.compareTo(x.right.interval.low) <= 0) {
				return ;
			}
			allSameHigh(itt, x.right, i);
		}
	}

}
