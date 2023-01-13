package multithreading;


import java.util.LinkedHashMap;

class BankAccount {
    private Integer balance;
    private final Integer overdraft;

    public BankAccount(Integer overdraft) {
        this.balance = 0;
        this.overdraft = overdraft;
    }

    public void topUp(Integer amount) {
        balance += amount;
    }

    public void debit(Integer amount) {
        balance -= amount;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getOverdraft() {
        return overdraft;
    }
}

class ATM {
    static void withdrow(BankAccount account, int amount) {
        Integer balance = account.getBalance();

        if((balance - amount) < - account.getOverdraft()) {
            System.out.println("Transaction denied");
        } else {
            account.debit(amount);
            System.out.println("$" + amount + " successfully withdrawn");
        }

        System.out.println("Current balance: " + account.getBalance());
    }
}

class User {
    private static final BankAccount account = new BankAccount(50);

    public static void main(String[] args) {
        account.topUp(100);

        Thread t1 = new Thread(() -> {
            ATM.withdrow(account, 100);
        });

        Thread t2 = new Thread(() -> {
            ATM.withdrow(account, 100);
        });

        t1.start();
        t2.start();
    }
}