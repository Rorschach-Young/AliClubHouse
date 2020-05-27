package com.gxtDemo.client.model;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface TypeProperties extends PropertyAccess<Type> {
    @Editor.Path("name")
    ModelKeyProvider<Type> key();
    @Editor.Path("name")
    LabelProvider<Type> nameLabel();
    ValueProvider<Type, String> name();
}
