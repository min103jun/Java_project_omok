import javax.swing.*;
import java.awt.*;

public class DirecionAlgorithm extends JFrame{
	
	public JLabel WhosTurn; // 누구 차례인지 표시
	public JLabel Yut; //던져서 무슨 윷이 나왔는지 표시
	public JLabel white_num;
	public JLabel black_num;
	public Font font = new Font("돋움", Font.PLAIN, 50);

	public int white = 0;
	public int white_count = 0;
	public int white_x = 709;
	public int white_y = 494;
	public int black = 0;
	public int black_count = 0;
	public int black_x = 709;
	public int black_y = 494;
	
	public boolean CATCH = false;
	
	public void direction(int who, int num) { 
		//윷놀이 방향 알고리즘
		int i;

		if (who == 0) { //white의 차례
			for (i = 0; i < num; i++) {
				if (white == 5 && i == 0) {
					white = 20;
					white_x -= 109;
					white_y += 68;
				}
				else if(white == 10 && i == 0) {
					white = 25;
					white_x += 109;
					white_y += 68;
				}
				else if (white == 22 && i == 0) {
					white = 28;
					white_x += 108;
					white_y += 66;
				}
				else if (0 <= white && white < 5){
					white++;
					white_y -= 80;
				}
				else if (5 <= white && white < 10) {
					white++;
					white_x -= 130;
				}
				else if (10 <= white && white < 15) {
					white++;
					white_y += 80;
				}
				else if (15 <= white && white < 19) {
					white++;
					white_x += 130;
				}
				else if (20 <= white && white <= 24) {
					if (white == 24) {
						white = 15;
						white_x -= 109;
						white_y += 68;
					}
					else {
						white++;
						white_x -= 108;
						white_y += 66;
					}
				}
				else if(25 <= white && white < 29) {
					white++;
					white_x += 108;
					white_y += 66;
				}
				else if (white == 19 || white == 29) {
					white_count++;
					minEvent Popup = new minEvent("white 말 한개가 들어왔습니다.");
					Popup.setLocationRelativeTo(null);
					Popup.setVisible(true);
					if (white_count == 1) {
						white_num.setText("white의 남은말 :  □ □ ");
						white = 0;
						white_x = 709;
						white_y = 494;
						break;
					}
					else if (white_count == 2) {
						white_num.setText("white의 남은말 :  □ ");
						white = 0;
						white_x = 709;
						white_y = 494;
						break;
					}
					else if (white_count == 3) {
						white_num.setText("white의 남은말 : ");
						white = 0;
						white_x = 709;
						white_y = 494;
						break;
					}
					else {
						WinnerEvent Win = new WinnerEvent(0);
						Win.setLocationRelativeTo(null);
						Win.setVisible(true);
						initialize();//종료를 누르지않으면 반드시 이쪽으로 넘어옴
						return;
					}
				}
				repaint();
			}
		}
		else { //black의 차례
			for (i = 0; i < num; i++) {
				if (black == 5 && i == 0) {
					black = 20;
					black_x -= 109;
					black_y += 68;
				}
				else if(black == 10 && i == 0) {
					black = 25;
					black_x += 109;
					black_y += 68;
				}
				else if (black == 22 && i == 0) {
					black = 28;
					black_x += 108;
					black_y += 66;
				}
				else if (0 <= black && black < 5){
					black++;
					black_y -= 80;
				}
				else if (5 <= black && black < 10) {
					black++;
					black_x -= 130;
				}
				else if (10 <= black && black < 15) {
					black++;
					black_y += 80;
				}
				else if (15 <= black && black < 19) {
					black++;
					black_x += 130;
				}
				else if (20 <= black && black <= 24) {
					if (black == 24) {
						black = 15;
						black_x -= 109;
						black_y += 68;
					}
					else {
						black++;
						black_x -= 108;
						black_y += 66;
					}
				}
				else if(25 <= black && black < 29) {
					black++;
					black_x += 108;
					black_y += 66;
				}
				else if (black == 19 || black == 29) {
					black_count++;
					minEvent Popup = new minEvent("Black 말 한개가 들어왔습니다.");
					Popup.setLocationRelativeTo(null);
					Popup.setVisible(true);
					if (black_count == 1) {
						black_num.setText("black의 남은말 :  ■ ■ ");
						black = 0;
						black_x = 709;
						black_y = 494;
						break;
					}
					else if (black_count == 2) {
						black_num.setText("black의 남은말 :  ■ ");
						black = 0;
						black_x = 709;
						black_y = 494;
						break;
					}
					else if (black_count == 3) {
						black_num.setText("black의 남은말 : ");
						black = 0;
						black_x = 709;
						black_y = 494;
						break;
					}
					else {
						WinnerEvent Win = new WinnerEvent(1);
						Win.setLocationRelativeTo(null);
						Win.setVisible(true);
						initialize();//종료를 누르지않으면 반드시 이쪽으로 넘어옴
						return;
					}
				}
			}
		}
	}

