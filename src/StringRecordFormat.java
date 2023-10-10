public class StringRecordFormat extends CheckInfo{
    private String name;
    private String surName;
    private String patronymic;
    private String birthDay;
    private int phoneNumber;
    private char gender;
    public StringRecordFormat(String name, String surName, String patronymic, String birthDay, int phoneNumber, char gender){
        this.surName = surName;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String StringBuild(){
        StringBuilder builder = new StringBuilder();
        builder.append("<");
        builder.append(surName);
        builder.append(">");
        builder.append("<");
        builder.append(name);
        builder.append(">");
        builder.append("<");
        builder.append(patronymic);
        builder.append(">");
        builder.append("<");
        builder.append(birthDay);
        builder.append(">");
        builder.append("<");
        builder.append(phoneNumber);
        builder.append(">");
        builder.append("<");
        builder.append(gender);
        builder.append(">");
        return builder.toString();
    }
}