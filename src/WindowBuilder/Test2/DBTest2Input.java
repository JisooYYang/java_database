package WindowBuilder.Test2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DBTest2Input extends JFrame {
	private JTextField txtName;
	private JTextField txtAge;
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	
	DBTest2DAO dao = new DBTest2DAO();
	DBTest2VO vo = new DBTest2VO();
	
	public DBTest2Input() {
		super("회원가입폼");
		setSize(600, 480);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 441);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입 폼");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(58, 21, 470, 51);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("성 명");
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(39, 114, 97, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("나  이");
		lblNewLabel_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(39, 173, 97, 25);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("성 별");
		lblNewLabel_1_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(39, 225, 97, 25);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("입사일");
		lblNewLabel_1_1_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(39, 285, 97, 25);
		panel.add(lblNewLabel_1_1_1_1);
		
		txtName = new JTextField();
		txtName.setBounds(148, 117, 253, 25);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(148, 176, 253, 25);
		panel.add(txtAge);
		
		JRadioButton radioMale = new JRadioButton("남 자");
		radioMale.setSelected(true);
		btnGroupGender.add(radioMale);
		radioMale.setHorizontalAlignment(SwingConstants.CENTER);
		radioMale.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		radioMale.setBounds(159, 229, 119, 25);
		panel.add(radioMale);
		
		JRadioButton radioFemale = new JRadioButton("여 자");
		btnGroupGender.add(radioFemale);
		radioFemale.setHorizontalAlignment(SwingConstants.CENTER);
		radioFemale.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		radioFemale.setBounds(257, 229, 119, 25);
		panel.add(radioFemale);
		
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
			
		JComboBox comboY = new JComboBox(yy);
		comboY.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		comboY.setBounds(148, 288, 116, 25);
		panel.add(comboY);
		
		JComboBox comboM = new JComboBox(mm);
		comboM.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		comboM.setBounds(272, 289, 60, 25);
		panel.add(comboM);
		
		JComboBox comboD = new JComboBox(dd);
		comboD.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		comboD.setBounds(341, 289, 60, 25);
		panel.add(comboD);
		
		JButton btnInput = new JButton("가입하기");

		btnInput.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnInput.setBounds(53, 364, 124, 31);
		panel.add(btnInput);
		
		JButton btnCancel = new JButton("취소하기");

		btnCancel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnCancel.setBounds(230, 364, 124, 31);
		panel.add(btnCancel);
		
		JButton btnExit = new JButton("창닫기");

		btnExit.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnExit.setBounds(407, 364, 124, 31);
		panel.add(btnExit);
		
		setVisible(true);
		/* 아래로 메소드 처리 */
		
		// 가입하기
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String age = txtAge.getText();
				String gender;
				String joinday = comboY.getSelectedItem()+"-"+comboM.getSelectedItem()+"-"+comboD.getSelectedItem();
				
				//유효성검사
				if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요");
					txtName.requestFocus();
				}
				else if(age.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "나이를 입력하세요");
					txtAge.requestFocus();					
				}
				else {
					if(!Pattern.matches("^[0-9]*$", age)) {
						JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요");
						txtAge.requestFocus();											
					}
					else {
						if(radioMale.isSelected()) gender = "남자";
						else gender = "여자";
			
					// 가입처리(DB처리)
					vo.setName(name);
					vo.setAge(Integer.parseInt(age));
					vo.setGender(gender);
					vo.setJoinday(joinday);
					
					dao.DBTestInput(vo);
					JOptionPane.showMessageDialog(null, "회원 가입 되었습니다");
						
					// 다음자료 준비
					txtName.setText("");
					txtAge.setText("");
					txtName.requestFocus();
					}
				}	
			}
		});
		
		// 취소하기
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				txtName.requestFocus();
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
		new DBTest2Input();
	}
}
