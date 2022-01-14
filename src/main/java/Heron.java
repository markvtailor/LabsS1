import org.decimal4j.util.DoubleRounder;


public class Heron {

    public static Double HeronRoot(double x){

        double root = 2;
        if(x == 0){
            return 0.0;
        }else if(x<0){
            throw new NumberFormatException();
        }else{
            while(DoubleRounder.round(root*root, 2) != x){
                root = 0.5*(root+x/root);
                DoubleRounder.round(root,2);

            }

        }
        return DoubleRounder.round(root,2);
    }
}
