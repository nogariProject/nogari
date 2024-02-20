package nogari.global.batch.domain.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SeqInitDTO {

    String errCd;
    String errMsg;

}// end class
