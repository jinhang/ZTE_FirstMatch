package jins.start;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * ��¼
 * @author jinhang
 *
 */
public class DengLu extends JFrame {

	public JLabel name = new JLabel("�û���");
	public JLabel pass = new JLabel("�� ��");
	public JTextField userName = new JTextField();
	public JPasswordField passWord = new JPasswordField();
	public Button bok = new Button("��½");
	public Button bexit = new Button("ȡ��");
	public DengLu() {
		this.setContentPane(new MyPanel());
		setTitle("��ӭʹ���������ϵͳ");
		setLayout(null);
		setSize(500, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm = this.getSize();
		setLocation( (scr.width - frm.width) / 2,
				(scr.height - frm.height) / 2 - 18);
		name.setBounds(70, 260, 120, 20);
		userName.setBounds(120, 260, 120, 27);
		pass.setBounds(70, 300, 120, 20);
		passWord.setBounds(120, 300, 120, 27);
		passWord.setEchoChar('*');
		bok.setBounds(340, 260, 100, 28);
		bexit.setBounds(340, 300, 100, 28);
		add(name);
		add(userName);
		add(pass);
		add(passWord);
		add(bok);
		add(bexit);
		setVisible(true);
		bexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		bok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (userName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�û�������Ϊ��!");
				} else if (passWord.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "���벻��Ϊ��!");
				} else {
					if (userName.getText().equals("admin") &&
							passWord.getText().equals("admin")) {
						dispose();
						Activity activity = new Activity();
						activity.init();
						Frame frame = new Frame(activity);
						frame.show();
					} else {
						JOptionPane.showMessageDialog(null, "�������");
						userName.setText(null);
						passWord.setText(null);
					}
				}
			}
		});
	}
	private class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
			super.paintComponent(g);
			Image img = Toolkit.getDefaultToolkit().getImage("bg.jpg");
			g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
}