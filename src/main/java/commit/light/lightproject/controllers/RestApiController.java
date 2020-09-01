package commit.light.lightproject.controllers;
import commit.light.lightproject.model.LightEntity;
import commit.light.lightproject.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping (value = "/get")
public class RestApiController {
    @Autowired
    ApiService apiService;

    @GetMapping("/getAll")
    public List<LightEntity> getAll(){
//        return new ResponseEntity<List<LightEntity>>(apiService.getAllValues(),new HttpHeaders(), HttpStatus.OK);
        return apiService.getAllValues();
    }
    @GetMapping("/")
    public String getdemo(){
//        return new ResponseEntity<List<LightEntity>>(apiService.getAllValues(),new HttpHeaders(), HttpStatus.OK);
        return "Light App With GSM Module!";
    }

    @PostMapping("/insert")
    public String insert(@RequestBody LightEntity lightEntity){

        return apiService.insertData(lightEntity);
    }
}
