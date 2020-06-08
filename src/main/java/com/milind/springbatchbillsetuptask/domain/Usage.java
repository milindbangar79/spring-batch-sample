package com.milind.springbatchbillsetuptask.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "firstName",
        "lastName",
        "mins",
        "dataUsage"
})
public class Usage {

    public Usage(){
        super();
    }

    @JsonProperty("Id")
    private Long Id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("mins")
    private Long mins;
    @JsonProperty("dataUsage")
    private Long dataUsage;
}
