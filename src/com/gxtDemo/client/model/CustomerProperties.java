package com.gxtDemo.client.model;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface CustomerProperties extends PropertyAccess<Customer> {
    @Editor.Path("id")
    ModelKeyProvider<Customer> key();
    ValueProvider<Customer, Integer> id();
    ValueProvider<Customer, String> code();
    ValueProvider<Customer, String> name();
    ValueProvider<Customer, String> mnemonicCode();
    ValueProvider<Customer, String> type();
    ValueProvider<Customer, String> phone();
    ValueProvider<Customer, String> fax();
    ValueProvider<Customer, String> email();
    ValueProvider<Customer, Boolean> mark();
}
