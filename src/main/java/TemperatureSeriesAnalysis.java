import org.apache.commons.lang3.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import static java.lang.Math.*;

public class TemperatureSeriesAnalysis {
    double[] row;

    public TemperatureSeriesAnalysis() {
        row = new double[]{3, 5, -1, 20, 4, 12, 1, 13, -13, 44, -56};
        System.out.println(row);
    }

    public TemperatureSeriesAnalysis(double[] incomingRow) {
        row = new double[incomingRow.length];
        for (int i = 0; i < incomingRow.length; i++) {
            row[i] = incomingRow[i];
        }
    }


    boolean arrayIsEmpty() {
        if (row.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    double average() {
//        Вычисляет средние значение температуры. Если ряд пустой генерирует IllegalArgumentException.
        if (arrayIsEmpty()) {
            throw new IllegalArgumentException();
        }

        double sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }
        return sum / row.length;
    }

    double deviation() {
//        Возвращает cреднеквадрати́ческое отклоне́ние температуры. Если ряд пустой генерирует IllegalArgumentException.
        if (arrayIsEmpty()) {
            throw new IllegalArgumentException();
        }

        double qsum = 0;

        double avg = average();
        for (int i = 0; i < row.length; i++) {
            qsum += pow((row[i] - avg), 2);
        }
        return sqrt((qsum) / row.length);
    }

    double min() {
//        Возвращает минимальную температур. Если ряд пустой генерирует IllegalArgumentException.
        if (arrayIsEmpty()) {
            throw new IllegalArgumentException();
        }

        double buffer = row[row.length - 1];
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] < buffer) {
                buffer = row[i];
            }
        }
        return buffer;
    }

    double max() {
//        Возвращает максимальную температур. Если ряд пустой генерирует IllegalArgumentException.
        if (arrayIsEmpty()) {
            throw new IllegalArgumentException();
        }

        double buffer = row[row.length - 1];
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] > buffer) {
                buffer = row[i];
            }
        }
        return buffer;
    }

    double findTempClosestToZero() {
//      Возвращает значение температуры ближайшее к 0. Если ряд пустой генерирует IllegalArgumentException.
//        Если в ряде несколько значений одинаково близки к 0 (к примеру -0.2 и 0.2),
//        то возвращается положительное (большее) (т.е. 0.2)
        if (arrayIsEmpty()) {
            throw new IllegalArgumentException();
        }

        int indexOfClosestValue = 0;
        double result = 0;
        double buffer = abs(row[0]);
        for (int i = 0; i < row.length; i++) {
            if (abs(row[i]) < buffer) {
                buffer = abs(row[i]);
                indexOfClosestValue = i;
            }
        }
        result = row[indexOfClosestValue];
        for (int i = 0; i < row.length; i++) {
            if (row[indexOfClosestValue] * (-1) == row[i]) {
                result = abs(row[indexOfClosestValue]);
            }
        }
        return result;
    }

    double findTempClosestToValue(double value) {
//      Аналогично предыдущему методу, только возвращает значение ближайшее к указанному tempValue
        if (arrayIsEmpty()) {
            throw new IllegalArgumentException();
        }

        double buffer = row[0];

        for (double elem : row) {
            if (abs(value - elem) < abs(value - buffer)) {
                buffer = elem;
            }
            if (elem == abs(buffer) && buffer < value) {
                buffer = elem;
            }
        }
        return buffer;
    }

    ;

    double[] findTempsLessThan(double tempValue) {
//        Возвращает массив со значениями температуры меньше указанного tempValue.
//        Если ряд пустой генерирует IllegalArgumentException.
        if (arrayIsEmpty()) {
            throw new IllegalArgumentException();
        }

        double a = 0;
        int j = 0;
        ArrayList orderedArrayList = new ArrayList();
        double[] rowCopy = new double[row.length];
        for (int i = 0; i < rowCopy.length; i++) {
            rowCopy[i] = row[i];
        }
        do {
            for (int i = 0; i < rowCopy.length - 1; i++) {
                if (rowCopy[i] > rowCopy[i + 1]) {
                    a = rowCopy[i];
                    rowCopy[i] = rowCopy[i + 1];
                    rowCopy[i + 1] = a;
                }
            }
            j++;
        } while (j < rowCopy.length);

        for (int i = 0; i < rowCopy.length; i++) {
            if (rowCopy[i] < tempValue) {
                orderedArrayList.add(rowCopy[i]);
            }
        }

        double[] requiredArray = new double[orderedArrayList.size()];
        Iterator<Double> iterator = orderedArrayList.iterator();
        int q = 0;
        while (iterator.hasNext()) {
            requiredArray[q] = iterator.next().doubleValue();
            q++;
        }
        return requiredArray;
    }

    double[] findTempsGreaterThan(double tempValue) {
//        Возвращает массив со значениями температуры больше либо равно указанного tempValue.
//        Если ряд пустой генерирует IllegalArgumentException.
        if (arrayIsEmpty()) {
            throw new IllegalArgumentException();
        }

        double a = 0;
        int j = 0;
        ArrayList orderedArrayList = new ArrayList();
        double[] rowCopy = new double[row.length];
        for (int i = 0; i < rowCopy.length; i++) {
            rowCopy[i] = row[i];
        }
        do {
            for (int i = 0; i < rowCopy.length - 1; i++) {
                if (rowCopy[i] > rowCopy[i + 1]) {
                    a = rowCopy[i];
                    rowCopy[i] = rowCopy[i + 1];
                    rowCopy[i + 1] = a;
                }
            }
            j++;
        } while (j < rowCopy.length);

        for (int i = 0; i < rowCopy.length; i++) {
            if (rowCopy[i] >= tempValue) {
                orderedArrayList.add(rowCopy[i]);
            }
        }

        double[] requiredArray = new double[orderedArrayList.size()];
        Iterator<Double> iterator = orderedArrayList.iterator();
        int q = 0;
        while (iterator.hasNext()) {
            requiredArray[q] = iterator.next().doubleValue();
            q++;
        }
        return requiredArray;
    }

    TempSummaryStatistics summeryStatistics() {
//        - TempSummaryStatistics summaryStatistics()
//        Возвращает immutable экземпляр класса TempSummaryStatistics в котором содержится информация:
//        - double avgTemp;
//        - double devTemp;
//        - double minTemp;
//        - double maxTemp;
//        Если ряд пустой генерирует IllegalArgumentException.

//        класс TemperatureSeriesAnalysis должен иметь конструктор по умолчанию и конструктор с параметром принимающий
//        начальный ряд температур
        if (arrayIsEmpty()) {
            throw new IllegalArgumentException();
        }

        TempSummaryStatistics memory = new TempSummaryStatistics(this.average(), this.deviation(), this.min(), this.max());
        return memory;
    }


    int addTemps(double[] new_temps) {
//        Добавляет в конец ряда уже имеющихся данных новые значения температур, возвращает суммарное число значений температур.
//        Структура (массив) используемая в классе TemperatureSeriesAnalysis для хранения уже переданных температур должна
//        увеличиваться в 2 раза, если в ней нет места для хранения новых значений.

//        если в переданном ряде температур, встречается хоть одно значение меньше чем -273С, то все значения из данного
//        ряда не должны добавляться к основному ряду и должно выбрасываться исключение InputMismatchException
        if (arrayIsEmpty()) {
            throw new IllegalArgumentException();
        }

        boolean superZero = false;
        for (int i = 0; i < new_temps.length; i++) {
            if (new_temps[i] < -273.0) {
                superZero = true;
                break;
            }
        }

        if (false == superZero) {
            double[] new_row = new double[row.length + new_temps.length];
            new_row = ArrayUtils.addAll(row, new_temps);
            row = new double[new_row.length];
            for (int i = 0; i < new_row.length; i++) {
                row[i] = new_row[i];
            }
        } else {
            throw new InputMismatchException();
        }
        return row.length;
    }

}