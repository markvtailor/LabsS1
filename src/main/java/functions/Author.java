package functions;

public class Author {
    private String name;
    private Double confidence;
    private Double mailAmount;
    private String lastMailDate;
    private String firstMailDate;
    public Author(String name, Double mailAmount, Double confidence){
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
    public void setLastMailDate(String matcher){
        this.lastMailDate = String.valueOf(matcher);
    }
    public void setFirstMailDate(String matcher){
        this.firstMailDate = String.valueOf(matcher);
    }
    public String getName() {return name;}
    public Double getConfidence(){
        return confidence;
    }
    public Double getMailAmount() {return mailAmount;}
    public String getLastMailDate() {return lastMailDate;}
    public String getFirstMailDate() {return firstMailDate;}

}
