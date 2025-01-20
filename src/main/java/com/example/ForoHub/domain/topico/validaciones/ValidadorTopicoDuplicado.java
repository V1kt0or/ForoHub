package com.example.ForoHub.domain.topico.validaciones;

import com.example.ForoHub.domain.ValidacionException;
import com.example.ForoHub.domain.topico.DatosRegistroTopico;
import com.example.ForoHub.domain.topico.DatosRespuestaTopico;
import com.example.ForoHub.domain.topico.Topico;
import com.example.ForoHub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoDuplicado {

    @Autowired
    private TopicoRepository topicoRepository;

    public DatosRespuestaTopico registrar(DatosRegistroTopico datos) {
        var yaExisteTopico = topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if (yaExisteTopico) {
            throw new ValidacionException("Paciente ya tiene una consulta reservada para ese dia");
        }
        Topico topico = topicoRepository.save(new Topico(datos));
        return new DatosRespuestaTopico( topico.getTitulo(),topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
