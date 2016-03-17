import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis();

        double center = 10.0;
        System.out.println("closestToZero = " + object.findTempClosestToZero());
        System.out.println("closestTo" + center + " = " + object.findTempClosestToValue(center));
        System.out.println("lower = " +  object.findTempsLessThan(2));
        System.out.println("upper = " +  object.findTempsGreaterThan(2));
    }
}
