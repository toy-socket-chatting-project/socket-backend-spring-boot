package com.lk.socket.chatting.util;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ImageUtil {

    public static BufferedImage base64Img(String imgSrc) {
        byte[] bytes = imgSrc.substring(imgSrc.indexOf(",") + 1).getBytes(StandardCharsets.UTF_8);
        byte[] image = Base64.getDecoder().decode(bytes);
        try {
            return ImageIO.read(new ByteArrayInputStream(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage resize(BufferedImage buffer, int width, int height) {
        Image image = buffer.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        int[] pixels = new int[width+height];
        PixelGrabber pg = new PixelGrabber(image,0,0,width,height,pixels,0,width);
        try {
            pg.grabPixels();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        BufferedImage outPutImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        outPutImage.setRGB(0,0,width,height,pixels,0,width);
        return outPutImage;
    }

    public static String imgBase64(BufferedImage image, String type) {
        String imageString = "data:image/" + type + ";base64,";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, type, bos);
            imageString = Base64.getEncoder().encodeToString(bos.toByteArray());
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }
}
