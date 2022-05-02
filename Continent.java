public class Continent {
    int id;
    String name;

    public Continent(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Continent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
