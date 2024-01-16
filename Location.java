public class Location {
    private double latitude;
    private double longitude;
    private String coordinateSystem;

    public Location(double latitude, double longitude, String coordinateSystem) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.coordinateSystem = coordinateSystem;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCoordinateSystem() {
        return coordinateSystem;
    }

    public void setCoordinateSystem(String coordinateSystem) {
        this.coordinateSystem = coordinateSystem;
    }
}
