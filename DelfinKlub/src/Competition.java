import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.lang.*;

public class Competition {
    Membership ms = new Membership();
    MemberRegistry memberRegistry = new MemberRegistry(ms);

    List<Member> seniorCompetitionMembers = new ArrayList<>();
    List<Member> juniorCompetitionMembers = new ArrayList<>();

    private LocalTime raceTime;
    private int memberId;

    public Competition(int memberId, LocalTime raceTime) {
        this.raceTime = raceTime;
        this.memberId = memberId;
    }

    public Competition() {
    }

    public LocalTime getRaceTime() {
        return raceTime;
    }

    public void addCompetitionMembers() {

        seniorCompetitionMembers.clear();
        juniorCompetitionMembers.clear();
        memberRegistry.memberListFileReader();

        for (Member member : memberRegistry.members) {
            if (member.isCompetitionSwimmer()) {
                int age = member.getAge();

                if (age >= 18) {
                    seniorCompetitionMembers.add(member);
                }
                if (age < 18)
                    juniorCompetitionMembers.add(member);
            }
        }
    }

    public void writeCompFile() {

        memberRegistry.memberListFileReader();
        addCompetitionMembers();
        Scanner sc = new Scanner(System.in);

        try {
            BufferedWriter writeCompetitionFile = new BufferedWriter(new FileWriter("DelfinKlub/src/Competition.txt", true));

            System.out.println("Disciplin: ");
            System.out.println("↓");
            Disciplin disciplin = Disciplin.valueOf(sc.next().toUpperCase());
            writeCompetitionFile.write(LocalDate.now() + "\n");
            writeCompetitionFile.write(String.valueOf(disciplin) + "\n");

            // Indsæt metode der kalder junior eller senior (Printer overskriften)
            System.out.println("Vil du skrive for Junior eller Senior medlemmer?");
            String input = sc.next();

            if (Objects.equals(input.toLowerCase(), "senior")) {
                seniorFileWriter(writeCompetitionFile);
            } else if (Objects.equals(input.toLowerCase(), "junior")) {
                juniorFileWriter(writeCompetitionFile);
            }
            writeCompetitionFile.flush();
            writeCompetitionFile.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void seniorFileWriter(BufferedWriter writer) throws IOException {

        writer.write("SENIOR" + "\n");

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {

            while (true) {
                System.out.println("Indtast MedlemsNr: ");
                System.out.println("↓");
                int compMId = sc.nextInt();
                Member compMember = memberRegistry.memberFromId(compMId);

                boolean found = false;

                for (Member senior : seniorCompetitionMembers) {
                    if (compMember == senior) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    this.memberId = compMId;
                    break;
                }
                System.out.println("Medlem er ikke aktiv i konkurrencer/ikke et senior medlem");
            }
            System.out.println("Indtast konkurrence resultat (mm:ss:ms): ");
            System.out.println("↓");
            LocalTime seniorTime = LocalTime.parse(sc.next());
            String seniorLine = memberId + "," + seniorTime + "\n";
            writer.write(seniorLine);
        }
        System.out.println("Vil du tilføje flere resultater fra dagens konkurrence (ja/nej)");
        System.out.println("↓");
        String input = sc.next();

        if (Objects.equals(input, "ja")) {
            writer.write("-\n");
            writer.flush();
            System.out.println("Disciplin: ");
            System.out.println("↓");
            writer.write(LocalDate.now() + "\n");
            Disciplin disciplin = Disciplin.valueOf(sc.next().toUpperCase());

            writer.write(String.valueOf(disciplin));
            writer.write("\n");
            seniorFileWriter(writer);
        } else {
            writer.write("-");
            writer.write("\n");
            writer.flush();
        }
    }

    public void juniorFileWriter(BufferedWriter writer) throws IOException {

        writer.write("JUNIOR" + "\n");

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {

            while (true) {
                System.out.println("Indtast MedlemsNr: ");
                System.out.println("↓");
                int compMId = sc.nextInt();
                Member compMember = memberRegistry.memberFromId(compMId);

                boolean found = false;

                for (Member junior : juniorCompetitionMembers) {
                    if (compMember == junior) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    this.memberId = compMId;
                    break;
                }
                System.out.println("Medlem er ikke aktiv i konkurrencer/ikke et junior medlem");
            }
            System.out.println("Indtast konkurrence resultat (mm:ss:ms): ");
            System.out.println("↓");
            LocalTime juniorTime = LocalTime.parse(sc.next());


            String juniorLine = memberId + "," + juniorTime + "\n";
            writer.write(juniorLine);
        }

        System.out.println("Vil du tilføje flere resultater fra dagens konkurrence (ja/nej)");
        System.out.println("↓");
        String input = sc.next();

        if (Objects.equals(input, "ja")) {
            writer.write("-\n");
            writer.flush();

            System.out.println("Dicsiplin: ");
            System.out.println("↓");
            writer.write(LocalDate.now() + "\n");
            Disciplin disciplin = Disciplin.valueOf(sc.next().toUpperCase());

            writer.write(String.valueOf(disciplin));
            writer.write("\n");
            juniorFileWriter(writer);
        } else {
            writer.write("-");
            writer.write("\n");
            writer.flush();
        }
    }

    public void readCompetitionFile(String date, String disciplin, String ageGroup, File filePath) {

        List<Competition> compList = new ArrayList<>();
        memberRegistry.memberListFileReader();
        boolean dateBlock = false;
        boolean disciplineMatched = false;
        boolean ageMatched = false;

        try {
            String startRegex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
            String line;

            if (!date.matches(startRegex)) {
                System.out.println("Ugyldigt datoformat");
                return;
            }

            try {
                BufferedReader readTrainingFile = new BufferedReader(new FileReader(filePath));

                while ((line = readTrainingFile.readLine()) != null) {

                    if (line.equals(date)) {
                        dateBlock = true;
                        continue;
                    }

                    if (dateBlock) {

                        if (line.matches(disciplin.toUpperCase())) {

                            disciplineMatched = true;
                            continue;
                        }

                        if (disciplineMatched) {
                            if (line.equals(ageGroup.toUpperCase())) {
                                ageMatched = true;
                                System.out.println(line);

                            }
                            if (ageMatched) {
                                System.out.println("Resultater" + " - " + date + ":");

                                while ((line = readTrainingFile.readLine()) != null) {


                                    if (line.contains(",")) {
                                        String[] parts = line.split(",");
                                        int memberId = Integer.parseInt(parts[0]);
                                        LocalTime raceTime = LocalTime.parse(parts[1]);

                                        Competition c = new Competition(memberId, raceTime);
                                        compList.add(c);
                                    }

                                    if (line.equals("-")) {
                                        Collections.sort(compList, new TimeComparator());
                                        compList.forEach(System.out::println);
                                        break;
                                    }
                                }

                            }
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
        return memberId + ": " + raceTime;
    }
}