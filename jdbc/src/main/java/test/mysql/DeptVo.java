package test.mysql;

public class DeptVo {
	@Override
	public String toString() {
		return "DeptVo [no=" + no + ", name=" + name + "]";
	}

	private Long no;
	private String name; 
	
	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
