public class Project {
    private String province;
    private String beneficiary;
    private int beneficiaryNum;
    private String assetClass;
    private String name;
    private String description;
    private String stage;
    private Location location;

    public Project(String province, String beneficiary, int beneficiaryNum, String assetClass, String name, String description, String stage, Location location) {
        this.province = province;
        this.beneficiary = beneficiary;
        this.beneficiaryNum = beneficiaryNum;
        this.assetClass = assetClass;
        this.name = name;
        this.description = description;
        this.stage = stage;
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public int getBeneficiaryNum() {
        return beneficiaryNum;
    }

    public void setBeneficiaryNum(int beneficiaryNum) {
        this.beneficiaryNum = beneficiaryNum;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}