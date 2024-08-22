public class Keyboard {
    private final int type; // тип без енама
    private final boolean presenceOfBacklight; // подсветка
    private final double weight;

    public Keyboard(int type, boolean presenceOfBacklight, double weight) {
        this.type = type;
        this.presenceOfBacklight = presenceOfBacklight;
        this.weight = weight;
    }

    // гетеры

    public int getType() {
        return type;
    }

    public boolean isPresenceOfBacklight() {
        return presenceOfBacklight;
    }

    public double getWeight() {
        return weight;
    }

    // сетеры

    public Keyboard setType(int type) {
        return new Keyboard(type, presenceOfBacklight, weight);
    }

    public Keyboard setPresenceOfBacklight(boolean presenceOfBacklight) {
        return new Keyboard(type, presenceOfBacklight, weight);
    }

    public Keyboard setWeight(double weight) {
        return new Keyboard(type, presenceOfBacklight, weight);
    }

    public String toString() {
        return "\n" + "    " + "Тип: "  + getType() + "; " + "\n" +
                "    " + "Подсветка: "  + ((isPresenceOfBacklight() == false) ? "Нету подсветки" : "Подсветка есть") + "\n" +
                "    " + "Вес: "  + getWeight() + "; ";
    }
}
