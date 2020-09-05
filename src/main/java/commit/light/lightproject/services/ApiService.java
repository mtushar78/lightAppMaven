package commit.light.lightproject.services;
import commit.light.lightproject.model.LightEntity;
import commit.light.lightproject.model.LightInfo;
import commit.light.lightproject.repository.LightInfoRepo;
import commit.light.lightproject.repository.LightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService {
    @Autowired
    LightRepo lightRepo;
    @Autowired
    LightInfoRepo lightInfoRepo;

    public List<LightEntity> getAllValues() {
        return lightRepo.findAll();
    }
    public LightEntity getLight(Integer id){
        Optional<LightEntity> x = lightRepo.findById(id);
        if(x.isPresent()){
            return x.get();
        }else {
           return  new LightEntity();
        }
    }
    
    public Integer insertData(LightEntity lightEntity) {
        Integer dbNo = lightEntity.getLightInfo().getLightDBIdentity().getDbNo();
        Integer lightno = lightEntity.getLightInfo().getLightDBIdentity().getLightNo();
        int isTurnedOn = lightEntity.isTurnedOn();

        if (lightRepo.findByLightInfo(lightEntity.getLightInfo()) != null) {

            lightRepo.updateIsOn(isTurnedOn, dbNo, lightno);
            return lightRepo.getLightID(dbNo,lightno);
        } else {
            Integer isLightInfoExists = lightInfoRepo.ifLightInfoExists(dbNo,lightno);
            if(isLightInfoExists == 0){
                lightInfoRepo.save(lightEntity.getLightInfo());
                lightRepo.save(lightEntity);
                return lightRepo.getLightID(dbNo,lightno);
            }
            else{
                lightRepo.save(lightEntity);
                return lightRepo.getLightID(dbNo,lightno);
            }
        }
//
    }
}
