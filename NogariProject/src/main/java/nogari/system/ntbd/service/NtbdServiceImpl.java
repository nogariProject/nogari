package nogari.system.ntbd.service;

import nogari.system.ntbd.dao.mapper.NtbdMapper;
import nogari.system.ntbd.domain.dto.BoardRespDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NtbdServiceImpl implements NtbdService {
    @Resource
    private NtbdMapper mapper;

    public List<BoardRespDto> selectBoard(String ntbdCd){
        return mapper.selectBoard(ntbdCd);
    }
}
