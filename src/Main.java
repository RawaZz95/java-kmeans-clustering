package kmeansalgorithm;

import java.util.ArrayList;

/**
 *
 * @author RawaZz
 * It is not fully complete, but it is working.
 * 
 * The program is designed to take a set of inputs in and two means have been chosen randomly.
 * Euclidean Distance is used to check the distance between two inputs.
 * the mean of two inputs can be returned using the getMean method.
 * 
 */
 
public class Main {

    ArrayList<Input2D> inputList;
    int k;
    Input2D[] kMeans;
    boolean iterate = true;

    public Main() {

        k = 2;
        kMeans = new Input2D[k];
        inputList = new ArrayList<Input2D>();

        inputList.add(new Input2D(185, 72));
        inputList.add(new Input2D(170, 56));
        inputList.add(new Input2D(168, 60));
        inputList.add(new Input2D(179, 68));
        inputList.add(new Input2D(182, 72));
        inputList.add(new Input2D(188, 77));
        inputList.add(new Input2D(180, 71));
        inputList.add(new Input2D(180, 70));
        inputList.add(new Input2D(183, 84));
        inputList.add(new Input2D(180, 88));
        inputList.add(new Input2D(180, 67));
        inputList.add(new Input2D(177, 76));

        // Assigning the first 2 to k
        kMeans[0] = inputList.get(0);
        kMeans[1] = inputList.get(1);

        int iterationCounter = 0;

        while (iterate) {

            System.out.println("");
            System.out.println("------------------Iteration: " + iterationCounter + " ------------------------");
            System.out.println("");

            for (Input2D in : inputList) {
                System.out.println("#Current-Centroid 1 = " + kMeans[0]);
                System.out.println("#Current-Centroid 2 = " + kMeans[1]);
                System.out.println("->>>Comes in: " + in.toString());

                double distFrom1 = eucliddanDistance(in, kMeans[0]);
                double distFrom2 = eucliddanDistance(in, kMeans[1]);

                System.out.println("Distance from cluster 1 = " + distFrom1);
                System.out.println("Distance from cluster 2 = " + distFrom2);

                // Check the smallest distance to the cluster
                if (distFrom1 < distFrom2) {
                    // Minimum distance from cluster 1
                    // Check if cluster is changed
                    if (in.getClusterName() != null && in.getClusterName().equalsIgnoreCase("Cluster 1")) {
                        iterate = false; // stops the iteration
                    } else {
                        in.setClusterName("Cluster 1");
                        kMeans[0] = getMean(kMeans[0], in);
                        iterate = true;
                    }

                } else if (distFrom2 < distFrom1) {
                    // Minimum distance from cluster 2
                    if (in.getClusterName() != null && in.getClusterName().equalsIgnoreCase("Cluster 2")) {
                        iterate = false; // stops the iteration
                    } else {
                        in.setClusterName("Cluster 2");
                        kMeans[1] = getMean(kMeans[1], in);
                        iterate = true;
                    }
                } else {

                    // Neutral automatically assigned to cluster 1
                    if (in.getClusterName() != null && in.getClusterName().equalsIgnoreCase("Cluster 1")) {
                        iterate = false; // stops the iteration
                    } else {
                        in.setClusterName("Cluster 1");
                        kMeans[0] = getMean(kMeans[0], in);
                        iterate = true;
                    }
                }

                System.out.println("Input (" + in.getX() + ", " + in.getY() + ") is under" + in.getClusterName());
            }

            System.out.println("##############################################################");
            for (Input2D input : inputList) {
                System.out.println("# " + input.toString() + " ---> " + input.getClusterName() + " #");
            }
            System.out.println("##############################################################");

            // Stops after 1000 iterations in case it doesn't stop auomatically
            if (iterationCounter >= 1000) {
                iterate = false;
            }

            iterationCounter++;
        }
    }

    public static void main(String[] args) {
        new Main();
    }

    public double eucliddanDistance(Input2D input1, Input2D input2) {

        double x1 = input1.getX();
        double x2 = input2.getX();

        double y1 = input1.getY();
        double y2 = input2.getY();

        double xSUBx = x1 - x2;
        double absXSqr = Math.pow(xSUBx, 2);

        double ySUBy = y1 - y2;
        double absYSqr = Math.pow(ySUBy, 2);

        double result = Math.sqrt(absXSqr + absYSqr);

        return result;
    }

    public Input2D getMean(Input2D input1, Input2D input2) {
        double newX = (input1.getX() + input2.getX()) / 2;
        double newY = (input1.getY() + input2.getY()) / 2;

        return new Input2D(newX, newY);
    }

}
