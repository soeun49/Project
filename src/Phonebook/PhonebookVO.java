package Phonebook;

public class PhonebookVO {

	private Long telid;
	private String name;
	private String phonehome;
	private String mobile;
	
	public PhonebookVO (Long telid, String name, String phonehome, String mobile){
		this.telid=telid;
		this.name=name;
		this.phonehome=phonehome;
		this.mobile=mobile;
				
	}

	public Long getId() {
		return telid;
	}

	public void setId(Long telid) {
		this.telid = telid;
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
		return "PhonebookVO [telid=" + telid + ", name=" + name + ", mobile=" + mobile + ", phonehome=" + phonehome + "]";
	}
	
}
