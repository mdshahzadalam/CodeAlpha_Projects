package PROJECTS;
import java.util.*;
import java.util.Random;

class Fuctions
{
    
    public int balance=1000;
    public int amount;
    private final Random generator;
    
    public Fuctions() {
    generator = new Random();
    
  }
    
  private int generateSecretNumber() {
    return (generator.nextInt(10000) + 1 );
  }

    Scanner sc= new Scanner(System.in);
    Calendar calendar=Calendar.getInstance();
    public void CheckBalance()
    {
        System.out.println("Total Balance "+balance+" Rs.");
        System.out.println();
    }

    public void DepositMoney()
    {
        
        System.out.print("Enter the amount of money you want to Deposit: ");
        amount=sc.nextInt();
        if(amount > 0)
        {
            balance = balance + amount;
            System.out.println(amount +" successfully Deposit in your account total balance is "+balance+" Rs.");
            System.out.println();
            depositReceipt();
        }
        else{
            System.out.println("Soory please enter the amount more than 0 ");
        }
        
    }

    public void WithdrawMoney()
    {
        System.out.print("Enter the amount of money you want to widthdraw: ");
        amount=sc.nextInt();

        if(amount > 0)
        {
            if(amount > balance)
        {
            System.out.println("You don't have sufficient balance to make this widthdrawal");
        }
        else
        {
            balance = balance - amount;
            System.out.println(amount+" successfully widthdrawn in your account remaining balance "+balance+" Rs.");
            System.err.println();

        }
            Withdrawreceipt();
        }
        else
        {
            System.out.println("Soory please enter the amount more than 0 ");
        }
        
    }

    public void Withdrawreceipt()
    {
        
        System.out.println("Do you want to Receipt?");
        System.out.println("Y / N");
        System.out.println();

        char s =sc.next().charAt(0);
        
        if(s == 'y')
        {
            System.out.println("---------------------------------");
            System.out.println("            APNA  ATM            ");
            System.out.println("---------------------------------");

            System.out.print("DATE : ");
            System.out.println(calendar.get(Calendar.DATE)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.YEAR));
            System.out.print("TIME : ");
            System.out.println(calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
            System.out.println("CARD NO. XXXXXXXXXXXX");
            System.out.println("TO KNOW YOUR BALANCES, CALL TOLL FREE");
            System.out.println("ON XXXX-XXX-XXXX FROM YOUR MOBILE ANS ");
            System.out.println("GET YOUR ACCOUNT BALANCE INSTANTLY");
            System.out.print("SERIAL NO. : ");
            System.out.println(generateSecretNumber());
            System.out.println("WITHDRAWAL AMOUNT : "+amount);
            System.out.println("AVAILABLE BALANCE : "+balance);
        }
        else if(s == 'n')
        {
            return;
        }
        else
        {
            System.out.println("'y' and 'n' in the keyboard?? Please try again...................");
        }
        
    }
    public void depositReceipt()
    {
        System.out.println("Do you want to Receipt?");
        System.out.println("Y / N");
        System.out.println();
        char s =sc.next().charAt(0);
        if(s == 'y')
        {
            System.out.println("---------------------------------");
            System.out.println("            APNA  ATM            ");
            System.out.println("---------------------------------");

            System.out.print("DATE : ");
            System.out.println(calendar.get(Calendar.DATE)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.YEAR));
            System.out.print("TIME : ");
            System.out.println(calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
            System.out.println("CARD NO. XXXXXXXXXXXX");
            System.out.println("TO KNOW YOUR BALANCES, CALL TOLL FREE");
            System.out.println("ON XXXX-XXX-XXXX FROM YOUR MOBILE ANS ");
            System.out.println("GET YOUR ACCOUNT BALANCE INSTANTLY");
            System.out.print("SERIAL NO. : ");
            System.out.println(generateSecretNumber());
            System.out.println("DEPOSIT AMOUNT : "+amount);
            System.out.println("AVAILABLE BALANCE : "+balance);
        }
        else if(s == 'n')
        {
            return;
        }
        else
        {
            System.out.println("'y' and 'n' in the keyboard?? Please try again...................");
        }

    }
        

}
public class ATM {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int i=1;

        Fuctions f = new Fuctions();

        System.out.println("**************************************************************************************");
        System.out.println("---------------------------------Welcome to the APNA ATM------------------------------");
        System.out.println("**************************************************************************************");
        System.out.println();
        Calendar calendar=Calendar.getInstance();
        System.out.println("Date: "+calendar.get(Calendar.DATE)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.YEAR));
        System.out.println("Time: "+calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
        System.out.print("Please enter your four digit pin: ");
        int pin = sc.nextInt();
        
        if(pin == 1234)
        {
            do{
            System.out.println("what do you want to do");
            System.out.println();
            System.out.println("Enter 1 for Balance Enquiry");
            System.out.println("Enter 2 for Deposit Cash");
            System.out.println("Enter 3 for Withdraw Cash");
            System.out.println("Enter 4 for Quit");
            System.out.println();

            System.out.print("Enter the number corresponding to the activity you want to do: ");
            System.out.println();

            int check=sc.nextInt();

            switch(check)
            {
                case 1 : 
                f.CheckBalance();
                System.out.println();
                break;
                case 2 :
                f.DepositMoney();
                System.out.println();
                break;
                case 3 :
                f.WithdrawMoney();
                System.out.println();
                break;
                case 4 :
                System.out.println("Visit Again");
                System.out.println();
                break;

                default:
                System.out.println("Please enter a correct value shown");
                System.out.println();
                

            }
            if(check == 4)
            {
                return;
            }
            
        }while(i>0);
            

        }
        else
        {
            System.out.println("Entered wrong pin please Try Agian..............");
        }
    }
}
