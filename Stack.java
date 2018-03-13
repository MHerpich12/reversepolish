/**
 * Stack class implements an array-based Stack construct using a pointer for the top.
 * Functions defined include push, pop, and an isEmpty() boolean test.
 * Will output an Exception if Stack underflows.
 */
public class Stack {

	/**
	 * Stack class instance variables.
	 * Int toppoint: a pointer to the top of the Stack.
	 * Object[] stackarray: the Object array used for the Stack.  Note that downcasting may be involved.
	 * Int arraylen: an integer to keep track of the length of the array.  Initial value set to 6.
	 */
	private int toppoint;
	private Object[] stackarray;
	private int arraylen;
	
	/**
	 * Stack constructor.  Initializes array to be 6 units long and the toppoint value to be -1 (empty state).
	 */
	Stack(){
		arraylen = 6;
		stackarray = new Object[arraylen];
		toppoint = -1;
	}
	
	/**
	 * Push method adds an Object to the Stack.  If adding an additional object will exceed array boundaries,
	 * performs a copy of the array to a new array with twice the length.  Increments top pointer by 1.
	 * Pre-Condition: assumes sufficient memory.  Also assumes valid Object as input.
	 * Post-Condition: Object added to array and top pointer incremented by 1.  If at array boundary, new array generated
	 * which copies existing array and adds new Object.
	 * Best-Case Runtime: Theta(1), constant.
	 * Worst-Case Runtime: Theta(N), linear.  Worst-Case occurs when array must double in size to fit new Object.
	 */
	public void push(Object input){
		if(toppoint + 1 >= arraylen){
			this.arraylen *= 2;
			Object[] newarray = new Object[arraylen];
			for(int i = 0; i < stackarray.length; i++){
				newarray[i] = stackarray[i];
			}
			this.stackarray = newarray;
		}
		toppoint += 1;
		stackarray[toppoint] = input;
	}
	
		/**
		 * Pop method removes an Object from the Stack in LIFO format.
		 * Pre-Condition: assumes non-empty array.  If array is empty, will throw Exception.
		 * Post-Condition: returns Object reference to popped Object and decrements top pointer by 1.
		 */
		public Object pop(){
			Object popobj = new Object();
			popobj = null;
			
			if(!isEmpty()){
				popobj = stackarray[toppoint];
				toppoint -= 1;
			} else {
				try{
				throw new CustomException("Error: stack underflow exception.");
				} catch(CustomException e){
					e.printStackTrace();
					System.exit(0);
				}
			}
			
			return popobj;
		}
		
		/**
		 * isEmpty boolean method tests for an empty Stack.
		 */
		public boolean isEmpty(){
			if(toppoint == -1){
				return true;
			} else {
				return false;
			}
		}
	
}
