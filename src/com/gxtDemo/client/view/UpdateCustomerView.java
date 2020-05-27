package com.gxtDemo.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gxtDemo.client.GxtDemo;
import com.gxtDemo.client.GxtDemoService;
import com.gxtDemo.client.dto.UpdateCustomer;
import com.gxtDemo.client.model.*;
import com.gxtDemo.client.model.data.TypeData;
import com.gxtDemo.client.model.data.SettlementData;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.*;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.*;
import com.sencha.gxt.widget.core.client.info.Info;

public class UpdateCustomerView {
    private VerticalLayoutContainer verticalLtWidget;
    static Integer id;
    static final TextField tdCode = new TextField(); // 客户代码
    static final TextField tdName = new TextField(); // 客户名称
    static final TextField tdMnemonicCode = new TextField(); // 助记码

    static TypeProperties typeProperties = GWT.create(TypeProperties.class);
    static ListStore<Type> listStoreType = new ListStore<>(typeProperties.key());
    static ComboBox<Type> cbbType = new ComboBox<>(listStoreType, typeProperties.nameLabel()); // 客户类型

    static final TextField tdPhone = new TextField(); // 电话
    static final TextField tdFax = new TextField(); // 传真
    static final TextField tdEmail = new TextField(); // 邮箱
    static final TextField tdAddress = new TextField(); // 联系地址
    static CheckBox chkMark = new CheckBox();
    static final TextField tdCompany = new TextField(); // 工作单位
    static final DateTimeWidget dtBirthday = new DateTimeWidget(); // 出生日期
    static final TextField tdPostCode = new TextField(); // 邮编
    static final TextField tdBankAccount = new TextField();// 银行账号
    static final TextField tdBank = new TextField(); // 银行

    static SettlementProperties settlementProperties = GWT.create(SettlementProperties.class);
    static ListStore<Settlement> listStoreSettlement = new ListStore<>(settlementProperties.key());
    static ComboBox<Settlement> cbbSettlement = new ComboBox<Settlement>(listStoreSettlement, settlementProperties.nameLabel());// 结算方式

    static final DateTimeWidget dtSettlementTime = new DateTimeWidget(); // 结算日期
    static final DateTimeWidget dtMonthlyTime = new DateTimeWidget(); // 月结日期
    static TextArea taRemark = new TextArea(); // 备注


    public VerticalLayoutContainer getVerticalLtWidget() {
        if (verticalLtWidget == null) {
            verticalLtWidget = new VerticalLayoutContainer();
            // 基础信息部分
            ContentPanel cpBasic = createBasicFields();
            // 详细信息部分
            ContentPanel cpDetail = createDetailFields();

            // 顶部按钮
            //保存按钮
            TextButton buttonSave = new TextButton("保存");
            buttonSave.setSize("100", "30");
            buttonSave.addSelectHandler(new SelectEvent.SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    UpdateCustomer request = validate();
                    if (request != null) {
                        GxtDemoService.App.getInstance().updateCustomer(request, new UpdateCustomerAsyncCallback());
                    }
                }
            });
            //返回按钮
            TextButton buttonBack = new TextButton("返回");
            buttonBack.setSize("100", "30");
            buttonBack.addSelectHandler(new SelectEvent.SelectHandler() {

                @Override
                public void onSelect(SelectEvent event) {
                    GxtDemo.back();
                }
            });

            // 按钮平行布局
            HBoxLayoutContainer hboxLtBtn = new HBoxLayoutContainer();
            hboxLtBtn.add(buttonSave, new BoxLayoutContainer.BoxLayoutData(new Margins(10, 0, 0, 0)));
            hboxLtBtn.add(buttonBack, new BoxLayoutContainer.BoxLayoutData(new Margins(10, 0, 0, 50)));


