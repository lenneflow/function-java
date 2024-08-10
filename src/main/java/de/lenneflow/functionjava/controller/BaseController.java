package de.lenneflow.functionjava.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BaseController {

    @GetMapping(value={"", "/"})
    public String checkService() {
        return "Welcome to the Java Function Simulator!";
    }

    @PostMapping(value={ "/process/{timeInSeconds}"})
    public Map<String, Object> processFunction(@RequestBody Map<String, Object> inputData, @PathVariable int timeInSeconds) {
        Map<String, Object> outputData = new HashMap<>();
        System.out.println(String.format("Start {0} seconds processing of following input\n{1}\n\n", timeInSeconds, inputData));
        try {
            Thread.sleep(timeInSeconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        outputData.put("processTime", timeInSeconds);
        System.out.println("successfully processed");
        return outputData;
    }
}
