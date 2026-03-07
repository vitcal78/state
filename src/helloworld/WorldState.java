package helloworld;

public class WorldState implements HelloWorldState {

	private static final WorldState INSTANCE = new WorldState();

	public static WorldState getInstance() {
		return INSTANCE;
	}

	@Override
	public void sayHello(HelloWorldContext context) {
		System.out.println("World!");
		context.setState(HelloState.getInstance());
	}

}
