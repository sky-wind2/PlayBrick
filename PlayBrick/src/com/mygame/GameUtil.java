package com.mygame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
 
public class GameUtil {
    // ��������ý�������˽�л���
    private GameUtil() {
    } 
     
    /**
     * ����ָ��·���ļ���ͼƬ����
     * @param path
     * @return
     */
    public static Image getImage(String path) {
        BufferedImage picture = null;
        try {
            URL url = GameUtil.class.getClassLoader().getResource(path);
            picture = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picture;
    }
}