import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class MemberRegistry {
    public ArrayList<Member> members = new ArrayList<>();
    public List<Member> arrears = new ArrayList<>();
    Membership membership;


    public MemberRegistry(Membership membership) {
        this.membership = membership;
    }

    public void showMembers() {
        System.out.println("List of all current members");
        for (Member m : members) {
            System.out.println(m + " ");
        }
    }


    public void memberListFileReader() {
        members.clear();
        File file = new File("DelfinKlub/src/MemberList.txt");
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
                boolean active = Boolean.parseBoolean((parts[5]));

                int memberId = id;
                id++;

                Member member = new Member(cpr, firstName, lastName, gender, memberId, competitionSwimmer, active);
                members.add(member);
            }
            memberListReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMember(Member member) {

        Member m = (member);

        String memberLine =
                m.getCpr() + "," + m.getFirstName() + "," + m.getLastName() + "," + m.stringFromGender() + "," + m.getCompSwimmerString() + "," + m.isActive();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("DelfinKlub/src/MemberList.txt", true));
            bw.write(memberLine);
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
            memberListFileReader();
        }
    }


    public void removeMember(int id) {
        Path fileSource = Path.of("DelfinKlub/src/tempmembers.txt");
        Path fileDestination = Path.of("DelfinKlub/src/MemberList.txt");
        Member rm = memberFromId(id - 1);
        rm.paidArrears(rm.getMemberId());
        String memberLine = rm.getCpr() + "," + rm.getFirstName() + "," + rm.getLastName() + "," + rm.stringFromGender() + "," + rm.getCompSwimmerString();
        try {
            List<String> lines = Files.readAllLines(fileDestination);

            lines.removeIf(s -> s.equals(memberLine));

            File newFile = new File("DelfinKlub/src/tempmembers.txt");
            newFile.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter("DelfinKlub/src/tempmembers.txt"));
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            Files.move(fileSource, fileDestination, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        memberListFileReader();
    }

    public int getAmountOfMembers() {
        return members.size();
    }

    public Member memberFromId(int Id) {
        return members.get(Id);
    }

    // tjekker for arreas txt filen og giver output tilbage med folk der " mangler betaling"
    public void checkArrearsStatus() {
        for (Member m : members) {
            m.setInArrears(false);
        }
        arrears.clear();
        try {
            List<String> lines = Files.readAllLines(
                    Path.of("DelfinKlub/src/Arrears.txt"));

            for (String line : lines) {
                if (line.trim().isEmpty()) continue;

                int memberId = Integer.parseInt(line.trim());
                Member m = memberFromId(memberId);
                if (m != null) {
                    m.setInArrears(true);
                    arrears.add(m);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Medlemmer der mangler betaling:");

        for (Member m : arrears) {

            System.out.println(m + "\n");

        }
    }

    // printer total omsætning samt antal medlemmer
    public String totalrevenue() {

        double revenue = 0;
        for (Member m : members) {
            revenue += membership.getPrice(m);
        }

        return "___________________________________________\n"
                + "Total omsætning = " + revenue + " kr,-\n" +
                "Antal medlemmer: " + getAmountOfMembers() + "\n" +
                "___________________________________________\n";
    }
}