package com.dhl.dhlxmlpidemo.service;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface RequestService {
    String getShippment() throws IOException;
}
