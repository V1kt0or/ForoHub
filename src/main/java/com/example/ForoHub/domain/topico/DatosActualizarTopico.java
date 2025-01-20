package com.example.ForoHub.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopico (@NotNull Long Id, String titulo,

                                     String mensaje,

                                     String status

                                     ) {
}
