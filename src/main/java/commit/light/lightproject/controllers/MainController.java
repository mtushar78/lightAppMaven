package commit.light.lightproject.controllers;

import commit.light.lightproject.model.LightEntity;
import commit.light.lightproject.pojo.ShowLightsInList;
import commit.light.lightproject.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class MainController {
    @Autowired
    ApiService apiService;
    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping(value = "/list")
    public String data(Model model){
        List<LightEntity> x = apiService.getAllValues();
        ShowLightsInList lightList[] = new ShowLightsInList[x.size()];
        int index = 0;
        for (LightEntity entity: x) {
            lightList[index] = new ShowLightsInList(entity.getLightInfo().getLightDBIdentity().getLightNo(),
                    entity.getLightInfo().getLightDBIdentity().getDbNo(),
                    entity.getLightInfo().getZoneNo(),
                    entity.isTurnedOn());
            index++;
        }
        model.addAttribute("lights",lightList);
        return "data";
    }
}
