import org.junit.*;
import java.lang.Exception;
import java.lang.Override;
import java.util.Arrays;
import java.util.InputMismatchException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;



public class TemperatureSeriesAnalysisTest {
    double[] arr;

    //========== Tests for method "average"
    @Test (expected = IllegalArgumentException.class)
    public void testAverageEmpty()  {
        arr = new double[0];
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        object.average();
    }
    @Test
    public void testAveragePositive()  {
        arr = new double[]{3, 5, -1, 20, 4, 12, 1, 13, -13, 44, -56};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(2.909,object.average(),0.001);
    }
    @Test
    public void testAverageNotOpositeValue()  {
        arr = new double[]{3, 5, -1, 20, 4, 12, 1, 13, -13, 44, -56};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertNotEquals(-2.909,object.average(),0.001);
    }
    //==========================

    //========== Tests for method "deviation"
    @Test (expected = IllegalArgumentException.class)
    public void testDeviationEmpty() {
        arr = new double[0];
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        object.deviation();
    }
    @Test
    public void testDeviationPositive() {
        arr = new double[]{3, 5, -1, 20, 4, 12, 1, 13, -13, 44, -56};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(23.1848,object.deviation(),0.001);
    }
    //==========================

    //========== Tests for method "min"
    @Test (expected = IllegalArgumentException.class)
    public void testMinEmpty() {
        arr = new double[0];
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        object.min();
    }
    @Test
    public void testMinPositiveLastPosition() {
        arr = new double[]{3, 5, -1, 20, 4, 12, 1, 13, -13, 44, -56};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(-56, object.min(), 0);
    }
    @Test
    public void testMinPositiveFirstPosition() {
        arr = new double[]{-56, 3, 5, -1, 20, 4, 12, 1, 13, -13, 44,};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(-56, object.min(), 0);
    }
    //==========================

    //========== Tests for method "max"
    @Test (expected = IllegalArgumentException.class)
    public void testMaxEmpty() {
        arr = new double[0];
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        object.max();
    }
    @Test
    public void testMaxPositiveLastPosition() {
        arr = new double[]{3, 5, -1, 20, 4, 12, 1, 13, -13, 44};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(44, object.max(), 0);
    }
    @Test
    public void testMaxPositiveFirstPosition() {
        arr = new double[]{44, 3, 5, -1, 20, 4, 12, 1, 13, -13};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(44, object.max(), 0);
    }
    //==========================

