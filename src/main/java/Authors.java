import java.util.Enumeration;
import java.util.HashMap;

import java.util.Map;

public class Authors {

    static Map<String, Float> authors = new HashMap<>();


    public static void authorsCount(String line){

        if(line.startsWith("From: ")){
            String authorName = line.replace("From: ","");
            float count = authors.containsKey(authorName) ? (float) authors.get(authorName) : 0;
            if(authors.containsKey(authorName)){
                authors.put(authorName, count+1);

            }else{
                authors.put(authorName, 1F);
            }
        }
    }

}
