import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.image.*;

public class YutNori extends DirecionAlgorithm implements ActionListener{
	public static final int WIDTH = 1100;
	public static final int HEIGHT = 630;
	private int turnchecker = 0; // 0이면 white차례, 1이면 black차례
	
	public JPanel TopPanel;
	public JPanel YutPanel;
	public JPanel PanPanel;
	public JPanel ImagePanel;
	public JLabel ImageLabel;
	public JPanel ButtonPanel;
	public JButton Throw;
	public JButton Exit;
	
	public String[] Y = {"", "도", "개", "걸", "윷", "모"};
	//말의 정보
	private int many = 0; //윷이나 모가 3번이상 나오면 차례를 넘김
	
	public YutNori() {
		super();
		setSize(WIDTH,HEIGHT);
		setTitle("YutNori");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(5, 5));
		
		TopPanel = new JPanel();
		TopPanel.setLayout(new GridLayout(2, 1));
		YutPanel = new JPanel();
		YutPanel.setLayout(new GridLayout(1, 4));
		white_num = new JLabel("White의 남은말 :  □ □ □ ");
		YutPanel.add(white_num);
		black_num = new JLabel("Black의 남은말 : ■ ■ ■ ");
		YutPanel.add(black_num);
		TopPanel.add(YutPanel);
		add(TopPanel, BorderLayout.NORTH);
		
		PanPanel = new JPanel();
		PanPanel.setBackground(Color.ORANGE);
		add(PanPanel, BorderLayout.CENTER);
		
		ImagePanel = new JPanel();
		ImagePanel.setLayout(new BorderLayout(10, 10));
		ImagePanel.setBackground(Color.WHITE);
		ImageLabel = new JLabel(new ImageIcon("도.png"));
		ImagePanel.add(ImageLabel, BorderLayout.CENTER);
		Yut = new JLabel("");
		Yut.setFont(font);
		ImagePanel.add(Yut, BorderLayout.SOUTH);
		WhosTurn = new JLabel("   white");// white와 black
		WhosTurn.setFont(font);
		ImagePanel.add(WhosTurn,BorderLayout.NORTH);
		add(ImagePanel, BorderLayout.EAST);
		
