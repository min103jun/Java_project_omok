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
			WhosWinner = new JLabel("White�� �̰���ϴ�.!");
		else
			WhosWinner = new JLabel("Black�� �̰���ϴ�.!");
		add(WhosWinner);
		
		minButtonPanel = new JPanel();
		minRetry = new JButton("�ٽ��ϱ�");
		minRetry.addActionListener(this);
		minButtonPanel.add(minRetry);
		minExit = new JButton("����");
		minExit.addActionListener(this);
		minButtonPanel.add(minExit);
		
		add(minButtonPanel);
	}

	public void actionPerformed(ActionEvent e) {
		String E = e.getActionCommand();
		
		if(E.equals("�ٽ��ϱ�")) {
			setVisible(false);
		}
		else if (E.equals("����")) {
			System.exit(0);
		}
	}
}