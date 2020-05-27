package com.gxtDemo.client.model.data;

import com.gxtDemo.client.model.Settlement;

import java.util.ArrayList;
import java.util.List;

public class SettlementData {
    public static List<Settlement> getSettlementList(){
        List<Settlement> settlementList = new ArrayList<>();
        settlementList.add(new Settlement("临时指定"));
        settlementList.add(new Settlement("指定账期"));
        settlementList.add(new Settlement("指定日期"));
        settlementList.add(new Settlement("货到付款"));
        return settlementList;
    }
}
