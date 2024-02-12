package nogari.system.file.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import nogari.system.file.domain.dto.FileDTO;

@Mapper
public interface FileMapper {
    void insertFile(FileDTO dto);
}
