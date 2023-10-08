public class SpotCheck extends CheckInfo {
    private String name;
    private String surName;
    private String patronymic;
    private String birthDay;
    private String  phoneNumber;
    private char gender;
    public SpotCheck(String name, String surName, String patronymic, String birthDay, String phoneNumber, char gender){
        this.surName = surName;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

        private boolean isBirthday(String s) throws BirthdayException {
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            if(isNumeric(arr[0])&&isNumeric(arr[1])&&isNumeric(arr[3])&&isNumeric(arr[4])&&isNumeric(arr[6])&&isNumeric(arr[7])&&isNumeric(arr[8])&&isNumeric(arr[9])&&(arr[2].equals("."))&&(arr[5].equals("."))){
                return true;
            }else{
                throw new BirthdayException();
            }
        }
        return false;
    }

    private boolean isSex(Character s)throws UncorrectedGender {
        if(s.equals('f')||s.equals('m')){
            return true;
        }else{
            throw new UncorrectedGender();
        }
    }
}