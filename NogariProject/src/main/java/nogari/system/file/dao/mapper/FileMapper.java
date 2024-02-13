package nogari.system.file.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import nogari.system.file.domain.dto.FileDTO;

@Mapper
public interface FileMapper {
    void insertFile(FileDTO dto);
    List<FileDTO> selectFile(FileDTO dto);
    Map<String, String> selectFilePath(FileDTO dto);
    void updateFile(FileDTO dto);
}
