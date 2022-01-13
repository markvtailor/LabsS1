
import java.util.HashMap;
import java.util.Map;


public class Confidence {

    static float confidenceNumber = 0;
    static Map<String, Float> authorsConfidence = new HashMap<>();

    public static void confidenceCounter(String line,String name){
        if(line.startsWith("X-DSPAM-Confidence:")){
            String probabilityString = line.replace("X-DSPAM-Confidence:"," ");
            confidenceNumber = Float.parseFloat(probabilityString);
            float authorConfidenceNumber = authorsConfidence.containsKey(name) ? (float) authorsConfidence.get(name) : 0;

            if(authorsConfidence.containsKey(name)){
                authorsConfidence.put(name,authorConfidenceNumber+confidenceNumber);
            }else{
                authorsConfidence.put(name,confidenceNumber);
            }
        }
    }
}
