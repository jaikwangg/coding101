import java.util.ArrayList;

public class AcctList_650776 {
    public static void main(String[] args) {
        testAccount();
        testAcctList();
    }

    static void testAcctList() {
        ProFun12_AcctList clients = new ProFun12_AcctList();
        String startWith = "c";
        System.out.println("List of account name start with " + startWith.toUpperCase());
        System.out.println(clients.filterName(startWith.toUpperCase()));
        int bound = 1400;
        System.out.println("List of account balance less than " + bound);
        System.out.println(clients.balanceLessThan(bound));
    }

    static void testAccount() {
        Account_650776 acct1 = new Account_650776(1, "melon", 1500);
        Account_650776 acct2 = new Account_650776(2, "rose apple", 2200);
        System.out.println(acct1.credit(700)); // 2200
        System.out.println(acct2.debit(300)); // 1900
        System.out.println(acct1.transfer(acct2, 1000)); // 2200
        System.out.println(acct1.credit(-50)); // 1200
        System.out.println(acct2.debit(-50)); // 2900
        System.out.println(acct1);
        System.out.println(acct2);
    }
}

class ProFun12_AcctList {
    ArrayList<Account_650776> acctList;

    ProFun12_AcctList() {
        acctList = new ArrayList<>();
        acctList.add(new Account_650776(1, "Cactus", 1000));
        acctList.add(new Account_650776(2, "Celsia", 500));
        acctList.add(new Account_650776(3, "Clove pink", 1500));
        acctList.add(new Account_650776(4, "Crown Imperial", 900));
        acctList.add(new Account_650776(5, "Daffodil", 1200));
        acctList.add(new Account_650776(6, "Daisy", 1700));
        acctList.add(new Account_650776(7, "Dandelion", 500));
        acctList.add(new Account_650776(8, "Dittany", 600));
    }

    ArrayList<Account_650776> filterName(String c) {
        ArrayList<Account_650776> result = new ArrayList<>();
        for (Account_650776 acct : acctList) {
            if (acct.name.startsWith(c)) {
                result.add(acct);
            }
        }
        return result;
    }

    ArrayList<Account_650776> balanceLessThan(int b) {
        ArrayList<Account_650776> result = new ArrayList<>();
        for (Account_650776 acct : acctList) {
            if (acct.balance < b) {
                result.add(acct);
            }
        }
        return result;
    }
}