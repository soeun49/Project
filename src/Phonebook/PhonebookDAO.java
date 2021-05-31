package Phonebook;

import java.util.List;

//설계도

public interface PhonebookDAO {

	public List <PhonebookVO> getlist();
	public List <PhonebookVO> search(String keyword);
	public PhonebookVO get(Long id);
	public boolean insert (PhonebookVO vo);
	public boolean delte (Long id);

	

}
