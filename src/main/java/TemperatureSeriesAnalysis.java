import java.util.ArrayList;

import static java.lang.Math.*;

public class TemperatureSeriesAnalysis {

    double[] row = new double[] {3,5,-1,20,4,12,1,13,-13,44,-56};

    double average(){
        double sum = 0;
        for(int i=0; i < row.length; i++){
            sum += row[i];
        }
        return sum/row.length;
    }

    double deviation(){
        double qsum = 0;

        double avg = average();
        for (int i=0; i<row.length; i++) {
            qsum += pow( (row[i] - avg), 2 );
        }
        return sqrt( (qsum)/row.length );
    }

    double min(){
        double buffer = row[row.length-1];
        for(int i=0; i<row.length-1; i++){
            if (row[i] < buffer){
                buffer = row[i];
            }
        }
        return buffer;
    }
    double max(){
        double buffer = row[row.length-1];
        for(int i=0; i<row.length-1; i++){
            if (row[i] > buffer){
                buffer = row[i];
            }
        }
        return buffer;
    }
    double findTempClosestToZero(){
        int indexOfClosestValue = 0;
        double result = 0;
        double buffer = abs( row[row.length-1] );
        for (int i=0; i<row.length; i++){
            if ( abs(row[i]) < buffer){
                buffer = abs( row[i] );
                indexOfClosestValue = i;
            }
        }
        result = row[indexOfClosestValue];
        for (int i=0; i<row.length; i++){
            if ( row[indexOfClosestValue]*(-1) == row[i]){
               result = abs( row[indexOfClosestValue] );
            }
        }
        return result;
    }
    double findTempClosestToValue(double value){
        double buffer = row[0];

        for (double elem : row) {
            if ( abs(value-elem) < abs(value-buffer) ){
                buffer = elem;
            }
            if( elem == abs(buffer)  &&  buffer < value){
                buffer = elem;
            }
        }
        return buffer;
    };
    ArrayList findTempsLessThan(double tempValue){
        double a = 0;
        int j = 0;
        ArrayList requiredArray = new ArrayList();
        do {
            for(int i=0; i<row.length-1; i++){
                if (row[i] > row[i+1]) {
                    a = row[i];
                    row[i] = row[i+1];
                    row[i+1] = a;
                }
            }
            j++;
        } while (j < row.length);

        for(int i=0; i<row.length; i++){
            if(row[i] < tempValue){
                requiredArray.add(row[i]);
            }
        }

        return requiredArray;
    }
    ArrayList findTempsGreaterThan(double tempValue){
        double a = 0;
        int j = 0;
        ArrayList requiredArray = new ArrayList();
        do {
            for(int i=0; i<row.length-1; i++){
                if (row[i] > row[i+1]) {
                    a = row[i];
                    row[i] = row[i+1];
                    row[i+1] = a;
                }
            }
            j++;
        } while (j < row.length);

        for(int i=0; i<row.length; i++){
            if(row[i] >= tempValue){
                requiredArray.add(row[i]);
            }
        }

        return requiredArray;
    }
//    TempSummeryStatisstics summeryStatisstics
}
