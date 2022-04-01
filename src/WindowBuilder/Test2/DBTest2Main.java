package WindowBuilder.Test2;

import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DBTest2Main extends JFrame {
	
	@SuppressWarnings("unused")
	public DBTest2Main() {
		super("회원가입 메인화면");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 561);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원관리프로그램(v1.0)");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(59, 22, 660, 42);
		panel.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		URL imgUrl = this.getClass().getClassLoader().getResource("1.jpg");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\JavaGreen\\Java\\works\\0329_database\\images\\1.jpg"));
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(59, 74, 660, 361);
		panel.add(lblNewLabel_1);
		
		JButton btnInput = new JButton("회원등록");
		btnInput.setFont(new Font("맑은 고딕", Font.PLAIN, 16));

		btnInput.setBounds(60, 471, 121, 42);
		panel.add(btnInput);
		
		JButton btnSearch = new JButton("개별조회");
	
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnSearch.setBounds(241, 471, 121, 42);
		panel.add(btnSearch);
		
		JButton btnList = new JButton("전체조회");
		btnList.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnList.setBounds(422, 471, 121, 42);
		panel.add(btnList);
		
		JButton btnExit = new JButton("종  료");
		btnExit.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnExit.setBounds(603, 471, 121, 42);
		panel.add(btnExit);
		
		
		
		setVisible(true);
	
		
	/* 아래로 메소드 처리부 */
		
		// 회원등록
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DBTest2Input();
			}
		});
		
		// 개별조회
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DBTest2Search();
			}
		});

		// 전체조회
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DBTest2List();
			}
		});
		
	
		// 종료버튼 클릭
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// 종료버튼에서 엔터키를 누르면 종료.
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			}
		});
	}
	
	
	public static void main(String[] args) {
		new DBTest2Main();
	}
}
