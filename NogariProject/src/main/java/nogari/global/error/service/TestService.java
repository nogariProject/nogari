package nogari.global.error.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	public void testServ() throws Exception {
		throw new Exception("service단에서 터지면?");
	}
	
	
}
