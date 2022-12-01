package hellojunit;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito.Then;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GreetingimplTest {
	
	@Mock
	private GreetingService service;
	
	@InjectMocks
	private Greetingimpl greeting;

	/*@BeforeEach
	public void setup() {
		greeting = new Greetingimpl();
	}*/
	
	
	@Test
	public void nameshouldreturnvalidoutput() {
		when(service.greet("Junit")).thenReturn("Hello Junit");

		String result = greeting.greet("Junit");
		assertNotNull(result);
		assertEquals("Hello Junit",result);
	}
	
	
	@Test
	public void greetshouldthrowexcptionif_name_is_null() {
		doThrow(IllegalArgumentException.class).when(service).greet(null);
		assertThrows(IllegalArgumentException.class,()->{
			
			greeting.greet(null);

		});
	}
	
	@Test
	public void greetshouldthrowexcptionif_name_is_blank() {
		doThrow(IllegalArgumentException.class).when(service).greet("");

		assertThrows(IllegalArgumentException.class,()->{
			greeting.greet("");

		});
	}
	
	
	@AfterEach
	void tearDown(){
		greeting =null;
	}


}
