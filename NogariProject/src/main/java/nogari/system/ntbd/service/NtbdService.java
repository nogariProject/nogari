package nogari.system.ntbd.service;

import java.util.List;
import nogari.system.ntbd.domain.dto.BoardRespDto;

public interface NtbdService {

    public List<BoardRespDto> selectBoard(String ntbdCd);
}
