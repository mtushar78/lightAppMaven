package commit.light.lightproject.services;
import commit.light.lightproject.model.LightEntity;
import commit.light.lightproject.repository.LightInfoRepo;
import commit.light.lightproject.repository.LightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {
    @Autowired
    LightRepo lightRepo;
    @Autowired
    LightInfoRepo lightInfoRepo;

    public List<LightEntity> getAllValues() {
        return lightRepo.findAll();
    }
    
    public String insertData(LightEntity lightEntity) {
        Integer dbNo = lightEntity.getLightInfo().getLightDBIdentity().getDbNo();
        Integer lightno = lightEntity.getLightInfo().getLightDBIdentity().getLightNo();
        int isTurnedOn = lightEntity.isTurnedOn();
        if (lightRepo.findByLightInfo(lightEntity.getLightInfo()) != null) {
            lightRepo.updateIsOn(isTurnedOn, dbNo, lightno);
            return "updated";
        } else {
            Integer isLightInfoExists = lightInfoRepo.ifLightInfoExists(dbNo,lightno);
            if(isLightInfoExists == 0){
                lightInfoRepo.save(lightEntity.getLightInfo());
                lightRepo.save(lightEntity);
                return "LightInfo Saved then Entry Created!";
            }
            else{
                lightRepo.save(lightEntity);
                return "Created";
            }
        }
//
    }
}
