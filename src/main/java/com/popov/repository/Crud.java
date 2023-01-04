package com.popov.repository;

import com.popov.model.Car;

import java.util.Optional;

public interface Crud<T> {
    void save(final T car);

    T[] getAll();

    Optional<Car> getById(final String id);

    void delete(final String id);

}
