import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Training {

    LocalDate date;
    int placement;
    private static Member member;

    public ArrayList<Member> competitiveMembers = new ArrayList<>();

    public Training() {

    }

    public void addTraining(LocalDate date) {

        File backCrawl = new File("DelfinKlub/src/Backcrawl.txt");

        try {
            BufferedWriter writeTrainingFile = new BufferedWriter(new FileWriter(backCrawl, true));

            writeTrainingFile.write("Dato: ");
            writeTrainingFile.write(String.valueOf(date));
            writeTrainingFile.write("\n");
            writeTrainingFile.flush();

            trainingInfo(writeTrainingFile);

            writeTrainingFile.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void trainingInfo(BufferedWriter writeTrainingFile) throws IOException {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {

            System.out.println("Indtast MedlemsNr: ");
            int memberId = sc.nextInt();
            writeTrainingFile.write(memberId + ",");
            writeTrainingFile.flush();

            System.out.println("Indtast placering");
            int placement = sc.nextInt();
            writeTrainingFile.write("" + placement);
            writeTrainingFile.write("\n");
            writeTrainingFile.write("-");
            writeTrainingFile.flush();

            sc.close();
        }
    }

    public void readBackCrawl(String date) {

        try {
            String regex = "(0?[1-9]|[12][0-9]|3[01])[/|-](0?[1-9]|1[0-2])[/|-][0-9]{4}";
            String regex2 = "-";
            String line;

            BufferedReader readTrainingFile = new BufferedReader(new FileReader("DelfinKlub/src/Backcrawl.txt"));

            while ((line = readTrainingFile.readLine()) != null) {

                if (line.equals(date) && date.matches(regex)) {
                    System.out.println(line);

                    while ((line = readTrainingFile.readLine()) != null) {
                        System.out.println(line);

                        if (line.equals(regex2)) {
                            break;
                        }
                    }
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("fil ikke fundet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void readCrawl(String date) {

        try {
            String regex = "(0?[1-9]|[12][0-9]|3[01])[/|-](0?[1-9]|1[0-2])[/|-][0-9]{4}";
            String regex2 = "-";
            String line;

            BufferedReader readTrainingFile = new BufferedReader(new FileReader("DelfinKlub/src/crawl.txt"));

            while ((line = readTrainingFile.readLine()) != null) {

                if (line.equals(date) && date.matches(regex)) {
                    System.out.println(line);

                    while ((line = readTrainingFile.readLine()) != null) {
                        System.out.println(line);

                        if (line.equals(regex2)) {
                            break;
                        }
                    }
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("fil ikke fundet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readBreastStroke(String date) {

        try {
            String regex = "(0?[1-9]|[12][0-9]|3[01])[/|-](0?[1-9]|1[0-2])[/|-][0-9]{4}";
            String regex2 = "-";
            String line;

            BufferedReader readTrainingFile = new BufferedReader(new FileReader("DelfinKlub/src/BreastStroke.txt"));

            while ((line = readTrainingFile.readLine()) != null) {

                if (line.equals(date) && date.matches(regex)) {
                    System.out.println(line);

                    while ((line = readTrainingFile.readLine()) != null) {
                        System.out.println(line);

                        if (line.equals(regex2)) {
                            break;
                        }
                    }
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("fil ikke fundet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void readButterfly(String date) {

        try {
            String regex = "(0?[1-9]|[12][0-9]|3[01])[/|-](0?[1-9]|1[0-2])[/|-][0-9]{4}";
            String regex2 = "-";
            String line;

            BufferedReader readTrainingFile = new BufferedReader(new FileReader("DelfinKlub/src/ButterFly.txt"));

            while ((line = readTrainingFile.readLine()) != null) {

                if (line.equals(date) && date.matches(regex)) {
                    System.out.println(line);

                    while ((line = readTrainingFile.readLine()) != null) {
                        System.out.println(line);

                        if (line.equals(regex2)) {
                            break;
                        }
                    }
                    break;
                }
            }
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