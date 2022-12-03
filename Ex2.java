import java.io.FileWriter;
import java.io.IOException;

public class Ex2 {
    public static void main(String[] args) throws IOException {
        int[] array = { 4, 6, 9, 5, 7, 2, 1 };
        int[] newarray = arraySort(array);
        for (int index = 0; index < newarray.length; index++) {
            System.out.print(newarray[index]);
        }
    }

    public static int[] arraySort(int[] array) throws IOException {
        FileWriter fw = new FileWriter("Ex2log.txt");
        int step = 1;
        for (int count = 0; count < array.length; count++) {

            for (int index = 0; index < array.length - 1; index++) {
                if (array[index] > array[index + 1]) {
                    int buffer = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = buffer;
                    fw.write("Шаг " + step + ". " + array[index + 1] + " сдвинули с позиции " + index + " на позицию "
                            + (index + 1) + "\n");
                    for (int ind = 0; ind < array.length; ind++) {
                        fw.write(array[ind] + " ");
                    }
                    fw.write("\n" + "\n");
                    step++;
                }
            }
        }
        fw.close();
        return array;
    }
}
