/*
 * 
 */
package tasks;

import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class BinarySearchTree.
 * 
 * @param <T>
 *            the generic type
 */
public class BinarySearchTree<T>
{
	
	/** The r. */
	private BinarySearchTree<T> l, r;
	
	/** The val. */
	private T val;
	
	/** The comparator. */
	private Comparator<T> comparator;
	
	/**
	 * Instantiates a new binary search tree.
	 * 
	 * @param comparator
	 *            the comparator
	 */
	public BinarySearchTree(Comparator<T> comparator)
	{
		this.comparator = comparator;
	}
	
	/**
	 * Instantiates a new binary search tree.
	 * 
	 * @param val
	 *            the val
	 * @param comparator
	 *            the comparator
	 */
	public BinarySearchTree(T val, Comparator<T> comparator)
	{
		this.val = val;
		this.comparator = comparator;
	}
	
	/**
	 * Sets the value.
	 * 
	 * @param val
	 *            the new value
	 */
	public void setValue(T val)
	{
		this.val = val;
	}
	
	/**
	 * Sets the comparator.
	 * 
	 * @param comparator
	 *            the new comparator
	 */
	public void setComparator(Comparator<T> comparator)
	{
		this.comparator = comparator;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		String result = "";
		if(l != null)
			result += l.toString() + " ";
		result += val;
		if(r != null)
			result += " " + r.toString();
		return result;
	}
	
	/**
	 * Adds the.
	 * 
	 * @param val
	 *            the val
	 */
	public void add(T val)
	{
		if(this.val == null)
			this.val = val;
		else if(comparator.compare(this.val, val) < 0)
		{
			if(l == null)
				l = new BinarySearchTree<T>(val, comparator);
			else l.add(val);
		}
		else
		{
			if(r == null)
				r = new BinarySearchTree<T>(val, comparator);
			else r.add(val);
		}
	}
	
	// Supprime le plus petit elmt et le renvoie
	/**
	 * Take first.
	 * 
	 * @return the t
	 */
	public T takeFirst()
	{
		if(l != null)
		{
			if(l.l != null)
				return l.takeFirst();
			else
			{
				T result = l.val;
				l = l.r;
				return result;
			}
		}
		T result = val;
		if(r != null)
		{
			val = r.val;
			l = r.l;
			r = r.r;
		}
		else val = null;
		return result;
	}
	
	/**
	 * Gets the first.
	 * 
	 * @return the first
	 */
	public T getFirst()
	{
		if(l != null)
		{
			if(l.l != null)
				return l.getFirst();
			else
				return l.val;
		}
		T result = val;
		return result;
	}
	
	// Supprime le plus petit element et le renvoie
	/**
	 * Take last.
	 * 
	 * @return the t
	 */
	public T takeLast()
	{
		if(r != null)
		{
			if(r.r != null)
				return r.takeLast();
			else
			{
				T result = r.val;
				r = r.l;
				return result;
			}
		}
		T result = val;
		if(l != null)
		{
			val = l.val;
			r = l.r;
			l = l.l;
		}
		return result;
	}
	
	/**
	 * Checks if is empty.
	 * 
	 * @return true, if is empty
	 */
	public boolean isEmpty()
	{
		return val == null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public BinarySearchTree<T> clone(){
		BinarySearchTree<T> tasksTemp = new BinarySearchTree<>(comparator);
		if(l != null)
			tasksTemp.l = l.clone();
		if(r!= null)
			tasksTemp.r = r.clone();
		tasksTemp.val = val;
		return tasksTemp;
	}
}
