package com.example.sms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @Positive
    @Min(100)
    private int roll;

    @NotEmpty
    @NotBlank
    @NotNull
    private String name;

    @Email(message = "Email Not Found. Please Provide a Valid Email.")
    private String email;

    @PositiveOrZero
    private double fees;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Phone Number Shoudl Be In valid Format")
    private String phoneNumber;
}
