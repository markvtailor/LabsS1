public class Probability {
    static float probabilityNumber = 0;
    static float probabilityTotalNumber = 0;
    static float counter = 0;
    static float probabilityAverage;
    public static float ProbabilityCheck(String str){
        if(str.startsWith("X-DSPAM-Probability:")){
            String probabilityString = str.replace("X-DSPAM-Probability:"," ");
            probabilityNumber = Float.parseFloat(probabilityString);
            probabilityTotalNumber += probabilityNumber;
            counter++;
        }
        return probabilityAverage = probabilityTotalNumber/counter;
    }
}
