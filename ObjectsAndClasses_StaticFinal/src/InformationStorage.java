public class InformationStorage {
    private final TypeInformationStorage type; // HDD, SSD;
    private final double memory; // обьем памяти
    private final double weight;

    public InformationStorage(TypeInformationStorage type, double memory, double weight) {
        this.type = type;
        this.memory = memory;
        this.weight = weight;
    }

    // гетеры

    public TypeInformationStorage getType() {
        return type;
    }

    public double getMemory() {
        return memory;
    }

    public double getWeight() {
        return weight;
    }

    // сетеры

    public InformationStorage setType(TypeInformationStorage type) {
        return new InformationStorage(type, memory, weight);
    }

    public InformationStorage setMemory(double memory) {
        return new InformationStorage(type, memory, weight);
    }

    public InformationStorage setWeight(double weight) {
        return new InformationStorage(type, memory, weight);
    }

    public String toString() {
        return "\n" + "    " + "Тип: "  + getType() + "; " + "\n" +
                "    " + "Обьем памяти: "  + getMemory() + "; " + "\n" +
                "    " + "Вес: "  + getWeight() + "; ";
    }
}
