import java.io.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Membership membership = new Membership();
        Member member= new Member("1010901010","gustav","jantzen",Gender.MAN,1,'k',false);
        MemberRegistry memberRegistry = new MemberRegistry(membership);
        memberRegistry.memberListFileReader();
        memberRegistry.showMembers();
        memberRegistry.checkArreasStatus();
        System.out.println("membership:" + membership);
        System.out.println(membership.getPrice(member));
        System.out.println(memberRegistry.totalrevenue());


        //  tr.addTraining(me, LocalDate.now(), 1);
        //  tr.addTraining(me, LocalDate.now(), 2);


    }

}

