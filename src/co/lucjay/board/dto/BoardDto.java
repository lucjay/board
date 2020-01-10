package co.lucjay.board.dto;

import java.sql.Date;

public class BoardDto {
	private int board_id;
	private String board_writer;
	private Date board_date;
	private String board_title;
	private String board_subject;
	private int hit;

	public BoardDto() {

	}

	public BoardDto(int id, String writer, String title, String subject) {
		this.board_id = id;
		this.board_writer = writer;
		this.board_title = title;
		this.board_subject = subject;
	}

	public int getBoard_id() {
		return board_id;
	}

	public String getBoard_writer() {
		return board_writer;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public String getBoard_title() {
		return board_title;
	}

	public String getBoard_subject() {
		return board_subject;
	}

	public int getBoard_hit() {
		return hit;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}

	public void setBoard_hit(int board_hit) {
		this.hit = board_hit;
	}

	public String toString() {
		System.out.println("순번 : " + board_id);
		System.out.println("작성자 : " + board_writer);
		System.out.println("작성일자 : " + board_date);
		System.out.println("제 목 : " + board_title);
		System.out.println("내 용 : " + board_subject);
		System.out.println("조 회 수 : " + hit);
		return null;
	}

}
