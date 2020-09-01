package commit.light.lightproject.controllers;

import commit.light.lightproject.pojo.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.simp.SimpMessagingTemplate;
@RestController
public class NotificationController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    HelloMessage hello = new HelloMessage("Tushar Vaiyaa !! ");
    @GetMapping("/notify")
    public String getNotification() {
        // Push notifications to front-end
        simpMessagingTemplate.convertAndSend("/topic/notification", hello);

        return "Notifications successfully sent to Angular !";
    }
}
