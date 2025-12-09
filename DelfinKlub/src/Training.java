import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Training {

    LocalDate date;
    int placement;
    private static Member member;

    public ArrayList<Member> competitiveMembers = new ArrayList<>();

    public Training() {

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
                writeTrainingFile.flush();
            }
            writeTrainingFile.write("-");
            sc.close();
    }

    public void addBackCrawl(LocalDate date) { // BackCrawl

        File backCrawl = new File("DelfinKlub/src/Backcrawl.txt");

        try {
            BufferedWriter writeTrainingFile = new BufferedWriter(new FileWriter(backCrawl, true));
            writeTrainingFile.write(String.valueOf(date));
            writeTrainingFile.write("\n");
            writeTrainingFile.flush();

            trainingInfo(writeTrainingFile);

            writeTrainingFile.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBreastStroke(LocalDate date) { // BreastStroke

        File backCrawl = new File("DelfinKlub/src/Breaststroke.txt");

        try {
            BufferedWriter writeTrainingFile = new BufferedWriter(new FileWriter(backCrawl, true));

            writeTrainingFile.write(String.valueOf(date));
            writeTrainingFile.write("\n");
            writeTrainingFile.flush();

            trainingInfo(writeTrainingFile);

            writeTrainingFile.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addButterfly(LocalDate date) { //Butterfly

        File backCrawl = new File("DelfinKlub/src/Butterfly.txt");

        try {
            BufferedWriter writeTrainingFile = new BufferedWriter(new FileWriter(backCrawl, true));

            writeTrainingFile.write(String.valueOf(date));
            writeTrainingFile.write("\n");
            writeTrainingFile.flush();

            trainingInfo(writeTrainingFile);

            writeTrainingFile.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addCrawl(LocalDate date) {

        File backCrawl = new File("DelfinKlub/src/Crawl.txt");

        try {
            BufferedWriter writeTrainingFile = new BufferedWriter(new FileWriter(backCrawl, true));

            writeTrainingFile.write(String.valueOf(date));
            writeTrainingFile.write("\n");
            writeTrainingFile.flush();

            trainingInfo(writeTrainingFile);

            writeTrainingFile.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void readBackCrawl(String date) {

        try {
            String startRegex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
            String stopRegex = "-";
            String line;

            BufferedReader readTrainingFile = new BufferedReader(new FileReader("DelfinKlub/src/Backcrawl.txt"));

            while ((line = readTrainingFile.readLine()) != null) {

                if (line.equals(date) && date.matches(startRegex)) {
                    System.out.println(line);

                    while ((line = readTrainingFile.readLine()) != null) {
                        System.out.println(line);

                        if (line.equals(stopRegex)) {
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
            String startRegex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
            String stopRegex = "-";
            String line;

            BufferedReader readTrainingFile = new BufferedReader(new FileReader("DelfinKlub/src/crawl.txt"));

            while ((line = readTrainingFile.readLine()) != null) {

                if (line.equals(date) && date.matches(startRegex)) {
                    System.out.println(line);

                    while ((line = readTrainingFile.readLine()) != null) {
                        System.out.println(line);

                        if (line.equals(stopRegex)) {
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
            String startRegex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
            String stopRegex = "-";
            String line;

            BufferedReader readTrainingFile = new BufferedReader(new FileReader("DelfinKlub/src/BreastStroke.txt"));

            while ((line = readTrainingFile.readLine()) != null) {

                if (line.equals(date) && date.matches(startRegex)) {
                    System.out.println(line);

                    while ((line = readTrainingFile.readLine()) != null) {
                        System.out.println(line);

                        if (line.equals(stopRegex)) {
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
            String startRegex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
            String stopRegex = "-";
            String line;

            BufferedReader readTrainingFile = new BufferedReader(new FileReader("DelfinKlub/src/ButterFly.txt"));

            while ((line = readTrainingFile.readLine()) != null) {

                if (line.equals(date) && date.matches(startRegex)) {
                    System.out.println(line);

                    while ((line = readTrainingFile.readLine()) != null) {
                        System.out.println(line);

                        if (line.equals(stopRegex)) {
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