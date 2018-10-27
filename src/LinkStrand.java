
public class LinkStrand implements IDnaStrand {
	private int myAppends;
	private int myLocalIndex;
	private int myIndex;
	private Node myCurrent;
	private Node myFirst, myLast;
	private long mySize;

	private class Node {
		String info;
		Node next;

		public Node(String s) {
			info = s;
			next = null;
		}
	}


	public LinkStrand(String newString) {
		initialize(newString);

	}

	public LinkStrand() {
		this("");
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return mySize;
	}

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

	@Override
	public String toString() {
		Node stringNode = myFirst;
		StringBuilder newBuild = new StringBuilder();
		while (stringNode != null) {
			newBuild.append(stringNode.info);
			stringNode = stringNode.next;

		}
		return newBuild.toString();

	}

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

	@Override
	public IDnaStrand reverse() {
		
		LinkStrand Ola = new LinkStrand();
		Node newFirst1 = myFirst;
		Node newFirst2 = myFirst;

		StringBuilder copy = new StringBuilder(newFirst1.info);
		copy.reverse();
		String newCopy = copy.toString();
		Ola.myFirst.info = newCopy;
		newFirst1 = newFirst1.next;

		while (newFirst1 != null) {
			StringBuilder copy1 = new StringBuilder(newFirst1.info);
			copy1.reverse();
			String newCopy1 = copy1.toString();
			Node newNode = new Node(newCopy1);
			newNode.next = Ola.myFirst;
			Ola.myFirst = newNode;
			newFirst1 = newFirst1.next;
		}
		
		//while (newFirst2 != null) {
			
			 
			
		//}

		return Ola;

		
/*		myLast=myFirst;
		if (myLast==null){
			return this;
		}
		Node current=myFirst;
		Node current2=myFirst.next;
		Node current3=null;
		if (current.next==null){
		StringBuilder info=new StringBuilder(current.info);
		info.reverse();
		current.info=info.toString();
		return this;
		}
		while (current.next!=null){
			StringBuilder info=new StringBuilder(current.info);
			info.reverse();
			current.info=info.toString();
			current.next=current3;
			current3=current;
			current=current2;
			current2=current.next;
		
		}	
		myFirst=current;
*/
		
	
		// iterate linked list
		// when find node, create copy but in reverse
		//

		// TODO Auto-generated method stub

	}

	@Override
	public int getAppendCount() {
		// TODO Auto-generated method stub
		return myAppends;
	}

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
		} 
		else {
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

