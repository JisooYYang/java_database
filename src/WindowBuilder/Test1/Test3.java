package WindowBuilder.Test1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class Test3 extends JFrame{
	private JTextField txtMid;
	private JPasswordField txtPwd;
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	private JTable tdlContent;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Test3() {
		super("컴포넌트 연습");
		setSize(600, 590);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.LIGHT_GRAY);
		pn1.setBounds(12, 55, 560, 43);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(12, 10, 59, 23);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		pn1.add(lblNewLabel);
		
		txtMid = new JTextField();
		txtMid.setBounds(75, 10, 124, 23);
		pn1.add(txtMid);
		txtMid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_1.setBounds(198, 10, 83, 23);
		pn1.add(lblNewLabel_1);
		
		JButton btnMidPwd = new JButton("아이디출력");

		btnMidPwd.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnMidPwd.setBounds(422, 10, 126, 25);
		pn1.add(btnMidPwd);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(278, 10, 132, 23);
		pn1.add(txtPwd);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 10, 560, 35);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setFont(new Font("맑은 고딕", Font.BOLD, 16));

		btnExit.setBounds(436, 5, 112, 25);
		pn2.add(btnExit);
		
		JLabel lblDisplay = new JLabel("* 출 력 창 *");
		lblDisplay.setBounds(0, 5, 438, 25);
		pn2.add(lblDisplay);
		lblDisplay.setForeground(Color.RED);
		lblDisplay.setBackground(Color.ORANGE);
		lblDisplay.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lblDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 105, 560, 43);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JRadioButton rdMale = new JRadioButton("남 자");
		btnGroupGender.add(rdMale);
		rdMale.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		rdMale.setBounds(94, 6, 78, 31);
		pn3.add(rdMale);
		
		JRadioButton rdFemale = new JRadioButton("여 자");
		btnGroupGender.add(rdFemale);
		rdFemale.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		rdFemale.setBounds(208, 6, 78, 31);
		pn3.add(rdFemale);
		
		JButton btnGender = new JButton("성별출력");

		btnGender.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnGender.setBounds(309, 6, 149, 31);
		pn3.add(btnGender);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(12, 158, 298, 193);
		getContentPane().add(pn4);
		pn4.setLayout(null);
		
		JComboBox comboJob = new JComboBox();
		comboJob.setModel(new DefaultComboBoxModel(new String[] {"학생", "회사원", "군인", "의사", "변호사", "기타"}));
		comboJob.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		comboJob.setBounds(12, 10, 139, 23);
		pn4.add(comboJob);
		
		JButton btnJob = new JButton("직업출력");

		btnJob.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnJob.setBounds(12, 43, 139, 23);
		pn4.add(btnJob);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 76, 139, 107);
		pn4.add(scrollPane);
		
		JList listJob = new JList();
		listJob.setModel(new AbstractListModel() {
			String[] values = new String[] {"학생", "회사원", "공무원", "군인", "의사", "변호사", "자영업", "무직"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listJob);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(163, 43, 124, 140);
		pn4.add(scrollPane_1);
		
		JTextArea txtaContent = new JTextArea();
		scrollPane_1.setViewportView(txtaContent);
		
		JButton btnJob2 = new JButton("직업출력2");

		btnJob2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnJob2.setBounds(163, 10, 124, 23);
		pn4.add(btnJob2);
		
		JPanel pn5 = new JPanel();
		pn5.setBounds(322, 158, 250, 193);
		getContentPane().add(pn5);
		pn5.setLayout(null);
		
		JCheckBox chkCard1 = new JCheckBox("국민카드");
		chkCard1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		chkCard1.setBounds(8, 21, 100, 25);
		pn5.add(chkCard1);
		
		JCheckBox chkCard2 = new JCheckBox("신한카드");
		chkCard2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		chkCard2.setBounds(126, 21, 100, 25);
		pn5.add(chkCard2);
		
		JCheckBox chkCard3 = new JCheckBox("우리카드");
		chkCard3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		chkCard3.setBounds(8, 64, 100, 25);
		pn5.add(chkCard3);
		
		JCheckBox chkCard4 = new JCheckBox("하나카드");
		chkCard4.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		chkCard4.setBounds(126, 64, 100, 25);
		pn5.add(chkCard4);
		
		JCheckBox chkCard5 = new JCheckBox("농협카드");
		chkCard5.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		chkCard5.setBounds(8, 106, 110, 25);
		pn5.add(chkCard5);
		
		JCheckBox chkCard6 = new JCheckBox("삼성카드");
		chkCard6.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		chkCard6.setBounds(126, 106, 100, 25);
		pn5.add(chkCard6);
		
		JButton btnCard = new JButton("선택카드출력");

		btnCard.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnCard.setBounds(22, 158, 198, 25);
		pn5.add(btnCard);
		
		JPanel pn6 = new JPanel();
		pn6.setBounds(12, 361, 560, 176);
		getContentPane().add(pn6);
		pn6.setLayout(null);
		
		/* JTable을 디자인탭에 올리는 순서?
			1. Panel을 만들고, Absolute Layout을 패널에 찍어준다.
			2. JScrollPane을 패널의 크기에 맞게 그린다.
			3. JTable을 JScrollPane의 ViewPort에 클릭해준다.
			4. Database에 연결을 위해 DefaultTableModel객체를 준비해준다.
				 DefaultTableModel객체는 Vector형식의 자료를 사용한다.
				 따라서 '제목'과 '내용물'을 모두 백터로 준비시켜준다.
			5. 준비된 Vector형식의 자료를 DefaultTableModel객체에 올린다.
			6. DefaultTableModel객체를 JTable에 올려준다.
			7. JTable을 JScrollPane에 올려주낟.
			8. JScrollPane을 '패널'에 올려준다.
		*/	
	
		
		// 타이틀을 백터로 처리해둔다.
		Vector title = new Vector();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
		// 데이터로 백터로 준비해둔다.
		Test3DAO dao = new Test3DAO();
		Vector vData = dao.getList();
		//System.out.println("vData : " + vData);
		
		// DefaultTableModel에 준비한 백터 자료를 담는다.
		DefaultTableModel defaultTableModel = new DefaultTableModel(vData, title); // (데이터,타이틀)
		
		// DefaultTableModel를 JTable에 올린다.
		tdlContent = new JTable(defaultTableModel);
		
		// JTable을 JScrollPane에 올려준다.
		JScrollPane spContent = new JScrollPane(tdlContent);
		spContent.setBounds(0, 0, 560, 176);
		
		// JScrollPane을 Penel에 올려준다.
		pn6.add(spContent);
	
		//spContent.setViewportView(tdlContent);  -> new JScrollPane에 tdlContent를 넣어줘서 이건 써줄 필요가 없음
		
		setVisible(true);
		
		/* 아래로 메소드 처리 */
		
		// 아이디와 비밀번호 출력처리
		btnMidPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mid = txtMid.getText();
				String pwd = txtPwd.getText();
				if(mid.equals("") || pwd.equals("")) {
					JOptionPane.showConfirmDialog(null, "아이디와 비밀번호를 입력하세요.");
					if(mid.equals("")) txtMid.requestFocus();
					else txtPwd.requestFocus();
				}
				else {
					lblDisplay.setText("아이디 : "+mid+" , 비밀번호 : "+pwd);
				}
			}
		});
		
		// 성별 출력 버튼
		btnGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdMale.isSelected()) lblDisplay.setText("남자 선택");
				else lblDisplay.setText("여자 선택");
			}
		});
		
		// 직업 출력 버튼
		btnJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDisplay.setText(comboJob.getSelectedItem().toString()+"을(를) 선택하셨습니다.");  //Object타입이었는데 .toString붙여서 타입변환시켜줌.
				
			}
		});
		
		// 선택된 직업을 textArea에 출력하기
		btnJob2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtaContent.setText(comboJob.getSelectedItem().toString());
				txtaContent.append(comboJob.getSelectedItem().toString()+"\n");
			}
		});
		
		// 선택된 카드를 모두 레이블에 처리하는 버튼메소드
		btnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String card = "";
				if(chkCard1.isSelected()) card += chkCard1.getText() + "/";
				if(chkCard2.isSelected()) card += chkCard2.getText() + "/";
				if(chkCard3.isSelected()) card += chkCard3.getText() + "/";
				if(chkCard4.isSelected()) card += chkCard4.getText() + "/";
				if(chkCard5.isSelected()) card += chkCard5.getText() + "/";
				if(chkCard6.isSelected()) card += chkCard6.getText() + "/";
				lblDisplay.setText("선택카드 : " + card);
			}
		});
		
		
		// 종료버튼 처리
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		new Test3();
	}
}
