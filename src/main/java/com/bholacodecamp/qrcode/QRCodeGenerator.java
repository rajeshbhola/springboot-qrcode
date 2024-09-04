package com.bholacodecamp.qrcode;

import com.bholacodecamp.entity.User;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

    public static void generateQRCode(User user) throws WriterException, IOException {
        String qrCodePath = System.getProperty("user.dir") + "/src/main/resources/qrcodes/";
        File directory = new File(qrCodePath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String qrCodeName = qrCodePath + user.getFirstName() + user.getId() + "-QRCode.png";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "ID: " + user.getId() + "\n" +
                        "First Name: " + user.getFirstName() + "\n" +
                        "Last Name: " + user.getLastName() + "\n" +
                        "Email Id: " + user.getEmail() + "\n" +
                        "Mobile No: " + user.getMobile(), BarcodeFormat.QR_CODE, 400, 400);

        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
