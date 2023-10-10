import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        FillDictionary forDictionary = new FillDictionary();
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Нажмите любую кнопку, для выхода - 0");
            if (!scanner.nextLine().equals("0")) {
                MainAsk ask1 = new MainAsk();
                CheckInfo check = new CheckInfo(ask1.getInfo());
                boolean result = check.checkResult();
                if (result) {
                    SpotCheck spotCheck = new SpotCheck(check.getName(), check.getSurName(), check.getPatronymic(), check.getBirthDay(), check.getPhoneNumber(), check.getGender());
                    try {
                        if (spotCheck.outCome()) {
                            StringRecordFormat recordFormat = new StringRecordFormat(check.getName(), check.getSurName(), check.getPatronymic(), check.getBirthDay(), check.getPhoneNumber(), check.getGender());
                            forDictionary.addDict(check.getName(), check.getSurName(), check.getPatronymic(), check.getBirthDay(), check.getPhoneNumber(), check.getGender());
                            forDictionary.show();
                            try (BufferedWriter buff = new BufferedWriter(new FileWriter(check.getSurName() + ".txt"))) {
                                buff.write(recordFormat.StringBuild());
                            }
                        }
                    } catch (NotStringException e) {
                        System.out.println(e.getMessage());
                    } catch (BirthdayException e) {
                        System.out.println(e.getMessage());
                    } catch (UncorrectedGender e) {
                        System.out.println(e.getMessage());
                    }
                }

            }else{
                flag = false;
            }
        }
    }
}