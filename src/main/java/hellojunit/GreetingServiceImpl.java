package hellojunit;

public class GreetingServiceImpl implements GreetingService {

	@Override
	public String greet(String name) {
		// TODO Auto-generated method stub
		
		if(name == null || name.length()==0) {
			throw new IllegalArgumentException();
		}
		return "Hello "+ name;
	//	return null;
	}

}
