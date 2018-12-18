import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

class WinnerEvent extends JDialog implements ActionListener{
	//http://blog.naver.com/PostView.nhn?blogId=battledocho&logNo=220035916932
	public JLabel WhosWinner;
	public JPanel minButtonPanel;
	public JButton minRetry;
	public JButton minExit;
	
	public WinnerEvent (int who) {
		setSize(200, 100);
		setLayout(new GridLayout(2, 1));
		
		if (who == 0) 
			WhosWinner = new JLabel("White가 이겼습니다.!");
		else
			WhosWinner = new JLabel("Black이 이겼습니다.!");
		add(WhosWinner);
		
		minButtonPanel = new JPanel();
		minRetry = new JButton("다시하기");
		minRetry.addActionListener(this);
		minButtonPanel.add(minRetry);
		minExit = new JButton("종료");
		minExit.addActionListener(this);
		minButtonPanel.add(minExit);
		
		add(minButtonPanel);
	}

	public void actionPerformed(ActionEvent e) {
		String E = e.getActionCommand();
		
		if(E.equals("다시하기")) {
			setVisible(false);
		}
		else if (E.equals("종료")) {
			System.exit(0);
		}
	}
}