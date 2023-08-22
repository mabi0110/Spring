package com.example.generatortabel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TableGeneratorController {

    @PostMapping(path = "/generate", produces = "text/plain")
    @ResponseBody
    String generateTable(@RequestParam String headers, @RequestParam String data){
        String[] headersArray = headers.split(TableGeneratorService.SEPARATOR);
        String[] dataRows = data.split("\n");
        String[][] dataArray = new String[dataRows.length][];
        for (int i = 0; i < dataRows.length; i++) {
            dataArray[i] = dataRows[i].split(TableGeneratorService.SEPARATOR);
        }
        return TableGeneratorService.getTable(headersArray, dataArray );
    }

}
