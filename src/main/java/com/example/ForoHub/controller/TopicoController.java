package com.example.ForoHub.controller;

import com.example.ForoHub.domain.topico.*;
import com.example.ForoHub.domain.topico.validaciones.ValidadorTopicoDuplicado;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private ValidadorTopicoDuplicado validadorTopicoDuplicado;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){

        var detalleConsulta = validadorTopicoDuplicado.registrar(datosRegistroTopico);

        return ResponseEntity.ok(detalleConsulta);
    }


    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 2) Pageable paginacion){
        // return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornarDatosTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico =new DatosRespuestaTopico( topico.getTitulo(),topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getCurso());
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity  actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico =topicoRepository.getReferenceById(datosActualizarTopico.Id());
        topico.actualizarDatos(datosActualizarTopico);
        return  ResponseEntity.ok(new DatosRespuestaTopico( topico.getTitulo(),topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getCurso()));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public  ResponseEntity eliminarMedico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

    // @DeleteMapping("/{id}")
    //  @Transactional
    //  public  void eliminarMedico(@PathVariable Long id) {
    //     Topico topico = medicoRepository.getReferenceById(id);
    //     medicoRepository.delete(topico);
    // }


}
