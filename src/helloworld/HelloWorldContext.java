package helloworld;

public class HelloWorldContext {

	private HelloWorldState state;

	public HelloWorldContext() {
		state = HelloState.getInstance();
	}

	public void setState(HelloWorldState state) {
		this.state = state;
	}

	public HelloWorldState getState() {
		return state;
	}

	public void sayHello() {
		state.sayHello(this);
	}

}
