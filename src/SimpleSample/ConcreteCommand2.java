package SimpleSample;

public class ConcreteCommand2 implements Command {
    private Receiver receiver;

    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.operation2();
        System.out.println("SimpleSample.Command 2 executed");
    }
}
