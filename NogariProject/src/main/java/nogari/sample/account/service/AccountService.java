package nogari.sample.account.service;

import java.util.List;

import nogari.sample.domain.entity.MemberEntity;

public interface AccountService {
	public List<MemberEntity> selectAccount();
	public String updateAccount(String id, String password, String newName, String newPassword);
	public String deleteAccount(String id, String password);
}
