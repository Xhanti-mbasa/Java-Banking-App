package operations.bank;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest {
    
    @Test
    public void testGetBalance() {
        Bank bank = new Bank();
        assertEquals(0.0, bank.getBalance(), 0.01);
    }
    
    @Test
    public void testDeposit() {
        Bank bank = new Bank();
        assertTrue(bank.deposit(100));
        assertEquals(100.0, bank.getBalance(), 0.01);
    }
    
    @Test
    public void testWithdraw() {
        Bank bank = new Bank();
        bank.deposit(100);
        assertTrue(bank.withdraw(50));
        assertEquals(50.0, bank.getBalance(), 0.01);
    }
    
    @Test
    public void testWithdrawInsufficientFunds() {
        Bank bank = new Bank();
        bank.deposit(50);
        assertFalse(bank.withdraw(100));
        assertEquals(50.0, bank.getBalance(), 0.01);
    }
    
    @Test
    public void testNegativeDeposit() {
        Bank bank = new Bank();
        assertFalse(bank.deposit(-50));
        assertEquals(0.0, bank.getBalance(), 0.01);
    }
}
