public class LinkedList<E> {
    private Node<E> mHead;
    private int mSize;


    public LinkedList(){
        mHead = null;
        mSize = 0;
    }
    public int size(){
        return mSize;
    }
    public boolean add(E element) {
        this.add(mSize, element);
        return true;
    }

    public boolean add(int index, E element){
        if (index < 0 || index > mSize)
            throw new IndexOutOfBoundsException("Index must be >= 0 and <= " + mSize);
        if (index == 0)
            // If index is 0, Node assigned to head
            mHead = new Node(element, mHead);

        else {
            // Create a local variable temp, and assign temp to the node "before" the index
            Node<E> temp = mHead;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.mNext;
            }
            temp.mNext = new Node(element, temp.mNext);
        }

        mSize++;
        return true;
    }

    @Override
    public String toString() {
        String output = "[";
        Node<E> temp = mHead;

        // Keep looping as long as temp != null
        while (temp != null) {
            output += temp.mData + ((temp.mNext != null) ? ", " : "]");
            temp = temp.mNext;
        }

        return output;
    }

    class Node<E> {
        private E mData;
        private Node<E> mNext;

        private Node(E data, Node<E> next){
            mData = data;
            mNext = next;
        }
        private Node(E data){
            this(data, null);
        }

    }
}
