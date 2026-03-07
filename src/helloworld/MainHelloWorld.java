package helloworld;

public class MainHelloWorld {

	public static void main(String[] args) {

		HelloWorldContext context = new HelloWorldContext();

		// First call: HelloState prints "Hello, " and transitions to WorldState
		context.sayHello();

		// Second call: WorldState prints "World!" and transitions back to HelloState
		context.sayHello();

	}

}
