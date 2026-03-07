package helloworld;

public class HelloWorldContext {

	private HelloWorldState state;

	public HelloWorldContext() {
		state = new HelloState();
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
