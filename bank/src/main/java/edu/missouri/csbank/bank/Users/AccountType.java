package edu.missouri.csbank.bank.Users;

public enum AccountType {
    SAVINGS, CHECKING, INVESTMENT, CREDIT;

    // Savings --> Hold money and has debit card
    // Checking --> hold money, used to pay things, has a debit card
    // Investment --> invest money, no cards linked to it
    // credit --> account for a credit card

    /*
    Savings
        Balance = amount in account
        apr = interest rate
        No account limit
        Account minimum (maybe)

    Checking
        Balance = amount in account
        apr = interest rate
        No account limit
        Account minimum (maybe)

    Investment
        Balance = amount in account
        apr = interest rate
        No account limit
        no cash back rate
        Account minimum (maybe)
        no card linked to it
        Different types (money market, stock market, index fund, cd)

    Credit
        Balance = current amount owed
        apr = normal
        Account limit = credit limit
        past due balance
        due date
        Cash back goes towards Rewards
        minimum payment (maybe)
        (-) Note: Interest is charged on past due balance.
     */
}
