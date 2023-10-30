package com.vinni.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinni.entity.Vehiculo;
import com.vinni.repository.VehiculoRepository;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;


@Service
@WebService(serviceName = "usuarios")
public class SOAPImplementacion {

    //private Datos datos = new Datos();
    
    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    @WebMethod(operationName = "obtenerVehiculos")
    public List<Vehiculo> consultar() {
        return vehiculoRepository.findAll();
    }

    @WebMethod(operationName = "obtenerVehiculo")
    public Vehiculo obtenerVehiculo(@WebParam(name = "placa") String placa){
        Vehiculo vehiculo = vehiculoRepository.findById(placa).orElse(null);
        return vehiculo;
    }

    @WebMethod(operationName = "nuevoVehiculo")
    public boolean crearVehiculo(@WebParam(name = "placa") String placa,
                                 @WebParam(name = "marca") String marca, 
                                 @WebParam(name = "modelo") int modelo,
                                 @WebParam(name = "precio") Long precio) {
        try {
            Optional<Vehiculo> existingVehiculo = vehiculoRepository.findById(placa);
            if (existingVehiculo.isPresent()) {
                return false;
            } else {
                Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, precio);
                vehiculoRepository.save(vehiculo);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @WebMethod(operationName = "calcularSOAT")
    public Long consultarSOAT(@WebParam(name = "placa") String placa){
        Vehiculo vehiculo = vehiculoRepository.findById(placa).orElse(null);
        if (vehiculo == null) {
            return null;
        }
        int modelo = vehiculo.getModelo();
        int antiguedad = 2023 - modelo;
        Long valorSOAT;

        if (antiguedad < 5) {
            valorSOAT = 100000L;
        } else {
            valorSOAT = 150000L;
        }
        return valorSOAT;
    }

    /*
     
    @WebMethod(operationName = "obtener")
    public List<Usuario> getUsuarios() {
        db.vehiculo.findAll();
        return datos.usuariosList;
    }
    /* 
    @WebMethod(operationName = "adicionar")
    public void addUsuario(@WebParam Usuario usuario) {
        datos.adicionarUsuario(usuario); 
    }
    */
    /* 
    @WebMethod(operationName = "consultaUniversidad")
    public Universidad consulta(@WebParam String nit){
        return new Universidad("nit", "nit");
    }
    */

}