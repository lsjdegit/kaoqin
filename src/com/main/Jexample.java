package com.main;

import com.param.XlsParam;
import com.util.XlsUtil;
import java.awt.Container;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Jexample implements ActionListener {
    XlsParam xp = new XlsParam();
    JFrame frame = new JFrame(xp.getSheetName());// 框架布局
    JTabbedPane tabPane = new JTabbedPane();// 选项卡布局
    Container con = new Container();//

    JLabel label2 = new JLabel("选择文件");
    JTextField text1 = new JTextField();// TextField 目录的路径
    JTextField text2 = new JTextField();// 文件的路径
    JButton button2 = new JButton("...");// 选择
    JFileChooser jfc = new JFileChooser();// 文件选择器
    JButton button3 = new JButton("确定");//

    Jexample() {
        jfc.setCurrentDirectory(new File("D://考勤"));// 文件选择器的初始目录定为c盘

        double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();

        double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        frame.setLocation(new Point((int) (lx / 2) - 150, (int) (ly / 2) - 150));// 设定窗口出现位置
        frame.setSize(300, 200);// 设定窗口大小
        frame.setContentPane(tabPane);// 设置布局
        label2.setBounds(10, 35, 70, 20);
        text2.setBounds(75, 35, 120, 20);
        button2.setBounds(210, 35, 50, 20);
        button3.setBounds(100, 60, 60, 20);
        button2.addActionListener(this); // 添加事件处理
        button3.addActionListener(this); // 添加事件处理
        con.add(text1);
        con.add(label2);
        con.add(text2);
        con.add(button2);
        con.add(button3);
        frame.setVisible(true);// 窗口可见
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 使能关闭窗口，结束程序
        tabPane.add("xls表格选择", con);// 添加布局
    }
    /**
     * 时间监听的方法
     */
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        // 绑定到选择文件，先择文件事件
        if (e.getSource().equals(button2)) {
            jfc.setFileSelectionMode(0);// 设定只能选择到文件
            int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
            if (state == 1) {
                return;// 撤销则返回
            } else {
                File f = jfc.getSelectedFile();// f为选择到的文件
                text2.setText(f.getAbsolutePath());
            }
        }
        if (e.getSource().equals(button3)) {
            // 弹出对话框可以改变里面的参数具体得靠大家自己去看，时间很短
            System.out.println("所选文件路径"+text2.getText());
            String path=text2.getText();
            System.out.println(path);
            XlsUtil obj = new XlsUtil();
            // 此处为我创建Excel路径
            File file = new File(path);
            XlsUtil xlsUtil = new XlsUtil();
            String msg = xlsUtil.isXls(file);
            if(msg == "no"){
                JOptionPane.showMessageDialog(null, "文件不存在！", "提示", 2);
            }else if(msg == "use"){
                JOptionPane.showMessageDialog(null, "文件被占用！", "提示", 2);
            }else if(msg == "noxls"){
                JOptionPane.showMessageDialog(null, "请选择.xls文件！", "提示", 2);
            }else if(msg == "nokq"){
                JOptionPane.showMessageDialog(null, "文件缺少“"+xp.getSheetName()+"”页！", "提示", 2);
            }else{
                try {
                    obj.update(file);
                    JOptionPane.showMessageDialog(null, "修改成功！", "提示", 2);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "拒绝访问！", "提示", 2);
                }
            }
        }
    }
}
