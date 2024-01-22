import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat ;


class UserInterface {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       System.out.println("Enter the Connection ID : ");
       int connectionId = scanner.nextInt();

       System.out.println("Enter the Connection Type : ");
       String connectionType = scanner.next().toUpperCase();

       System.out.println("Enter the Previous Reading : ");
       int previousReading = scanner.nextInt();

       System.out.println("Enter the Current Reading : ");
       int currentReading = scanner.nextInt();

       String connectionStatus = checkConnectionType(connectionType);
       if (connectionStatus.equals("Valid Connection")) {
           int readingValue = currentReading - previousReading;
           double price = readingValue > 200 ? 5 : 2;
           double billAmount = readingValue * price;

           System.out.println("Bill Amount (LongNumberFormat) : " + longNumberFormat((int)billAmount));
           System.out.println("Bill Amount (ShortNumberFormat) : " + shortNumberFormat((int)billAmount));
       } else {
           System.out.println("Invalid Connection");
       }
   }

   public static String checkConnectionType(String connectionType) {
       switch(connectionType){
        case "SinglePhase" , "ThreePhase" , "SINGLEPHASE" , "THREEPHASE" :
               return ("Valid Connection");
        default: 
                return ("Invalid Connection");
       }
   }

   public static String longNumberFormat(int number) {
    NumberFormat  formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style. LONG);
    String res = formatter.format(number);
    return res ;
}


   public static String shortNumberFormat(int number) {
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US , NumberFormat.Style.SHORT);
        String res1 = formatter.format(number) ;
        return res1 ;
   }

}
