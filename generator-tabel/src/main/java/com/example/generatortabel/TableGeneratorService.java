package com.example.generatortabel;

import com.github.freva.asciitable.AsciiTable;

public class TableGeneratorService {
    public static final String SEPARATOR = ";";

    public static String getTable(String[] headers, String[][] data){
        return AsciiTable.getTable(headers, data);
    }
}
