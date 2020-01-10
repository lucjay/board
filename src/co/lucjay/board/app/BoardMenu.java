package co.lucjay.board.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.lucjay.board.dto.BoardDto;
import co.lucjay.board.service.BoardService;
import co.lucjay.board.serviceImpl.BoardServiceImpl;

public class BoardMenu {
	Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		int choice;
		boolean b = true;
		do {
			System.out.println("▶▶자유게시판◀◀");
			System.out.println(" 1. 목록 보기");
//			System.out.println(" 2. 게시글 작성");
//			System.out.println(" 3. 게시글 수정");
//			System.out.println(" 4. 게시글 삭제");
			System.out.println(" 2. 종 료 ");
			System.out.println("────────────");
			System.out.println("번호를 입력 하세요.");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				boardList();
				break;
			case 2:
				b = false;
				System.out.println("종료 되었습니다.");
				break;
			}
			sc.nextLine();
		} while (b);
	}

	private void boardDelete() {
		// TODO Auto-generated method stub

	}

	private void boardEdit() {
		// TODO Auto-generated method stub

	}

	private void boardWrite() {
		// TODO Auto-generated method stub

	}

	private void boardSearch(int key) {
		BoardService service = new BoardServiceImpl();
		BoardDto dto = new BoardDto();
		dto.setBoard_id(key);
		try {
			dto = service.select(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dto.toString();
		System.out.println("=======================");
		System.out.println("아무키나 눌러여");
		System.out.println("=======================");
		String str = sc.nextLine();
	}

	private void boardList() {
		BoardService service = new BoardServiceImpl();
		List<BoardDto> list = new ArrayList<BoardDto>();

		try {
			list = service.allSelect();
			System.out.println("=순번=====작성자=====작성일자=====제 목=====조회수=");
			for (BoardDto dto : list) {
				System.out.print(dto.getBoard_id() + " ");
				System.out.print(dto.getBoard_writer() + " ");
				System.out.print(dto.getBoard_date() + " ");
				System.out.print(dto.getBoard_title() + " ");
//				System.out.print(dto.getBoard_subject() + " ");
				System.out.println(dto.getBoard_hit() + " ");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("=======================");
		System.out.println("내용을 볼 순번 입력핼");
		System.out.println("=======================");
		int key = sc.nextInt();
		boardSearch(key);
	}

}
