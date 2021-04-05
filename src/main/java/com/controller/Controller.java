package com.controller;

import com.etc.exception.invalid_input_exception.InvalidDescriptionException;
import com.etc.exception.invalid_input_exception.InvalidInputException;
import com.etc.exception.invalid_input_exception.InvalidNameInputException;
import com.etc.exception.invalid_input_exception.InvalidUserExcepcion;
import com.model.Model;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Controller<T extends Model> {
    protected ArrayList<T> data;

    public abstract void insert(String[] args) throws InvalidInputException, SQLException;

    public abstract void alter(String[] args) throws InvalidNameInputException, InvalidDescriptionException.LongDescriptionException, InvalidUserExcepcion, SQLException, InvalidInputException;

    public abstract void remove(String[] args) throws SQLException;

    public abstract T getItem(String[] args);

    public ArrayList<T> getData() {
        return data;
    }

    public abstract void updateData(String[] args) throws SQLException;
}
