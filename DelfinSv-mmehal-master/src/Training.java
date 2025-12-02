import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Training {

    Disciplin disciplin;
    LocalDate date;
    int placement;
    Member member;

    public ArrayList<Member> competitiveMembers = new ArrayList<>();

    public Training(LocalDate date, int placement, Member member, Disciplin disciplin) {
        this.date = date;
        this.placement = placement;
        this.member = member;
    }

//    public void addTraining(Member member, LocalDate date, int placement) {
//
//        File currentTraining = new File("TrainingResults.txt");
//
//        try {
//            BufferedWriter writeTrainingFile = new BufferedWriter(new FileWriter(currentTraining, true));
//
//            writeTrainingFile.write("Dato: ");
//            writeTrainingFile.write(String.valueOf(date));
//            writeTrainingFile.write(", MedlemsNr: ");
//            writeTrainingFile.write(String.valueOf(member.getMemberId()));
//            writeTrainingFile.write(", Stilling: ");
//            writeTrainingFile.write(String.valueOf(placement));
//            writeTrainingFile.write("\n");
//            writeTrainingFile.flush();
//
//            /*
//            Fil indhold: Dato, id, placering
//            Bufferedwriter
//            Hent memberlist
//            Random: Placement
//            Sort: Efter placering
//            write to file loop
//             */
//        writeTrainingFile.close();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

public void readCrawl() {

    try {
        BufferedReader readTrainingFile = new BufferedReader(new FileReader("Crawl.txt)"));
        String line;

        while ((line = readTrainingFile.readLine()) != null) {

        }
        readTrainingFile.close();

    } catch (FileNotFoundException e) {
        System.out.println("fil ikke fundet");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

    public void readBreastStroke() {

        try {
            BufferedReader readTrainingFile = new BufferedReader(new FileReader("Breaststroke.txt)"));
            String line;

            while ((line = readTrainingFile.readLine()) != null) {

            }
            readTrainingFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("fil ikke fundet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readBackCraw() {

        try {
            BufferedReader readTrainingFile = new BufferedReader(new FileReader("Backcrawl.txt)"));
            String line;

            while ((line = readTrainingFile.readLine()) != null) {

            }
            readTrainingFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("fil ikke fundet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readButterfly() {

        try {
            BufferedReader readTrainingFile = new BufferedReader(new FileReader("Butterfly.txt)"));
            String line;

            while ((line = readTrainingFile.readLine()) != null) {

            }
            readTrainingFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("fil ikke fundet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return " ";
    }
}
