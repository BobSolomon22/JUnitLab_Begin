package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.rules.ExpectedException;
public class GiftCardTest
{
	@Test
	public void getIssuingStore()
	{
			double balance;
			GiftCard card;
			int issuingStore;
			
			issuingStore = 1337;
			balance = 100.00;
			card = new GiftCard(issuingStore, balance);
			assertEquals("getIssuingStore()",
					issuingStore, card.getIssuingStore());
	}
	
	@Test
	public void getBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getBalance()",
				balance, card.getBalance(), 0.001);
	}
	
	@Test
	public void testDeduct()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		double transaction;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		transaction = 100.00;
		
		if(transaction <= balance)
		{
			assertEquals("testDeduct()",
					"Remaining Balance: " + String.format("%6.2f",
	                        Math.abs(balance - transaction)), card.deduct(transaction));	
		}
		else if(transaction < 0.0)
		{
			assertEquals("testDeduct()","Invalid Transaction",card.deduct(transaction));
		}
		else // transaction > balance
		{
			assertEquals("testDeduct()",
					"Amount Due: " + String.format("%6.2f",
	                        Math.abs(balance - transaction)), card.deduct(transaction));
		}
	}
	
	@Test
	public void constructor_IncorrectID_Low()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-5,-100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_High()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000,-100.00);});
	}
}