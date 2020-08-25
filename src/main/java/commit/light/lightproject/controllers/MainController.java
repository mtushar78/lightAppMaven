package commit.light.lightproject.controllers;

import commit.light.lightproject.model.LightEntity;
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
    public String home(Model model){
      List<LightEntity> x =   apiService.getAllValues();
        model.addAttribute("names",x);
        return "home";
    }
}
