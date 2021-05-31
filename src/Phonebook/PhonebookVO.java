package Phonebook;

public class PhonebookVO {

	private Long id;
	private String name;
	private String phonehome;
	private String mobile;
	
	public PhonebookVO (Long id, String name, String phonehome, String mobile){
		this.id=id;
		this.name=name;
		this.phonehome=phonehome;
		this.mobile=mobile;
				
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonehome() {
		return phonehome;
	}

	public void setPhonehome(String phonehome) {
		this.phonehome = phonehome;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "PhonebookVO [id=" + id + ", name=" + name + ", phonehome=" + phonehome + ", mobile=" + mobile + "]";
	}
	
}
