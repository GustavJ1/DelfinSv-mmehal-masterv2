import java.io.*;
import java.time.Period;
import java.time.LocalDate;
import java.util.ArrayList;

public class Member {

    private int memberId;
    private Gender gender;
    private String firstName;
    private String lastName;
    private String cpr;
    private boolean competitionSwimmer;
    private boolean membershipStatus;
    public boolean active;
    private int squad;

    public ArrayList<Member> members = new ArrayList<>();

    public Member(String cpr, String firstName, String lastName, Gender gender, int memberId) {
        this.memberId = memberId;
        this.cpr = cpr;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.competitionSwimmer = false;
        this.active = true;
        this.squad = assignSquadByCpr();
    }

    public Member() {

    }

    public int yearFromCpr() {
        int year = Integer.parseInt(cpr.substring(4, 6));

        if (year > 30) {
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

    public int assignSquadByCpr() {
        int squad = 0;
        int age = getAge();

        if (age < 18) {
            squad = 1;
        } else if (age >= 18) {
            squad = 3;

        } else if (age > 60) {
            squad = 5;
        }
        return squad;
    }

    public void memberListFileReader() {
        File file = new File("C:/Users/gusta/Downloads/DelfinSv-mmehal-master/DelfinSv-mmehal-master/MemberList.txt");
        int memberId = 0;

        try {
            BufferedReader memberListReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = memberListReader.readLine()) != null) {

                memberId ++;
                String[] parts = line.split(",");
                String cpr = parts[0];
                String firstName = parts[1];
                String lastName = parts[2];
                Gender gender = Gender.valueOf(parts[3]);

                Member member = new Member(cpr, firstName, lastName, gender, memberId);

                members.add(member);
            }
            memberListReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printMembers(){

        for (Member m : members) {
            System.out.println(m + "\n");
        }

    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + ". Medlems Nr: " + memberId;
    }
}
