package t4_DBTest_VO;

import java.util.ArrayList;
import java.util.Scanner;

public class DBTestService {

	Scanner sc = new Scanner(System.in);
	
	DBTestDAO dao = new DBTestDAO();
	DBTestVO vo = new DBTestVO();

	String name;
	
	// 자료등록
	public void input() {
		System.out.println("성명 : "); vo.setName(sc.next());
		System.out.println("나이 : ");	vo.setAge(sc.nextInt());
		System.out.println("성별 : ");	vo.setGender(sc.next());
		System.out.println("입사일 : ");	vo.setJoinday(sc.next());
		dao.input(vo);
	}

	// 개별자료 조회
	public void search() {
		System.out.println("찾고자 하는 성명을 입력하세요? ");
		name = sc.next();
		vo = dao.search(name);
	}

	// 전체자료 검색 후 출력처리 하는곳
	public void list() {
		ArrayList<DBTestVO> vos = dao.list();
		// 전체자료 출력처리하는곳
		System.out.println("======================================================");
		System.out.println("번호\t성명\t나이\t성별\t가입일자");
		System.out.println("------------------------------------------------------");
		
		for(int i=0; i<vos.size(); i++) {
			vo = vos.get(i);
			System.out.println(vo.getIdx()+"\t"+vo.getName()+"\t"+vo.getAge()+"\t"+vo.getGender()+"\t"+vo.getJoinday());
		}
		System.out.println("======================================================");
	}
	
	// 자료수정
	public void update() {
		System.out.println("수정할 성명을 입력하세요? ");
		name = sc.next();
		vo = dao.update(name);
	
	}

	// 삭제
	public void delete() {
		System.out.println("삭제할 성명을 입력하세요? ");
		name = sc.next();
		vo = dao.delete(name);
	}

	
	
}
