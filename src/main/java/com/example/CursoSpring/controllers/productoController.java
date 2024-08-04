package com.example.CursoSpring.controllers;

import com.example.CursoSpring.entities.producto;
import com.example.CursoSpring.repositories.productoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class productoController {

    @Autowired
    private productoRepository productoRep;

    @GetMapping
    public List<producto> getAllproducto(){
        return productoRep.findAll();
    }

    @GetMapping("/{id}")
    public producto getproductoById(@PathVariable Long id){
        return productoRep.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el producto pepe"));
    }

    @PostMapping
    public producto createproducto(@RequestBody producto producto){
        return productoRep.save(producto);
    }

    @PutMapping("/{id}")
    public producto updateproducto(@PathVariable Long id,@RequestBody producto detallesproducto){
        producto product=productoRep.findById(id).orElseThrow(()->new RuntimeException("No se encontro el producto pepe"));
        product.setNombre(detallesproducto.getNombre());
        product.setPrecio(detallesproducto.getPrecio());
        return  productoRep.save(product);
    }

    @DeleteMapping("/{id}")
    public String deleteproducto(@PathVariable Long id){
        try {
            producto product=productoRep.findById(id).orElseThrow(()->new RuntimeException("No se encontro el producto pepe"));
            productoRep.delete(product);
            return "El producto con el id: "+id+" Se elimino con exito";
        }catch (Exception e){
            return "Ocurrio un error al eliminar pepe";
        }
    }
}
