public class Country {
    int id;
    String name;
    String code;
    String continent;

    public Country(int id, String name, String code, Continent continent){
        this.id = id;
        this.name = name;
        this.code = code;
        this.continent = continent.name;
    }
    public Country(int id, String name, String code, String  continent){
        this.id = id;
        this.name = name;
        this.code = code;
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", continent='" + continent + '\'' +
                '}';
    }
}
