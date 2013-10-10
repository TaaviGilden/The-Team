package ee.ut.math.tvt.TheTeam;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IntroUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static void iUI(){
		
		JFrame raam=new JFrame();
		raam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		raam.setSize(500, 300);
		raam.setResizable(false);
		raam.setTitle("Intro");
		raam.setContentPane(new JLabel(new ImageIcon("background.png")));
		
		
		JLabel teamName = new JLabel("Team name: The Team");
		teamName.setBounds(1, 10, 200, 30);
		raam.add(teamName);
		
		
		JLabel teamLeader = new JLabel("Team Leader: Taavi Gilden");
		teamLeader.setBounds(1, 40, 200, 30);
		raam.add(teamLeader);
		
		
		JLabel teamLeaderMail = new JLabel("Team leader email: Taavi.Gilden@gmail.com");
		teamLeaderMail.setBounds(1, 70, 350, 30);
		raam.add(teamLeaderMail);
		
		
		JLabel teamMembers = new JLabel("Team members: Taavi Gilden, Karl Metsand, Kristiina Ilves, Peeter Robert Reissar");
		teamMembers.setBounds(1, 100, 500, 30);
		raam.add(teamMembers);
		
		
		
		JLabel version = new JLabel("Build.number: 0.0.1");
		version.setBounds(1, 130, 200, 30);
		raam.add(version);
		
		ImageIcon pilt = new ImageIcon("logo.png");
		JLabel logo = new JLabel(pilt);
		logo.setBounds(380,160,100,100);
		raam.add(logo);
		
		//Miskipärast ei töötanud setBounds meetod viimasel lisatud JLabelil ning seega lisasin tühja JLabeli
		JLabel empty = new JLabel("");
		empty.setBounds(0,150,0,0);
		raam.add(empty);
		
		
		raam.setVisible(true);
	}
}
