import com.opencsv.CSVReader;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOclass {
    public boolean addContinent(Connection c, Continent continent){
        try {
            Statement stmt;
            stmt = c.createStatement();
            System.out.println("insert into continents values (" + String.valueOf(continent.id) + ","+ "'" + continent.name + "'" + ");");
            stmt.executeUpdate("insert into continents values (" + String.valueOf(continent.id) + ","+ "'" + continent.name + "'" + ");");
            System.out.println("Inserted successfully!");
            stmt.close();
            return true;
        }
        catch (Exception e){
            System.out.println("Invalid continetn or continent already exists!");
            return false;
        }
    }


    public boolean addCountry(Connection c, Country country){
        try {
            Statement stmt;
            stmt = c.createStatement();
            System.out.println("insert into countries values (" + String.valueOf(country.id) + ","+ "'" + country.name + "'" + "," + "'" +country.code + "'" + ","+ "'" + country.continent +"'" + ");");
            stmt.executeUpdate("insert into countries values (" + String.valueOf(country.id) + ","+ "'" + country.name + "'" + "," + "'" +country.code + "'" + ","+ "'" + country.continent +"'" + ");");
            System.out.println("Inserted successfully!");
            stmt.close();
            return true;
        }
        catch (Exception e){
            System.out.println("Invalid country or country already exists!");
            return false;
        }
    }

    public Continent getContinent(Connection c, int searchedId){
        try {
            Statement stmt;
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM continents where id = " +  String.valueOf(searchedId) + ";");
            rs.next();
            System.out.println("SELECT * FROM continents where id = " +  String.valueOf(searchedId) + ";");
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Continent continent = new Continent(id, name);
            rs.close();
            stmt.close();
            System.out.println("SUCCESS!");
            return continent;
        }
        catch (Exception e){
            System.out.println("The country does not exist!");
            return null;
        }
    }

    public Continent getContinent(Connection c, String searchedName){
        try {
            Statement stmt;
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM continents where name = " +  "'" + searchedName  +  "'" + ";");
            rs.next();
            System.out.println("SELECT * FROM continents where name = " +  "'" + searchedName  +  "'" + ";");
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Continent continent = new Continent(id, name);
            rs.close();
            stmt.close();
            System.out.println("SUCCESS!");
            return continent;
        }
        catch (Exception e){
            System.out.println("The country does not exist!");
            return null;
        }
    }


    public Country getCountry(Connection c, int searchedId){
        try {
            Statement stmt;
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM countries where id = " +  String.valueOf(searchedId) + ";");
            rs.next();
            System.out.println("SELECT * FROM countries where id = " +  String.valueOf(searchedId) + ";");
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String code = rs.getString("code");
            String continent = rs.getString("continent");
            Country country = new Country(id, name, code, continent);
            rs.close();
            stmt.close();
            System.out.println("SUCCESS!");
            return country;
        }
        catch (Exception e){
            System.out.println("The country does not exist!");
            return null;
        }
    }

    public Country getCountry(Connection c, String searchedName){
        try {
            Statement stmt;
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM countries where name = " +  "'" + searchedName  +  "'" + ";");
            rs.next();
            System.out.println("SELECT * FROM countries where name = " +  "'" + searchedName  +  "'" + ";");
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String code = rs.getString("code");
            String continent = rs.getString("continent");
            Country country = new Country(id, name, code, continent);
            rs.close();
            stmt.close();
            System.out.println("SUCCESS!");
            return country;
        }
        catch (Exception e){
            System.out.println("The country does not exist!");
            return null;
        }
    }

    public boolean addCity(Connection c, City city){
        try {
            Statement stmt;
            stmt = c.createStatement();
            //System.out.println("insert into cities values (" + String.valueOf(city.id) + ","+ "'" + city.country + "'" + "," + "'" +city.name + "'" + ","+ "'" + city.capital +"'" + "'" + String.valueOf(city.latitude) +"'" + "'" + String.valueOf(city.longitude) +"'"+");");
            stmt.executeUpdate("insert into cities values (" + String.valueOf(city.id) + ","+ "'" + city.country + "'" + "," + "'" +city.name + "'" + ","+ "'" + city.capital +"'" + ","+ "'" + String.valueOf(city.latitude) +"'" + ","+ "'" + String.valueOf(city.longitude) +"'"+");");
            System.out.println("Inserted successfully!");
            stmt.close();
            return true;
        }
        catch (Exception e){
            System.out.println("Invalid city!");
            return false;
        }
    }

    public City getCity(Connection c, int searchedId){
        try {
            Statement stmt;
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM cities where id = " +  String.valueOf(searchedId) + ";");
            rs.next();
            System.out.println("SELECT * FROM cities where id = " +  String.valueOf(searchedId) + ";");
            int id = rs.getInt("id");
            String country = rs.getString("country");
            String name = rs.getString("name");
            boolean capital = rs.getBoolean("capital");
            double latitude = rs.getDouble("latitude");
            double longitude = rs.getDouble("longitude");

            City city = new City(id, country, name, capital, latitude, longitude);
            rs.close();
            stmt.close();
            System.out.println("SUCCESS!");
            return city;
        }
        catch (Exception e){
            System.out.println("The city does not exist!");
            return null;
        }
    }

    public City getCity(Connection c, String searchedName){
        try {
            Statement stmt;
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM cities where name = " +  "'" + searchedName  +  "'" + ";");
            rs.next();
            System.out.println("SELECT * FROM cities where name = " +  "'" + searchedName  +  "'" + ";");
            int id = rs.getInt("id");
            String country = rs.getString("country");
            String name = rs.getString("name");
            boolean capital = rs.getBoolean("capital");
            double latitude = rs.getDouble("latitude");
            double longitude = rs.getDouble("longitude");

            City city = new City(id, country, name, capital, latitude, longitude);
            rs.close();
            stmt.close();
            System.out.println("SUCCESS!");
            return city;
        }
        catch (Exception e){
            System.out.println("The city does not exist!");
            return null;
        }
    }

    public boolean addAllCities(Connection c){
        try (CSVReader reader = new CSVReader(new FileReader("D:\\Desktop\\archive\\concap.csv"))) {
            String[] lineInArray;
            int id = 0;
            while ((lineInArray = reader.readNext()) != null) {
                id++;
                City city = new City(id, lineInArray[0], lineInArray[1], true, Double.parseDouble(lineInArray[2]), Double.parseDouble(lineInArray[3]));
                addCity(c, city);
                //System.out.println(city.toString());
                //System.out.println(lineInArray[0] + " " + lineInArray[1] + " " +lineInArray[2] + " " +lineInArray[3] + " "+ lineInArray[4] + " "+ lineInArray[5]);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