            verticalLtWidget.add(hboxLtBtn, new VerticalLayoutContainer.VerticalLayoutData(500, 50, new Margins(0, 0, 0, 20)));
            verticalLtWidget.add(cpBasic);
            verticalLtWidget.add(cpDetail);
        }
        return verticalLtWidget;
    }


    public static void setCustomer(Customer customer) {
        id = customer.getId();
        tdCode.setValue(customer.getCode());
        tdName.setValue(customer.getName());
        tdMnemonicCode.setValue(customer.getMnemonicCode());
        cbbType.setValue(new Type(customer.getType()));
        tdPhone.setValue(customer.getPhone());
        tdFax.setValue(customer.getFax());
        tdEmail.setValue(customer.getEmail());
        tdAddress.setValue(customer.getAddress());
        chkMark.setValue(customer.getMark());
        tdCompany.setValue(customer.getCompany());
        dtBirthday.getDateField().setValue(customer.getBirthday());
        tdPostCode.setValue(customer.getPostCode());
        tdBankAccount.setValue(customer.getBankAccount());
        tdBank.setValue(customer.getBank());
        cbbSettlement.setValue(new Settlement(customer.getSettlement()));
        dtSettlementTime.getDateField().setValue(customer.getSettlementTime());
        dtMonthlyTime.getDateField().setValue(customer.getMonthlyTime());
        taRemark.setValue(customer.getRemark());
    }


    private ContentPanel createBasicFields() {
        // 基本信息
        tdCode.setWidth(200);
        tdName.setWidth(200);
        tdMnemonicCode.setWidth(200);
        listStoreType.addAll(TypeData.getTypes());
        cbbType.setWidth(200);
        tdPhone.setWidth(200);
        tdFax.setWidth(200);
        tdEmail.setWidth(200);
        tdAddress.setWidth(200);
        chkMark.setBoxLabel("启用标记");
        chkMark.setPosition(0,5);

        ContentPanel cpBasic = new ContentPanel();
        cpBasic.setHeading("基本信息");
        cpBasic.setHeight(230);
        HorizontalLayoutContainer horizonalLt = new HorizontalLayoutContainer();
        // 左侧
        VerticalLayoutContainer verticalLtLeft = new VerticalLayoutContainer();
        // 右侧
        VerticalLayoutContainer verticalLtRight = new VerticalLayoutContainer();

        FieldLabel flbCode = new FieldLabel(tdCode, "客户代码");
        FieldLabel flbName = new FieldLabel(tdName, "客户名称");
        FieldLabel flbMnemonicCode = new FieldLabel(tdMnemonicCode, "助记码");
        FieldLabel flbType = new FieldLabel(cbbType, "客户类型");
        FieldLabel flbPhone = new FieldLabel(tdPhone, "电话");
        FieldLabel flbFax = new FieldLabel(tdFax, "传真");
        FieldLabel flbEmail = new FieldLabel(tdEmail, "邮箱");
        FieldLabel flbAddress = new FieldLabel(tdAddress, "联系地址");
        FieldLabel fldMark = new FieldLabel(chkMark, "启用标记");

        verticalLtLeft.add(flbCode);
        verticalLtLeft.add(flbMnemonicCode);
        verticalLtLeft.add(flbPhone);
        verticalLtLeft.add(flbEmail);
        verticalLtLeft.add(fldMark);
        verticalLtRight.add(flbName);
        verticalLtRight.add(flbType);
        verticalLtRight.add(flbFax);
        verticalLtRight.add(flbAddress);

        horizonalLt.add(verticalLtLeft, new HorizontalLayoutContainer.HorizontalLayoutData(-1, 1, new Margins(0, 0, 0, 20)));
        horizonalLt.add(verticalLtRight, new HorizontalLayoutContainer.HorizontalLayoutData(-1, 1, new Margins(0, 0, 0, 20)));
        cpBasic.add(horizonalLt, new MarginData(20, 0, 0, 20));

        return cpBasic;
    }

    private ContentPanel createDetailFields() {
        // 详细信息
        tdCompany.setWidth(200);
        tdPostCode.setWidth(200);
        tdBankAccount.setWidth(200);
        tdBank.setWidth(200);
        listStoreSettlement.addAll(SettlementData.getSettlementList());
        cbbSettlement.setWidth(200);
        taRemark.setSize("200", "120");

        ContentPanel cpDetail = new ContentPanel();
        cpDetail.setHeight(350);
        cpDetail.setHeading("详细信息");
        HorizontalLayoutContainer horizonalLt = new HorizontalLayoutContainer();
        // 左侧
        VerticalLayoutContainer verticalLtLeft = new VerticalLayoutContainer();
        // 右侧
        VerticalLayoutContainer verticalLtRight = new VerticalLayoutContainer();

        FieldLabel flbCompany = new FieldLabel(tdCompany, "工作单位");
        FieldLabel flbBirthday = new FieldLabel(dtBirthday, "出生日期");
        FieldLabel flbPostCode = new FieldLabel(tdPostCode, "邮编");
        FieldLabel flbBankAccount = new FieldLabel(tdBankAccount, "银行账号");
        FieldLabel flbBank = new FieldLabel(tdBank, "银行");
        FieldLabel flbSettlement = new FieldLabel(cbbSettlement, "结算方式");
        FieldLabel flbSettlementTime = new FieldLabel(dtSettlementTime, "结算日期");
        FieldLabel flbMonthlyTime = new FieldLabel(dtMonthlyTime, "月结日期");
        FieldLabel flbRemark = new FieldLabel(taRemark, "备注");

        verticalLtLeft.add(flbCompany);
        verticalLtLeft.add(flbPostCode);
        verticalLtLeft.add(flbBank);
        verticalLtLeft.add(flbSettlementTime);
        verticalLtLeft.add(flbRemark);
        verticalLtRight.add(flbBirthday);
        verticalLtRight.add(flbBankAccount);
        verticalLtRight.add(flbSettlement);
        verticalLtRight.add(flbMonthlyTime);

        horizonalLt.add(verticalLtLeft, new HorizontalLayoutContainer.HorizontalLayoutData(-1, 1, new Margins(0, 0, 0, 20)));
        horizonalLt.add(verticalLtRight, new HorizontalLayoutContainer.HorizontalLayoutData(-1, 1, new Margins(0, 0, 0, 20)));
        cpDetail.add(horizonalLt, new MarginData(20, 0, 0, 20));

        return cpDetail;
    }

    private UpdateCustomer validate() {
        UpdateCustomer request = new UpdateCustomer();

        if (tdCode.getValue() == null || tdCode.getValue().isEmpty()) {
            Info.display("提示", "请填写客户代码");
            return null;
        } else {
            request.setCode(tdCode.getValue());
        }
        if (tdName.getValue() == null || tdName.getValue().isEmpty()) {
            Info.display("提示", "请填写客户名称");
            return null;
        } else {
            request.setName(tdName.getValue());
        }
        if (tdMnemonicCode.getValue() == null || tdMnemonicCode.getValue().isEmpty()) {
            Info.display("提示", "请填写助记码");
            return null;
        } else {
            request.setMnemonicCode(tdMnemonicCode.getValue());
        }
        if (cbbType.getValue() == null || cbbType.getValue().getName() == null || cbbType.getValue().getName().isEmpty()) {
            Info.display("提示", "请选择客户类型");
            return null;
        } else {
            request.setType(cbbType.getValue().getName());
        }
        if (tdPhone.getValue() == null || tdPhone.getValue().isEmpty()) {
            Info.display("提示", "请填写电话");
            return null;
        } else {
            request.setPhone(tdPhone.getValue());
        }
        if (tdAddress.getValue() == null || tdAddress.getValue().isEmpty()) {
            Info.display("提示", "请填写联系地址");
            return null;
        } else {
            request.setAddress(tdAddress.getValue());
        }
        if (tdCompany.getValue() == null || tdCompany.getValue().isEmpty()) {
            Info.display("提示", "请填写工作单位");
            return null;
        } else {
            request.setCompany(tdCompany.getValue());
        }
        if (tdBankAccount.getValue() == null || tdBankAccount.getValue().isEmpty()) {
            Info.display("提示", "请填写银行账号");
            return null;
        } else {
            request.setBankAccount(tdBankAccount.getValue());
        }
        if (tdBank.getValue() == null || tdBank.getValue().isEmpty()) {
            Info.display("提示", "请填写银行");
            return null;
        } else {
            request.setBank(tdBank.getValue());
        }
        if (cbbSettlement.getValue() == null || cbbSettlement.getValue().getName() == null || cbbSettlement.getValue().getName().isEmpty()) {
            Info.display("提示", "请选择结算方式");
            return null;
        } else {
            request.setSettlement(cbbSettlement.getValue().getName());
        }

        request.setId(id);
        request.setCode(tdCode.getValue());
        request.setName(tdName.getValue());
        request.setMnemonicCode(tdMnemonicCode.getValue());
        request.setType(cbbType.getValue().getName());
        request.setPhone(tdPhone.getValue());
        request.setFax(tdFax.getValue());
        request.setEmail(tdEmail.getValue());
        request.setAddress(tdAddress.getValue());
        request.setMark(chkMark.getValue());
        request.setCompany(tdCompany.getValue());
        request.setBirthday(dtBirthday.getDateField().getValue());
        request.setPostCode(tdPostCode.getValue());
        request.setBankAccount(tdBankAccount.getValue());
        request.setBank(tdBank.getValue());
        request.setSettlement(cbbSettlement.getValue().getName());
        request.setSettlementTime(dtSettlementTime.getDateField().getValue());
        request.setMonthlyTime(dtMonthlyTime.getDateField().getValue());
        request.setRemark(taRemark.getValue());

        return request;
    }

    public static class DateTimeWidget extends Composite {
        private DateField dateField;

        public DateTimeWidget() {
            dateField = new DateField();
            dateField.setWidth(200);

            HBoxLayoutContainer hlc = new HBoxLayoutContainer(HBoxLayoutContainer.HBoxLayoutAlign.MIDDLE);
            hlc.add(dateField, new BoxLayoutContainer.BoxLayoutData(new Margins(0, 0, 0, 0)));
            initWidget(hlc);
        }

        public DateField getDateField() {
            return dateField;
        }

        public void setDateField(DateField dateField) {
            this.dateField = dateField;
        }
    }


    private class UpdateCustomerAsyncCallback implements AsyncCallback<String> {
        @Override
        public void onFailure(Throwable caught) {
            Info.display("修改失败", caught.getMessage());
        }

        @Override
        public void onSuccess(String result) {
            Info.display("修改成功", result);
            GxtDemo.back();
        }
    }

}
