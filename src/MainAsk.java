import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainAsk {
    private boolean mainFlag = true;
    private final ArrayList<String> info = new ArrayList<>();
    public ArrayList<String> getInfo() {
        mainAsk();
        return info;
    }

    private ArrayList<String> mainAsk() {
        while (mainFlag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите через пробел: Фамилию Имя Отчество, дату рождения(в формате dd.mm.yyyy), номер телефона, пол(f или m)");
            String[] result = scanner.nextLine().trim().split(" ");
            try{
                if(result.length-1 == 5) {
                    info.addAll(Arrays.asList(result));
                    System.out.println("Принято");
                    mainFlag = false;
                }else{
                    throw new FillArrayException(result);
                }
            }catch(FillArrayException e){
                System.out.println(e.getMessage());
            }
        }
        return info;
    }
}
