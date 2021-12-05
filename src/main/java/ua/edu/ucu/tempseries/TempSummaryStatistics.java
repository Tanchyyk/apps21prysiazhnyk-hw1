package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private final double averageTemp;
    private final double stdOfTemps;
    private final double minTemp;
    private final double maxTemp;

    public TempSummaryStatistics(double averageTemp, double stdOfTemps, double minTemp, double maxTemp) {
        this.averageTemp = averageTemp;
        this.stdOfTemps = stdOfTemps;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    @Override
    public String toString() {
        return "TempSummaryStatistics{" +
                "averageTemp=" + averageTemp +
                ", stdOfTemps=" + stdOfTemps +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                '}';
    }
}
