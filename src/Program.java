import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        FillDictionary fillDictionary = new FillDictionary();
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Нажмите любую кнопку, для выхода наберите 0");
            if (!scanner.nextLine().equals("0")) {
                MainAsk ask1 = new MainAsk();
                CheckInfo check = new CheckInfo(ask1.getInfo());
                boolean result = check.checkResult();
                if (result) {
                    SpotCheck spotCheck = new SpotCheck(check.getName(), check.getSurName(), check.getPatronymic(), check.getBirthDay(), check.getPhoneNumber(), check.getGender());
                    StringRecordFormat recordFormat = new StringRecordFormat(check.getName(), check.getSurName(), check.getPatronymic(), check.getBirthDay(), check.getPhoneNumber(), check.getGender());
                    fillDictionary.addDict(check.getName(), check.getSurName(), check.getPatronymic(), check.getBirthDay(), (String) check.getPhoneNumber(), check.getGender());
                    fillDictionary.show();
                    try (BufferedWriter buff = new BufferedWriter(new FileWriter(check.getSurName() + ".txt"))) {
                        buff.write(recordFormat.StringBuild());
                    }
                }

            }else{
                flag = false;
            }
        }
    }
}