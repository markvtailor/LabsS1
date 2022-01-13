import org.decimal4j.util.DoubleRounder;

import java.io.Serializable;

public class Heron {

    public static Serializable HeronRoot(double x){

        double root = 2;
        if(x == 0){
            return "Квадратный корень введенного числа: " + 0;
        }else if(x<0){
            return "Из отрицательного числа нельзя извлечь корень";
        }else{
            while(DoubleRounder.round(root*root, 2) != x){
                root = 0.5*(root+x/root);
                DoubleRounder.round(root,2);

            }
            return "Квадратный корень введенного числа: " + DoubleRounder.round(root,2);
        }

    }
}
