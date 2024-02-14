package nogari.global.file.dao.mapper;

import nogari.global.file.domain.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {

    /**
     * 파일 업로드시 파일 데이터 저장
     * @param fileDTO   파일 관련 정보 (fileCd, seq, useYn, fileNm, path, fileSize, userId)
     * @return
     */
    int insertFile(FileDTO fileDTO);

    /**
     * 파일 다운로드시 파일 경로 선택
     * @param fileDTO   파일 관련 정보 (fileCd, seq, fileNm)
     * @return path    파일 경로
     */
    String selectPath(FileDTO fileDTO);     /* 파일 다운로드시 저장된 파일 경로 선택 */
}
