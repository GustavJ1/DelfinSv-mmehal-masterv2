import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Console {
    Member member;
    MemberRegistry memberRegistry;
    Training training;
    Membership membership;
    Scanner sc = new Scanner(System.in);
    boolean running = true;

    public void Program() {

        while (running) {


            System.out.println("Velkommen til Delfin Club");
            System.out.println("Tast 1 for [Coach] \nTast 2 for [Formand] \nTast 3 for [Kasserer]");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Tast 1 for at indskrive træningsresultater\n" +
                            "Tast 2 for indskrive konkurrenceresultater \n" +
                            "Tast 3 for at se træningsresultater");

                    int choices = sc.nextInt();

                    if (choices == 1) {
                        System.out.println("Enter date (yyyy-MM-dd)");
                        String input = sc.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                        try {
                            LocalDate myDate = LocalDate.parse(input, formatter);
                            training.readBackCrawl(myDate.toString());

                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                    } else if (choices == 2) {

                    } else if (choices == 3) {
                        System.out.println("""
                                Hvad vil du se resultater for?\s
                                [1] Backcrawl
                                [2] Breaststroke
                                [3] Butterfly
                                [4] Crawl""");

                        int chooseFile = sc.nextInt();
                        if (chooseFile == 1) {
                            System.out.println("Vælg dato");
                            String date = sc.nextLine();
                            training.readBackCrawl(date);

                        }
                        else if (chooseFile==2){
                            System.out.println("vælg dato");
                            //training.readBreastStroke(sc.nextLine());
                        }
                    }

                    break;

                case 2:


                    break;
                case 0:
                    System.out.println("programmet afsluttet");
                    running = false;
                    break;
                default:
                    System.out.println("ugyldigt valg");
                    break;
            }


        }
    }
}
/*                 */

/* Scanner start menu - "velkommen til Delfin Club
Coach / Formand / Kasserer
Coach {
tast 1 opret training
tast 2 opret competition
tast 3 print trainingResults (skal man have noget funktionalitet i forhold til udtagelse til competition?)
tast 4 print competitionResults
}
Formand {
tast 1 opret medlem
Tast 2 fjern medlem
Tast 3 liste af medlemmer
}
Kasserer {
Tast 1 se totalRevenue (periode)
tast 2 se medlemmer i restance
tast 3 se specifik medlem kontingent

}
*/