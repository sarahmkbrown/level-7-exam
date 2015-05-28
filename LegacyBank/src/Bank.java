import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Bank {
	public static final double INTEREST_RATE = 2.54 / 100;

	public void updateBalances(ArrayList<BankAccount> accounts) {
		for (BankAccount account : accounts) {
			account.setMoney(account.getMoney() + calculateInterest(account));
		}

	}
	
	public double calculateInterest(BankAccount account) {

		return findTimeBetweenDatesAccessed(account) * INTEREST_RATE
				* account.getBalance();
	}

	public double findTimeBetweenDatesAccessed(BankAccount account) {
		Date dateOpened = account.getDate();

		Calendar currentTime = Calendar.getInstance(Locale.US);
		currentTime.setTime(new Date());
		Calendar timeBankAccountOpened = Calendar.getInstance(Locale.US);
		timeBankAccountOpened.setTime(dateOpened);
		int differenceInTimeAccountAccessed = timeBankAccountOpened
				.get(Calendar.YEAR) - currentTime.get(Calendar.YEAR);
		if (currentTime.get(Calendar.MONTH) > timeBankAccountOpened
				.get(Calendar.MONTH)
				|| (currentTime.get(Calendar.MONTH) == timeBankAccountOpened
						.get(Calendar.MONTH) && currentTime.get(Calendar.DATE) > timeBankAccountOpened
						.get(Calendar.DATE))) {
			differenceInTimeAccountAccessed--;
		}
		if (differenceInTimeAccountAccessed < 0)
			differenceInTimeAccountAccessed = -differenceInTimeAccountAccessed;
		return differenceInTimeAccountAccessed;
	}

}

class BankAccount {

	private Date date;
	private double money;

	public BankAccount(Date date, double money) {
		this.setDate(date);
		this.setMoney(money);
	}

	public double getBalance() {
		return getMoney();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

}
