import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class operate {
    Double median;
    double average;
    int size;
    ArrayList<Double> dataset;
    Scanner dataScan;
    Double sum;

    public operate() {
        this.dataset = new ArrayList<>();
        dataScan = new Scanner(System.in);
        loadDataSet();


    }

    public void loadDataSet() {
        int givenSize = dataScan.nextInt();
        while (dataScan.hasNextDouble()) {

            dataset.add(dataScan.nextDouble());
        }
        if (givenSize < dataset.size()) {
            System.err.println("More data given than expected.");
            System.exit(1);
        }
    }

    public int size() {
        // need to check if the dataset is actually the size that the first integer says it is
         size = dataset.size();



        return size;
    }



    public double getAverage()  {
        if (!dataset.isEmpty()) {
            sum = (double) 0;
            for (Double aDouble : dataset) {
                sum += aDouble;
            }

            average = sum / dataset.size();

            return average;
        }
        else {
            System.out.println("No data => no statistics!");
            System.exit(0);
        }
        return 0;
    }

    public Double getMedian() {
        int target = size() / 2;
        if (!dataset.isEmpty()) {
            Collections.sort(dataset);
            median = dataset.get(target);


        }
        else {
            System.out.println("No data => no statistics!");
            System.exit(0);

        }
        return median;
    }




}