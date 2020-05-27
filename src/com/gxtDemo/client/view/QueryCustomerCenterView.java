package com.gxtDemo.client.view;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gxtDemo.client.GxtDemo;
import com.gxtDemo.client.GxtDemoService;
import com.gxtDemo.client.GxtDemoServiceAsync;
import com.gxtDemo.client.dto.DeleteCustomer;
import com.gxtDemo.client.dto.QueryCustomer;
import com.gxtDemo.client.dto.QueryCustomerDTO;
import com.gxtDemo.client.model.Customer;
import com.gxtDemo.client.model.CustomerProperties;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.state.client.GridStateHandler;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.info.Info;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class QueryCustomerCenterView {
    private static final CustomerProperties props = GWT.create(CustomerProperties.class);
    static ListStore<Customer> store = new ListStore<>(props.key());
    private VerticalLayoutContainer verticalLtCenter;
    private GridStateHandler<Customer> gridStateHandler;

    public VerticalLayoutContainer getVerticalLtCenter() {
        if (verticalLtCenter == null) {
            init();

            //复选框选择模型
            CheckBoxSelectionModel<Customer> chkSelectionModel = new CheckBoxSelectionModel<Customer>(){
            };

            ColumnConfig<Customer, String> columnCode = new ColumnConfig<Customer, String>(props.code(), 50, "客户代码");
            ColumnConfig<Customer, String> columnName = new ColumnConfig<Customer, String>(props.name(), 50, "客户名称");
            ColumnConfig<Customer, String> columnMnemonicCode = new ColumnConfig<Customer, String>(props.mnemonicCode(), 50, "助记码");
            ColumnConfig<Customer, String> columnType = new ColumnConfig<Customer, String>(props.type(), 50, "客户类型");
            ColumnConfig<Customer, String> columnPhone = new ColumnConfig<Customer, String>(props.phone(), 50, "电话");
            ColumnConfig<Customer, String> columnFax = new ColumnConfig<Customer, String>(props.fax(), 50, "传真");
            ColumnConfig<Customer, String> columnEmail = new ColumnConfig<Customer, String>(props.email(), 50, "EMail");
            ColumnConfig<Customer, Boolean> columnMark = new ColumnConfig<Customer, Boolean>(props.mark(), 50, "启用标记");
            columnMark.setCell(new Cell<Boolean>() {
                 @Override
                    public boolean dependsOnSelection() {
                    return false;
                }

                @Override
                public Set<String> getConsumedEvents() {
                    return null;
                }

                @Override
                public boolean handlesSelection() {
                    return false;
                }

                @Override
                public boolean isEditing(Context context, Element parent, Boolean value) {
                    return false;
                }

                @Override
                public void onBrowserEvent(Context context, Element parent, Boolean value, NativeEvent event, ValueUpdater<Boolean> valueUpdater) { }

                @Override
                public void render(Context context, Boolean value, SafeHtmlBuilder sb) {
                    sb.appendHtmlConstant(value==true?"是":"否");
                }

                @Override
                public boolean resetFocus(Context context, Element parent, Boolean value) {
                    return false;
                }

                @Override
                public void setValue(Context context, Element parent, Boolean value) { }
            });

            List<ColumnConfig> columnList = new ArrayList<>();
            columnList.add(chkSelectionModel.getColumn());
            columnList.add(columnCode);
            columnList.add(columnName);
            columnList.add(columnMnemonicCode);
            columnList.add(columnType);
            columnList.add(columnPhone);
            columnList.add(columnFax);
            columnList.add(columnEmail);
            columnList.add(columnMark);

            final Grid<Customer> gridCustomer = new Grid<Customer>(store, new ColumnModel(columnList)){};


            //设置选择模型
            gridCustomer.setSelectionModel(chkSelectionModel);
            gridCustomer.setAllowTextSelection(true);
            gridCustomer.getView().setStripeRows(true);
            gridCustomer.getView().setColumnLines(true);
            gridCustomer.setBorders(false);
            gridCustomer.setColumnReordering(true);
            gridCustomer.setStateful(true);
            gridCustomer.setStateId("gridStateExample");
            verticalLtCenter = new VerticalLayoutContainer();


            // 刷新按钮
            TextButton btnReQuery = new TextButton("刷新");
            btnReQuery.setSize("80","30");
            btnReQuery.addSelectHandler(new SelectEvent.SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    init();
                    GxtDemo.back();
                }
            });

            // 新增按钮
            TextButton btnSave = new TextButton("新增");
            btnSave.setSize("80","30");
            btnSave.addSelectHandler(new SelectEvent.SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    GxtDemo.save();
                }
            });

            //删除按钮
            TextButton btnDelete = new TextButton("删除");
            btnDelete.setSize("80", "30");
            btnDelete.addSelectHandler(new SelectEvent.SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    DeleteCustomer request = new DeleteCustomer();
                    List<Customer> models = gridCustomer.getSelectionModel().getSelectedItems();
                    if(models.size() == 0){
                        createAlert();
                    } else {
                        List<Integer> ids = new ArrayList<>();
                        for (Customer customer : models){
                            ids.add(customer.getId());
                            store.remove(store.indexOf(customer));
                        }
                        request.setIds(ids);
                        GxtDemoService.App.getInstance().deleteCustomer(request,new DeleteCustomerAsyncCallback());
                    }
                }
            });



            //修改按钮
            TextButton btnUpdate = new TextButton("修改");
            btnUpdate.setSize("80","30");
            btnUpdate.addSelectHandler(new SelectEvent.SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    List<Customer> models = gridCustomer.getSelectionModel().getSelectedItems();
                    if(models.size() != 1){
                        createAlert();
                    } else {
                        Customer customer = new Customer();

                        customer.setId(models.get(0).getId());
                        customer.setCode(models.get(0).getCode());
                        customer.setName(models.get(0).getName());
                        customer.setMnemonicCode(models.get(0).getMnemonicCode());
                        customer.setType(models.get(0).getType());
                        customer.setPhone(models.get(0).getPhone());
                        customer.setFax(models.get(0).getFax());
                        customer.setEmail(models.get(0).getEmail());
                        customer.setAddress(models.get(0).getAddress());
                        customer.setMark(models.get(0).getMark());
                        customer.setCompany(models.get(0).getCompany());
                        customer.setBirthday(models.get(0).getBirthday());
                        customer.setPostCode(models.get(0).getPostCode());
                        customer.setBankAccount(models.get(0).getBankAccount());
                        customer.setBank(models.get(0).getBank());
                        customer.setSettlement(models.get(0).getSettlement());
                        customer.setSettlementTime(models.get(0).getSettlementTime());
                        customer.setMonthlyTime(models.get(0).getMonthlyTime());
                        customer.setRemark(models.get(0).getRemark());

                        UpdateCustomerView.setCustomer(customer);
                        GxtDemo.update();
                    }
                }
            });

            HBoxLayoutContainer hboxLtBtn = new HBoxLayoutContainer();
            hboxLtBtn.setHeight(45);
            hboxLtBtn.add(btnReQuery, new BoxLayoutContainer.BoxLayoutData(new Margins(5,0,0,20)));
            hboxLtBtn.add(btnSave, new BoxLayoutContainer.BoxLayoutData(new Margins(5,0,0,20)));
            hboxLtBtn.add(btnUpdate, new BoxLayoutContainer.BoxLayoutData(new Margins(5,0,0,20)));
            hboxLtBtn.add(btnDelete, new BoxLayoutContainer.BoxLayoutData(new Margins(5,0,0,20)));
            verticalLtCenter.add(hboxLtBtn);
            verticalLtCenter.add(gridCustomer, new VerticalLayoutContainer.VerticalLayoutData(1, 1));
            gridStateHandler = new GridStateHandler<>(gridCustomer);
        }
        gridStateHandler.loadState();
        return verticalLtCenter;
    }


    private void init() {
        QueryCustomer request = new QueryCustomer();
        request.setCode("");
        GxtDemoService.App.getInstance().listCustomer(request, new QueryCustomerAsyncCallback());
    }

    private void createAlert() {
        AlertMessageBox messageBox = new AlertMessageBox("提示", "请选择需要进行操作的客户");
        messageBox.show();
    }

    private static class DeleteCustomerAsyncCallback implements AsyncCallback<String> {
        public DeleteCustomerAsyncCallback() { }

        @Override
        public void onFailure(Throwable caught) {
            Info.display("删除失败", caught.getMessage());
        }

        @Override
        public void onSuccess(String result) {
            Info.display("删除成功", result);
        }
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
