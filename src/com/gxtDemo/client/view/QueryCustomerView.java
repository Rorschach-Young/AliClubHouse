package com.gxtDemo.client.view;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gxtDemo.client.GxtDemoService;
import com.gxtDemo.client.dto.QueryCustomer;
import com.gxtDemo.client.dto.QueryCustomerDTO;
import com.gxtDemo.client.model.Customer;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.state.client.BorderLayoutStateHandler;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;

import java.util.ArrayList;
import java.util.List;

public class QueryCustomerView {
    private BorderLayoutContainer borderLtWidget;
    private BorderLayoutStateHandler borderLtStateHandler;

    public BorderLayoutContainer getBorderLtWidget() {
        if(borderLtWidget == null ){
            // north部分
            ContentPanel cpNorth = new ContentPanel();
            cpNorth.setHeading("查询条件");
            cpNorth.setBodyBorder(false);
            // 查询条件
            final TextField tdCondition = new TextField();
            tdCondition.setWidth(200);
            FieldLabel flbCondition = new FieldLabel(tdCondition, "输入代码、助记符、名称");
            flbCondition.setLabelWidth(150);
            // 查询按钮
            TextButton btnRead = new TextButton("查询");
            btnRead.addSelectHandler(new SelectEvent.SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    QueryCustomer request = new QueryCustomer();
                    if (tdCondition.getValue() != null && !tdCondition.getValue().isEmpty()){
                        request.setCode(tdCondition.getValue());
                        request.setMnemonicCode(tdCondition.getValue());
                        request.setName(tdCondition.getValue());
                    }
                    GxtDemoService.App.getInstance().listCustomer(request, new QueryCustomerAsyncCallback());
                }
            });
            btnRead.setWidth(60);
            HBoxLayoutContainer hboxLtNorth = new HBoxLayoutContainer();
            hboxLtNorth.add(flbCondition);
            hboxLtNorth.add(btnRead,new BoxLayoutContainer.BoxLayoutData(new Margins(0,0,0,10)));
            hboxLtNorth.setPosition(20,10);
            cpNorth.add(hboxLtNorth);

            // west部分
            ContentPanel cpWest = new ContentPanel();
            cpWest.setHeading("客户类型");
            cpWest.setBodyBorder(false);

            // center部分
            ContentPanel cpCenter = new ContentPanel();
            cpCenter.add(new QueryCustomerCenterView().getVerticalLtCenter());
            cpCenter.setHeaderVisible(false);
            cpCenter.setBodyBorder(false);

            BorderLayoutContainer.BorderLayoutData borderLtNorthData = new BorderLayoutContainer.BorderLayoutData(100);
            borderLtNorthData.setCollapsible(true);
            borderLtNorthData.setCollapseHeaderVisible(true);
            borderLtNorthData.setSplit(false);

            BorderLayoutContainer.BorderLayoutData borderLtWestData = new BorderLayoutContainer.BorderLayoutData(150);
            borderLtWestData.setCollapsible(true);
            borderLtWestData.setSplit(false);

            BorderLayoutContainer.BorderLayoutData borderLtCenterData = new BorderLayoutContainer.BorderLayoutData(100);
            borderLtWidget =  new BorderLayoutContainer();
            borderLtWidget.setNorthWidget(cpNorth, borderLtNorthData);
            borderLtWidget.setWestWidget(cpWest, borderLtWestData);
            borderLtWidget.setCenterWidget(cpCenter, borderLtCenterData);
            borderLtStateHandler = new BorderLayoutStateHandler(borderLtWidget, "blcId1");
            borderLtWidget.setStateful(true);
        }
        borderLtStateHandler.loadState();
        return borderLtWidget;
    }

    private class QueryCustomerAsyncCallback implements AsyncCallback<List<QueryCustomerDTO>> {
        @Override
        public void onFailure(Throwable caught) {
            Info.display("查询失败", caught.getMessage());
        }

        @Override
        public void onSuccess(List<QueryCustomerDTO> result) {
            QueryCustomerCenterView.store.clear();
            List<Customer> customerList = new ArrayList<>();
            if(result != null && !result.isEmpty()){
                for (QueryCustomerDTO rsp : result){
                    Customer customer = new Customer();

                    customer.setId(rsp.getId());
                    customer.setCode(rsp.getCode());
                    customer.setName(rsp.getName());
                    customer.setMnemonicCode(rsp.getMnemonicCode());
                    customer.setType(rsp.getType());
                    customer.setPhone(rsp.getPhone());
                    customer.setFax(rsp.getFax());
                    customer.setEmail(rsp.getEmail());
                    customer.setAddress(rsp.getAddress());
                    customer.setMark(rsp.getMark());
                    customer.setCompany(rsp.getCompany());
                    customer.setBirthday(rsp.getBirthday());
                    customer.setPostCode(rsp.getPostCode());
                    customer.setBankAccount(rsp.getBankAccount());
                    customer.setBank(rsp.getBank());
                    customer.setSettlement(rsp.getSettlement());
                    customer.setSettlementTime(rsp.getSettlementTime());
                    customer.setMonthlyTime(rsp.getMonthlyTime());
                    customer.setRemark(rsp.getRemark());

                    customerList.add(customer);
                }
            }

            QueryCustomerCenterView.store.addAll(customerList);
        }
    }
}
