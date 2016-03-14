package jins.start;  
import jins.start.Activity;  
import jins.start.Person;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.text.NumberFormat;  
import javax.swing.*;  
import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;  
import java.sql.*;  
public class Frame{  
	private JFrame frame;  
	private JTextArea infoArea;  
	private Activity activity;  
	public Frame(Activity activity)  
	{  
		this.activity = activity;  
	}  
	public void show()  
	{  
		frame = new JFrame();  
		frame.setTitle("���ֻ����");  
		frame.setDefaultCloseOperation(3);  
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;  
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;  
		frame.setLocation(width / 2 - 200, height / 2 - 150);  
		init();  
		frame.pack();  
		frame.setVisible(true);  
		frame.setResizable(false);  
		frame.setSize(800, 400);  
	}  
	private void init()  
	{  
		InputVerifier verifier = new InputVerifier() {  
			final Frame this$0;  
			public boolean verify(JComponent input)  
			{  
				JFormattedTextField field = (JFormattedTextField)input;  
				if (field.isEditValid())  
				{  
					if (field.getText() == null || field.getText().trim().equals(""))  
					{  
						infoArea.append((new StringBuilder(String.valueOf(field.getName()))).append("�������,������1~98���� \n").toString());  
						return false;  
					}  
					int value = Integer.parseInt(field.getText());  
					if (value >= 1 && value <= 98)  
					{  
						return true;  
					} else  
					{  
						infoArea.append((new StringBuilder(String.valueOf(field.getName()))).append("�������,������1~98���� \n").toString());  
						return false;  
					}  
				} else  
				{  
					infoArea.append((new StringBuilder(String.valueOf(field.getName()))).append("�������,������1~98���� \n").toString());  
					return false;  
				}  
			}  

			{  
				this$0 = Frame.this;  
				//super();  
			}  
		};  
		JPanel mainPanel = new JPanel();  
		mainPanel.setLayout(new BorderLayout());  
		JTabbedPane westPanel = new JTabbedPane();  
		JPanel manulPanel = new JPanel();  
		Box mainBox = Box.createVerticalBox();  
		Box genderBox = Box.createHorizontalBox();  
		JLabel genderLabel = new JLabel("�Ա�");  
		ButtonGroup group = new ButtonGroup();  
		final JRadioButton maleButton = new JRadioButton("��", true);  
		group.add(maleButton);  
		JRadioButton femaleButton = new JRadioButton("Ů", false);  
		group.add(femaleButton);  
		genderBox.add(genderLabel);  
		genderBox.add(Box.createHorizontalStrut(10));  
		genderBox.add(maleButton);  
		genderBox.add(Box.createHorizontalStrut(10));  
		genderBox.add(femaleButton);  
		Box attributeBox = Box.createHorizontalBox();  
		Box personalBox = Box.createVerticalBox();  
		JLabel personalLabel = new JLabel("��������");  
		Box fortuneBox = Box.createHorizontalBox();  
		JLabel fortuneLabel = new JLabel("�Ƹ���");  
		final JFormattedTextField fortuneField = new JFormattedTextField(NumberFormat.getInstance());  
		fortuneField.setName("�������ԣ��Ƹ���");  
		fortuneField.setSize(100, 100);  
		fortuneField.setInputVerifier(verifier);  
		fortuneBox.add(fortuneLabel);  
		fortuneBox.add(Box.createHorizontalStrut(10));  
		fortuneBox.add(fortuneField);  
		Box appearanceBox = Box.createHorizontalBox();  
		JLabel appearanceLabel = new JLabel("��ò��");  
		final JFormattedTextField appearanceField = new JFormattedTextField(NumberFormat.getInstance());  
		appearanceField.setName("�������ԣ���ò��");  
		appearanceField.setInputVerifier(verifier);  
		appearanceBox.add(appearanceLabel);  
		appearanceBox.add(Box.createHorizontalStrut(10));  
		appearanceBox.add(appearanceField);  
		Box charactoreBox = Box.createHorizontalBox();  
		JLabel charactorLabel = new JLabel("Ʒ��");  
		final JFormattedTextField charactorField = new JFormattedTextField(NumberFormat.getInstance());  
		charactorField.setName("�������ԣ�Ʒ��");  
		charactorField.setInputVerifier(verifier);  
		charactoreBox.add(charactorLabel);  
		charactoreBox.add(Box.createHorizontalStrut(10));  
		charactoreBox.add(charactorField);  
		personalBox.add(personalLabel);  
		personalBox.add(Box.createVerticalStrut(20));  
		personalBox.add(fortuneBox);  
		personalBox.add(Box.createVerticalStrut(20));  
		personalBox.add(appearanceBox);  
		personalBox.add(Box.createVerticalStrut(20));  
		personalBox.add(charactoreBox);  
		Box requireBox = Box.createVerticalBox();  
		JLabel requireLabel = new JLabel("��������");  
		Box requireFortuneBox = Box.createHorizontalBox();  
		JLabel requireFortuneLabel = new JLabel("�Ƹ���");  
		final JFormattedTextField requireFortuneField = new JFormattedTextField(NumberFormat.getInstance());  
		requireFortuneField.setName("�������ԣ��Ƹ���");  
		requireFortuneField.setInputVerifier(verifier);  
		requireFortuneBox.add(requireFortuneLabel);  
		requireFortuneBox.add(Box.createHorizontalStrut(10));  
		requireFortuneBox.add(requireFortuneField);  
		Box requireAppearanceBox = Box.createHorizontalBox();  
		JLabel requireAppearanceLabel = new JLabel("��ò��");  
		final JFormattedTextField requireAppearanceField = new JFormattedTextField(NumberFormat.getInstance());  
		requireAppearanceField.setName("�������ԣ���ò��");  
		requireAppearanceField.setInputVerifier(verifier);  
		requireAppearanceBox.add(requireAppearanceLabel);  
		requireAppearanceBox.add(Box.createHorizontalStrut(10));  
		requireAppearanceBox.add(requireAppearanceField);  
		Box requireCharactoreBox = Box.createHorizontalBox();  
		JLabel requireCharactorLabel = new JLabel("Ʒ��");  
		final JFormattedTextField requireCharactorField = new JFormattedTextField(NumberFormat.getInstance());  
		requireCharactorField.setName("�������ԣ�Ʒ��");  
		requireCharactorField.setInputVerifier(verifier);  
		requireCharactoreBox.add(requireCharactorLabel);  
		requireCharactoreBox.add(Box.createHorizontalStrut(10));  
		requireCharactoreBox.add(requireCharactorField);  
		requireBox.add(requireLabel);  
		requireBox.add(Box.createVerticalStrut(20));  
		requireBox.add(requireFortuneBox);  
		requireBox.add(Box.createVerticalStrut(20));  
		requireBox.add(requireAppearanceBox);  
		requireBox.add(Box.createVerticalStrut(20));  
		requireBox.add(requireCharactoreBox);  
		attributeBox.add(personalBox);  
		attributeBox.add(Box.createHorizontalStrut(40));  
		attributeBox.add(requireBox);  
		Box buttonBox = Box.createHorizontalBox();  
		JButton confirm = new JButton("ȷ��");  
		confirm.addActionListener(new ActionListener() {  

			@Override  
			public void actionPerformed(ActionEvent e) {  
				// TODO Auto-generated method stub  
				if (!fortuneField.isEditValid() || fortuneField.getText().equals(""))  
				{  
					infoArea.append((new StringBuilder(String.valueOf(fortuneField.getName()))).append("�������,������1~98���� \n").toString());  
					return;  
				}  
				if (!appearanceField.isEditValid() || appearanceField.getText().equals(""))  
				{  
					infoArea.append((new StringBuilder(String.valueOf(appearanceField.getName()))).append("�������,������1~98���� \n").toString());  
					return;  
				}  
				if (!charactorField.isEditValid() || charactorField.getText().equals(""))  
				{  
					infoArea.append((new StringBuilder(String.valueOf(charactorField.getName()))).append("�������,������1~98���� \n").toString());  
					return;  
				}  
				int requireFortune = -200;  
				int requireAppearance = -200;  
				int requireCharactor = -200;  
				if (!requireFortuneField.isEditValid() || requireFortuneField.getText().equals(""))  
				{  
					infoArea.append((new StringBuilder(String.valueOf(requireFortuneField.getName()))).append("�������,������1~98���� \n").toString());  
					return;  
				}  
				requireFortune = Integer.parseInt(requireFortuneField.getText());  
				if (!requireAppearanceField.isEditValid() || requireAppearanceField.getText().equals(""))  
				{  
					infoArea.append((new StringBuilder(String.valueOf(requireAppearanceField.getName()))).append("�������,������1~98���� \n").toString());  
					return;  
				}  
				requireAppearance = Integer.parseInt(requireAppearanceField.getText());  
				if (!requireCharactorField.isEditValid() || requireCharactorField.getText().equals(""))  
				{  
					infoArea.append((new StringBuilder(String.valueOf(requireCharactorField.getName()))).append("�������,������1~98���� \n").toString());  
					return;  
				}  
				requireCharactor = Integer.parseInt(requireCharactorField.getText());  
				if (requireFortune + requireAppearance + requireCharactor != 100)  
				{  
					infoArea.append("��������֮�ͣ��Ƹ�+��ò+Ʒ�񣩱���Ϊ100 \n");  
				} else  
				{  
					int gender = maleButton.isSelected() ? 1 : 0;  
					infoArea.append("�����������... \n");  
					infoArea.append(activity.generate(gender));  
					infoArea.append("����������� \n");  
					infoArea.append("ƥ����: \n");  
					infoArea.append(activity.join(new Person(-1, gender, Integer.parseInt(fortuneField.getText()), Integer.parseInt(appearanceField.getText()), Integer.parseInt(charactorField.getText()), requireFortune, requireAppearance, requireCharactor)));  
					infoArea.append(" \n");  
				}  
			}  
		});  
		JButton clear1 = new JButton("�����Ϣ");  
		clear1.addActionListener(new ActionListener() {  


			final Frame this$0;  


			public void actionPerformed(ActionEvent arg0)  
			{  
				infoArea.setText("");  
			}  



			{  
				this$0 = Frame.this;  
				//super();  
			}  
		});  
		buttonBox.add(confirm);  
		buttonBox.add(Box.createHorizontalStrut(40));  
		buttonBox.add(clear1);  
		mainBox.add(genderBox);  
		mainBox.add(Box.createVerticalStrut(20));  
		mainBox.add(attributeBox);  
		mainBox.add(Box.createVerticalStrut(20));  
		mainBox.add(buttonBox);  
		manulPanel.add(mainBox);  
		JScrollPane manulPane = new JScrollPane(mainBox);  
		westPanel.add("�ֶ�������ʾ", manulPane);  
		JPanel autoPanel = new JPanel();  
		autoPanel.setLayout(new FlowLayout());  
		JButton start = new JButton("��ʼ");  
		start.addActionListener(new ActionListener() {  


			final Frame this$0;  


			public void actionPerformed(ActionEvent arg0)  
			{  
				infoArea.append("100λ����ƥ�������£� \n");  
				infoArea.append(activity.play());  
			}  



			{  
				this$0 = Frame.this;  
				//super();  
			}  
		});  
		autoPanel.add(start);  
		JButton clear2 = new JButton("�����Ϣ");  
		clear2.addActionListener(new ActionListener() {  


			final Frame this$0;  


			public void actionPerformed(ActionEvent arg0)  
			{  
				infoArea.setText("");  
			}  



			{  
				this$0 = Frame.this;  
				//super();  
			}  
		});  
		autoPanel.add(clear2);  
		westPanel.add("����������ʾ", autoPanel);  
		infoArea = new JTextArea(20, 35);  
		infoArea.setLineWrap(true);  
		infoArea.setEditable(false);  
		JScrollPane eastPanel = new JScrollPane(infoArea);  
		mainPanel.add(westPanel, "West");  
		mainPanel.add(eastPanel, "East");  
		frame.add(mainPanel);  
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