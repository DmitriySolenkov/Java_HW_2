import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("Ex3.txt");
        Scanner scan = new Scanner(fr);
        String str = scan.nextLine();
        fr.close();
        scan.close();
        String[] pupils = arrayCreation(str, 1);
        for (int index = 0; index < pupils.length; index++) {
            String newStr = stringBuild(pupils[index]);
            pupils[index] = newStr;
        }
        for (String st : pupils) {
            System.out.println(st);
        }

    }

    public static String[] arrayCreation(String str, int num) {
        switch (num) {
            case 1:
                String[] array = str.split("},");
                return array;
            default:
                String[] array2 = str.split(",");
                return array2;
        }
    }

    public static String stringBuild(String str) {
        StringBuilder builder = new StringBuilder();
        str = str.replace("[", "");
        str = str.replace("]", "");
        str = str.replace("{", "");
        str = str.replace("}", "");
        str = str.replace("'", "");
        String[] array = arrayCreation(str, 2);
        for (String elem : array) {
            if (elem.contains("фамилия")) {
                String[] elemArray = elem.split(":");
                builder.append("Студент " + elemArray[1]);
            }
            if (elem.contains("оценка")) {
                String[] elemArray = elem.split(":");
                builder.append(" получил " + elemArray[1]);
            }
            if (elem.contains("предмет")) {
                String[] elemArray = elem.split(":");
                builder.append(" по предмету " + elemArray[1] + ".");
            }

        }

        return builder.toString();
    }
}
