package functions;

import java.util.ArrayList;
import java.util.Objects;

public class InfoGatherer  {
    public ArrayList<Author> authors = new ArrayList<>();
    private String lastEncounteredAuthor;
    private Double totalProbability = 0.0;

    public void gatherNamesAndMail(String line) {
        if (line.startsWith("From: ")) {
           String name = line.replace("From: ", "");
           if(authors.isEmpty()){
               authors.add(new Author(name, 1.0,0.0));
           }else{
               if(authors.stream().anyMatch(author -> author.getName().equals(name))) {
                   for (Author author : authors) {
                       if (Objects.equals(author.getName(), name)) {
                           author.setMailAmount();
                       }
                   }
               } else{
                   authors.add(new Author(name, 1.0,0.0));

               }
               }
        }
    }

    public void rememberLastEncounteredAuthor(String line) {
        if (line.startsWith("From: ")) {
           lastEncounteredAuthor = line.replace("From: ", "");
        }
    }
    public String getLastEncounteredAuthor(){
        return lastEncounteredAuthor;
    }

    public void gatherAuthorsConfidence(String line) {
        String confidenceLine;
        Double confidence;
        if (line.startsWith("X-DSPAM-Confidence:")) {
            confidenceLine = line.replace("X-DSPAM-Confidence:", " ");
            confidence = Double.parseDouble(confidenceLine);
            if(authors.stream().anyMatch(author -> author.getName().equals(getLastEncounteredAuthor()))) {
                for (Author author : authors) {
                    if (Objects.equals(author.getName(), getLastEncounteredAuthor())) {
                        author.setConfidence(confidence);
                    }
                }
            }
        }
    }

    public void  gatherProbability(String line){
        if(line.startsWith("X-DSPAM-Probability:")){
            String probabilityString = line.replace("X-DSPAM-Probability:"," ");
            Double probabilityNumber = Double.parseDouble(probabilityString);
            totalProbability += probabilityNumber;
        }
    }

    public Double getProbability(){
        return totalProbability;
    }

    public ArrayList<Author> getAuthorsInfo(){
        return authors;
    }

}
