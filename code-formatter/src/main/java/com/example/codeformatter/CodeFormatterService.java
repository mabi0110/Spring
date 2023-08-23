package com.example.codeformatter;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import org.springframework.stereotype.Service;

@Service
public class CodeFormatterService {

    String formatCode(String sourceCode) throws FormatterException {
        return new Formatter().formatSource(sourceCode);
    }

}
