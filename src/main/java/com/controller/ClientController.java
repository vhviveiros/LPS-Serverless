package com.controller;

import com.dao.ClientDao;
import com.etc.exception.invalid_input_exception.ExistingUserException;
import com.etc.exception.invalid_input_exception.InvalidInputException;
import com.model.Client;
import com.validation.UserValidation;

import java.sql.SQLException;

public class ClientController extends Controller<Client> {
    private final ClientDao clientDao = new ClientDao();

    @Override
    public void insert(String[] args) throws InvalidInputException, SQLException {
        UserValidation validation = new UserValidation(args);

        boolean gender = args[4].equals("Masculino");

        try {
            clientDao.insert(new Client(
                    validation.nameValidation(),
                    gender,
                    validation.birthDateValidation(),
                    validation.cpfValidation(),
                    validation.identityValidation(),
                    ControllerSingleton.currentUser.getAddress(),
                    ControllerSingleton.currentUser.getCredentials()));
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate"))
                throw new ExistingUserException();
            throw e;
        }
    }

    @Override
    public void alter(String[] args) {

    }

    @Override
    public void remove(String[] args) {

    }

    @Override
    public Client getItem(String[] args) {
        return null;
    }

    @Override
    public void updateData(String[] args) throws SQLException {
        ControllerSingleton.currentUser = clientDao.getItem(args);
    }
}
