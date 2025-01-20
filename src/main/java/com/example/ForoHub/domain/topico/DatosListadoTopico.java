package com.example.ForoHub.domain.topico;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosListadoTopico (Long Id, String titulo,

                                 String mensaje,

                                  LocalDate fechaCreacion,

                                 String status,

                                 int autor,

                                 int curso) {

    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
