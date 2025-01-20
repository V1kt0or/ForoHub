package com.example.ForoHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosRegistroTopico(

            @NotBlank
             String titulo,
            @NotBlank
             String mensaje,
            @NotNull
            LocalDate fechaCreacion,
            @NotBlank
             String status,
            @NotNull
             int autor,
            @NotNull
             int curso

) {
}
