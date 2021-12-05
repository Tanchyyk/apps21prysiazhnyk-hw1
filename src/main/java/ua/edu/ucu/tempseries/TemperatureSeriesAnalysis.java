package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {

    }

    public boolean validateTemps(double[] temperatureSeries) {
        for (double temperature: temperatureSeries) {
            if (Double.compare(temperature, -273.0) == -1) {
                return false;
            }
        }
        return true;
    }

    public boolean checkLength(double[] temperatureSeries) {
        return temperatureSeries.length != 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        if (!checkLength(temperatureSeries) || !validateTemps(temperatureSeries)) {
            throw new InputMismatchException();
        } else {
            this.temperatureSeries = Arrays.copyOf(temperatureSeries, temperatureSeries.length);
        }
    }

    public double average() {
        if (!checkLength(temperatureSeries)){
            throw new IllegalArgumentException();
        }

        double sum = 0;
        for (double temperatureSery : temperatureSeries) {
            sum += temperatureSery;
        }
        return sum / temperatureSeries.length;
    }

    public double deviation() {
        if (!checkLength(temperatureSeries)){
            throw new IllegalArgumentException();
        }

        double std = 0;

        for (double temperature: temperatureSeries){
            std += Math.pow(Math.abs(temperature - average()), 2);
        }

        return Math.pow(std / temperatureSeries.length, 0.5);
    }

    public double min() {
        return findTempClosestToValue(-273);
    }

    public double max() {
        return findTempClosestToValue(273);
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (!checkLength(temperatureSeries)){
            throw new IllegalArgumentException();
        }

        double MinDiff = Math.abs(temperatureSeries[0] - tempValue);
        double closest = temperatureSeries[0];
        for (int i = 1; i < temperatureSeries.length; i++) {
            if (Math.abs(temperatureSeries[i] - tempValue) < MinDiff) {
                MinDiff = Math.abs(temperatureSeries[i] - tempValue);
                closest = temperatureSeries[i];
            }
        }
        return closest;
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] tempLessThenArr = new double[temperatureSeries.length];
        int currIdx = 0;

        for (double temperature: temperatureSeries) {
            if (temperature < tempValue) {
                tempLessThenArr[currIdx] = temperature;
                currIdx++;
            }
        }
        return Arrays.copyOf(tempLessThenArr, tempLessThenArr.length);
    }

    public double[] findTempsGreaterThen(double tempValue) {
        double[] tempLargeThenArr = new double[temperatureSeries.length];
        int currIdx = 0;

        for (double temperature: temperatureSeries) {
            if (temperature > tempValue) {
                tempLargeThenArr[currIdx] = temperature;
                currIdx++;
            }
        }
        return Arrays.copyOf(tempLargeThenArr, tempLargeThenArr.length);
    }

    public TempSummaryStatistics summaryStatistics() {
        if (!checkLength(temperatureSeries)){
            throw new IllegalArgumentException();
        }

        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int exactLength() {
        int counter = 0;
        for (double temp: temperatureSeries) {
            if (temp != 0.0)
            counter += 1;
        }
        return counter;
    }

    public int addTemps(double... temps) {
        for (double temperature: temps) {
            if (exactLength() == temperatureSeries.length) {
                temperatureSeries = Arrays.copyOf(temperatureSeries, temperatureSeries.length * 2);
            }
            temperatureSeries[exactLength()] = temperature;
        }

        double sum = 0;
        for (double temp: temperatureSeries) {
            sum += temp;
        }

        return (int) sum;
    }
}
