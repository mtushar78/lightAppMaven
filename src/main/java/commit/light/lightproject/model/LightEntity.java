package commit.light.lightproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "light_entity")
public class LightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private LightInfo lightInfo;
    @JsonProperty
    private int isTurnedOn;

    public LightEntity() {
    }

    public LightEntity(LightInfo lightInfo, int isTurnedOn) {
        this.lightInfo = lightInfo;
        this.isTurnedOn = isTurnedOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LightInfo getLightInfo() {
        return lightInfo;
    }

    public void setLightInfo(LightInfo lightInfo) {
        this.lightInfo = lightInfo;
    }

    public int isTurnedOn() {
        return isTurnedOn;
    }

    public void setTurnedOn(int turnedOn) {
        isTurnedOn = turnedOn;
    }
}
