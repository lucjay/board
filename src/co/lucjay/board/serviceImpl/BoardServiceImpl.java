package co.lucjay.board.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.lucjay.board.dto.BoardDto;
import co.lucjay.board.service.BoardService;

public class BoardServiceImpl extends BoardService {
	private BoardDto dto;
	private PreparedStatement psmt;
	private ResultSet rs;
	private final String ALL_SELECT = "SELECT * FROM board";
	private final String SELECT = "SELECT * FROM board WHERE board_id = ?";
	private final String INSERT = "INSERT INTO board (BOARD_ID, BOARD_WRITER, BOARD_TITLE, BOARD_SUBJECT) VALUES (?,?,?,?)";
	private final String UPDATE = "UPDATE board SET board_subject=? WHERE board_id = ?";
	private final String DELETE = "DELETE FROM board WHERE board_id = ?";

	@Override
	public List<BoardDto> allSelect() throws SQLException {
		List<BoardDto> list = new ArrayList<BoardDto>();
		psmt = conn.prepareStatement(ALL_SELECT);
		rs = psmt.executeQuery();
		while (rs.next()) {
			dto = new BoardDto();
			dto.setBoard_id(rs.getInt("board_id"));
			dto.setBoard_writer(rs.getString("board_writer"));
			dto.setBoard_date(rs.getDate("board_date"));
			dto.setBoard_title(rs.getString("board_title"));
			dto.setBoard_subject(rs.getString("board_subject"));
			dto.setBoard_hit(rs.getInt("hit"));
			list.add(dto);
		}
		return list;
	}

	@Override
	public BoardDto select(BoardDto dto) throws SQLException {
		psmt = conn.prepareStatement(SELECT);
		psmt.setInt(1, dto.getBoard_id());
		rs = psmt.executeQuery();
		if (rs.next()) {
			dto.setBoard_id(rs.getInt("board_id"));
			dto.setBoard_writer(rs.getString("board_writer"));
			dto.setBoard_date(rs.getDate("board_date"));
			dto.setBoard_title(rs.getString("board_title"));
			dto.setBoard_subject(rs.getString("board_subject"));
			dto.setBoard_hit(rs.getInt("hit"));
		}
		return dto;
	}

	@Override
	public int insert(BoardDto dto) throws SQLException {
		psmt = conn.prepareStatement(INSERT);
		psmt.setInt(1, dto.getBoard_id());
		psmt.setString(2, dto.getBoard_writer());
		psmt.setString(3, dto.getBoard_title());
		psmt.setString(4, dto.getBoard_subject());
		int n = psmt.executeUpdate();
		return n;
	}

	@Override
	public int delete(BoardDto dto) throws SQLException {
		psmt = conn.prepareStatement(DELETE);
		psmt.setInt(1, dto.getBoard_id());
		int n = psmt.executeUpdate();
		return n;
	}

	@Override
	public int update(BoardDto dto) throws SQLException {
		psmt = conn.prepareStatement(UPDATE);
		psmt.setString(1, dto.getBoard_subject());
		psmt.setInt(2, dto.getBoard_id());
		int n = psmt.executeUpdate();
		return n;
	}

}
