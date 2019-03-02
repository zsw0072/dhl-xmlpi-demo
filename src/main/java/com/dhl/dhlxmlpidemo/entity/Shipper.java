package com.dhl.dhlxmlpidemo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shipper {

    String ShipperAccountNumber = "";
    String ShippingPaymentType;
    String BillingAccountNumber = "";
    String DutyPaymentType;

    String shipperID;
    String CompanyName;
    String AddressLine1;
    String AddressLine2;
    String AddressLine3;
    String City;
    String PostalCode;
    String CountryCode;
    String CountryName;
    String PersonName;
    String PhoneNumber;

}
