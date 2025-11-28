import java.util.ArrayList;
import java.util.List;

public class MemberType extends Member {


    private boolean yearlyRenewalStatus;

    public MemberType(String cpr, String firstName, String lastName, Gender gender, int memberId) {
       super(cpr, firstName, lastName, gender, memberId);
       this.yearlyRenewalStatus = true;
    }

    public double getPrice() {
        double price = 500;
        if (active) {
            int age = getAge();
            if (age >= 60) {
                price = 1600 * 0.75;
            } else if (age >= 18) {
                price = 1600;
            } else {
                price = 1000;
            }
        }
        return price;
    }

    public void setArrears(){
        this.yearlyRenewalStatus = false;
    }

    public void showMembers() {
        System.out.println("List of all current members");
        for (Member m : members) {
            System.out.println(m + " ");
        }
    }

    public void checkYearlyRenewalStatus() {
        for (Member member : members) {

            if (yearlyRenewalStatus = false) {

                List<Member> arrears = new ArrayList<>();

                arrears.add(member);
            }
        }
    }
}
