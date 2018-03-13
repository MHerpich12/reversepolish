import java.math.BigInteger;

/**
 * RedBlackNode class creates Node objects to be utilized in a RedBlackTree.
 * Default implementation is key-value store, where key is string and value is BigInteger.
 * Contains references to parent, left child, and right child, and utilizes final int for color (B = 0, R = 1).
 */
public class RedBlackNode {
	
	public static final int BLACK = 0;
	public static final int RED = 1;
	
	private String nodekey;
	private BigInteger nodedata;
	private int nodecolor;
	private RedBlackNode nodeparent;
	private RedBlackNode nodelc;
	private RedBlackNode noderc;
	
	/**
	 * Construct a RedBlackNode with data, color, parent pointer, left child pointer and right child pointer.
	*  Parameters:
	*  data - a simple value held in the tree
	*  color - either RED or BLACK
	*  p - the parent pointer
	*  lc - the pointer to the left child (will be null only for the node that represents all external nulls.
	*  rc - the pointer to the right child (will be null only for the node that represents all external nulls.
	 */
	RedBlackNode(String keydata, BigInteger valuedata, int color, RedBlackNode p, RedBlackNode lc, RedBlackNode rc){
		nodekey = keydata;
		nodedata = valuedata;
		nodecolor = color;
		nodeparent = p;
		nodelc = lc;
		noderc = rc;
	}
	
	/**
	* The getColor() method returns RED or BLACK.
	* Returns:
	* the color value (RED or BLACK)
	*/
	public int getColor(){
		return nodecolor;
	}
	
	/**
	* The getKey() method returns the key in the node.
	* Returns:
	* the key value in the node
	*/
	public String getKey(){
		return nodekey;
	}
	
	/**
	* The getData() method returns the data in the node.
	* Returns:
	* the data value in the node
	*/
	public BigInteger getData(){
		return nodedata;
	}
	
	/**
	* The getLc() method returns the left child of the RedBlackNode.
	* Returns:
	* the left child field
	* */
	public RedBlackNode getLc(){
		return nodelc;
	}
	
	/**
	* The getRc() method returns the right child of the RedBlackNode.
	* Returns:
	* the right child field
	* */
	public RedBlackNode getRc(){
		return noderc;
	}
	
	/**
	* The getP() method returns the parent of the RedBlackNode.
	* Returns:
	* the parent field
	* */
	public RedBlackNode getP(){
		return nodeparent;
	}
	
	/**
	* The setData() method sets the data or key of the RedBlackNode.
	* Parameters:
	*  key - the string used as the key for the key-value pair.
	 * data - a BigInteger value used as the value for the key-value pair.
	*/
	public void setData(String key, BigInteger data){
		nodekey = key;
		nodedata = data;
	}
	/**
	 * The setData() method sets the data or key of the RedBlackNode.
	 * Parameters:
	 *  key - the string used as the key for the key-value pair.
	 */
	public void setData(String key){
		nodekey = key;
	}
	/**
	 * The setData() method sets the data or key of the RedBlackNode.
	 * Parameters:
	 * data - a BigInteger value used as the value for the key-value pair.
	 */
	public void setData(BigInteger data){
		nodedata = data;
	}
	
	/**
	* The setColor() method sets the color of the RedBlackNode.
	* Parameters:
	* color - is either RED or BLACK
	*/
	public void setColor(int color){
		nodecolor = color;
	}
	
	/**
	* The setLc() method sets the left child of the RedBlackNode.
	* Parameters:
	* lc - establishes a left child for this node
	*/
	public void setLc(RedBlackNode lc){
		nodelc = lc;
	}
	
	/**
	* The setRc() method sets the right child of the RedBlackNode.
	* Parameters:
	* rc - establishes a right child for this node
	*/
	public void setRc(RedBlackNode rc){
		noderc = rc;
	}
	
	/**
	* The setP() method sets the parent of the RedBlackNode.
	* Parameters:
	* p - establishes a parent pointer for this node
	*/
	public void setP(RedBlackNode p){
		nodeparent = p;
	}
	
	/**
	 * The toString() methods returns a string representation of the RedBlackNode.
	 * Overrides:
	 * toString in class java.lang.Object
	 * Returns:
	 * the string representation of a RedBlackNode
	 */
	public String toString(){
		return nodedata.toString();
	}
}
