import java.io.*;
import java.time.Period;
import java.time.LocalDate;
public class Member {

    public int memberId;
    private final Gender gender;
    private String firstName;
    private String lastName;
    private final String cpr;
    private char competitionSwimmer;
    public boolean active;

    public Member(String cpr, String firstName, String lastName, Gender gender, int memberId, char competitionSwimmer) {
        this.cpr = cpr;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.competitionSwimmer = competitionSwimmer;
        this.active = true;
        this.memberId=memberId;
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


    @Override
    public String toString() {
        return lastName + ", " + firstName + ". Medlems Nr: " + memberId + ", " + (competitionSwimmer == 'K' ? "Konkurrence Svømmer" : "Fritids Svømmer");
    }
}
