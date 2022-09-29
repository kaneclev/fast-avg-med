import gnu.getopt.Getopt;
import java.text.DecimalFormat;
import gnu.getopt.LongOpt;

public class Main {
        // make an array for all the options we can store
        public static void printHelp() {
                System.out.println("Usage: java [options] Main [-m average[median]||[-h]");
                System.out.println("Would you like average or median, and in simple or verbose mode?");
        }
        public static void main(String[] args) {
                operate a = new operate();
                DecimalFormat round = new DecimalFormat("0.00");


                LongOpt[] LongOptions = {
                        new LongOpt("help", LongOpt.NO_ARGUMENT, null, 'h'),
                        // first arg is long opt, second m is short opt
                        new LongOpt("mode", LongOpt.REQUIRED_ARGUMENT, null, 'm'),
                        // verbose command
                        new LongOpt("verbose", LongOpt.NO_ARGUMENT, null, 'v'),
                };
                // make the getopt object in order to process the args variable
           /*
        To construct;
        - name of program,
        - args array
        - short option string
            + list alphabetically or in order from long option array
            + for short options with required additional argument, add a ':' after that letter
        - long option array
         */

                Getopt g = new Getopt("Project0", args, "hvm:", LongOptions);
                g.setOpterr(true);

                // now we are ready to process command line arguments
                // g.getOpt() returns 1 command line argument from the args array.
                // then, it returns the integer representation of the short option.
                // basically the integer version of our "h" or "m:" from the short opt argument
                // it returns -1 if there are no more arguments to process
                //-----------------------
                // store the most recent argument to process from our getopt object
                int choice;
                String mode = "";


                while ((choice = g.getopt()) != -1) {
                        // this loop is trying to constantly receive an argument from the command line user
                        // until it has received an input and has decided whether it is a valid argument

                        switch (choice) {

                                case 'h' -> {
                                        printHelp();
                                        System.exit(0);
                                }

                                case 'm' -> {
                                        mode = g.getOptarg(); // reads the next argument from the command line
                                        if (!mode.equals("average") && !mode.equals("median")) {
                                                // if the mode string given by the user does not equal either of our two modes, throw an error
                                                System.err.println("Error: invalid mode: " + mode);
                                                // now exit the program
                                                System.exit(1);
                                        }

                                }
                                case 'v' -> {
                                        // verbose case; this works regardless of if it is median or average
                                        System.out.println("Reading " + a.size() + " numbers.");
                                        System.out.println("Read " + a.size() + " numbers.");
                                }

                                default -> {
                                        // this will run if none of the other cases match
                                        // it comes at the end of the switch

                                        System.err.println("Invalid Option");
                                        System.exit(1);
                                }
                                // end of the switch
                        }
                        // back to the while loop

                }

                if (mode.equals("average")) {
                        System.out.println("Average: " + round.format(a.getAverage()));

                }
                if (mode.equals("median")) {
                        System.out.println("Median: " + a.getMedian());
                }

                if (g.getopt() == -1) {
                        System.err.println("No command specified.");
                        System.exit(1);
                }


        }

}