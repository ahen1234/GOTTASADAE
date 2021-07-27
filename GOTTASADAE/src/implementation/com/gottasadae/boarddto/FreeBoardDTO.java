package implementation.com.gottasadae.boarddto;

import java.sql.Date;

public class FreeBoardDTO {
	private int free_num;
	private String free_id;
	private String free_subject;
	private String free_content;
	private String free_file;
	private int free_count;
	private Date free_date;
	
	public FreeBoardDTO() {
		
	}

	public int getFree_num() {
		return free_num;
	}

	public void setFree_num(int free_num) {
		this.free_num = free_num;
	}

	public String getFree_id() {
		return free_id;
	}

	public void setFree_id(String free_id) {
		this.free_id = free_id;
	}

	public String getFree_subject() {
		return free_subject;
	}

	public void setFree_subject(String free_subject) {
		this.free_subject = free_subject;
	}

	public String getFree_content() {
		return free_content;
	}

	public void setFree_content(String free_content) {
		this.free_content = free_content;
	}

	public String getFree_file() {
		return free_file;
	}

	public void setFree_file(String free_file) {
		this.free_file = free_file;
	}

	public int getFree_count() {
		return free_count;
	}

	public void setFree_count(int free_count) {
		this.free_count = free_count;
	}

	public Date getFree_date() {
		return free_date;
	}

	public void setFree_date(Date free_date) {
		this.free_date = free_date;
	}
}
