package com.gxtDemo.client.model;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface SettlementProperties extends PropertyAccess<Settlement>{
    @Editor.Path("name")
    ModelKeyProvider<Settlement> key();
    @Editor.Path("name")
    LabelProvider<Settlement> nameLabel();
    ValueProvider<Settlement, String> name();
}
