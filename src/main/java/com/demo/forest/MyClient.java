package com.demo.forest;

import com.demo.base.Result;
import com.dtflys.forest.annotation.Request;
import com.dtflys.forest.http.ForestResponse;

public interface MyClient {
    @Request(url = "http://localhost:9090/hi", dataType = "json")
    ForestResponse<Result> simpleRequest();
}
