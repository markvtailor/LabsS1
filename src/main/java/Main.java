public class Main {
    public static void main(String[] args) {
        PolyCalculator.calculatePolynom(ArgsParser.parseArgs(CmdParser.parse(args)));
    }
}
