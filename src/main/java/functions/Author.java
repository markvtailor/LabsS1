package functions;

import java.util.Objects;

public class Author {
    private String name;
    Double confidence;
    Double mailAmount;
    public Author(String name, Double mailAmount, Double confidence ){
        this.name = name;
        this.confidence = confidence;
        this.mailAmount = mailAmount;
    }
    public void setName(String line){
        this.name = line;
    }
    public void setConfidence(Double confidence){
        this.confidence += confidence;
    }
    public void setMailAmount(){
            mailAmount++;
    }
    public String getName() {return name;}
    public Double getConfidence(){
        return confidence;
    }
    public Double getMailAmount() {return mailAmount;}

}
