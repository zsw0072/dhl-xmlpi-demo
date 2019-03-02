package com.dhl.dhlxmlpidemo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExportLineItem {

    String LineNumber;
    String Quantity;
    String QuantityUnit;
    String Description;
    String Value;
    String Weight;
    String WeightUnit;

}
