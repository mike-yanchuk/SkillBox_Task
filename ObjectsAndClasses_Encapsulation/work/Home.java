public class Home {




    private final double height; // высота
    private final double length; // длина
    private final double width; // ширина
    private final String adres;
    private final double weight; // масса
    private final String registrationNumber;
    private final Dimensions dimensions;

    private  final boolean fragile; // хрупкий?
    private final boolean coup; // переворот?

    public Home(Dimensions dimensions,
                String adres,
                double height,
                double length,
                double width,
                double weight,
                boolean coup,
                String registrationNumber,
                boolean fragile ){

        this.dimensions = dimensions;

        this.height = height ;
        this.length = length ;
        this.width = width ;

        this.adres = adres;
        this.coup = coup;
        this.weight = weight;
        this.registrationNumber = registrationNumber;
        this.fragile = fragile;
    }

    public Home(Dimensions dimensions) {
        this.dimensions = dimensions;

        this.adres = "";
        this.height = 0;
        this.length = 0;
        this.width = 0;
        this.weight = 0;
        this.coup = false;
        this.registrationNumber = "";
        this.fragile = false;

    }


    public Home setDimensions(Dimensions dimensions){
        return new Home(dimensions,adres, height, length, width, weight, coup, registrationNumber, fragile);
    }

    public Home  setAdres(String adres) {
        return new Home (dimensions, adres, height, length, width, weight, coup, registrationNumber, fragile);
    }

    public Home  setWeight(double weight) {
        return new Home (dimensions, adres, height, length, width, weight, coup, registrationNumber, fragile);
    }

    public String getAdres(){
        return adres;
    }

    public double getWeight(){
        return weight;
    }

    public Dimensions getDimensions(){
        return dimensions;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean getFragile() {
        return fragile;
    }

    public boolean getCoup() {
        return coup;
    }


    public String toString(){
        return
                "Адрес: " + adres + "\n"+
                "Высота: " + height + "\n" +
                "Длина: " + length + "\n" +
                "Ширина: " + weight + "\n" +
                "Допускаются ли поворот: " + ((coup == true) ? "yes" : "no") + "\n" +
                "Регистрационный номер: " + registrationNumber + "\n" +
                "Хрупкий ли: " + ((fragile == true) ? "yes" : "no");
    }
}