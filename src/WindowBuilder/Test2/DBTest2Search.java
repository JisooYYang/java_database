package WindowBuilder.Test2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class DBTest2Search extends JFrame {
	private JTextField txtName;
	private JTextField txtAge;
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	
	DBTest2DAO dao = new DBTest2DAO();
	DBTest2VO vo = new DBTest2VO();
	
	private JTextField txtGender;
	private JTextField txtJoinday;
	private JTextField txtSearch;
	
	public DBTest2Search() {
		super("개별 회원 조회");
		setSize(600, 480);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 584, 441);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 조 회 폼");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(58, 21, 470, 51);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("성 명");
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(86, 82, 97, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("나  이");
		lblNewLabel_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(86, 141, 97, 25);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("성 별");
		lblNewLabel_1_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(86, 195, 97, 25);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("입사일");
		lblNewLabel_1_1_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(86, 255, 97, 25);
		panel.add(lblNewLabel_1_1_1_1);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setBounds(209, 82, 253, 25);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setEditable(false);
		txtAge.setColumns(10);
		txtAge.setBounds(209, 141, 253, 25);
		panel.add(txtAge);
		
		String[] yy = new String[30];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi;
		for(int i=0; i<=22; i++) {
			imsi = i + 2000;
			yy[i] = imsi + "";
		}
		for(int i=0; i<12; i++) {
			mm[i] = (i+1) + "";
		}
		for(int i=0; i<31; i++) {
			dd[i] = (i+1) + "";
		}
		
		JButton btnSearch = new JButton("조회하기");

		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnSearch.setBounds(404, 338, 124, 31);
		panel.add(btnSearch);
		
		JButton btnExit = new JButton("창닫기");


		btnExit.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnExit.setBounds(86, 386, 442, 31);
		panel.add(btnExit);
		
		txtGender = new JTextField();
		txtGender.setEditable(false);
		txtGender.setColumns(10);
		txtGender.setBounds(209, 195, 253, 25);
		panel.add(txtGender);
		
		txtJoinday = new JTextField();
		txtJoinday.setEditable(false);
		txtJoinday.setColumns(10);
		txtJoinday.setBounds(209, 255, 253, 25);
		panel.add(txtJoinday);
		
		JLabel lblNewLabel_2 = new JLabel("조회할 고유번호를 입력하세요.");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(12, 303, 560, 25);
		panel.add(lblNewLabel_2);
		
		txtSearch = new JTextField();
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txtSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		txtSearch.setBounds(90, 338, 302, 31);
		panel.add(txtSearch);
		txtSearch.setColumns(10);
		
		setVisible(true);
		/* 아래로 메소드 처리 */
		
		// 조회하기

		
		// 조회하기 출력창 버튼 수행
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = txtSearch.getText();
				if(search.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "고유번호를 입력하세요.");
					txtSearch.requestFocus();
				}
				else {
					if(!Pattern.matches("^[0-9]*$", search)) {
						JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요");
						txtSearch.setText("");
						txtSearch.requestFocus();											
					}
					else {
						DBTest2VO vo = dao.getSearch(Integer.parseInt(search));  //문자로 받아온 인덱스를 정수타입으로 바꿔준 후 vo로 넘겨준다.
						if(vo.getIdx() == 0) {
							JOptionPane.showMessageDialog(null, "검색한 고유번호가 없습니다. 다시 검색하세요.");
							txtSearch.requestFocus();												
						}
						else { 
							txtName.setText(vo.getName());
							txtAge.setText(String.valueOf(vo.getAge()));
							txtGender.setText(vo.getGender());
							txtJoinday.setText(vo.getJoinday());
						}
					}
				}
			}
		});
		
		
		// 창닫기
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		new DBTest2Search();
	}
}
