import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Period;
import java.time.LocalDate;
import java.util.List;

public class Member {

    public int memberId;
    private final Gender gender;
    private String firstName;
    private String lastName;
    private final String cpr;
    private char competitionSwimmer;
    public boolean active;
    private boolean yearlyRenewalStatus;
    MemberRegistry memberRegistry;
    public boolean inArrears;

    public Member(String cpr, String firstName, String lastName, Gender gender, int memberId, char competitionSwimmer, boolean active) {
        this.cpr = cpr;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.competitionSwimmer = competitionSwimmer;
        this.active = active;
        this.memberId=memberId;
    }
    public boolean isActive(){
        return active;
    }

    public String getCompSwimmerString(){
        if (this.competitionSwimmer == 'T' ){
            return "T";
        } else return "K";
    }
    public boolean getActive(){
        return this.active;
    }

    public String stringFromGender() {
        if (this.gender == Gender.MAN) {
            return "MAN";
        } else return "WOMAN";
    }

    public int getMemberId(){
        return this.memberId;
    }

    public int yearFromCpr() {
        int year = Integer.parseInt(cpr.substring(4, 6));

        if (year > 25) {
            year += 1900;
        } else {
            year += 2000;
        }
        return year;
    }

    private int monthFromCpr() {
        return Integer.parseInt(cpr.substring(2, 4));
    }

    private int dayFromCpr() {
        return Integer.parseInt(cpr.substring(0, 2));
    }

    public int getAge() {
        Period age = Period.between(getBirthday(), LocalDate.now());
        return age.getYears();
    }

    private LocalDate getBirthday() {
        return LocalDate.of(yearFromCpr(), monthFromCpr(), dayFromCpr());
    }

    public char competitionSwimmer() {
        return competitionSwimmer;
    }

    public void setArrears(int iD) {
        File arrearsFile = new File("DelfinKlub/src/Arrears.txt");
        try{
            BufferedWriter writeArrearsFile = new BufferedWriter(new FileWriter(arrearsFile, true));
            writeArrearsFile.write(iD+""+"\n");
            writeArrearsFile.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setInArrears(boolean inArrears) {
        this.inArrears = inArrears;

    }

    public void paidArrears(int iD) {
        Path fileSource = Path.of("DelfinKlub/src/temparrears.txt");
        Path fileDestination = Path.of("DelfinKlub/src/Arrears.txt");

        try {
            List<String> lines = Files.readAllLines(fileDestination);

            String idRemoval = String.valueOf(iD);
            lines.removeIf(s -> s.equals(idRemoval));

            File newFile = new File("DelfinKlub/src/temparrears.txt");
            newFile.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter("DelfinKlub/src/temparrears.txt"));
            for (String line : lines){
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            File oldFiles = new File("DelfinKlub/src/Arrears.txt");
            oldFiles.delete();
            Files.move(fileSource, fileDestination);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCpr() {
        return cpr;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



    @Override
    public String toString() {
        return lastName + ", " + firstName + ". Medlems Nr: " + memberId + ", " + (competitionSwimmer == 'K' ? "Konkurrence Svømmer" : "Fritids Svømmer");
    }


}
