import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  Who was the first Indian woman in Space");
			radioButton[0].setText("Kalpana Chawla");
			radioButton[1].setText("Sunita Williams");
			radioButton[2].setText("Koneru Humpy");
			radioButton[3].setText("None of the above");
		}
		if (current == 1) {
			label.setText("Que2:  Who was the first Indian in space?");
			radioButton[0].setText("Vikram Ambalal");
			radioButton[1].setText("Ravish Malhotra");
			radioButton[2].setText("Rakesh Sharma");
			radioButton[3].setText("Nagapathi Bhat");
		}
		if (current == 2) {
			label.setText("Que3: Who was the first Man to Climb Mount Everest Without Oxygen?");
			radioButton[0].setText("Junko Tabei");
			radioButton[1].setText("Reinhold Messner");
			radioButton[2].setText("Peter Habeler");
			radioButton[3].setText("Phu Dorji");
		}
		if (current == 3) {
			label.setText("Que4: Who built the Jama Masjid?");
			radioButton[0].setText("Jahangir");
			radioButton[1].setText("Akbar");
			radioButton[2].setText("Imam Bukhari");
			radioButton[3].setText("Shah Jahan");
		}
		if (current == 4) {
			label.setText("Que5:  Who wrote the Indian National Anthem?");
			radioButton[0].setText("Bakim Chandra Chatterji");
			radioButton[1].setText("Rabindranath Tagore");
			radioButton[2].setText("Swami Vivekanand");
			radioButton[3].setText("None of the above");
		}
		if (current == 5) {
			label.setText("Que6: Who was the first Indian Scientist to win a Nobel Prize?");
			radioButton[0].setText("CV Raman");
			radioButton[1].setText("Amartya Sen");
			radioButton[2].setText("Hargobind Khorana");
			radioButton[3].setText("Subramanian Chrandrashekar");
		}
		if (current == 6) {
			label.setText("Que7:  Who is the first Indian to win a Nobel Prize?");
			radioButton[0].setText("Rabindranath Tagore");
			radioButton[1].setText("CV Raman");
			radioButton[2].setText("Mother Theresa");
			radioButton[3].setText("Hargobind Khorana");
		}
		if (current == 7) {
			label.setText("Que8:  Who was the first Indian woman to win the Miss World Title?");
			radioButton[0].setText("Aishwarya Rai");
			radioButton[1].setText("Sushmita Sen");
			radioButton[2].setText("Reita Faria");
			radioButton[3].setText("Diya Mirza");
		}
		if (current == 8) {
			label.setText("Que9: Who was the first President of India?");
			radioButton[0].setText("Abdul Kalam");
			radioButton[1].setText("Lal Bahadur Shastri");
			radioButton[2].setText("Dr. Rajendra Prasad");
			radioButton[3].setText("Zakir Hussain");
		}
		if (current == 9) {
			label.setText("Que10: Who was the first Indian to win the Booker Prize?");
			radioButton[0].setText("Dhan Gopal Mukerji");
			radioButton[1].setText("Nirad C. Chaudhuri");
			radioButton[2].setText("Arundhati Roy");
			radioButton[3].setText("Aravind Adiga");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[0].isSelected());
		if (current == 1)
			return (radioButton[2].isSelected());
		if (current == 2)
			return (radioButton[3].isSelected());
		if (current == 3)
			return (radioButton[3].isSelected());
		if (current == 4)
			return (radioButton[1].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[0].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[2].isSelected());
		if (current == 9)
			return (radioButton[2].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Online Test App");
	}

}