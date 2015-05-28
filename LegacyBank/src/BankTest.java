import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class BankTest {

	@Test
	public void calculateInterestTest() throws ParseException {
		Bank testBank = new Bank();
		SimpleDateFormat simpleDate = new SimpleDateFormat("mm/dd/yyyy");
		Date currentDate = simpleDate.parse("05/28/2014");
		BankAccount testBankAccount = new BankAccount(currentDate, 100.00);
		testBank.calculateInterest(testBankAccount);

		assertEquals(5.08, testBank.calculateInterest(testBankAccount), .0001);

		SimpleDateFormat simpleDate2 = new SimpleDateFormat("mm/dd/yyyy");
		Date currentDate2 = simpleDate.parse("05/28/2012");
		BankAccount testBankAccount2 = new BankAccount(currentDate2, 100.00);
		testBank.calculateInterest(testBankAccount2);
		assertEquals(10.16, testBank.calculateInterest(testBankAccount2), .0001);

	}

	@Test
	public void updateBalancesTest() throws ParseException {
		Bank testBank = new Bank();
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

		SimpleDateFormat simpleDate = new SimpleDateFormat("mm/dd/yyyy");
		Date currentDate = simpleDate.parse("05/28/2014");
		SimpleDateFormat simpleDate2 = new SimpleDateFormat("mm/dd/yyyy");
		Date currentDate2 = simpleDate.parse("05/28/2012");

		BankAccount testBankAccount = new BankAccount(currentDate, 100.00);
		
		
		BankAccount testBankAccount2 = new BankAccount(currentDate2, 100.00);

		accounts.add(testBankAccount);
		accounts.add(testBankAccount2);
		
		testBank.updateBalances(accounts);
		
		assertEquals(105.08, testBankAccount.getBalance(),.0001);
		assertEquals(110.16, testBankAccount2.getBalance(),.0001);


	}

}
