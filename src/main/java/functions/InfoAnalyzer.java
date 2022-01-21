package functions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class InfoAnalyzer extends InfoGatherer {
    private final ArrayList<String> potentinalSpamers = new ArrayList<>();
    private Double totalMailAmount = 0.0;
    private Double averageProbability = 0.0;
    public void findSpamers(ArrayList<Author> authors) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        for (Author author:
             authors) {
            Date firstDate = sdf.parse(author.getFirstMailDate());
            Date secondDate = sdf.parse(author.getLastMailDate());
            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if(author.getConfidence()/author.getMailAmount() < 0.75 && author.getMailAmount()/diff > 1){
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
