package commit.light.lightproject.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LightDBIdentity implements Serializable {
    @Column(name = "light_no")
    private Integer lightNo;
    @Column(name = "db_no")
    private Integer dbNo;

    public LightDBIdentity() {
    }

    public LightDBIdentity(Integer lightNo, Integer dbNo) {
        this.lightNo = lightNo;
        this.dbNo = dbNo;
    }

    public Integer getLightNo() {
        return lightNo;
    }

    public void setLightNo(Integer lightNo) {
        this.lightNo = lightNo;
    }

    public Integer getDbNo() {
        return dbNo;
    }

    public void setDbNo(Integer dbNo) {
        this.dbNo = dbNo;
    }
}
