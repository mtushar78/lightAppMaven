package commit.light.lightproject.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class LightInfo {
    @EmbeddedId
    private LightDBIdentity lightDBIdentity;
    private int zoneNo;

    public LightInfo() {
    }

    public LightInfo(LightDBIdentity lightDBIdentity, int zoneNo) {
        this.lightDBIdentity = lightDBIdentity;
        this.zoneNo = zoneNo;
    }

    public LightDBIdentity getLightDBIdentity() {
        return lightDBIdentity;
    }

    public void setLightDBIdentity(LightDBIdentity lightDBIdentity) {
        this.lightDBIdentity = lightDBIdentity;
    }

    public int getZoneNo() {
        return zoneNo;
    }

    public void setZoneNo(int zoneNo) {
        this.zoneNo = zoneNo;
    }
}
