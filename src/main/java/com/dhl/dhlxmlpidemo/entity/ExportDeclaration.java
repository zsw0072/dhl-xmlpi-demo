package com.dhl.dhlxmlpidemo.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class ExportDeclaration {

    String DeclaredValue;
    String DeclaredCurrency;

    String ExportReasonCode;
    String InvoiceNumber;
    String InvoiceDate;
    List<ExportLineItem> exportItemList = new LinkedList<ExportLineItem>();
    String Reference;

}
