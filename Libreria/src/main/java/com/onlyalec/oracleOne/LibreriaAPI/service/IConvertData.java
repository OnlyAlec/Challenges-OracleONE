package com.onlyalec.oracleOne.LibreriaAPI.service;

public interface IConvertData {
    <T> T obtenerDatos(String json, Class<T> clase);
}
