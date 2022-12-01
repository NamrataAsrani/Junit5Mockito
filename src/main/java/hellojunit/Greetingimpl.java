package hellojunit;

import java.security.Provider.Service;

public class Greetingimpl implements Greeting {

	private GreetingService service;
	@Override
	public String greet(String name) {
		// TODO Auto-generated method stub
		
		return service.greet(name);
	}

}
