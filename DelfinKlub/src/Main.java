import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Membership membership = new Membership();
        Console console = new Console();
        Member member = new Member("1010901010", "gustav", "jantzen", Gender.MAN, 1, 'k');

       console.Program();


    }

}

