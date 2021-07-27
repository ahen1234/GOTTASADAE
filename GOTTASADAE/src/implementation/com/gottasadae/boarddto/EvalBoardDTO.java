package implementation.com.gottasadae.boarddto;

import java.sql.Date;

public class EvalBoardDTO {
	private int eval_num;
	private String eval_id;
	private String eval_subject;
	private String eval_content;
	private String eval_file;
	private int eval_count;
	private Date eval_date;
	
	public EvalBoardDTO() {
		
	}

	public int getEval_num() {
		return eval_num;
	}

	public void setEval_num(int eval_num) {
		this.eval_num = eval_num;
	}

	public String getEval_id() {
		return eval_id;
	}

	public void setEval_id(String eval_id) {
		this.eval_id = eval_id;
	}

	public String getEval_subject() {
		return eval_subject;
	}

	public void setEval_subject(String eval_subject) {
		this.eval_subject = eval_subject;
	}

	public String getEval_content() {
		return eval_content;
	}

	public void setEval_content(String eval_content) {
		this.eval_content = eval_content;
	}

	public String getEval_file() {
		return eval_file;
	}

	public void setEval_file(String eval_file) {
		this.eval_file = eval_file;
	}

	public int getEval_count() {
		return eval_count;
	}

	public void setEval_count(int eval_count) {
		this.eval_count = eval_count;
	}

	public Date getEval_date() {
		return eval_date;
	}

	public void setEval_date(Date eval_date) {
		this.eval_date = eval_date;
	}
	
	
}
