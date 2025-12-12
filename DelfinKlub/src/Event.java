import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Event {

    public Event() {
    }

    private void eventInfo(BufferedWriter writeTrainingFile) throws IOException {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {

            System.out.println("Indtast MedlemsNr: ");
            System.out.println("↓");
            int memberId = sc.nextInt();
            writeTrainingFile.write(memberId + ",");

            System.out.println("Indtast placering");
            System.out.println("↓");
            int placement = sc.nextInt();
            writeTrainingFile.write("" + placement);
            writeTrainingFile.write("\n");
        }

        System.out.println("Vil du tilføje flere discipliner for dagens træning (ja/nej)");
        System.out.println("↓");
        String input = sc.next();

        if (Objects.equals(input, "ja")) {
            writeTrainingFile.flush();

            System.out.println("Disciplin: ");
            System.out.println("↓");
            Disciplin disciplin = Disciplin.valueOf(sc.next().toUpperCase());

            writeTrainingFile.write(String.valueOf(disciplin));
            writeTrainingFile.write("\n");
            eventInfo(writeTrainingFile);
        } else {
            writeTrainingFile.write("-");
            writeTrainingFile.write("\n");
            writeTrainingFile.flush();
        }
    }

    public void eventDate(Disciplin disciplin, String pathname) {

        File filePath = new File(pathname);

        try {
            BufferedWriter writeTrainingFile = new BufferedWriter(new FileWriter(filePath, true));
            writeTrainingFile.write(LocalDate.now() + "\n");
            writeTrainingFile.write(String.valueOf(disciplin));
            writeTrainingFile.write("\n");
            writeTrainingFile.flush();

            eventInfo(writeTrainingFile);

            writeTrainingFile.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void manuallyEnterEventDate(LocalDate date, Disciplin disciplin, String pathname) {

        File filePath = new File(pathname);

        try {
            BufferedWriter writeTrainingFile = new BufferedWriter(new FileWriter(filePath, true));
            writeTrainingFile.write((date + "\n"));
            writeTrainingFile.write(String.valueOf(disciplin));
            writeTrainingFile.write("\n");
            writeTrainingFile.flush();

            eventInfo(writeTrainingFile);

            writeTrainingFile.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readEvent(String date, String filePath)  {

        try {
            String startRegex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
            String line;

            if (!date.matches(startRegex)) {
                System.out.println("Fokert dato format (yyyy-MM-dd)");
            }

            try {
                BufferedReader readTrainingFile = new BufferedReader(new FileReader(filePath));

                while ((line = readTrainingFile.readLine()) != null) {

                    if (line.equals(date)) {
                        System.out.println(filePath + " resultater " + "- " + date + ":");

                        while ((line = readTrainingFile.readLine()) != null) {

                            if (line.equals("-")) {
                                return;
                            }
                            System.out.println(line);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("fil ikke fundet");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return " ";
    }
}