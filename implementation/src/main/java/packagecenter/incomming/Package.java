package packagecenter.incomming;

public class Package {
    private final String id;
    private final char content;
    private final String zipCode;
    private final PackageType type;
    private final double weight;

    public String getId() {
        return this.id;
    }

    public char getContent() {
        return this.content;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public PackageType getType() {
        return this.type;
    }

    public double getWeight() {
        return this.weight;
    }

    /**
     * 
     * @param id
     * @param content
     * @param zip_code
     * @param type
     * @param weight
     */
    public Package(String id, char[][][] content, String zip_code, PackageType type, double weight) {
        // TODO - implement Package.Package @Löh
        throw new UnsupportedOperationException();
    }

}