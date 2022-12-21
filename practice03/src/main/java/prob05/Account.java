package prob05;

public class Account {
	private String accountNo;
	private int balance;

	public Account(String accountNo) {
		System.out.println(accountNo + " 계좌가 개설되었습니다.");
		this.accountNo = accountNo;
	}

	public void save(int won) {
		balance += won;
		System.out.println(this.accountNo + " 계좌에 " + won + "만원이 입금되었습니다.");
	}

	public void deposit(int won) {
		balance -= won;
		System.out.println(this.accountNo + " 계좌에 " + won + "만원이 출금되었습니다.");
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
