import org.jasypt.util.text.BasicTextEncryptor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBPasswordEncrypt extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    JLabel input = new JLabel(" 请输入密码前半段：");
    JLabel input2 = new JLabel(" 请输入密码后半段：");
    TextField password = new TextField(13);
    TextField password2 = new TextField(13);
    JButton submit = new JButton("提交");
    JButton reset = new JButton("重置");
    JLabel output = new JLabel("加密后的的密码是：");
    JTextField show = new JTextField(20);
    DBPasswordEncrypt() {
        super("0.0");
        this.setLayout(new FlowLayout());
        submit.addActionListener(this);
        reset.addActionListener(this);
        this.add(input);
        password.setEchoChar('*');
        password2.setEchoChar('*');
        this.add(password);
        this.add(input2);
        this.add(password2);
        this.add(output);
        this.add(show);
        this.add(submit);
        this.setSize(300, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new DBPasswordEncrypt();
    }
    public void actionPerformed(ActionEvent e) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
//        Properties properties = new Properties();
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/application-prd.properties"));
//            properties.load(bufferedReader);
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
        textEncryptor.setPassword("ccmuat");
        String str = password.getText();
        String str2 = password2.getText();
        String str3 = textEncryptor.encrypt(str+str2);
        JButton jb = (JButton) e.getSource();
        if (jb == submit) {
            show.setText(str3);
        }
        if (jb == reset) {
            password.setText(null);
            password2.setText(null);
            show.setText(null);
        }
    }
}
