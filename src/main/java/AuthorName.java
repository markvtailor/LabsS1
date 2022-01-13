public class AuthorName {
    private static String authorName;
    public static String Name (String line){
        if(line.startsWith("From: ")){
            authorName = line.replace("From: ","");
        }
        return authorName;
    }
}
