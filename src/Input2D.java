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

public class Input2D {
    double x;
    double y;
    String clusterName = null;

    public Input2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    @Override
    public String toString() {
        return "Input2D{" + "x=" + x + ", y=" + y + '}';
 
    }
    
    
}
