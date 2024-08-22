import javax.crypto.spec.PSource;

public class Dimensions {
    private final double height;
    private final double length;
    private final double width;

    private final double proizved;


    public Dimensions(double height, double length, double width){
        this.width = width;
        this.height= height;
        this.length = length;
        double proizved = (height * length) * width;
        this.proizved = proizved;
    }

    public double print(){
        return proizved;
    }

    public String toString(){
        return "Обьем: " + proizved + "\n";
    }
}
