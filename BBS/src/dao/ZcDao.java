package dao;

import model.User;

public interface ZcDao {
	public boolean judge(String userId);
	public void addUser(User user);

}
