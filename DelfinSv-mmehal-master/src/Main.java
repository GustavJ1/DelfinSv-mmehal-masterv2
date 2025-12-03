import java.io.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        MemberRegistry memberRegistry = new MemberRegistry();
        memberRegistry.memberListFileReader();
        memberRegistry.showMembers();
        memberRegistry.checkArreasStatus();


        //  tr.addTraining(me, LocalDate.now(), 1);
        //  tr.addTraining(me, LocalDate.now(), 2);


    }


}

