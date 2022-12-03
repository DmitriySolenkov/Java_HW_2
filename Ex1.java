import java.io.FileReader;
import java.util.Scanner;
import java.lang.StringBuilder;

public class Ex1 {
    public static void main(String[] args) throws Exception {
        String fileStr = readFile();
        String[] pairs = fileStr.split(", ");
        String[] pair0 = pairs[0].split(":");
        String[] pair1 = pairs[1].split(":");
        String[] pair2 = pairs[2].split(":");
        String[] pair3 = pairs[3].split(":");
        String[][] array = { { pair0[0], pair0[1] }, { pair1[0], pair1[1] }, { pair2[0], pair2[1] },
                { pair3[0], pair3[1] } };
        String sql = getSQL(array);
        System.out.println(sql);

    }

    public static String readFile() throws Exception {
        FileReader fr = new FileReader("Ex1.txt");
        Scanner scan = new Scanner(fr);
        String str = scan.nextLine();
        scan.close();
        fr.close();
        return str;
    }

    public static String getSQL(String[][] array) {
        StringBuilder builder = new StringBuilder();
        System.out.println(array[3][1]);
        builder.append("SELECT * FROM students WHERE ");
        builder.append(array[0][0] + " = " + array[0][1]);
        for (int i = 1; i < array.length; i++) {
            if (array[i][1].contains("null")) {
                builder.append("");
            } else {
                builder.append(" AND " + array[i][0].replace("'", " ") + " = " + array[i][1]);
            }
        }
        return builder.toString();
    }
}