    //========== Tests for method "findTempClosestToZero"
    @Test (expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroEmpty() {
        arr = new double[0];
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        object.findTempClosestToZero();
    }
    @Test
    public void testFindClosestToZero() {
        arr = new double[]{3, 5, -1, 20, 4, 12, 13, -13, 44, -56};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(-1, object.findTempClosestToZero(), 0);
    }
    @Test
    public void testFindClosestToZeroTwoOpositeValue() {
        arr = new double[]{3, 5, -1, 20, 4, 1, 12, 13, -13, 44, -56};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(1, object.findTempClosestToZero(), 0);
    }
    @Test
    public void testFindClosestToZeroLastPosition() {
        arr = new double[]{3, 5, -1, 20, 4, 12, 13, -13, 44, -56, 0.05, -0.05};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(0.05, object.findTempClosestToZero(), 0);
    }
    @Test
    public void testFindClosestToZeroFirstPosition() {
        arr = new double[]{-0.05, 0.05, 3, 5, -1, 20, 4, 1, 12, 13, -13, 44, -56};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(0.05, object.findTempClosestToZero(), 0);
    }
    //==========================

    //========== Tests for method "findTempClosestToValue"
    @Test (expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueEmpty() {
        arr = new double[0];
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        object.findTempClosestToValue(100);
    }
    @Test
    public void testFindClosestToValuePositive() {
        arr = new double[]{3, -1, 20, 4, 1, 12, 13, -13, 44, -56};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(4, object.findTempClosestToValue(5), 0);
    }
    @Test
    public void testFindClosestToVaslueTwoValues() { // 4 and 6 are equally far from 5
        arr = new double[]{3, -1, 20, 4, 6, 1, 12, 13, -13, 44, -56};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(4, object.findTempClosestToValue(5), 0);
    }
    //==========================

    //========== Tests for method "findTempsLessThan"
    @Test (expected = IllegalArgumentException.class)
    public void testFindTempsLessThanEmpty(){
        arr = new double[0];
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        object.findTempsLessThan(0);
    }
    @Test
    public void testFindTempsLessThan() {
        arr = new double[]{3, -1, 20, 4, 1, 12, 13, -13, 44, -56};
        double[] correct = new double[]{-56, -13, -1};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(Arrays.toString(correct), Arrays.toString(object.findTempsLessThan(0)));
    }
    @Test
    public void testFindTempsLessThanWithPositiveNumbers() {
        arr = new double[]{3, -1, -1, 20, 4, 1, 12, 0, 13, -13, 44, -56};
        double[] correct = new double[]{-56, -13, -1, -1, 0, 1, 3, 4};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(Arrays.toString(correct), Arrays.toString(object.findTempsLessThan(5)));
    }
    //==========================

    //========== Tests for method "findTempsGreaterThan"
    @Test (expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThanEmpty(){
        arr = new double[0];
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        object.findTempsGreaterThan(0);
    }
    @Test
    public void testFindTempsGreaterThan() {
        arr = new double[]{3, -1, 20, 4, 1, 12, 13, -13, 44, -56};
        double[] correct = new double[]{1,3,4,12,13,20,44};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(Arrays.toString(correct), Arrays.toString(object.findTempsGreaterThan(0)));
    }
    @Test
    public void testFindTempsGreaterThanWithNegativeValues() {
        arr = new double[]{3, -1, 20, 4, 0, 1, 12, 13, -13, 44, -56};
        double[] correct = new double[]{-13,-1,0,1,3,4,12,13,20,44};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertEquals(Arrays.toString(correct), Arrays.toString(object.findTempsGreaterThan(-14)));
    }
    //==========================

    //========== Tests for method "summeryStatistics"
    @Test (expected = IllegalArgumentException.class)
    public void testSummeryStatistics(){
        arr = new double[0];
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        object.summeryStatistics();
    }
    @Test
    public void testSummeryStatisticsPositive(){
        arr = new double[]{3, 5, -1, 20, 4, 12, 1, 13, -13, 44, -56};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        assertThat(object.summeryStatistics(), instanceOf(TempSummaryStatistics.class));
    }
    //==========================

    //========== Tests for method "addTemps"
    @Test (expected = IllegalArgumentException.class)
    public void testAddTempsEmpty(){
        arr = new double[0];
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        object.addTemps(arr);
    }
    @Test (expected = InputMismatchException.class)
    public void testAddTempsSUPERMINUS(){
        arr = new double[]{1,2,3,4,5,6,7,-274000,0,};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        object.addTemps(arr);
    }
    @Test
    public void testAddTempsPositive(){
        arr = new double[]{3, -1, 20, 4, 0, 1, 12, 13, -13, 44, -56};
        double[] addArr = new double[]{100,101,102,103};
        double[] correcrArr = new double[]{3, -1, 20, 4, 0, 1, 12, 13, -13, 44, -56, 100,101,102,103};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        int length = object.addTemps(addArr);
        assertEquals(Arrays.toString(correcrArr), Arrays.toString(object.row));
        assertEquals(15,length);
    }
    @Test
    public void testAddTempsAddEmptyArray(){
        arr = new double[]{3, -1, 20, 4, 0, 1, 12, 13, -13, 44, -56};
        double[] addArr = new double[0];
        double[] correcrArr = new double[]{3, -1, 20, 4, 0, 1, 12, 13, -13, 44, -56};
        TemperatureSeriesAnalysis object = new TemperatureSeriesAnalysis(arr);
        int length = object.addTemps(addArr);
        assertEquals(Arrays.toString(correcrArr), Arrays.toString(object.row));
        assertEquals(11,length);
    }
    //==========================
}
