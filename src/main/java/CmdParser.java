import org.apache.commons.cli.*;

public class CmdParser {
    public static boolean checker;
    public static String parse(String[] args){

        Options options = new Options();
        Option poly = new Option("poly", "poly", true, "Полином");
        Option strict = new Option("strict", "strict", false, "Обработка нечисловых значений");
        poly.setRequired(true);
        strict.setRequired(false);
        options.addOption(poly);
        options.addOption(strict);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        checker = cmd.hasOption("strict");

        return(cmd.getOptionValue("poly"));
}
    }
