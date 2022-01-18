public class ArgsParser {
    public static double[] parseArgs(String args){
        String polyInput;
        polyInput = args;
        char[] argsArray = polyInput.toCharArray();
        double[] passedArray = new double[polyInput.length()];
        char input;
        if(CmdParser.checker)
        {
            for (int i = 0; i < polyInput.length(); i++) {
                input = argsArray[i];
                if(Character.isDigit(input)){
                    passedArray[i] = Character.getNumericValue(input);
                }else if(input != ','){
                    return passedArray;
                }
            }
        }else {
            for (int i = 0; i < polyInput.length(); i++) {
                input = argsArray[i];
                if(Character.isDigit(input)){
                    passedArray[i] = Character.getNumericValue(input);
                }
            }
        }
        return passedArray;
    }
}
