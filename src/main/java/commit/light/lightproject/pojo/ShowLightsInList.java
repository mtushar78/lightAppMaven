package commit.light.lightproject.pojo;

public class ShowLightsInList {
    private int lightNo;
    private int dbNo;
    private int zoneNo;
    private int lightStatus;

    public int getLightStatus() {
        return lightStatus;
    }

    public void setLightStatus(int lightStatus) {
        this.lightStatus = lightStatus;
    }

    public int getLightNo() {
        return lightNo;
    }

    public void setLightNo(int lightNo) {
        this.lightNo = lightNo;
    }

    public int getDbNo() {
        return dbNo;
    }

    public void setDbNo(int dbNo) {
        this.dbNo = dbNo;
    }

    public int getZoneNo() {
        return zoneNo;
    }

    public void setZoneNo(int zoneNo) {
        this.zoneNo = zoneNo;
    }

    public ShowLightsInList(int lightNo, int dbNo, int zoneNo, int lightStatus) {
        this.lightNo = lightNo;
        this.dbNo = dbNo;
        this.zoneNo = zoneNo;
        this.lightStatus = lightStatus;
    }
    public ShowLightsInList() {
    }

    public String getRealLightStatus(){
        if(this.lightStatus ==1){
            return "On";
        }
        return "Off";
    }
}
