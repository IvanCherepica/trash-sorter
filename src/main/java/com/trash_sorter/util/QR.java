package com.trash_sorter.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Класс для генерации qr кода бака
 */
class QR {

    private String urlTankId;
    private int sizeQr;

    public QR() {
    }

    QR(String urlTankId, int sizeQr) {
        this.urlTankId = urlTankId;
        this.sizeQr = sizeQr;
    }

    /**
     * Генерим URL статической карты с точками
     * @return qrUrl for users
     */
    public String generateQrCode() {
        QR qr = new QR();
        StringBuilder qrBuilder = new StringBuilder();
        String urlTankIdRequest = urlTankId;
        int sizeQrRequest = sizeQr;

        StringBuilder url = new StringBuilder();
        Properties properties = new Properties();
        try(InputStream is = qr.getClass().getClassLoader().getResourceAsStream("qrPROP.properties")){
            properties.load(is);
            url.append(properties.getProperty("linkRequest"));
            url.append(urlTankId);
            url.append(properties.getProperty("preSizeRequest_1"));
            url.append(sizeQrRequest);
            url.append(properties.getProperty("preSizeRequest_2"));
            url.append(sizeQrRequest);
            url.append(properties.getProperty("endRequest"));
            System.out.println(url);
        }catch (IOException e){
            e.printStackTrace();
        }
        return url.toString();
    }
}



























