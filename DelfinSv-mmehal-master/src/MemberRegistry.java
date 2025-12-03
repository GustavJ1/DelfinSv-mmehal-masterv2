import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemberRegistry {
    Member member;
    public ArrayList<Member> members = new ArrayList<>();
    private boolean yearlyRenewalStatus;
    private int squad;
    public List<Member> arrears = new ArrayList<>();
    private boolean isArreas;
    Membership membership;


    public MemberRegistry(Membership membership) {
        this.membership=membership;

    }

    public void showMembers() {
        System.out.println("List of all current members");
        for (Member m : members) {
            System.out.println(m + " ");
        }
    }

    public int assignSquadByCpr() {
        if (member.getAge() < 18) return 1;
        if (member.getAge() > 60) return 5;
        return 3;
    }

    public boolean isCompetitionSwimmer() {
        return member.competitionSwimmer() == 'K';
    }

    public void memberListFileReader() {
        File file = new File("C:\\Users\\gusta\\IdeaProjects\\DelfinSv-mmehal-masterv2\\DelfinSv-mmehal-master\\MemberList.txt");
        int id = 1;

        try {
            BufferedReader memberListReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = memberListReader.readLine()) != null) {

                String[] parts = line.split(",");
                String cpr = parts[0];
                String firstName = parts[1];
                String lastName = parts[2];
                Gender gender = Gender.valueOf(parts[3]);
                char competitionSwimmer = (parts[4].charAt(0));
                boolean inArreas = false;
                if (parts.length > 5) {
                    inArreas = parts[5].equalsIgnoreCase("ALERT");
                }
                int memberId = id;
                id++;

                Member member = new Member(cpr, firstName, lastName, gender, memberId, competitionSwimmer, inArreas);
                members.add(member);

            }
            memberListReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkArreasStatus() {
        System.out.println("Medlemmer der mangler betaling:");
        for (Member m : members) {


            if (m.inArreas) {
                arrears.add(m);
                System.out.println(m + "\n");
            }



        }


    }
    public double totalrevenue() {

        double revenue = 0;
        for (Member m : members) {
            revenue += membership.getPrice(m);


        }
        return revenue;
    }



}
