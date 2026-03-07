package helloworld;

public class HelloState implements HelloWorldState {

	private static final HelloState INSTANCE = new HelloState();

	public static HelloState getInstance() {
		return INSTANCE;
	}

	@Override
	public void sayHello(HelloWorldContext context) {
		System.out.print("Hello, ");
		context.setState(WorldState.getInstance());
	}

}
