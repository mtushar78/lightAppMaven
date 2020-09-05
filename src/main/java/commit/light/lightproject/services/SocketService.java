package commit.light.lightproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SocketService {
    @Autowired
    RestTemplate restTemplate;


    public String  pushNotification(Integer id){
        String lightList =  restTemplate.getForObject("http://localhost:8089/get/notify/"+id ,String.class);
        return lightList;
    }
}
