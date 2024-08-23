package org.example.bikerental.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class ImageToBase64Bike {

    /**
     * Converts an image file to a Base64 encoded string.
     *
     * @param fileName The name of the image file.
     * @return The Base64 encoded string of the image.
     */
    public String getImageBase64(String fileName) {
        // Update the path to the directory where bike images are stored
        String filePath = System.getProperty("user.dir") + "/Bikefile/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }
}
