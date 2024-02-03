package nogari.system.menu.domain.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("MenuMstDTO")
public class MenuMstDTO {
    private MenuDtlDTO master;
    private List<MenuDtlDTO> detail;
}
