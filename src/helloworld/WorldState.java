package helloworld;

public class WorldState implements HelloWorldState {

	@Override
	public void sayHello(HelloWorldContext context) {
		System.out.println("World!");
		context.setState(new HelloState());
	}

}
