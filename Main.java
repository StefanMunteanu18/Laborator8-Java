import java.sql.Connection;
import java.sql.Statement;

public class Main {
    public static void main(String args[]) {


        Continent eu = new Continent(1, "Europe");
        Country ro = new Country(1, "Romania", "RO", eu);
        DAOclass dao = new DAOclass();
        Connection c = Database.getConnection();
        Statement stmt;
        SQLScripts script = new SQLScripts();
        try {
            stmt = c.createStatement();
            stmt.executeUpdate(script.createCountries);
            stmt.executeUpdate(script.createCities);
            stmt.executeUpdate(script.createContinents);

            dao.addAllCities(c);
            dao.addCountry(c, ro);
            dao.addContinent(c, eu);

            Country result = dao.getCountry(c, "Romania");
            City resultCity = dao.getCity(c, "Bucharest");
            Continent resultCont = dao.getContinent(c, "Europe");

            System.out.println(result.toString());
            System.out.println(resultCity.toString());
            System.out.println(resultCont.toString());

            ShowDistance dist = new ShowDistance();
            System.out.println(dist.distance(c, "Bucharest", "Paris"));

            stmt.executeUpdate("Drop table countries");
            stmt.executeUpdate("Drop table cities");
            stmt.executeUpdate("Drop table continents");

            stmt.close();
            c.close();
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }

    }
}
