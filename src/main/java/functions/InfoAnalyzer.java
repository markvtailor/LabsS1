package functions;

import java.util.ArrayList;

public class InfoAnalyzer extends InfoGatherer {
    private final ArrayList<String> potentinalSpamers = new ArrayList<>();
    private Double totalMailAmount = 0.0;
    private Double averageProbability = 0.0;
    public void findSpamers(ArrayList<Author> authors){
        for (Author author:
             authors) {
            if(author.getConfidence()/author.getMailAmount() < 0.75){
                 potentinalSpamers.add(author.getName());
            }
        }
    }
    public ArrayList<String> getSpamersList(){
        return potentinalSpamers;
    }

    public void calculateAverageProbability(Double totalProbability, ArrayList<Author> authors){
        for (Author author:
             authors) {
           totalMailAmount += author.getMailAmount();
        }
        averageProbability = totalProbability / totalMailAmount;
    }
    public Double getAverageProbability(){
        return averageProbability;
    }
}
