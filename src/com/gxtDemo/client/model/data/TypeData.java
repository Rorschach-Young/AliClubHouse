package com.gxtDemo.client.model.data;

import com.gxtDemo.client.model.Type;

import java.util.ArrayList;
import java.util.List;

public class TypeData {
    public static List<Type> getTypes(){
        List<Type> Types = new ArrayList<>();
        Types.add(new Type("普通客户"));
        Types.add(new Type("VIP客户"));
        return Types;
    }
}
