package sortObject;
/**
 * Stu
 * @author Problemin
 *
 */
public class Stu implements Comparable<Stu>{
	private int id ;
	private String name;
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
	public Stu(int id,String name){
		this.id = id ;
		this.name = name;
	}
	@Override
	public int compareTo(Stu o) {
		if(this.id == o.getId()){
			return 0;
		}
		if(this.id<o.getId()){
			return -1;
		}else{
			return 1;
		}
	}
	@Override
	public String toString() {
		return "Stu [id=" + id + ", name=" + name + "]";
	}
}