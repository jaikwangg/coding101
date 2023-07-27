public class Account_650776 {
    int id;
    String name;
    int balance = 0;

    Account_650776(int id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    int getID() {
        return id;
    }

    String getName() {
        return name;
    }

    int getBalance() {
        return balance;
    }

    int credit(int amount) {
        balance += amount;
        return balance;
    }

    int debit(int amount) {
        if (balance >= amount) {
            balance -= amount;
        }
        return balance;
    }

    int transfer(Account_650776 acct, int amount) {
        if (balance >= amount) {
            this.debit(amount);
            acct.credit(amount);
        }
        return balance;
    }

    public String toString() {
        return "Account_650776[id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
}
