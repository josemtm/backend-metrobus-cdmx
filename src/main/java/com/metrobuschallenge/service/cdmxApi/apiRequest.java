package com.metrobuschallenge.service.cdmxApi;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class apiRequest implements Serializable {

    private static final long serialVersionUID = 626911415667756283L;

    private Boolean success;
    private ResultRequest result;
}
