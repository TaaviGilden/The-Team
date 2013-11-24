

package ee.ut.math.tvt.TheTeam;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.*;

public class IntroUI extends JFrame {

	private static final long serialVersionUID = 1L;

	public IntroUI() {

		setTitle("Intro");
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension actualSize = getContentPane().getSize();
		setLocation((screen.width - actualSize.width) / 2,
				(screen.height - actualSize.height) / 2);

		Container intro = getContentPane();
		intro.setLayout(new BoxLayout(intro, BoxLayout.Y_AXIS));
		intro.setBackground(new Color(255, 255, 255));

		Properties appProp = new Properties();
		Properties verProp = new Properties();
		try {
			appProp.load(new FileInputStream("application.properties"));
			verProp.load(new FileInputStream("version.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel teamName = new JLabel("Team name: "
				+ appProp.getProperty("TeamName"));
		intro.add(teamName);
		JLabel teamLeader = new JLabel("Team leader: "
				+ appProp.getProperty("TeamLeader"));
		intro.add(teamLeader);

		JLabel leaderEmail = new JLabel("Team Leader Email: "
				+ appProp.getProperty("TeamLeaderEmail"));
		intro.add(leaderEmail);
		JLabel teamMembers = new JLabel("Team members: "
				+ appProp.getProperty("TeamMembers"));

		intro.add(teamMembers);

		JLabel buildVersion = new JLabel("Version: "
				+ verProp.getProperty("build.number"));
		intro.add(buildVersion);

		ImageIcon logo = new ImageIcon("logo.PNG");
		JLabel logoLabel = new JLabel(logo);
		intro.add(logoLabel);

		pack();

	}

}

