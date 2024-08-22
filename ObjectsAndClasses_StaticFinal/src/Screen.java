public class Screen {
    private final double diagonal;
    private final TypeScreen type; //(IPS, TN, VA);
    private final double weight;

    public Screen(double diagonal, TypeScreen type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    // гетеры

    public double getDiagonal() {
        return diagonal;
    }

    public TypeScreen getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    // сетеры

    public Screen setDiagonal(double diagonal) {
        return new Screen(diagonal, type, weight);
    }

    public Screen setType(TypeScreen type) {
        return new Screen(diagonal, type, weight);
    }

    public Screen setWeight(double weight) {
        return new Screen(diagonal, type, weight);

    }

    public String toString() {
        return "\n" + "    " + "Диагональ: "  + getType() + "; " + "\n" +
                "    " + "Тип: "  + getType() + "; " + "\n" +
                "    " + "Вес: "  + getWeight() + "; ";
    }
}
