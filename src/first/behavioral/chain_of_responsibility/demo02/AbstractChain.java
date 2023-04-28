package first.behavioral.chain_of_responsibility.demo02;

public abstract class AbstractChain implements Chain {
    private Chain next;
    public Chain getNext() {
        return next;
    }
    @Override
    public void setNext(Chain next) {
        this.next = next;
    }
}
