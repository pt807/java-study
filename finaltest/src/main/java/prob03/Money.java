package prob03;

import java.util.Objects;

public class Money {
	private int amount;

	/* 코드 작성 */
	public Money(int i) {
		amount = i;
	}

	public Object add(Money three) {

		return new Money(amount + three.amount);
	}

	public Object minus(Money two) {
		return new Money(amount - two.amount);
	}

	public Object multiply(Money two) {
		return new Money(amount * two.amount);
	}

	public Object devide(Money five) {
		return new Money(amount / five.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}

}
