package com.dhl.dhlxmlpidemo.service.impl;

import com.dhl.dhlxmlpidemo.entity.ExportDeclaration;
import com.dhl.dhlxmlpidemo.entity.ExportLineItem;
import com.dhl.dhlxmlpidemo.service.RequestService;
import com.dhl.dhlxmlpidemo.util.DHLHelper;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.dom.DOMDocument;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@Service
public class RequestServiceImpl implements RequestService {


    @Override
    public String getShippment() throws IOException {
        Document document = new DOMDocument();

        //创建根节点 req:ShipmentRequest
        Element root = document.addElement("req:ShipmentRequest");
        root.addAttribute("xsi:schemaLocation","http://www.dhl.com ship-val-global-req-6.2.xsd");
        root.addNamespace("req","http://www.dhl.com");
        root.addNamespace("xsi","http://www.w3.org/2001/XMLSchema-instance");
        root.addAttribute("schemaVersion","6.2");
        root.addElement("RegionCode").addText("AP");

             //Request
        Element request = root.addElement("Request");
            Element serviceHeader = request.addElement("ServiceHeader");
                Element messageTime = serviceHeader.addElement("MessageTime").addText(DHLHelper.getDhlDateTime());
                Element messageReference = serviceHeader.addElement("MessageReference").addText("ShippmentReferA00000001000000");
                Element siteID = serviceHeader.addElement("SiteID").addText("v62_qghRDEGIt6");
                Element password = serviceHeader.addElement("Password").addText("v62_qghRDEGIt6");
            Element metaData = request.addElement("MetaData");
                metaData.addElement("SoftwareName").addText("3PV");
                metaData.addElement("SoftwareVersion").addText("1.0");

        root.addElement("LanguageCode").addText("en");
        root.addElement("PiecesEnabled").addText("Y");

            //billing
        Element billing = root.addElement("Billing");
            billing.addElement("ShipperAccountNumber").addText("603468557");
            billing.addElement("ShippingPaymentType").addText("R");
            billing.addElement("BillingAccountNumber").addText("603468557");
            billing.addElement("DutyPaymentType").addText("S");

            //consignee
        Element consignee = root.addElement("Consignee");
            consignee.addElement("CompanyName").addText("BSH EV ALETLERI SAN.VE TIC.A.S");
            consignee.addElement("AddressLine").addText("SHUNDE");
            consignee.addElement("AddressLine").addText("1");
            consignee.addElement("AddressLine").addText("2");
            consignee.addElement("City").addText("Tampines");
            consignee.addElement("Division").addText("Singapore");
            consignee.addElement("DivisionCode").addText("AE2086");
            consignee.addElement("PostalCode").addText("520425");
            consignee.addElement("CountryCode").addText("SG");
            consignee.addElement("CountryName").addText("Singapore");
            Element contact = consignee.addElement("Contact");
                contact.addElement("PersonName").addText("ERIC");
                contact.addElement("PhoneNumber").addText("15388887777");

                //dutiable
        Element dutiable = root.addElement("Dutiable");
            dutiable.addElement("DeclaredValue").addText("1400.00");
            dutiable.addElement("DeclaredCurrency").addText("USD");

            //exportDeclaration
        Element exportDeclaration = root.addElement("ExportDeclaration");
            exportDeclaration.addElement("ExportReasonCode").addText("P");
            exportDeclaration.addElement("InvoiceNumber").addText("AN190228000001");
            exportDeclaration.addElement("InvoiceDate").addText("2019-02-28");
            Element exportLineItem = exportDeclaration.addElement("ExportLineItem");
       /* ExportDeclaration exportDeclaration1 = new ExportDeclaration();
        List<ExportLineItem> exportItemList = exportDeclaration1.getExportItemList();
        for (ExportLineItem lineItem: exportItemList) {
            exportLineItem.addElement("LineNumber").addText(lineItem.getLineNumber());
            exportLineItem.addElement("Quantity").addText(lineItem.getQuantity());
            exportLineItem.addElement("QuantityUnit").addText(lineItem.getQuantityUnit());
            exportLineItem.addElement("Description").addText(lineItem.getDescription());
            exportLineItem.addElement("Value").addText(lineItem.getValue());
            Element weight = exportLineItem.addElement("Weight");
                weight.addElement("Weight").addText(lineItem.getWeight());
                weight.addElement("WeightUnit").addText(lineItem.getWeightUnit());
            Element grossWeight = exportLineItem.addElement("GrossWeight");
                grossWeight.addElement("Weight").addText(lineItem.getWeight());
                grossWeight.addElement("WeightUnit").addText(lineItem.getWeightUnit());
        }*/

        //reference
        Element reference = root.addElement("Reference");
            reference.addElement("ReferenceID").addText("AN190228000001");

        Element shipmentDetails = root.addElement("ShipmentDetails");
            //shipmentDetails.addElement("NumberOfPieces").addText(Integer.toString(exportItemList.size()));
            shipmentDetails.addElement("Weight").addText("12.00");
            shipmentDetails.addElement("WeightUnit").addText("K");
            shipmentDetails.addElement("GlobalProductCode").addText("P");
            shipmentDetails.addElement("LocalProductCode").addText("P");
            shipmentDetails.addElement("Date").addText("2019-02-28");
            shipmentDetails.addElement("Contents").addText("air condition");
            shipmentDetails.addElement("DimensionUnit").addText("C");
            shipmentDetails.addElement("IsDutiable").addText("Y");
            shipmentDetails.addElement("CurrencyCode").addText("USD");


            //shipper
        Element shipper = root.addElement("Shipper");
            shipmentDetails.addElement("ShipperID").addText("603468557");
            shipmentDetails.addElement("CompanyName").addText("MIDEA");
            shipmentDetails.addElement("AddressLine1").addText("MIDEA,beijiao,shunde");
            shipmentDetails.addElement("AddressLine2").addText("");
            shipmentDetails.addElement("AddressLine3").addText("");
            shipmentDetails.addElement("City").addText("Foshan");
            shipmentDetails.addElement("PostalCode").addText("528311");
            shipmentDetails.addElement("CountryCode").addText("CN");
            shipmentDetails.addElement("CountryName").addText("China");
                Element contact1 = shipmentDetails.addElement("Contact");
                contact1.addElement("PersonName").addText("ERICC122");
                contact1.addElement("PhoneNumber").addText("0757-232323223");

                //notification
        Element notification = root.addElement("Notification");
            notification.addElement("EmailAddress").addText("zsw0072@163.com");

            root.addElement("LabelImageFormat").addText("PDF");



        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("C:\\Users\\admin\\Desktop\\request.xml"));
        xmlWriter.setEscapeText(false);
        xmlWriter.write(document);

        String s = document.asXML();
        return s;
    }
}
