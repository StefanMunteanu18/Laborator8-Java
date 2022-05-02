import java.sql.Connection;
import java.util.Objects;

public class ShowDistance {
    public double distance(Connection c, String cityName1, String cityName2) {
        DAOclass dao = new DAOclass();
        City city1 =  dao.getCity(c,cityName1);
        City city2 =  dao.getCity(c,cityName2);
        if(Objects.isNull(city1) == false && Objects.isNull(city2) == false){
            double lat1 = city1.latitude;
            double lon1 = city1.longitude;
            double lat2 = city2.latitude;
            double lon2 = city2.longitude;
            double theta = lon1 - lon2;
            double dist = Math.sin(degTorad(lat1)) * Math.sin(degTorad(lat2)) + Math.cos(degTorad(lat1)) * Math.cos(degTorad(lat2)) * Math.cos(degTorad(theta));
            dist = Math.acos(dist);
            dist = radTodeg(dist);
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344;
            return (dist);
        }
        else{
            System.out.println("Invalid cities!");
            return -1;
        }
    }

    public double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(degTorad(lat1)) * Math.sin(degTorad(lat2)) + Math.cos(degTorad(lat1)) * Math.cos(degTorad(lat2)) * Math.cos(degTorad(theta));
        dist = Math.acos(dist);
        dist = radTodeg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        return (dist);
    }

    private double degTorad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double radTodeg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
