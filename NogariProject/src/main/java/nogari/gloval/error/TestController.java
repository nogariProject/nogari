package nogari.gloval.error;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

	@PostMapping("/test")
	public void test(@RequestBody @Valid TestDTO dto) throws Exception{
		throw new Exception("Exception Test");
	}
	
}
