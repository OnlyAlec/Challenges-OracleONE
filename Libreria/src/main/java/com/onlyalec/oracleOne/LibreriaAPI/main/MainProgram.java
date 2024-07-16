package com.onlyalec.oracleOne.LibreriaAPI.main;

import com.onlyalec.oracleOne.LibreriaAPI.model.Autor;
import com.onlyalec.oracleOne.LibreriaAPI.model.DTOLibro;
import com.onlyalec.oracleOne.LibreriaAPI.model.Idioma;
import com.onlyalec.oracleOne.LibreriaAPI.model.Libro;
import com.onlyalec.oracleOne.LibreriaAPI.repository.AutorRepository;
import com.onlyalec.oracleOne.LibreriaAPI.repository.LibroRepostory;
import com.onlyalec.oracleOne.LibreriaAPI.service.ConnectAPI;
import com.onlyalec.oracleOne.LibreriaAPI.service.ConvertData;
import com.onlyalec.oracleOne.LibreriaAPI.service.DTOApi;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class MainProgram {
    String URL_BASE = "https://gutendex.com/books/?search=";

    Scanner sc = new Scanner(System.in);
    ConnectAPI connectAPI = new ConnectAPI();
    ConvertData convertData = new ConvertData();
    LibroRepostory libroRepostory;
    AutorRepository autorRepository;

    public MainProgram(LibroRepostory libroRepostory, AutorRepository autorRepository) {
        this.libroRepostory = libroRepostory;
        this.autorRepository = autorRepository;
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Menu! -------------------------------");
            System.out.println("\t1. Buscar libro por nombre");
            System.out.println("\t2. Mostrar todos los libros buscados");
            System.out.println("\t3. Mostrar libros por idioma");
            System.out.println("\t4. Mostrar todos los autores");
            System.out.println("\t5. Buscar autor vivo en determinado año");
            System.out.println("\n\t0. Salir");

            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    getLibro();
                    break;
                case 2:
                    showAllLibro();
                    break;
                case 3:
                    showLanguageLibro();
                    break;
                case 4:
                    showAllAuthors();
                    break;
                case 5:
                    showAliveAuthors();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void showAliveAuthors() {
        System.out.println("Introduzca el año de busqueda para los autores: ");
        try {
            int year = sc.nextInt();
            sc.nextLine();

            Optional<List<Autor>> listAutores = autorRepository.findAutorByDeathYearGreaterThanEqual(year);
            if (listAutores.isPresent()) {
                listAutores.get().forEach(System.out::println);
            } else {
                System.out.println("\nNo se encontraron autores!\n");
            }
        } catch (InputMismatchException e) {
            System.out.println("\nSolo introduzca numeros!\n");
            sc.nextLine();
        }
    }

    private void showAllAuthors() {
        libroRepostory.findAll().stream().map(Libro::getAuthors).forEach(System.out::println);
    }

    private void showLanguageLibro() {
        boolean valid = false;
        int languageUser = 0;

        List<Libro> libros = libroRepostory.findAll();
        List<Idioma> listLanguages = libros.stream()
                .map(Libro::getLanguages)
                .distinct()
                .toList();

        if (listLanguages.isEmpty()) {
            System.out.println("\nNo hay libros disponibles\n");
            return;
        }
        do {
            System.out.println("Selecciona un idioma:");

            for (int i = 0; i < listLanguages.size(); i++) {
                System.out.println("\t" + (i + 1) + ". " + listLanguages.get(i));
            }

            try {
                languageUser = sc.nextInt();
                sc.nextLine();

                if (languageUser < 1 || languageUser > listLanguages.size()) {
                    System.out.println("\nSelección invalida\n");
                } else {
                    valid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nSolo introduzca numeros!\n");
                sc.nextLine();
            }
        } while (!valid);

        Optional<List<Libro>> listLibrosSort = libroRepostory.findByLanguages(listLanguages.get(languageUser - 1));
        if (listLibrosSort.isPresent()) {
            listLibrosSort.get().forEach(System.out::println);
        } else {
            System.out.println("\nNo hay libros disponibles\n");
        }
    }

    private void showAllLibro() {
        libroRepostory.findAll().forEach(System.out::println);
    }

    public void getLibro() {
        try {
            DTOLibro dataLibro = buscarLibroAPI();
            if (dataLibro == null) {
                System.out.println("\nNo libro encontrado\n");
                return;
            }

            Libro libro = new Libro(dataLibro);
            libroRepostory.save(libro);
            System.out.println(libro);
        } catch (DataIntegrityViolationException e) {
            System.out.println("\nEl libro ya fue añadido previamente!\n");
        } catch (RuntimeException e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }
    }

    public DTOLibro buscarLibroAPI() {
        System.out.println("Introduce el nombre del libro:");
        String libroStr = sc.nextLine();

        if (libroStr.isBlank()) {
            throw new RuntimeException("El nombre del libro no puede estar vacio");
        }

        System.out.println("Buscando... '" + libroStr + "'");
        libroStr = libroStr.replace(" ", "%20");

        var res = connectAPI.getData(URL_BASE + libroStr);
        DTOApi listResults = convertData.obtenerDatos(res, DTOApi.class);
        Optional<DTOLibro> resultLibro = listResults.books()
                .stream()
                .findFirst();
        return resultLibro.orElse(null);
    }
}
