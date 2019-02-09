import static org.junit.Assert.*;

import java.util.Random;
import java.util.stream.Stream;
import org.junit
import org.junit.Test;

public class ListeTest {

	public final static int NUMTESTS = 1000;
	Random r = new Random();
	int randomInt = r.nextInt(100) + 1;
	
	@ParametrizedTest
	@MethodSource(value = "generateParams")
	public void testInserer() {
		fail("Not yet implemented");
	}
	
	static Stream<Arguments> generateParams(){
		Stream.builder<Arguments> sb = Stream.builder();
		
		for(int i =0 ; i< NUMTESTS; i++){
				sb.accept(Arguments.of(Math.random()));
		}
		
		return sb.build;
	}

}
