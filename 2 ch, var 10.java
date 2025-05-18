import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArraySpiral {

    public static int[][] generateSpiralArray(int m, int n) {
        int[][] array = new int[m][n];
        int value = 1;
        int startRow = 0, endRow = m - 1;
        int startCol = 0, endCol = n - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Заполняем верхнюю строку
            for (int i = startCol; i <= endCol; i++) {
                array[startRow][i] = value;
            }
            startRow++;

            // Заполняем правый столбец
            for (int i = startRow; i <= endRow; i++) {
                array[i][endCol] = value;
            }
            endCol--;

            // Заполняем нижнюю строку (справа налево)
            if (startRow <= endRow) { // Проверка для случаев, когда m нечетное
                for (int i = endCol; i >= startCol; i--) {
                    array[endRow][i] = value;
                }
                endRow--;
            }

            // Заполняем левый столбец (снизу вверх)
            if (startCol <= endCol) { // Проверка для случаев, когда n нечетное
                for (int i = endRow; i >= startRow; i--) {
                    array[i][startCol] = value;
                }
                startCol++;
            }
            value++;
        }

        return array;
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void writeArrayToFile(int[][] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int[] row : array) {
                for (int value : row) {
                    writer.write(value + " ");
                }
                writer.newLine(); // Переход на новую строку
            }
            System.out.println("Массив успешно записан в файл: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int m = 5; // Высота массива
        int n = 7;  // Ширина массива
        String filename = "spiral_array.txt"; // Имя файла для сохранения

        int[][] spiralArray = generateSpiralArray(m, n);

        System.out.println("Сгенерированный массив:");
        printArray(spiralArray);

        writeArrayToFile(spiralArray, filename);
    }
}