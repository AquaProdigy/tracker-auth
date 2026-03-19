package org.example.trackerauth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.trackerauth.api.ApiValidationMessages;

@Data
public class AuthUserRequest {

    @Email(message = ApiValidationMessages.EMAIL_NOT_VALID)
    @NotBlank(message = ApiValidationMessages.NOT_BLANK)
    @Size(min = 5, max = 100, message = ApiValidationMessages.SIZE_ERROR)
    private String email;

    @Size(min = 5, max = 100, message = ApiValidationMessages.SIZE_ERROR)
    private String password;
}
