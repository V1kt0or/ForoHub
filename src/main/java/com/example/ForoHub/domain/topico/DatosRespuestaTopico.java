package com.example.ForoHub.domain.topico;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosRespuestaTopico (
                                   String titulo,

                                   String mensaje,

                                   LocalDate fechaCreacion,

                                   String status,

                                   int autor,

                                   int curso) {
}
