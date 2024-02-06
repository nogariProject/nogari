package nogari.system.ntbd.service;

import lombok.RequiredArgsConstructor;
import nogari.system.ntbd.dao.mapper.NtbdMapper;
import nogari.system.ntbd.domain.dto.BoardRespDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NtbdServiceImpl implements NtbdService {

    private final NtbdMapper mapper;

    public List<BoardRespDto> selectBoard(String ntbdCd){
        return mapper.selectBoard(ntbdCd);
    }
}
