public class VolTank {
    public static int tankVol(int h, int d, int vt) {
        double r = d / 2.0;
        double z = r - h;
        double alpha = 2 * Math.acos(z / r);
        return (int) Math.floor((alpha / Math.toRadians(360)) * Math.PI * r * r - r * z * Math.sin(alpha / 2));
    }
}
