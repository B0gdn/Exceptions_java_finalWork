import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FillDictionary extends CheckInfo {
    Map<String, ArrayList<ArrayList<String>>> forDict= new HashMap<>();

    public void addDict(String name, String surName, String patronymic, String birthDay, String phoneNumber, char gender){
        ArrayList<String> lists = new ArrayList<>();
        ArrayList<ArrayList<String>> doubleArr = new ArrayList<>();
        lists.add(name);
        lists.add(patronymic);
        lists.add(birthDay);
        lists.add(phoneNumber);
        lists.add(Character.toString(gender));
        if (forDict.containsKey(surName)){
            for (Map.Entry<String, ArrayList<ArrayList<String>>> entry : forDict.entrySet()) {
                doubleArr.add(entry.getValue().get(0));
            }
        }
        doubleArr.add(lists);
        forDict.put(surName, doubleArr);
    }
    public void show(){
        forDict.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
