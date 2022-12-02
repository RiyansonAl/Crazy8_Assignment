package com.example.Assignment3;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HostController {

    gameHostBackEnd webHost;

    public HostController(){

    }

    public void setgameHostBackEnd(gameHostBackEnd host){
        webHost = host;
    }

    @CrossOrigin
    @RequestMapping("/getInfo")
    public Map<String, String> getInfoTest() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "Value");
        map.put("foo", "bar");
        map.put("aa", "bb");
        System.out.println("Entered this method on different file");
        return map;
    }

    @GetMapping(path = "/PlayerPlacedCard/{card}")
    public String placeCard(@PathVariable("card") String card) {

        System.out.println("The player played " + card + " card");

        return String.format("Hello %s!", card);
    }


}
