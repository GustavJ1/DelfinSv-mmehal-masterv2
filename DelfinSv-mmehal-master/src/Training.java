import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Training {
    private final File file;
    Disciplin disciplin;
    LocalDate date;

    public Training(File file) {
        this.file = file;
    }

   public void createTrainingFile() {

        File currentTraining = new File("");

        try {
            BufferedWriter writeTrainingFile = new BufferedWriter(new FileWriter(currentTraining));

            Scanner userInput = new Scanner(System.in);

            while ()  {




            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readTrainingFile() {

        try {
            BufferedReader readTrainingFile = new BufferedReader(new FileReader(file));
            String line;

            while ((line = readTrainingFile.readLine()) != null) {
                System.out.println(line);
            }
            readTrainingFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("fil ikke fundet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//
//      public void sortMemberByPlacementInDisciplines() {
//
//    }
//
//    public void addTopFiveToCompetition() {
//
//    }


    @Override
    public String toString() {
        return "SDSDSDSD";
    }
}
