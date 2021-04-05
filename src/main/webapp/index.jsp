<%@ page import="com.model.Address" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<style>
    input, select {
        margin-right: 2em;
        margin-left: -2em;
    }

    table {
        border-collapse: separate;
        border-spacing: 2em;
    }
</style>
<body>
<form action="UserServlet" method="get">
    <table align="center">
        <tr>
            <td>
                <table align="center">
                    <tr>
                        <td><h1 align="center" style="padding-right:.5em">Cadastro de</h1></td>
                        <td><select style="font-size: 20px; font-weight: bold;" name="user_type">
                            <option>Cliente</option>
                            <option>Faxineiro(a)</option>
                        </select></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>
                <fieldset>
                    <legend>Informações Básicas</legend>
                    <table>
                        <tr>
                            <td>Nome:</td>
                            <td><input type="text" name="name"></td>
                            <td>Nascimento:</td>
                            <td><input type="date" name="birth"></td>
                            <td>Sexo:</td>
                            <td><select name="gender">
                                <option value="male">Masculino</option>
                                <option value="female">Feminino</option>
                            </select></td>
                        </tr>

                        <tr>
                            <td>CPF (somente números!):</td>
                            <td><input type="text" name="cpf"></td>
                            <td>Identidade (somente números!):</td>
                            <td><input type="text" name="identity"></td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>

        <tr>
            <td>
                <fieldset>
                    <legend>Endereço</legend>
                    <table>
                        <tr>
                            <td>Estado:</td>
                            <td>
                                <select name="state">
                                    <%for (String state : Address.STATES) {%>
                                    <option><%out.print(state);%></option>
                                    <%}%>
                                </select>
                            </td>
                            <td>Cidade:</td>
                            <td><input type="text" style="width: 100%;" name="city"></td>
                            <td>Número:</td>
                            <td><input type="number" style="width: 100%;" name="number"></td>
                        </tr>

                        <tr>
                            <td>Logradouro:</td>
                            <td colspan="3"><input type="text" style="width: 100%;" name="address"></td>
                            <td>Bairro:</td>
                            <td colspan="3"><input type="text" style="width: 100%;" name="district"></td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>

        <tr align="center">
            <td>
                <input type="submit" name="confirm" value="Confirmar">
            </td>
        </tr>
    </table>
</form>
</body>
</html>