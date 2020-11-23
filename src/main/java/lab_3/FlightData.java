package lab_3;

import java.io.Serializable;
import java.util.Iterator;

public class FlightData implements Serializable {
    private String delay;
    private String isCancelled;

    FlightData(String delay, String isCancelled){
        this.delay = delay;
        this.isCancelled = isCancelled;
    }

    FlightData(){
        this.delay = "";
        this.isCancelled = "";
    }

    public String getDelay(){
        return this.delay;
    }

    public String getIsCancelled(){
        return this.isCancelled;
    }

    public FlightData calculations(Iterable<FlightData> flights){
        Iterator<FlightData> iter = flights.iterator();

        int maxDelay = 0;
        int counterCanceled = 0;
        int counterSize = 0;
        for (FlightData flight: flights){
            counterSize++;
            int cDelay = Integer.valueOf(flight.getDelay());
            int cIsCancelled = Integer.valueOf(flight.getIsCancelled());
            if (cDelay > maxDelay) maxDelay = cDelay;
            if (cIsCancelled == 1 || cDelay > 0) counterCanceled++;
        }
        FlightData tmp = new FlightData(String.valueOf(maxDelay), String.valueOf(counterCanceled/counterSize));
        return tmp;
    }
}
