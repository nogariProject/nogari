package nogari.system.menu.domain.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import nogari.global.annotation.UrlCheck;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("MenuDTO")
@UrlCheck
public class MenuDTO {
	
	private MenuFieldDTO master;
    private List<MenuFieldDTO> detail;
    
    // 화면ID(url) 검증
//    public boolean urlChk() {
//    	
//    	// 메뉴검증
//    	if(master != null && (master.getUrl() != null && !master.getUrl().equals("")) ) return false;
//    	
//    	// 화면검증
//    	if(detail != null) {
//    		for(MenuFieldDTO scr : detail) {
//    			String url = scr.getUrl();
//    			if(url == null || url.equals("")) return false;
//    		}
//    	}
//    	
//    	return true;
//    }
    
}
