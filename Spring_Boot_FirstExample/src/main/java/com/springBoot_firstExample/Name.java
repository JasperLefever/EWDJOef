package com.springBoot_firstExample;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Name {
    private String value;

   /* public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }*/
}
