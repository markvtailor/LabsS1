import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolyTest {
        @Test
        void test1()  {
            double[] input = {1,2,3,4,5};
            assertEquals(61.65, PolyCalculator.calculatePolynom(input),0.1);
        }
        @Test
        void test2(){
            String input = "poly=q,w,e";
            assertEquals(0,PolyCalculator.calculatePolynom(ArgsParser.parseArgs(input)),0.1);
        }
        @Test
        void test3(){
            String input = "poly=1.2.3,q,w,e --strict";
            assertEquals(49.5,PolyCalculator.calculatePolynom(ArgsParser.parseArgs(input)),0.1);
        }
        @Test
        void test4(){
            String input = "0";
            assertEquals(0,PolyCalculator.calculatePolynom(ArgsParser.parseArgs(input)),0.1);
        }
}
