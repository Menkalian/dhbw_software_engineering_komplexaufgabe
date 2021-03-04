package packagecenter.incomming;

public class Package {
    private final String id;
    private char[][][] content;
    private final String zipCode;
    private final PackageType type;
    private final double weight;

    public String getId() {
        return this.id;
    }

    public char[][][] getContent() {
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
        if(id.matches("(.*)[^a-z0-9](.*)")){
            this.id = null;
        } else this.id = id;

        this.content = content;
        if(content.length == 25 && content[0].length == 10 && content[0][0].length == 10){
            loop:
            for(int i = 0; i<25; i++){
                for(int j = 0; j<10; j++){
                    for(int k = 0; k<10; k++){
                        if (String.valueOf(content[i][j][k]).matches("(.*)[^a-z.:!-](.*)")){
                            this.content = null;
                            break loop;
                        }
                    }
                }
            }
        }else this.content = null;

        if(Integer.valueOf(zip_code)<1067 || Integer.valueOf(zip_code)>99998){
            this.zipCode = null;
        } else {
            //ignores leading zeros except for 0xxxx
            zipCode = zip_code.substring(zip_code.length()-5);
        }

        if(type instanceof packagecenter.incomming.PackageType) {
            this.type = type;
        }else this.type = null;

        if(1.00<=weight && weight<=5.00)
            this.weight = weight;
        else this.weight = 0.00;
    }

}