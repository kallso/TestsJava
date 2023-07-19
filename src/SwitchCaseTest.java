public class SwitchCaseTest {

    public static void main(String[] args) {
        String switchVar = args[0];

        switch (switchVar) {
            case "MONDAY":
                System.out.println("Mondays are bad.");
                break;

            case "FRIDAY":
                System.out.println("Fridays are better.");
                break;

            case "SATURDAY": case "SUNDAY":
                System.out.println("Weekends are best.");
                break;

            default:
                System.out.println("Midweek days are so-so.");
                break;
        }

    }
}
