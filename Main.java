import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class Main {
    public static void main(String []args) throws IOException {
        BufferedImage img = ImageIO.read(new File(("C:\\Users\\Sana\\IdeaProjects\\AIA5\\face.bmp")));
        int height = img.getHeight();
        int width = img.getWidth();
        int samples = height * width;

        int k = 255;
        int dim = 3;  //dimensions;
        int [][] majors = new int[k][dim];
        int [][] bookkeeping = new int [samples][k];

        Random rand = new Random();

        for (int i = 0;i < k;i++){    //initializing the majors array
            for (int j = 0;j < dim;j++) {
                majors[i][j] = rand.nextInt(256);
            }
        }
        for (int i = 0;i < samples;i++){    //initializing the bookkeeping array
            for (int j = 0;j < k;j++) {
                bookkeeping[i][j] = 0;
            }
        }

        boolean changed = true;
        while(changed) {
            int s = 0;
            int minindex = 0;
            double min;
            double dist = 0;
            Color c;
            int r, g, b;
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    min = 999999;
                    for (int i = 0; i < k; i++) {
                        c = new Color(img.getRGB(w, h));
                        r = c.getRed();
                        g = c.getGreen();
                        b = c.getBlue();
                        dist = sqrt(pow(r - majors[i][0], 2) + pow(g - majors[i][1], 2) + pow(b - majors[i][2], 2));
                        if (dist < min) {
                            min = dist;
                            minindex = i;
                        }
                    }
                    bookkeeping[s][minindex] = 1;
                    s++;
                }
            }

            int positives;
            int sumr, sumg, sumb;
            for (int i = 0;i < k;i++){
                positives = 0;
                s = 0;
                sumr = 0;
                sumg = 0;
                sumb = 0;
                for (int h = 0; h < height; h++) {
                    for (int w = 0; w < width; w++) {
                        c = new Color(img.getRGB(w, h));
                        r = c.getRed();
                        g = c.getGreen();
                        b = c.getBlue();
                        if (bookkeeping[s][i] == 1) {
                            sumr += r;
                            sumg += g;
                            sumb += b;
                            positives++;
                        }
                        s++;
                    }
                }
                if (positives == 0){
                    System.out.println("All zeros");
                }
                else{
                    sumr = sumr/positives;
                    sumg = sumg/positives;
                    sumb = sumb/positives;

                    if (majors[i][0] == sumr && majors[i][1] == sumg && majors[i][2] == sumb){
                        changed = false;
                    }
                    else{
                        majors[i][0] = sumr;
                        majors[i][1] = sumg;
                        majors[i][2] = sumb;
                    }
                }

            }
        }

        int s = 0;
        int r = 0, g = 0, b = 0, rgb;
        Color c;
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                for (int i = 0; i < k; i++){
                    if (bookkeeping[s][i] == 1){
                        r = majors[i][0];
                        g = majors[i][1];
                        b = majors[i][2];
                    }
                }
                c = new Color(r, g, b);
                rgb = c.getRGB();
                img.setRGB(w, h, rgb);
                s++;
            }
        }

        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(300,300);
        JLabel lbl=new JLabel();
        ImageIcon icon = new ImageIcon(img);
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
