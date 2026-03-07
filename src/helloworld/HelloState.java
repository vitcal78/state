package helloworld;

public class HelloState implements HelloWorldState {

	@Override
	public void sayHello(HelloWorldContext context) {
		System.out.print("Hello, ");
		context.setState(new WorldState());
	}

}
