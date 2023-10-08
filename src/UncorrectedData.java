public class UncorrectedData extends Exception{
    public String getMessage() {
        return String.format("Данные не корректны, возможно, в дате рождения использованы не точки, или пол указан не одной буквой");
    }
}
