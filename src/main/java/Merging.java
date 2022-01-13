import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Merging {
    static int i = 0;
    static float spamRate;
    static List<Float> confidenceRate = new ArrayList<>(Confidence.authorsConfidence.values());
    static List<Float> mailAmount = new ArrayList<>(Authors.authors.values());
    static List<Float> spamRateList = new ArrayList<>();
    static List<String> authorsName = new ArrayList<>(Authors.authors.keySet());
    static HashMap<String, Float> confidenceAverageHashMap = new HashMap<>();
    public static void result(){
        while (i <confidenceRate.size()){
            spamRate = confidenceRate.get(i)/mailAmount.get(i);
            spamRateList.add(spamRate);
            i++;
        }
        for (int j = 0; j < authorsName.size(); j++) {
            confidenceAverageHashMap.put(authorsName.get(j), spamRateList.get(j));
        }
        for (int k = 0; k < authorsName.size(); k++) {
            if(confidenceAverageHashMap.get(authorsName.get(k)) > 0.75 ){
                confidenceAverageHashMap.remove(authorsName.get(k));
            }
        }
    }
}
