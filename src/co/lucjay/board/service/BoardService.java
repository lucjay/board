package co.lucjay.board.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import co.lucjay.board.dto.BoardDto;

public abstract class BoardService { // 추상클래스
	public Connection conn;

	private String driver;
	private String url;
	private String user;
	private String password;

	private void getConnection() {
		Properties proper = new Properties();
		try {
			Reader reader = new FileReader("config/db.properties");
			proper.load(reader);
			driver = proper.getProperty("driver");
			url = proper.getProperty("url");
			user = proper.getProperty("user");
			password = proper.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BoardService() {
		getConnection();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("서비스가 잠시 중단 됐어 관리자 문의해");
		}
	}

	public abstract List<BoardDto> allSelect() throws SQLException;

	public abstract BoardDto select(BoardDto dto) throws SQLException;

	public abstract int insert(BoardDto dto) throws SQLException;

	public abstract int delete(BoardDto dto) throws SQLException;

	public abstract int update(BoardDto dto) throws SQLException;

}