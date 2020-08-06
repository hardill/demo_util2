package com.demo.forest;

import com.dtflys.forest.annotation.Request;

public interface MyClient {
    @Request(url = "http://localhost:9090/hi")
    String simpleRequest();
}
