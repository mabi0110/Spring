package com.example.sesje;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VisitCounter {

        private int counter;

        public int getCounter() {
            return counter;
        }

        void increment() {
            counter++;
        }



}
