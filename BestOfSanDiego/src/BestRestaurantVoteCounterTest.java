import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class BestRestaurantVoteCounterTest {

	@Test
	public void winningRestaurantTest() throws IOException {
		BestRestaurantVoteCounter counter = new BestRestaurantVoteCounter();
		assertEquals("C Level", counter.scanVotes());
	
	}

}
