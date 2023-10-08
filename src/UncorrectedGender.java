public class UncorrectedGender extends Exception{
    public String getMessage() {
        return "Пол указан не верно. Допустимы только 'f' или 'm'";
    }
}
