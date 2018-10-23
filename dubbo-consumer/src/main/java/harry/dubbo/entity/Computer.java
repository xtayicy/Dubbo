package harry.dubbo.entity;

import java.io.Serializable;

/**
 * 
 * @author harry
 *
 */
public class Computer implements Serializable{
	private Integer id;
	private String name;
	
	public Computer(String name) {
		super();
		this.name = name;
	}
	
	public Computer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + "]";
	}
}	
