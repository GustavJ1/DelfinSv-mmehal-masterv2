import java.util.ArrayList;
import java.util.List;

public class Membership {
    MemberRegistry memberRegistry;
    Member member;
    private boolean yearlyRenewalStatus;
    Membership membership;

    public Membership() {

    }

    public double getPrice(Member member) {
        double price = 500;
        if (member.active) {
            int age = member.getAge();
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



    @Override
    public String toString() {
        return " ";
    }
}
