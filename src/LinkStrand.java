/**
 * 
 * @author collins Abanda Under the implements method, initialized variables,
 *         myAppends, myLocalIndex myIndex, myCurrent, myFirst, myLast and
 *         mySize which are later used in the constructors called
 *
 */
public class LinkStrand implements IDnaStrand {
	private int myAppends;
	private int myLocalIndex;
	private int myIndex;
	private Node myCurrent;
	private Node myFirst, myLast;
	private long mySize;

	/**
	 * 
	 * initialized info and Node next under the private node class
	 *
	 */

	private class Node {
		String info;
		Node next;

		/**
		 * 
		 * @param s represents any string assign info to string s: this makes sure what
		 *          ever string is being operated on by the code is now contained in
		 *          this variable called info. Assigning next to null means that every
		 *          time I call .next initially, the it will be null, unless i fill the
		 *          node with something to replace the null value
		 */

		public Node(String s) {
			info = s;
			next = null;
		}
	}

	/**
	 * 
	 * @param newString representing the string in the LinkStrands initialize the
	 *                  newString in this constructor LinkStrand. This is so that it
	 *                  can be called and used in other methods
	 */
	public LinkStrand(String newString) {
		initialize(newString);

	}

	/**
	 * initialized LinkStrand as this. This works sort of like a reflection. this
	 * refers to the LinkStrand.
	 */
	public LinkStrand() {
		this("");
	}

	/**
	 * this method initializes and returns mySize
	 */
	@Override
	public long size() {
		// TODO Auto-generated method stub
		return mySize;
	}

	/**
	 * @param source initialized all my variables in constructor initialize
	 * @return LinkStrand(source)
	 * 
	 */
	@Override
	public void initialize(String source) {

		myFirst = new Node(source);
		myLast = myFirst;
		mySize = source.length();
		myAppends = 0;
		myIndex = 0;
		myLocalIndex = 0;
		myCurrent = myFirst;

		// length of string

		// TODO Auto-generated method stub

	}

	@Override
	public IDnaStrand getInstance(String source) {
		// TODO Auto-generated method stub
		return new LinkStrand(source);
	}

	/**
	 * This concatenates the strings stored in each node the entire node is
	 * essentially being changed toString it can be see as the string representation
	 * of the entire dna strand
	 * 
	 * @return newBuild.toString()
	 */
	@Override
	public String toString() {
		Node oneNode = myFirst;
		StringBuilder newBuild = new StringBuilder();
		while (oneNode != null) {
			newBuild.append(oneNode.info);
			oneNode = oneNode.next;

		}
		return newBuild.toString();

	}

	/**
	 * 
	 * This constructor creates a new node with dna. The constructor then appends
	 * the newly created node to the end of the internal linkedlist As it does this,
	 * each time the appends method is called, myAppends is incremented by 1
	 * 
	 * @param dna
	 * @return this
	 * 
	 */
	@Override
	public IDnaStrand append(String dna) {
		// myLast.next = new Node(dna);
		// myLast = myLast.next;
		Node newNode = new Node(dna);
		myLast.next = newNode;
		myLast = myLast.next;
		mySize = mySize + dna.length();
		myAppends++;

		// TODO Auto-generated method stub
		return this;
	}

	/**
	 * @return Ola creates reverse copy of linked list this method returns a new
	 *         strand. This new strand is the reversed version of the original. this
	 *         linked strand is the reverse of the object on which it is called
	 *         first while loop reverses strings withtin node and then reverses
	 *         entire string
	 * 
	 * @return Ola is a reversed LinkStrand that contains the newly reversed strings
	 *         in the nodes
	 */

	@Override
	public IDnaStrand reverse() {

		Node newFirst1 = myFirst;
		StringBuilder copyBuilder1 = new StringBuilder(newFirst1.info);
		copyBuilder1.append(newFirst1.info);
		copyBuilder1.reverse();
		String newCopy1 = copyBuilder1.toString();
		LinkStrand Ola = new LinkStrand(newCopy1);
		newFirst1 = newFirst1.next;
// implement while loop
		while (newFirst1 != null) {
			copyBuilder1 = new StringBuilder();
			copyBuilder1.append(newFirst1.info);
			copyBuilder1.reverse(); // reverses the new stringbuilder object
			Ola.myLast.next = new Node(copyBuilder1.toString());
			Ola.mySize += copyBuilder1.length();
			Ola.myLast = Ola.myLast.next;
			
			newFirst1 = newFirst1.next;
			newCopy1 = copyBuilder1.toString(); // changes the node to string
			Node newNode = new Node(newCopy1);

		}
		Node formerCurrent = null;
		Node thisNode = Ola.myFirst;
		Node nextNode = null;
		//implement next while loop  
		while (thisNode != null) {
			nextNode = thisNode.next;
			thisNode.next = formerCurrent;
			formerCurrent = thisNode;
			thisNode = nextNode;
		}
		Ola.myFirst = formerCurrent; 
		return Ola;
		
		
		
		



		// second while loop now checks to reverse entire node

	}

	// iterate linked list
	// when find node, create copy but in reverse
	//

	// TODO Auto-generated method stub

	/**
	 * return myAppends. myAppneds is called in this method
	 */
	@Override
	public int getAppendCount() {
		// TODO Auto-generated method stub
		return myAppends;
	}

	/**
	 * @param index
	 * @return list.info.charAt(dex) in first while loop
	 * @return myCurrent.info.charAt(myLocalIndex) in second while loop compare
	 *         index to mySize and state out of bounds if the comparison is not
	 *         possible either because index is >= mySize or index is negative, then
	 *         throw and indexoutofboundsException make code more efficient so that
	 *         it runs o(1) by creating a second loop to check for other cases
	 * 
	 */
	@Override
	public char charAt(int index) throws IndexOutOfBoundsException {
		if (index >= mySize || index < 0)
			throw new IndexOutOfBoundsException();
		if (myIndex == 0 || myIndex > index) {
			int count = 0;
			int dex = 0;
			Node list = myFirst;
			while (count != index) {
				count++;
				dex++;
				if (dex >= list.info.length()) {
					dex = 0;
					list = list.next;
				}
			}
			myIndex = count;
			myLocalIndex = dex;
			myCurrent = list;
			return list.info.charAt(dex);
		} else {
			while (myIndex != index) {
				myIndex++;
				myLocalIndex++;
				if (myLocalIndex >= myCurrent.info.length()) {
					myLocalIndex = 0;
					myCurrent = myCurrent.next;
				}
			}
			return myCurrent.info.charAt(myLocalIndex);

		}
	}

}

