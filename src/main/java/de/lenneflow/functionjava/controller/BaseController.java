package de.lenneflow.functionjava.controller;

import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/functionjava")
public class BaseController {

    @GetMapping(value={"", "/"})
    public String checkService() {
        return "Welcome to the Java Function Simulator!";
    }

    @PostMapping(value={ "/process"})
    public Map<String, Object> processFunction(@RequestBody Map<String, Object> inputData) {
        Map<String, Object> outputData = new HashMap<>();
        int processTimeInMillis = (int) inputData.get("processTimeInMillis");
        System.out.println(MessageFormat.format("Start {0} seconds processing of following input\n{1}\n\n", processTimeInMillis/1000, inputData));
        try {
            Thread.sleep(processTimeInMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        outputData.put("processTimeInSeconds", processTimeInMillis/1000);
        System.out.println("successfully processed");
        return outputData;
    }
}