	public void BackDo(int who) {

		if (who == 0) {
			if (white == 1) {
				white--;
				minEvent Popup = new minEvent("white 말 한개가 들어왔습니다.");
				Popup.setLocationRelativeTo(null);
				Popup.setVisible(true);
				white_count++;
				if (white_count == 1) {
					white_num.setText("white의 남은말 :  □ □ ");
					white = 0;
					white_x = 709;
					white_y = 494;
				}
				else if (white_count == 2) {
					white_num.setText("white의 남은말 :  □ ");
					white = 0;
					white_x = 709;
					white_y = 494;
				}
				else if (white_count == 3) {
					white_num.setText("white의 남은말 : ");
					white = 0;
					white_x = 709;
					white_y = 494;
				}
				else {
					WinnerEvent Win = new WinnerEvent(0);
					Win.setLocationRelativeTo(null);
					Win.setVisible(true);
					initialize();//종료를 누르지않으면 반드시 이쪽으로 넘어옴
					return;
				}
			}
			else if (1 < white && white <= 5) {
				white--;
				white_y += 80;
			}
			else if (6 <= white && white <= 10) {
				white--;
				white_x += 130;
			}
			else if (11<= white && white <= 15) {
				white--;
				white_y -= 80;
			}
			else if (16 <= white && white <= 19) {
				white--;
				white_x -= 130;
			}
			else if (20 <= white && white <= 24) {
				if (white == 20) {
					white = 15;
					white_x += 109;
					white_y -= 68;
				}
				else {
					white--;
					white_x += 108;
					white_y -= 66;
				}
			}
			else if (25 <= white && white <= 29) {
				if (white == 25) {
					white = 10;
					white_x -= 109;
					white_y -= 68;
				}
				else {
					white--;
					white_x -= 108;
					white_y -= 66;
				}
			}
		}
		else {
			if (black == 1) {
				black--;
				minEvent Popup = new minEvent("Black 말 한개가 들어왔습니다.");
				Popup.setLocationRelativeTo(null);
				Popup.setVisible(true);
				black_count++;
				if (black_count == 1) {
					black_num.setText("black의 남은말 :  ■ ■ ");
					black = 0;
					black_x = 709;
					black_y = 494;
				}
				else if (black_count == 2) {
					black_num.setText("black의 남은말 :  ■ ");
					black = 0;
					black_x = 709;
					black_y = 494;
				}
				else if (black_count == 3) {
					black_num.setText("black의 남은말 : ");
					black = 0;
					black_x = 709;
					black_y = 494;
				}
				else {
					WinnerEvent Win = new WinnerEvent(1);
					Win.setLocationRelativeTo(null);
					Win.setVisible(true);
					initialize();//종료를 누르지않으면 반드시 이쪽으로 넘어옴
				}
			}
			else if (1 < black && black <= 5) {
				black--;
				black_y += 80;
			}
			else if (6 <= black && black <= 10) {
				black--;
				black_x += 130;
			}
			else if (11<= black && black <= 15) {
				black--;
				black_y -= 80;
			}
			else if (16 <= black && black <= 19) {
				black--;
				black_x -= 130;
			}
			else if (20 <= black && black <= 24) {
				if (black == 20) {
					black = 15;
					black_x += 109;
					black_y -= 68;
				}
				else {
					black--;
					black_x += 108;
					black_y -= 66;
				}
			}
			else if (25 <= black && black <= 29) {
				if (black == 25) {
					black = 10;
					black_x -= 109;
					black_y -= 68;
				}
				else {
					black--;
					black_x -= 108;
					black_y -= 66;
				}
			}
		}
	}

	public void hold (int who) {
		
		if (white_x == black_x && white_y == black_y) {
			if (who == 0) {
				minEvent Popup = new minEvent("White가 Black을 잡았습니다. 한번 더 던지세요!");
				Popup.setLocationRelativeTo(null);
				Popup.setVisible(true);
				black = 0;
				black_x = 709;
				black_y = 494;
				CATCH = true;
			}
			else {
				minEvent Popup = new minEvent("Black이 White를 잡았습니다. 한번 더 던지세요!");
				Popup.setLocationRelativeTo(null);
				Popup.setVisible(true);
				white = 0;
				white_x = 709;
				white_y = 494;
				CATCH = true;
			}
		}
	}

	public void initialize() {
		white = 0;
		white_count = 0;
		white_x = 709;
		white_y = 494;
		black = 0;
		black_count = 0;
		black_x = 709;
		black_y = 494;
		WhosTurn.setText("White");
		Yut.setText("윷 : ");
		white_num.setText("white의 남은말 :  □ □ □");
		black_num.setText("black의 남은말 :  ■ ■ ■ ");
	}
}