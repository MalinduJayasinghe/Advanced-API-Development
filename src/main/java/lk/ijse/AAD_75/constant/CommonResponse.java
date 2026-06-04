package lk.ijse.AAD_75.constant;

import lk.ijse.AAD_75.dto.SchoolDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {

    private int status;
    private Object body;
    private String message;

    public CommonResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

}

