import java.util.ArrayList;
import java.util.List;

public class CheckInfo {
    private String name;
    private String surName;
    private String patronymic;
    private String birthDay;
    private String phoneNumber;
    private char gender;
    private ArrayList<String> array;
    public CheckInfo() {

    }

    protected String getName() {
        return name;
    }

    protected String getSurName() {
        return surName;
    }

    protected String getPatronymic() {
        return patronymic;
    }

    protected String getBirthDay() {
        return birthDay;
    }

    protected String getPhoneNumber() {
        return phoneNumber;
    }

    protected char getGender() {
        return gender;
    }

    public CheckInfo(ArrayList<String> array) {
        this.array = array;
    }

    private void parseArray() {
        List<String> tempoArr = new ArrayList<>();
        for (int i = array.size() - 1; i >= 0; i--) {
            if (array.get(i).length() == 1) {
                gender = array.get(i).charAt(0);
                tempoArr.add(array.get(i));
            }
            if (array.get(i).contains(".") && array.get(i).length() > 1) {
                birthDay = array.get(i);
                tempoArr.add(array.get(i));
            }
        }
        array.removeAll(tempoArr);
        surName = array.get(0);
        name = array.get(1);
        patronymic = array.get(2);
        phoneNumber = array.get(3);
    }

    protected boolean isNumeric(String str) {
        try {
            int tempo = Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public boolean checkResult() {
        parseArray();
        try {
            if(surName != null && name != null && patronymic != null && birthDay != null && phoneNumber != 0 && gender!=0) {
                System.out.printf("surname %s, name %s, p %s,birthday %s, phone %d, sex %s ", surName, name, patronymic, birthDay, phoneNumber, gender);
            }else{
                throw new UncorrectedData();
            }
        }catch(UncorrectedData e){
            System.out.println(e.getMessage());
        }
        return true;
    }

}