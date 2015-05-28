import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class BestRestaurantVoteCounter {

	public static void main(String[] args) throws IOException {
		new BestRestaurantVoteCounter().getGoing();
	}

	void getGoing() throws IOException {
		scanVotes();
	}

	public String scanVotes() throws IOException {
		URL fileWithVotes = getClass().getResource("sample-votes.txt");

		ArrayList<String> votes = new ArrayList();
		Scanner scanner = new Scanner(fileWithVotes.openStream());

		while (scanner.hasNextLine()) {
			votes.add(scanner.nextLine());
		}
		scanner.close();

		for (String string : votes) {
			System.out.println(string);
		}
		int votesForSangDeuan = 0, votesForOceanaCoastalKitchen = 0, votesForWerewolf = 0, votesForHomeAndAway = 0, votesForCLevel = 0;
		for (String vote : votes) {
			if (matchesSangDeuan(vote))
				votesForSangDeuan++;
			if (matchesOceanaCoastalKitchen(vote))
				votesForOceanaCoastalKitchen++;
			if (matchesWerewolf(vote))
				votesForWerewolf++;
			if (matchesHomeAndAway(vote))
				votesForHomeAndAway++;
			if (matchesCLevel(vote))
				votesForCLevel++;
		}

		String winningRestaurant = calculateWinner(votesForSangDeuan, votesForOceanaCoastalKitchen, votesForWerewolf, votesForHomeAndAway, votesForCLevel);
		System.out.println("Reader's favorite restaurant is: "  + winningRestaurant);
		return winningRestaurant;
	}

	private String calculateWinner(int votesForSangDeuan, int votesForOceanaCoastalKitchen, int votesForWerewolf, int votesForHomeAndAway, int votesForCLevel) {
		int mostVotes = 0;
		String winningRestaurant = null;
		if (votesForSangDeuan > mostVotes) {
			mostVotes = votesForSangDeuan;
			winningRestaurant = "Sang Deuan";
		}
		if (votesForOceanaCoastalKitchen > mostVotes) {
			mostVotes = votesForOceanaCoastalKitchen;
			winningRestaurant = "Oceana Coastal Kitchen";
		}
		
		if (votesForCLevel > mostVotes) {
			mostVotes = votesForCLevel;
			winningRestaurant = "C Level";
		}
		if (votesForWerewolf > mostVotes) {
			mostVotes = votesForWerewolf;
			winningRestaurant = "Werewolf";
		}
		if (votesForHomeAndAway > mostVotes) {
			mostVotes = votesForHomeAndAway;
			winningRestaurant = "Home & Away";
		}

		System.out.println(votesForWerewolf);
		System.out.println("c level" + votesForCLevel);


		return winningRestaurant;
	}

	boolean matchesSangDeuan(String possibleMatch) {
		if (possibleMatch.equalsIgnoreCase("Sang Deuan") || possibleMatch.equalsIgnoreCase("Sang Duan"))
			return true;
		else
			return false;
	}

	boolean matchesOceanaCoastalKitchen(String possibleMatch) {
		if (possibleMatch.equalsIgnoreCase("Oceana Coastal Kitchen") || possibleMatch.equalsIgnoreCase("Ocean Coastal"))
			return true;
		else
			return false;
	}

	boolean matchesWerewolf(String possibleMatch) {
		if (possibleMatch.equalsIgnoreCase("Wherewolf") || possibleMatch.equalsIgnoreCase("Werewolf") || possibleMatch.equalsIgnoreCase("werewolf") )
			return true;
		else
			return false;
	}

	boolean matchesHomeAndAway(String possibleMatch) {
		if (possibleMatch.equalsIgnoreCase("HomeAndAway") || possibleMatch.equalsIgnoreCase("Home And Away") || possibleMatch.equalsIgnoreCase("Home & Away"))
			return true;
		else
			return false;
	}

	boolean matchesCLevel(String possibleMatch) {
		if (possibleMatch.equals("C Level  ") || possibleMatch.equals("C Level") || possibleMatch.equals("c-level") || possibleMatch.equals("c level ") || possibleMatch.equals("C level lounge") || possibleMatch.equals("C-Level")) 
			return true;
		else
			return false;
	}

}
