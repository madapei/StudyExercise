package com.mapei.javatest.test_annotation;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/8/1
 */
public class ButtonFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private JPanel panel;
    private JButton yelloButton;
    private JButton blueButton;
    private JButton redButton;

    public ButtonFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        panel = new JPanel();
        add(panel);

        yelloButton = new JButton("Yellow");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");

        panel.add(yelloButton);
        panel.add(blueButton);
        panel.add(redButton);

        ActionListenerInstaller.processAnnotaitons(this);
    }

    @ActionListenerFor(source = "yelloButton")
    public void yellowBackground(){
        panel.setBackground(Color.YELLOW);
    }

    @ActionListenerFor(source = "blueButton")
    public void blueBackground(){
        panel.setBackground(Color.BLUE);
    }

    @ActionListenerFor(source = "redButton")
    public void redBackground(){
        panel.setBackground(Color.RED);
    }

    public static void main(String[] args) {
        ButtonFrame f = new ButtonFrame();
        //加上这一句就可以显示一个仅有关闭，最小化，最大化的按钮的Frame了
        f.setVisible(true);
        //再加上这一句就可以显示一个在左上角，拥有指定大小的Frame了
        f.setSize(300,400);
        //再加上这一句就可以把Frame放在最中间了
        f.setLocationRelativeTo(null);
        //如果没有这一句，在点击关闭Frame的时候程序其实还是在执行状态中的，加上这一句才算是真正的把资源释放掉了
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
