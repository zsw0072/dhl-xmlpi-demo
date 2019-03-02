package com.dhl.dhlxmlpidemo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ShipmentDetails {

    String numberOfPieces;
    String weight;
    String weightUnit;
    Character globalProductCode;
    Character localProductCode;
    Date date;
    String contents;
    Character dimensionUnit;
    Character IsDutiable;
    String CurrencyCode;

}
