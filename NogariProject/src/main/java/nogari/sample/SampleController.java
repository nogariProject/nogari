package nogari.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class SampleController {

    @GetMapping("/exceptions/manve")
    public void testController() throws Exception {
        log.info("SampleController.testController {}");
        throw new Exception("테스트");//
    }
    @PostMapping("/test/ntdb")
    public String postTest(@Valid @RequestBody SampleDTO ntbdDto){
        log.info(ntbdDto.toString());
        return "hi";
    }
}
