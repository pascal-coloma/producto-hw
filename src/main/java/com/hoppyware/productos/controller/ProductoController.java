package com.hoppyware.productos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.hoppyware.productos.service.*;
import java.util.List;
import com.hoppyware.productos.model.*;


@Controller
@RequestMapping("/hoppyware/v1/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listar(){
        List<Producto> listaProductos = productoService.findAll();
        if (listaProductos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaProductos);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
        Producto nuevoProd = productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProd);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarId(@PathVariable Long id){
        try{
            Producto producto = productoService.findById(id);
            return ResponseEntity.ok(producto);
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    

    

}
