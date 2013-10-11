package ee.ut.math.tvt.TheTeam;
// This is a comment
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class IntroUI extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void iUI() {

		Properties app = new Properties();
		Properties ver = new Properties();

		try {

			app.load(new FileInputStream("application.properties"));
			ver.load(new FileInputStream("version.properties"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height
				/ 2 - frame.getSize().height / 2);
		frame.setResizable(false);
		frame.setTitle("Intro");
		frame.getContentPane().setBackground(Color.WHITE);

		JLabel teamName = new JLabel("Team name: "
				+ app.getProperty("TeamName"));
		teamName.setBounds(1, 10, 200, 30);
		frame.add(teamName);

		JLabel teamLeader = new JLabel("Team Leader: "
				+ app.getProperty("TeamLeader"));
		teamLeader.setBounds(1, 40, 200, 30);
		frame.add(teamLeader);

		JLabel teamLeaderMail = new JLabel("Team leader email: "
				+ app.getProperty("TeamLeaderEmail"));
		teamLeaderMail.setBounds(1, 70, 350, 30);
		frame.add(teamLeaderMail);

		JLabel teamMembers = new JLabel("Team members: "
				+ app.getProperty("TeamMembers"));
		teamMembers.setBounds(1, 100, 500, 30);
		frame.add(teamMembers);

		JLabel version = new JLabel("Version: "
				+ ver.getProperty("build.number"));
		version.setBounds(1, 130, 200, 30);
		frame.add(version);

		ImageIcon pilt = new ImageIcon("logo.png");
		JLabel logo = new JLabel(pilt);
		logo.setBounds(380, 160, 100, 100);
		frame.add(logo);

		// Miskipärast ei töötanud setBounds meetod viimasel lisatud JLabelil
		// ning seega lisasin tühja JLabeli
		JLabel empty = new JLabel("");
		empty.setBounds(0, 150, 0, 0);
		frame.add(empty);

		frame.setVisible(true);

	}
}