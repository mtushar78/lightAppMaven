package commit.light.lightproject.controllers;
import commit.light.lightproject.model.LightEntity;
import commit.light.lightproject.services.ApiService;
import commit.light.lightproject.services.SocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping (value = "/get")
public class RestApiController {
    @Autowired
    ApiService apiService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    SocketService socketService;
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
    @GetMapping("/getLight/{id}")
    public LightEntity getLightByID(@PathVariable Integer id){
        return apiService.getLight(id);
    }

    @PostMapping("/insert")
    public String insert(@RequestBody LightEntity lightEntity){
        Integer res = apiService.insertData(lightEntity);
        System.out.println("Inserting data with id --------------!! : "+ res);
        String lightList = socketService.pushNotification(res);
        System.out.println("socket activated --------------!! : "+ lightList);

        return "res";
    }

    @GetMapping("/notify/{id}")
    public String getNotification(@PathVariable Integer id) {
        // Push notifications to front-end
        simpMessagingTemplate.convertAndSend("/topic/notification", apiService.getLight(id));


        return "Notifications successfully sent to Angular !";
    }
}
