package com.lothus.core.app.buy;

import com.lothus.core.app.buy.type.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Buy {

    private String name;
    private String product;

    private CategoryType type;

    private int hours;

}
