import java.util.*;
class information{
    String fullname;
    String username;
    String password;
    String accountno;
    double balance=3000000;
    int transactions=0;
    String transactionhistory= "";


//registration function
public void registration(){
    Scanner sc = new Scanner(System.in);
    System.out.println("enter your full name: ");
    this.fullname=sc.nextLine();
    System.out.println("\nenter your username: ");
    this.username=sc.nextLine();
    System.out.println("\nenter your password: ");
    this.password=sc.nextLine();
    System.out.println("\nenter your account number: ");
    this.accountno=sc.nextLine();
    System.out.println("\nregistration completed! kindly login to your account");
}
//login function
public boolean login(){
    boolean islogin=false;
    Scanner sc=new Scanner(System.in);
    while(!islogin){
        System.out.println("\nenter username: ");
        this.username=sc.nextLine();
        if(username.equals(username)){
            while(!islogin){
                System.out.println("\nenter password: ");
                this.password=sc.nextLine();
                if(password.equals(password)){
                    System.out.println("\nlogin succesfull !");
                    islogin =true;
                    
                }else{
                    System.out.println("\npassword incorrect");
                }
            }
        }else{
            System.out.println("\nusername not found");
        }
    }
    return islogin;

}
//Money withdrawl function
public void withdrawl(){
    Scanner sc=new Scanner(System.in);
    System.out.println("\nplease enter the amount");
    double amount=sc.nextDouble();
    try{
        if(balance>=amount){
            balance-=amount;
            System.out.println("\namount withdrawn succesful!");
            String str="Rs" +amount +"withdrawn";
            transactionhistory=transactionhistory.concat(str);
        }else{
            System.out.println("\nInsufficient funds");
        }
    }catch(Exception e){

    }
}
//Deposit function
public void deposit(){
    Scanner sc=new Scanner(System.in);
    System.out.println("\nplease enter the amount");
    double amount=sc.nextDouble();
    try{
        if(amount<3000000.00){
            transactions++;
            balance+=amount;
            System.out.println("\namount deposited succesful!");
            String str="Rs" +amount +"deposited\n";
            transactionhistory=transactionhistory.concat(str);
        }else{
            System.out.println("\nExcedded limit");
        }
    }catch(Exception e){

    }

}
//transfer function
public void Transfer(){
    Scanner sc=new Scanner(System.in);
    System.out.println("\nEnter the recipent name");
    String name=sc.nextLine();
    System.out.println("\nEnter amount to be transfered");
    double amount=sc.nextDouble();
    try{
        if(balance>=amount){
            if(amount>4000){
                transactions++;
                balance-=amount;
                System.out.println("\namount succesfully transfered to "+name);
                String str="Rs" +amount+ "transfered to" +name +"\n";
                transactionhistory=transactionhistory.concat(str);

            }else{
                System.out.println("\nLimit exceeded");
            }
        }else{
            System.out.println("\ninsufficient funds");
        }
        
    }catch(Exception e){
            
    }
}
//Balance check function
public void balance(){
     System.out.println("\n your account balance is"+balance);
}
//transactionhistory
public void transhistory(){
    if(transactions==0){
        System.out.println("\nempty");

    }else{
        System.out.println("\n"+transactionhistory);
    }
}


}



public class Atmmachine {
    public static int input(int uno){
        int input=0;
        boolean flag=false;
        while(!flag){
            try{
                Scanner sc=new Scanner(System.in);
                input=sc.nextInt();
                flag=true;
                if(flag && input>uno || input<1){
                    System.out.println("select the number between 1 to"+uno);
                    flag=false;
                }

            }catch(Exception e){
                System.out.println("Enter integer value ");
                flag=false;

            }
        }
        return input;
    }

   



    public static void main(String[] args) {
        System.out.println("welcome to BOI Atm");
        System.out.println("\n1.Register\n2.exit");
        System.out.println("\nplease enter your choice");
        int choice =input(2);
        if(choice==1){
           information am=new information();
            am.registration();
            while(true){
                System.out.println("\n1.login\n2.exit");
                System.out.println("enter your choice ");
                int ch=input(2);
                if(ch==1){
                    if(am.login()){
                        System.out.println("welcome back" +am.fullname);
                        boolean isfinished =false;
                    while(!isfinished){
                        System.out.println("\n1.Deposit\n2.Withdraw\n3.transfer\n4.check balance\n5.Transaction History");
                        System.out.println("Enter your choice");
                        int c=input(6);
                        switch(c){
                            case 1:
                            am.deposit();
                            break;
                            case 2:
                            am.withdrawl();
                            break;
                            case 3:
                            am.Transfer();
                            break;
                            case 4:
                            am.balance();
                            break;
                            case 5:
                            am.transhistory();
                            break;
                            case 6:
                            isfinished=true;
                            break;
                            default:
                            System.out.println("\nwrong choice");
                        }

                    }
                    }
                }System.exit(0);

            }

           


        }
        
    }
    
}