package nogari.system.menu.domain.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("MenuDTO")
public class MenuDTO {
    private MenuFieldDTO master;
    private List<MenuFieldDTO> detail;
}
