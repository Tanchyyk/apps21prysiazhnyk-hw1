package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testValidateTemps() {
        double[] temperatureSeries1 = {3.0, -5.0, 1.0, -360.0};
        double[] temperatureSeries2 = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries2);
        boolean actualResult = seriesAnalysis.validateTemps(temperatureSeries1);

        assertFalse(actualResult);
    }

    @Test
    public void testCheckLength() {
        double[] temperatureSeries1 = {};
        double[] temperatureSeries2 = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries2);
        boolean actualResult = seriesAnalysis.checkLength(temperatureSeries1);

        assertFalse(actualResult);
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.max();
    }

    @Test(expected = InputMismatchException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.min();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {19.9, 170.1, -5.67};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 77.53777416345031;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.deviation();
    }

    @Test
    public void testFindTempClosestToZero() {
        double[] temperatureSeries = {19.9, 170.1, -5.67};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.67;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToValue() {
        double[] temperatureSeries = {19.9, 170.1, -5.67};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 19.9;

        double actualResult = seriesAnalysis.findTempClosestToValue(20.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testFindTempClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToValue(25.5);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] temperatureSeries = {19.9, 170.1, -5.67};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-5.67, 0.0, 0.0};

        double[] actualResult = seriesAnalysis.findTempsLessThen(10.0);

        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testFindTempsGreaterThen() {
        double[] temperatureSeries = {19.9, 170.1, -5.67};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {19.9, 170.1, 0.0};

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(10.0);

        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {19.9, 170.1, -5.67};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(new TempSummaryStatistics(61.443333333333335, 77.53777416345031, -5.67, 170.1).toString(),
                seriesAnalysis.summaryStatistics().toString());
    }

    @Test(expected = InputMismatchException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.summaryStatistics();
    }

    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {7.0};
        double[] temps = {3.5, 3.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(14, seriesAnalysis.addTemps(temps));
    }
}
