/**
 * Following is my implementation solution to the Lyft, New Grad Software Engineer coding challenge
 * @author Devan Huapaya
 */

package im.devan;

public class ShortestDetourProblem {

    /*
        Problem:
        Calculate the detour distance between two different rides. Given four latitude / longitude pairs,
        where driver one is traveling from point A to point B and driver two is traveling from point C to point D,
        write a function (in your language of choice) to calculate the shorter of the detour distances the drivers
        would need to take to pick-up and drop-off the other driver.

        Assumptions:
        1. The Earth is spherical so the Haversine Formula is sufficient in calculating the distance between points
        2. That one driver can pick up the other and take them to their end point without having to return to the
            original location to retrieve there vehicle
        3. There can be only two possible outcomes: "ACDB" where driver one picks up driver two or "CABD"
            where driver two picks driver one
     */

    /**
     * Class to represent a point on a map
     */
    static class Point{

        double longitude, latitude;

        public Point(double longitude, double latitude) {
            this.longitude = longitude;
            this.latitude = latitude;
        }
    }

    /**
     * Class to represent a path from a start to an end
     */
    static class Ride{

        Point start, end;
        double distance;

        public Ride(Point start, Point end){
            this.start = start;
            this.end = end;
            this.distance = calcDistance(start, end);
        }
    }

    /**
     * Calculates the spherical distance between two points on a sphere
     * @param start
     * @param end
     * @return distance: Distance between start and end
     */
    static double calcDistance(Point start, Point end){

        /**
         * Radius of Earth in miles
         */
        final double radiusOfEarth = 3960;

        double diffLat = Math.toRadians(end.latitude - start.latitude);
        double diffLong = Math.toRadians(end.longitude - start.latitude);

        double startLat = Math.toRadians(start.latitude);
        double endLat = Math.toRadians(end.latitude);

        /**
         * Haversine Formula
         * @see http://www.movable-type.co.uk/scripts/latlong.html
         */
        double a = Math.pow(Math.sin(diffLat/2), 2) + Math.pow(Math.sin(diffLong/2), 2) * Math.cos(startLat) * Math.cos(endLat);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = radiusOfEarth * c;

        return distance;
    }


    /**
     * @summary Function that calculates the shortest detour between two rides
     * @param rideAB
     * @param rideCD
     * @return  String representation of the path with the shortest detour
     *
     */
    public static String calcShortestDetour(Ride rideAB, Ride rideCD){

        double distACDB = calcDistance(rideAB.start, rideCD.start) + rideCD.distance + calcDistance(rideCD.end, rideAB.end);
        double distCABD = calcDistance(rideCD.start, rideAB.start) + rideAB.distance + calcDistance(rideAB.end, rideCD.end);

        String result = (distACDB < distCABD)? "ACDB" : "CABD";

        return result;
    }

    /**
     * @summary Main function to test shortest distance calculation algorithm
     */
    public static void main(String[] args) {

        /**
         * Initialize test variables
         */
        Point A = new Point(30.631558, -96.354953); // House
        Point B = new Point(30.618878, -96.338932); // Bright building
        Point C = new Point(30.618637, -96.345158); // Kind of near Starbucks
        Point D = new Point(30.617824, -96.348066); // Blackwater draw

        Ride driver1Path = new Ride(A,B);
        Ride driver2Path = new Ride(C,D);

        /**
         * Call function to be tested
         */
        String shortestDetour = calcShortestDetour(driver1Path, driver2Path);

        /**
         * Print result
         */
        System.out.printf("The shorter path is: %s", shortestDetour);
    }
}