		ButtonPanel = new JPanel();
		Throw = new JButton("윷 던지기");
		Throw.addActionListener(this);
		ButtonPanel.add(Throw);
		Exit = new JButton("종료");
		Exit.addActionListener(this);
		ButtonPanel.add(Exit);
		add(ButtonPanel, BorderLayout.SOUTH);
	
	
	}
	
	public int WhatYut() {
		Random rand = new Random();
		int count = rand.nextInt(28);// 개 > 걸 > 도 > 윷 > 빽도 > 모 > 낙 순으로 우선순위
		int a;
		
		if (0<= count && count <=4) {
			Yut.setText("    도");
			ImageLabel.setIcon(new ImageIcon("도.png"));
			a = 1;// 도
		}
		else if (5 <= count && count <= 11) {
			Yut.setText("    개");
			ImageLabel.setIcon(new ImageIcon("개.png"));
			a = 2;// 개
		}
		else if (12 <= count && count <= 17) {
			Yut.setText("    걸");
			ImageLabel.setIcon(new ImageIcon("걸.png"));
			a = 3; //걸
		}
		else if (18 <= count && count <= 21) {
			Yut.setText("    윷");
			ImageLabel.setIcon(new ImageIcon("윷.png"));
			a = 4; //윷
		}
		else if (22 <= count && count <= 23) {
			Yut.setText("    모");
			ImageLabel.setIcon(new ImageIcon("모.png"));
			a = 5; //모
		}
		else if (24 <= count && count <= 26) {
			Yut.setText("   빽도");
			ImageLabel.setIcon(new ImageIcon("빽도.png"));
			a = -1; //빽도
		}
		else {
			Yut.setText("    낙");
			a = 0;
		}
		
		return a;
	}
	
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		int count = WhatYut();
		
		if(action.equals("윷 던지기")){
			if (count < 0) { //빽도 인경우
				if (turnchecker == 0) {
					if (white != 0) {
						BackDo(0);
						hold(0);
						if (CATCH == false) {
							WhosTurn.setText("   Black");
							turnchecker = 1;
						}
					}
					else if (white == 0){
						minEvent Popup = new minEvent("Start지점이라 빽도로 갈수 없습니다. 다음차례로 넘깁니다.");
						Popup.setLocationRelativeTo(null);
						Popup.setVisible(true);
						WhosTurn.setText("   Black");
						turnchecker = 1;
					}
				}
				else {
					if (black != 0) {
						BackDo(1);
						hold(1);
						if (CATCH == false) {
							WhosTurn.setText("   White");
							turnchecker = 0;
						}
					}
					else if (black == 0){
						minEvent Popup = new minEvent("Start지점이라 빽도로 갈수 없습니다. 다음차례로 넘깁니다.");
						Popup.setLocationRelativeTo(null);
						Popup.setVisible(true);
						WhosTurn.setText("   White");
						turnchecker = 0;
					}
				}
				CATCH = false;
			}
			else if (count == 0) { //낙인 경우
				minEvent Popup = new minEvent("낙입니다 차례를 넘기세요!");
				Popup.setLocationRelativeTo(null);
				Popup.setVisible(true);
				if (turnchecker == 0) {
					WhosTurn.setText("   Black");
					turnchecker = 1;
				}
				else {
					WhosTurn.setText("   White");
					turnchecker = 0;
				}
			}
			else if (count > 0) {
				if (turnchecker == 0) {
					direction(0, count);
					hold(0);
					if (count >= 4) {
						minEvent Popup = new minEvent(Y[count] + "가 나왔습니다. 한번 더 던지세요 !!");
						Popup.setLocationRelativeTo(null);
						Popup.setVisible(true);
						many++;
						if (many == 3) {
							minEvent Popup2 = new minEvent("너무 많이 던졌습니다. 차례를 양보하세요!");
							Popup2.setLocationRelativeTo(null);
							Popup2.setVisible(true);
							WhosTurn.setText("   Black");
							turnchecker = 1;
							many = 0;
							CATCH = false;
						}
					}
					if (CATCH == false && count < 4) {
						WhosTurn.setText("   Black");
						turnchecker = 1;
						many = 0;
					}
				}
				else {
					direction(1, count);
					hold(1);
					if (count >= 4) {
						minEvent Popup = new minEvent(Y[count] + "가 나왔습니다. 한번 더 던지세요 !!");
						Popup.setLocationRelativeTo(null);
						Popup.setVisible(true);
						many++;
						if (many == 3) {
							minEvent Popup2 = new minEvent("너무많이 던졌습니다. 차례를 양보하세요.");
							Popup2.setLocationRelativeTo(null);
							Popup2.setVisible(true);
							WhosTurn.setText("   White");
							turnchecker = 0;
							many = 0;
							CATCH = false;
						}
					}
					if (CATCH == false && count < 4) {
						WhosTurn.setText("   White");
						turnchecker = 0;
						many = 0;
					}
				}
			}
			CATCH = false;
			repaint();
		}
		else if (action.equals("종료")){
			System.exit(0);
		}
	}
	
	public void paint (Graphics g) {
		PanPaint(g);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("white.png"), white_x,white_y, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("black.png"), black_x, black_y, this);
	}
	
	public void PanPaint(Graphics g) {
		super.paint(g); //x += 130, y += 80
		g.drawOval(700, 485, 50 ,50); // 0
		g.drawOval(695, 480, 60 ,60); 
		g.drawOval(700, 405, 50 ,50); // 1
		g.drawOval(700, 325, 50 ,50); // 2
		g.drawOval(700, 245, 50 ,50); // 3
		g.drawOval(700, 165, 50 ,50); // 4
		g.drawOval(700, 85, 50 ,50); // 5
		g.drawOval(695, 80, 60 ,60); 
		g.drawOval(570, 85, 50 ,50); // 6
		g.drawOval(440, 85, 50 ,50); // 7
		g.drawOval(310, 85, 50 ,50); // 8
		g.drawOval(180, 85, 50 ,50); // 9
		g.drawOval(50, 85, 50 ,50); // 10
		g.drawOval(45, 80, 60 ,60);
		g.drawOval(50, 165, 50 ,50); // 11
		g.drawOval(50, 245, 50 ,50); // 12
		g.drawOval(50, 325, 50 ,50); // 13
		g.drawOval(50, 405, 50 ,50); // 14
		g.drawOval(50, 485, 50 ,50); // 15
		g.drawOval(45, 480, 60 ,60);
		g.drawOval(180, 485, 50 ,50); // 16
		g.drawOval(310, 485, 50 ,50); // 17
		g.drawOval(440, 485, 50 ,50); // 18
		g.drawOval(570, 485, 50 ,50); // 19
		g.drawOval(591, 153, 50 ,50); // 20
		g.drawOval(483, 219, 50 ,50); // 21
		g.drawOval(267, 351, 50 ,50); // 23
		g.drawOval(159, 417, 50 ,50); // 24
		g.drawOval(375, 285, 50 ,50); // 22(center) or 27
		g.drawOval(370, 280, 60 ,60); 
		g.drawOval(159, 153, 50 ,50); // 25
		g.drawOval(267, 219, 50 ,50); // 26
		g.drawOval(483, 351, 50 ,50); // 27
		g.drawOval(591, 417, 50 ,50); // 28
	}

}
