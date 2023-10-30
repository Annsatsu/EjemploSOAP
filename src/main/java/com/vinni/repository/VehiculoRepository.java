package com.vinni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.vinni.entity.Vehiculo;


@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {
    Vehiculo findByPlaca(String placa);
}
