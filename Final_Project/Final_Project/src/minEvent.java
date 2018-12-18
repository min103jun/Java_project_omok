import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class minEvent extends JDialog implements ActionListener{
	public JPanel StringPanel;
	public JLabel StringArea;
	public JPanel ButtonPanel;
	public JButton Ok;
	
	public minEvent (String text) {
		setSize(400, 100);
		setLayout(new GridLayout(2, 1));
		
		StringPanel = new JPanel();
		StringArea = new JLabel(text);
		StringPanel.add(StringArea);
		add(StringPanel);
		
		ButtonPanel = new JPanel();
		Ok = new JButton("확인");
		Ok.addActionListener(this);
		ButtonPanel.add(Ok);
		add(ButtonPanel);
		
	}
	public void actionPerformed(ActionEvent e) {
		String Command = e.getActionCommand();
		
		if (Command.equals("확인")) {
			setVisible(false);
		}
	}
}
