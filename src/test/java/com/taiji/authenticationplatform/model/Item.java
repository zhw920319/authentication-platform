package com.taiji.authenticationplatform.model;

import io.searchbox.annotations.JestId;
import lombok.Data;

@Data
public class Item {
    @JestId
    private  Integer id;
    private  String autor;
    private  String context;

}
