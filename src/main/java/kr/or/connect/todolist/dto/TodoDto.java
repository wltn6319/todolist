package kr.or.connect.todolist.dto;

public class TodoDto {
	private int id;
	private String name;
	private String title;
	private int sequence;
	private String type;
	
	public TodoDto(){
		
	}
	public TodoDto(String name, String title, int sequence) {
		super();
		this.name = name;
		this.title = title;
		this.sequence = sequence;

	}
	public TodoDto(int id, String name, String title, int sequence, String type) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.sequence = sequence;
		this.type =type;

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	 @Override
	  public String toString() {
	    return "Todo [id="+ id+", name=" + name + ",sequence=" + sequence
	        + ", title=" + title + ", type =" + type+"]";
	  }

}