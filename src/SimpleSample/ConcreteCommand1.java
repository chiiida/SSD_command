package SimpleSample;

public class ConcreteCommand1 implements Command {
    private Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.operation1();
        System.out.println("SimpleSample.Command 1 executed");
    }
}
