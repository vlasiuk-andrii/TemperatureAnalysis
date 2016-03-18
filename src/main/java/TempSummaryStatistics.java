
public class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    public TempSummaryStatistics() {
        avgTemp = 0.0;
        devTemp = 0.0;
        minTemp = 0.0;
        maxTemp = 0.0;
    }

    public TempSummaryStatistics(double avg, double dev, double min, double max) {
        avgTemp = avg;
        devTemp = dev;
        minTemp = min;
        maxTemp = max;
    }

}
