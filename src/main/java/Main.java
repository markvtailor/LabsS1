public class Main {
    public static void main(String[] args) {
        double sum = 0;
        for (String num: args){
            try{
                double polyn = Double.parseDouble(num);
                sum += (1/polyn)*27;
            }catch (NumberFormatException e){
                num = null;
            }

        }
        System.out.println(sum);
    }
}
